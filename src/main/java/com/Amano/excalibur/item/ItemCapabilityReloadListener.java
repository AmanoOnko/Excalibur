//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.Amano.excalibur.item;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.datafixers.util.Pair;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.TagParser;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;
import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.collider.MultiOBBCollider;
import yesman.epicfight.api.collider.OBBCollider;
import yesman.epicfight.data.conditions.EpicFightConditions;
import yesman.epicfight.data.conditions.Condition.ConditionBuilder;
import yesman.epicfight.data.conditions.itemstack.ItemStackCondition;
import yesman.epicfight.main.EpicFightMod;
import yesman.epicfight.world.capabilities.item.ArmorCapability;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.Style;
import yesman.epicfight.world.capabilities.item.TagBasedSeparativeCapability;
import yesman.epicfight.world.capabilities.item.WeaponCapability;
import yesman.epicfight.world.capabilities.item.WeaponTypeReloadListener;
import yesman.epicfight.world.capabilities.provider.ItemCapabilityProvider;
import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributes;

public class ItemCapabilityReloadListener extends SimpleJsonResourceReloadListener {
    private static final Gson GSON = (new GsonBuilder()).create();
    private static final Map<Item, CompoundTag> CAPABILITY_ARMOR_DATA_MAP = Maps.newHashMap();
    private static final Map<Item, CompoundTag> CAPABILITY_WEAPON_DATA_MAP = Maps.newHashMap();
    private static boolean armorReceived = false;
    private static boolean weaponReceived = false;
    private static boolean weaponTypeReceived = false;

    public ItemCapabilityReloadListener() {
        super(GSON, "capabilities");
    }

    protected void apply(Map<ResourceLocation, JsonElement> objectIn, ResourceManager resourceManagerIn, ProfilerFiller profilerIn) {
        Iterator var4 = objectIn.entrySet().iterator();

        while(var4.hasNext()) {
            Map.Entry<ResourceLocation, JsonElement> entry = (Map.Entry)var4.next();
            ResourceLocation rl = (ResourceLocation)entry.getKey();
            String path = rl.getPath();
            if (path.contains("/")) {
                String[] str = path.split("/", 2);
                ResourceLocation registryName = new ResourceLocation(rl.getNamespace(), str[1]);
                Item item = (Item)ForgeRegistries.ITEMS.getValue(registryName);
                if (item == null) {
                    EpicFightMod.LOGGER.warn("Tried to add a capability for item " + registryName + ", but it doesn't exist!");
                    return;
                }

                CompoundTag nbt = null;

                try {
                    nbt = TagParser.parseTag(((JsonElement)entry.getValue()).toString());
                } catch (CommandSyntaxException var14) {
                    CommandSyntaxException e = var14;
                    e.printStackTrace();
                }

                try {
                    CapabilityItem capability;
                    if (str[0].equals("armors")) {
                        capability = deserializeArmor(item, nbt);
                        ItemCapabilityProvider.put(item, capability);
                        CAPABILITY_ARMOR_DATA_MAP.put(item, nbt);
                    } else if (str[0].equals("weapons")) {
                        capability = deserializeWeapon(item, nbt);
                        ItemCapabilityProvider.put(item, capability);
                        CAPABILITY_WEAPON_DATA_MAP.put(item, nbt);
                    }
                } catch (Exception var13) {
                    Exception e = var13;
                    EpicFightMod.LOGGER.warn("Error while deserializing datapack for " + registryName);
                    e.printStackTrace();
                }
            }
        }

        ItemCapabilityProvider.addDefaultItems();
    }

    public static CapabilityItem deserializeArmor(Item item, CompoundTag tag) {
        ArmorCapability.Builder builder = ArmorCapability.builder();
        if (tag.contains("attributes")) {
            CompoundTag attributes = tag.getCompound("attributes");
            builder.weight(attributes.getDouble("weight")).stunArmor(attributes.getDouble("stun_armor"));
        }

        builder.item(item);
        return builder.build();
    }

