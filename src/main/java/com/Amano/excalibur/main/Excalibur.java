package com.Amano.excalibur.main;


import com.Amano.excalibur.skills.ExcaliburSkills;
import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static com.Amano.excalibur.entity.EntityRegister.ENTITY_TYPES;
import static com.Amano.excalibur.item.ModItem.ITEMS;


@Mod(Excalibur.MODID)
public class Excalibur
{
    public static final String MODID = "excalibur";
    private static final Logger LOGGER = LogUtils.getLogger();
    public Excalibur(){
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        bus.addListener(this::setupCommon);
        ENTITY_TYPES.register(bus);

    }
    private void setupCommon(final FMLCommonSetupEvent event){
        ExcaliburSkills.registerSkills();
    }

}
