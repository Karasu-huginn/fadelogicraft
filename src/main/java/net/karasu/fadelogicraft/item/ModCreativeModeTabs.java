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
                    .icon(() -> new ItemStack(ModItems.ALUMINUM_INGOT.get()))
                    .title(Component.translatable("creativetab.fadelogicraft.fadelogicraft"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TIN_INGOT.get());
                        output.accept(ModItems.TIN_ORE.get());
                        output.accept(ModItems.ALUMINUM_INGOT.get());
                        output.accept(ModItems.BAUXITE_ORE.get());
                        output.accept(ModItems.ZINC_INGOT.get());
                        output.accept(ModItems.SPHALERITE_ORE.get());
                        output.accept(ModBlocks.TIN_BLOCK.get());
                        output.accept(ModBlocks.TIN_ORE_BLOCK.get());
                    })
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
