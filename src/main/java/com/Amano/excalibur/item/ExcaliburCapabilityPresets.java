package com.Amano.excalibur.item;
import com.Amano.excalibur.settings.ExcaliburAnimation;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.world.capabilities.item.*;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.Amano.excalibur.skills.ExcaliburSkills.EXCALIBUR_SWEEPING_EDGE;



@Mod.EventBusSubscriber(
        modid = "excalibur",
        bus = Mod.EventBusSubscriber.Bus.MOD
)

public class ExcaliburCapabilityPresets {
    public static final Function<Item, CapabilityItem.Builder> EXCALIBUR = (item) -> {
        return WeaponCapability.builder().category(CapabilityItem.WeaponCategories.GREATSWORD).styleProvider((playerpatch) -> {
            return CapabilityItem.Styles.TWO_HAND;
        }).collider(ColliderPreset.LONGSWORD).swingSound((SoundEvent)EpicFightSounds.WHOOSH_BIG.get()).hitSound((SoundEvent)EpicFightSounds.BLADE_HIT.get()).canBePlacedOffhand(false).newStyleCombo(CapabilityItem.Styles.TWO_HAND, new StaticAnimation[]{ExcaliburAnimation.EXCALIBUR_AUTO1, ExcaliburAnimation.EXCALIBUR_AUTO2, ExcaliburAnimation.EXCALIBUR_AUTO3,ExcaliburAnimation.EXCALIBUR_DASH, ExcaliburAnimation.EXCALIBUR_AIRSLASH}).innateSkill(CapabilityItem.Styles.TWO_HAND, (itemstack) -> {
            return EXCALIBUR_SWEEPING_EDGE;
        }).livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.IDLE, Animations.BIPED_HOLD_LONGSWORD).livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.WALK, Animations.BIPED_WALK_LONGSWORD).livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.CHASE, Animations.BIPED_WALK_LONGSWORD).livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.RUN, Animations.BIPED_RUN_SPEAR).livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.JUMP, Animations.BIPED_HOLD_SPEAR).livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.KNEEL, Animations.BIPED_HOLD_LONGSWORD).livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.SNEAK, Animations.BIPED_HOLD_LONGSWORD).livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.SWIM, Animations.BIPED_HOLD_LONGSWORD).livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.FLY, Animations.BIPED_HOLD_LONGSWORD).livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.CREATIVE_FLY, Animations.BIPED_HOLD_LONGSWORD).livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.CREATIVE_IDLE, Animations.BIPED_HOLD_LONGSWORD).livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.BLOCK, Animations.LONGSWORD_GUARD);
    };


    public static Builder EFbuilder() {
        return new Builder();
    }

    public static class Builder {
        Map<Style, List<StaticAnimation>> heavyAutoAttackMotionMap = Maps.newHashMap();

        public Builder() {
        }

        public Builder newHeavyStyleCombo(Style style, StaticAnimation... animation) {
            this.heavyAutoAttackMotionMap.put(style, Lists.newArrayList(animation));
            return this;
        }
    }

    @SubscribeEvent
    public static void register(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put(new ResourceLocation("excalibur", "excalibur"), EXCALIBUR);
    }
}

