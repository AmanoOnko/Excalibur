package com.Amano.excalibur.event;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_EXCALIBUR = "key.category.excalibur";
    // 我们添加一个按键的描述，是可以被语言化文件处理的。
    public static final String KEY_BEAM_ATTACK = "key.excalibur.beam_attack";

    public static final KeyMapping BEAM_ATTACK = new KeyMapping(KEY_CATEGORY_EXCALIBUR, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_F,KEY_BEAM_ATTACK);

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
    public class ModClientEventHandler {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyInputHandler.BEAM_ATTACK);
        }
    }



}
