package net.karasu.fadelogicraft.item;

import net.karasu.fadelogicraft.Fadelogicraft;
import net.karasu.fadelogicraft.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Fadelogicraft.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FADELOGICRAFT_TAB = CREATIVE_MODE_TABS.register(
            "fadelogicraft_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.FADELOGITE.get()))
                    .title(Component.translatable("creativetab.fadelogicraft.fadelogicraft"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.FADELOGITE.get());
                        output.accept(ModItems.RAW_FADELOGITE.get());
                        output.accept(ModItems.PORTABLE_SMELTER.get());
                        output.accept(ModBlocks.FADELOGITE_BLOCK.get());
                        output.accept(ModBlocks.FADELOGITE_ORE.get());
                        output.accept(ModBlocks.RAW_FADELOGITE_BLOCK.get());
                    })
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
