package com.Amano.excalibur.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import yesman.epicfight.world.item.WeaponItem;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import java.util.List;
import java.util.UUID;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class ExcaliburType extends WeaponItem {
    protected static final UUID MOVEMENT_SPEED_MODIFIER = UUID.fromString("16295ED8-B092-4A75-9A94-BCD8D56668BB");
    private final float attackDamage;
    private final float attackSpeed;

    public ExcaliburType(Item.Properties build, Tier tier) {
        super(tier, 0, 0.0F, build);
        this.attackDamage = 11.0F + tier.getAttackDamageBonus();
        this.attackSpeed = -1.85F - 0.05F * (float) tier.getLevel();
    }

    public int getEnchantmentValue() {
        return 5;
    }

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        if (slot == EquipmentSlot.MAINHAND) {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", this.attackDamage, Operation.ADDITION));
            builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", this.attackSpeed, Operation.ADDITION));
            builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(MOVEMENT_SPEED_MODIFIER, "Weapon modifier", +0.02, Operation.ADDITION));
            return builder.build();
        } else {
            return super.getAttributeModifiers(slot, stack);
        }
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, level, list, flag);
        list.add(Component.literal("§5\u4EE3\u8868\u4E86\u80DC\u5229\u7684\u738B\u8005\u4E4B\u5251\uFF0C\u4F20\u8BF4\u4E8E\u963F\u74E6\u9686\u7528\u5B9D\u77F3\u6253\u9020"));

    }
}
