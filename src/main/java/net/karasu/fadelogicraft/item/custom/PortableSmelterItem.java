package net.karasu.fadelogicraft.item.custom;

import net.karasu.fadelogicraft.block.ModBlocks;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class PortableSmelterItem extends Item {
    private static final Map<Block, Block> PORTABLE_SMELTER_MAP = Map.of(
            Blocks.RAW_IRON_BLOCK, Blocks.IRON_BLOCK,
            Blocks.RAW_GOLD_BLOCK, Blocks.GOLD_BLOCK,
            Blocks.RAW_COPPER_BLOCK, Blocks.COPPER_BLOCK,
            ModBlocks.RAW_FADELOGITE_BLOCK.get(), ModBlocks.FADELOGITE_BLOCK.get()
    );

    public PortableSmelterItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if(PORTABLE_SMELTER_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(pContext.getClickedPos(), PORTABLE_SMELTER_MAP.get(clickedBlock).defaultBlockState());
                pContext.getItemInHand().hurtAndBreak(1,((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()), item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
                level.playSound(null, pContext.getClickedPos(), SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS);
                level.addParticle(ParticleTypes.FLAME, pContext.getClickedPos().getX(), pContext.getClickedPos().getY(), pContext.getClickedPos().getZ(), 0.15d, 0.15d, 0.15d);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
