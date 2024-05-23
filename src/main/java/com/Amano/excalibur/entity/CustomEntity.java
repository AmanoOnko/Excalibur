package com.Amano.excalibur.entity;

import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;


public class CustomEntity extends Entity {
    private static final EntityDataAccessor<Integer> COUNTER = SynchedEntityData.defineId(CustomEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> BEAM_LIFETIME = SynchedEntityData.defineId(CustomEntity.class, EntityDataSerializers.INT);

    Vec3 lookVector = new Vec3(0,0,0);
    public CustomEntity(EntityType<? extends CustomEntity> type, Level world) {
        super(type, world);
        this.lookAt(EntityAnchorArgument.Anchor.EYES,lookVector);
    }


    @Override
    protected void defineSynchedData() {
        this.entityData.define(BEAM_LIFETIME, 40);
        this.entityData.define(COUNTER,0);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        this.entityData.set(COUNTER,pCompound.getInt("counter"));
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putInt("counter",this.entityData.get(COUNTER));
        this.setLifetime(pCompound.getInt("LIFETIME"));
    }

    @Override
    public void tick(){
        if(this.level().isClientSide){
            Integer i =this.entityData.get(COUNTER);
        }
        if(!this.level().isClientSide){
            this.entityData.set(COUNTER,this.entityData.get(COUNTER)+1);
        }
        super.tick();
        int lifetime = this.getLifetime();
        if (lifetime > 0) {
            this.setLifetime(lifetime - 1);
        } else {
            this.discard();
            return;
        }

        Vec3 motion = this.getDeltaMovement();
        this.setPos(this.getX() + motion.x, this.getY() + motion.y, this.getZ() + motion.z);


    }


    public void setRotation(float yaw,float pitch){
        this.setYRot(yaw);
        this.setXRot(pitch);
    }

    public int getLifetime() {
        return this.entityData.get(BEAM_LIFETIME);
    }

    // 設置光束的壽命
    public void setLifetime(int lifetime) {
        this.entityData.set(BEAM_LIFETIME, lifetime);
    }


}
