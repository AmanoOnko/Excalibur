package com.Amano.excalibur.main;


import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static com.Amano.excalibur.item.ModItem.ITEMS;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(Excalibur.MODID)
public class Excalibur
{
    public static final String MODID = "excalibur";
    private static final Logger LOGGER = LogUtils.getLogger();
    public Excalibur(){
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
    }


}
