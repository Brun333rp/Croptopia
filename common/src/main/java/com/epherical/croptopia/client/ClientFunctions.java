package com.epherical.croptopia.client;

import com.epherical.croptopia.register.helpers.TreeCrop;
import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

import static com.epherical.croptopia.CroptopiaCommon.cropBlocks;
import static com.epherical.croptopia.CroptopiaCommon.leafBlocks;

public class ClientFunctions {

    public BlockTintSource registerLeafColors() {
        return BlockTintSources.foliage();
    }

    /*public ItemColor registerItemColors() {
        return (stack, tintIndex) -> {
            BlockState blockstate = ((BlockItem)stack.getItem()).getBlock().defaultBlockState();
            return Minecraft.getInstance().getBlockColors().getColor(blockstate, null, null, tintIndex);
        };
    }*/

    public Block[] leaves() {
        return leafBlocks.toArray(Block[]::new);
    }

    public Item[] items() {
        return TreeCrop.TREE_CROPS.stream().map(TreeCrop::getLeavesItem).toArray(Item[]::new);
    }

    public void registerBlockLayers(Consumer<Block> blockConsumer) {
        cropBlocks.forEach(blockConsumer);
    }
}
