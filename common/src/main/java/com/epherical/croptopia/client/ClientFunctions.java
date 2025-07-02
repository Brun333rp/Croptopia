package com.epherical.croptopia.client;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

import static com.epherical.croptopia.CroptopiaCommon.cropBlocks;
import static com.epherical.croptopia.CroptopiaCommon.leafBlocks;

public class ClientFunctions {

    public BlockColor registerLeafColors() {
        return (state, world, pos, tintIndex) ->
                world != null && pos != null
                        ? BiomeColors.getAverageFoliageColor(world, pos)
                        : FoliageColor.getDefaultColor();
    }

    public Block[] leaves() {
        return leafBlocks.toArray(Block[]::new);
    }

    public void registerBlockLayers(Consumer<Block> blockConsumer) {
        cropBlocks.forEach(blockConsumer);
    }
}