    public static CapabilityItem deserializeWeapon(Item item, CompoundTag tag) {
        Object capability;
        if (tag.contains("variations")) {
            ListTag jsonArray = tag.getList("variations", 10);
            List<Pair<ItemStackCondition, CapabilityItem>> list = Lists.newArrayList();
            CapabilityItem.Builder innerDefaultCapabilityBuilder = tag.contains("type") ? (CapabilityItem.Builder)WeaponTypeReloadListener.get(tag.getString("type")).apply(item) : CapabilityItem.builder();
            if (tag.contains("attributes")) {
                CompoundTag attributes = tag.getCompound("attributes");
                Iterator var7 = attributes.getAllKeys().iterator();

                while(var7.hasNext()) {
                    String key = (String)var7.next();
                    Map<Attribute, AttributeModifier> attributeEntry = deserializeAttributes(attributes.getCompound(key));
                    Iterator var10 = attributeEntry.entrySet().iterator();

                    while(var10.hasNext()) {
                        Map.Entry<Attribute, AttributeModifier> attribute = (Map.Entry)var10.next();
                        innerDefaultCapabilityBuilder.addStyleAttibutes((Style)Style.ENUM_MANAGER.get(key), Pair.of((Attribute)attribute.getKey(), (AttributeModifier)attribute.getValue()));
                    }
                }
            }

            Iterator var17 = jsonArray.iterator();

            while(var17.hasNext()) {
                Tag jsonElement = (Tag)var17.next();
                CompoundTag innerTag = (CompoundTag)jsonElement;
                Function<CompoundTag, ItemStackCondition> conditionProvider = EpicFightConditions.getConditionOrThrow(new ResourceLocation(innerTag.getString("condition")));
                ItemStackCondition condition = (ItemStackCondition)ConditionBuilder.builder(conditionProvider).setTag(innerTag.getCompound("predicate")).build();
                list.add(Pair.of(condition, deserializeWeapon(item, innerTag)));
            }

            capability = new TagBasedSeparativeCapability(list, innerDefaultCapabilityBuilder.build());
        } else {
            CapabilityItem.Builder builder = tag.contains("type") ? (CapabilityItem.Builder)WeaponTypeReloadListener.get(tag.getString("type")).apply(item) : CapabilityItem.builder();
            if (tag.contains("attributes")) {
                CompoundTag attributes = tag.getCompound("attributes");
                Iterator var15 = attributes.getAllKeys().iterator();

                while(var15.hasNext()) {
                    String key = (String)var15.next();
                    Map<Attribute, AttributeModifier> attributeEntry = deserializeAttributes(attributes.getCompound(key));
                    Iterator var23 = attributeEntry.entrySet().iterator();

                    while(var23.hasNext()) {
                        Map.Entry<Attribute, AttributeModifier> attribute = (Map.Entry)var23.next();
                        builder.addStyleAttibutes((Style)Style.ENUM_MANAGER.get(key), Pair.of((Attribute)attribute.getKey(), (AttributeModifier)attribute.getValue()));
                    }
                }
            }

            if (tag.contains("collider") && builder instanceof WeaponCapability.Builder) {
                WeaponCapability.Builder weaponCapBuilder = (WeaponCapability.Builder)builder;
                CompoundTag colliderTag = tag.getCompound("collider");
                Collider collider = deserializeCollider(colliderTag);
                weaponCapBuilder.collider(collider);
            }

            capability = builder.build();
        }

        return (CapabilityItem)capability;
    }

    private static Map<Attribute, AttributeModifier> deserializeAttributes(CompoundTag tag) {
        Map<Attribute, AttributeModifier> modifierMap = Maps.newHashMap();
        if (tag.contains("armor_negation")) {
            modifierMap.put((Attribute)EpicFightAttributes.ARMOR_NEGATION.get(), EpicFightAttributes.getArmorNegationModifier(tag.getDouble("armor_negation")));
        }

        if (tag.contains("impact")) {
            modifierMap.put((Attribute)EpicFightAttributes.IMPACT.get(), EpicFightAttributes.getImpactModifier(tag.getDouble("impact")));
        }

        if (tag.contains("max_strikes")) {
            modifierMap.put((Attribute)EpicFightAttributes.MAX_STRIKES.get(), EpicFightAttributes.getMaxStrikesModifier(tag.getInt("max_strikes")));
        }

        if (tag.contains("damage_bonus")) {
            modifierMap.put(Attributes.ATTACK_DAMAGE, EpicFightAttributes.getDamageBonusModifier(tag.getDouble("damage_bonus")));
        }

        if (tag.contains("speed_bonus")) {
            modifierMap.put(Attributes.ATTACK_SPEED, EpicFightAttributes.getSpeedBonusModifier(tag.getDouble("speed_bonus")));
        }

        return modifierMap;
    }

    public static Collider deserializeCollider(CompoundTag tag) {
        int number = tag.getInt("number");
        if (number < 1) {
            throw new IllegalArgumentException("Datapack deserialization error: the number of colliders must bigger than 0!");
        } else {
            ListTag sizeVector = tag.getList("size", 6);
            ListTag centerVector = tag.getList("center", 6);
            double sizeX = sizeVector.getDouble(0);
            double sizeY = sizeVector.getDouble(1);
            double sizeZ = sizeVector.getDouble(2);
            double centerX = centerVector.getDouble(0);
            double centerY = centerVector.getDouble(1);
            double centerZ = centerVector.getDouble(2);
            if (!(sizeX < 0.0) && !(sizeY < 0.0) && !(sizeZ < 0.0)) {
                return (Collider)(number == 1 ? new OBBCollider(sizeX, sizeY, sizeZ, centerX, centerY, centerZ) : new MultiOBBCollider(number, sizeX, sizeY, sizeZ, centerX, centerY, centerZ));
            } else {
                throw new IllegalArgumentException("Datapack deserialization error: the size of the collider must be non-negative value!");
            }
        }
    }

    public static Stream<CompoundTag> getArmorDataStream() {
        Stream<CompoundTag> tagStream = CAPABILITY_ARMOR_DATA_MAP.entrySet().stream().map((entry) -> {
            ((CompoundTag)entry.getValue()).putInt("id", Item.getId((Item)entry.getKey()));
            return (CompoundTag)entry.getValue();
        });
        return tagStream;
    }

    public static Stream<CompoundTag> getWeaponDataStream() {
        Stream<CompoundTag> tagStream = CAPABILITY_WEAPON_DATA_MAP.entrySet().stream().map((entry) -> {
            ((CompoundTag)entry.getValue()).putInt("id", Item.getId((Item)entry.getKey()));
            return (CompoundTag)entry.getValue();
        });
        return tagStream;
    }

    public static int armorCount() {
        return CAPABILITY_ARMOR_DATA_MAP.size();
    }

    public static int weaponCount() {
        return CAPABILITY_WEAPON_DATA_MAP.size();
    }

    public static void weaponTypeProcessedCheck() {
        weaponTypeReceived = true;
    }

    @OnlyIn(Dist.CLIENT)
    public static void reset() {
        armorReceived = false;
        weaponReceived = false;
        weaponTypeReceived = false;
    }
}
