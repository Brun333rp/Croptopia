package com.epherical.croptopia.items;

import com.epherical.croptopia.blocks.CroptopiaCropBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;

public class SeedItem extends ItemNameBlockItem {

    private TagKey<Biome> category;

    public SeedItem(Block block, Properties settings, TagKey<Biome> category) {
        super(block, settings);
        if (block instanceof CroptopiaCropBlock crop) {
            crop.setSeed(this);
        }
        this.category = category;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos hitPos = context.getClickedPos();
        Level world = context.getLevel();
        BlockState state = world.getBlockState(hitPos);
        if (state.getBlock() instanceof FarmBlock && context.getClickedFace() == Direction.UP) {
            return super.useOn(context);
        }
        return InteractionResult.FAIL;
    }

    public TagKey<Biome> getCategory() {
        return category;
    }
}
