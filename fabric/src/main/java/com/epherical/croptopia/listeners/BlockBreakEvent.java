package com.epherical.croptopia.listeners;

import com.epherical.croptopia.register.Content;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class BlockBreakEvent {

    public static void register() {
        StrippableBlockRegistry.register(Content.CINNAMON.getLog(), Content.CINNAMON.getStrippedLog());
        StrippableBlockRegistry.register(Content.CINNAMON.getWood(), Content.CINNAMON.getStrippedWood());

        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (world.isClientSide()) {
                return InteractionResult.PASS;
            }

            if (!(player.getItemInHand(hand).getItem() instanceof AxeItem)) {
                return InteractionResult.PASS;
            }

            BlockState state = world.getBlockState(hitResult.getBlockPos());
            if (!state.is(Content.CINNAMON.getLog()) && !state.is(Content.CINNAMON.getWood())) {
                return InteractionResult.PASS;
            }

            if (!player.isCreative()) {
                Block.popResourceFromFace(world, hitResult.getBlockPos(), hitResult.getDirection().getOpposite(), new ItemStack(Content.CINNAMON));
            }

            return InteractionResult.PASS;
        });
    }
}
