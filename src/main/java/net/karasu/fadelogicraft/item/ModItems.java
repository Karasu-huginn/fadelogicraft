package net.karasu.fadelogicraft.item;

import net.karasu.fadelogicraft.Fadelogicraft;
import net.karasu.fadelogicraft.item.custom.PortableSmelterItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Fadelogicraft.MOD_ID);

    public static final RegistryObject<Item> FADELOGITE = ITEMS.register("fadelogite", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_FADELOGITE = ITEMS.register("raw_fadelogite", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PORTABLE_SMELTER = ITEMS.register("portable_smelter", () -> new PortableSmelterItem(new Item.Properties().durability(63)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
