package com.Amano.excalibur.item;



import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;




import static com.Amano.excalibur.main.Excalibur.MODID;

public class ModItem {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,MODID);
    public static final RegistryObject<Item> EXCALIBUR =
            ITEMS.register("excalibur",
                    () ->new com.Amano.excalibur.item.ExcaliburType
                            (new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant(), com.Amano.excalibur.item.ModItemTier.EX_CALIBUR));


}
