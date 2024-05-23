package com.Amano.excalibur.event;

import com.Amano.excalibur.entity.CustomEntity;

import com.Amano.excalibur.main.Excalibur;
import net.minecraft.client.Minecraft;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.Amano.excalibur.entity.EntityRegister.CUSTOM_ENTITY;
import static com.Amano.excalibur.event.KeyInputHandler.BEAM_ATTACK;

@Mod.EventBusSubscriber(modid = Excalibur.MODID,value = Dist.CLIENT)
public class ForgeClientEventHandler {

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if(BEAM_ATTACK.consumeClick()) {
            Minecraft mc = Minecraft.getInstance();
            Player player = mc.player;
            Level world = player.level();
            if(player !=null && world !=null){
                if(player.getMainHandItem().getItem() == Items.STONE_SWORD){
                    float yaw = player.getYRot();
                    float pitch = player.getXRot();

                    Vec3 lookVec =player.getLookAngle();
                    Vec3 spawnPos = player.position().add(lookVec);
                    CustomEntity customEntity =new CustomEntity(CUSTOM_ENTITY.get(),world);
                    customEntity.setPos(spawnPos);
                    customEntity.setRotation(yaw, pitch);
                    double speed =1.5;
                    customEntity.setDeltaMovement(lookVec.scale(speed));

                    world.addFreshEntity(customEntity);
                }
            }
        }
    }
}


