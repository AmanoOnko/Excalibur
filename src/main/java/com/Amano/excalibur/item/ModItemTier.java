package com.Amano.excalibur.item;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;
import java.util.function.Supplier;

public enum ModItemTier implements Tier {
    EX_CALIBUR(4,2000,5.0F,9.0F,22,
            () -> Ingredient.of(ModItem.excalibur.get()));
    private final int harvestLevel;
    private final int maxUse;
    private final float efficiency;
    private final float atkDamage;
    private final int enchantAbility;
    private final Supplier<Ingredient> repairMaterial;

    ModItemTier(int harvestLevel, int maxUse, float efficiency, float atkDamage, int enchantAbility, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUse = maxUse;
        this.efficiency = efficiency;
        this.atkDamage = atkDamage;
        this.enchantAbility = enchantAbility;
        this.repairMaterial = repairMaterial;
    }


    @Override
    public int getUses() {
        return maxUse;
    }

    @Override
    public float getSpeed() {
        return efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return atkDamage;
    }

    @Override
    public int getLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantAbility;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairMaterial.get();
    }

    @Override
    public @Nullable TagKey<Block> getTag() {
        return Tier.super.getTag();
    }
}
