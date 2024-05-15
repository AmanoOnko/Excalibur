package com.Amano.excalibur.settings;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.forgeevent.AnimationRegistryEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.model.armature.HumanoidArmature;

@Mod.EventBusSubscriber(
        modid = "excalibur",
        bus = Mod.EventBusSubscriber.Bus.MOD
)

public class ExcaliburAnimation extends Animations {
    public static StaticAnimation EXCALIBUR_AUTO1;
    public static StaticAnimation EXCALIBUR_AUTO2;
    public static StaticAnimation EXCALIBUR_AUTO3;
    public static StaticAnimation EXCALIBUR_DASH;
    public static StaticAnimation EXCALIBUR_AIRSLASH;
    public static StaticAnimation EXCALIBUR_SWEEPING_EDGE;
    public ExcaliburAnimation(){

    }

    @SubscribeEvent
    public static void registerAnimations(AnimationRegistryEvent event) {
        event.getRegistryMap().put("excalibur", ExcaliburAnimation::build);
    }
    private static void build(){
        HumanoidArmature biped = Armatures.BIPED;
        EXCALIBUR_AUTO1 = (new BasicAttackAnimation(0.1F, 0.25F, 0.35F, 0.5F, (Collider)null, biped.toolR, "biped/combat/excalibur_auto1", biped)).addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F);
        EXCALIBUR_AUTO2 = (new BasicAttackAnimation(0.15F, 0.2F, 0.3F, 0.45F, (Collider)null, biped.toolR, "biped/combat/excalibur_auto2", biped)).addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F);
        EXCALIBUR_AUTO3 = (new BasicAttackAnimation(0.05F, 0.2F, 0.3F, 1.0F, (Collider)null, biped.toolR, "biped/combat/excalibur_auto3", biped)).addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F);
        EXCALIBUR_DASH = (new DashAttackAnimation(0.1F, 0.1F, 0.25F, 0.4F, 0.75F, (Collider)null, biped.toolR, "biped/combat/excalibur_dash", biped)).addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F);
        EXCALIBUR_AIRSLASH = new AirSlashAnimation(0.1F, 0.3F, 0.41F, 0.5F, (Collider)null, biped.toolR, "biped/combat/excalibur_airslash", biped);
        EXCALIBUR_SWEEPING_EDGE = (new AttackAnimation(0.1F, 0.0F, 0.15F, 0.3F, 0.8F, (Collider)null, biped.toolR, "biped/skill/excalibur_sweeping_edge", biped)).addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F).addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 1).addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, Animations.ReusableSources.COMBO_ATTACK_DIRECTION_MODIFIER);
    }

}
