package com.Amano.excalibur.skills;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.data.reloader.SkillManager;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.damagesource.EpicFightDamageType;
import yesman.epicfight.world.damagesource.ExtraDamageInstance;
import yesman.epicfight.world.damagesource.StunType;

import java.util.Set;

@Mod.EventBusSubscriber(
        modid = "excalibur",
        bus = Mod.EventBusSubscriber.Bus.FORGE
)
public class ExcaliburSkills extends EpicFightSkills {
    public static Skill EXCALIBUR_SWEEPING_EDGE;
    public ExcaliburSkills(){

    }
    public static void registerSkills() {
        SkillManager.register(SimpleWeaponInnateSkill::new, SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(new ResourceLocation("excalibur", "biped/skill/excalibur_sweeping_edge")), "excalibur", "excalibur_sweeping_edge");

    }
    @SubscribeEvent
    public static void buildSkillEvent(SkillBuildEvent onBuild) {
        WeaponInnateSkill excalibursweepingEdge = (WeaponInnateSkill)onBuild.build("excalibur", "excalibur_sweeping_edge");
        excalibursweepingEdge.newProperty().addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.adder(1.0F)).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2.0F)).addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(20.0F)).addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.multiplier(1.6F)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG).addProperty(AnimationProperty.AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create(new float[0]))).addProperty(AnimationProperty.AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageType.WEAPON_INNATE)).registerPropertiesToAnimation();
        EXCALIBUR_SWEEPING_EDGE = excalibursweepingEdge;
    }
}
