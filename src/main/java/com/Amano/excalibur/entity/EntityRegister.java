package com.Amano.excalibur.entity;


import com.Amano.excalibur.main.Excalibur;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class EntityRegister {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, Excalibur.MODID);
    public static final RegistryObject<EntityType<CustomEntity>> CUSTOM_ENTITY = ENTITY_TYPES.register("custom_entity",
            () -> EntityType.Builder.of(CustomEntity::new, MobCategory.MISC).sized(2, 2).build("custom_entity"));


}
