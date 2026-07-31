package com.epherical.croptopia.datagen;

import com.epherical.croptopia.register.Content;
import com.epherical.croptopia.register.helpers.FarmlandCrop;
import com.epherical.croptopia.register.helpers.Tree;
import com.epherical.croptopia.register.helpers.TreeCrop;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagAppender;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class CroptopiaBlockTagProvider extends TagsProvider<Block> {


    public CroptopiaBlockTagProvider(PackOutput output, ResourceKey<? extends Registry<Block>> registryKey,
                                     CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, registryKey, lookupProvider);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider arg) {
        generateSaplings();
        generateBarkLogs();
        generateLeaves();
        // in vanilla for bees only
        generateCrops();
        generateMisc();
    }

    protected void generateSaplings() {
        TagAppender<Block> saplings = this.tag(BlockItemTags.SAPLINGS.block());
        for (TreeCrop crop : TreeCrop.copy()) {
            saplings.add(key(crop.getSaplingBlock()));
        }
        for (Tree crop : Tree.copy()) {
            saplings.add(key(crop.getSaplingBlock()));
        }
    }

    protected void generateBarkLogs() {
        TagAppender<Block> burnableLog = this.tag(BlockItemTags.LOGS_THAT_BURN.block());
        for (Tree crop : Tree.copy()) {
            // add different log types to log tag of this crop
            tag(crop.getLogBlockTag())
                    .add(key(crop.getLog()))
                    .add(key(crop.getStrippedLog()))
                    .add(key(crop.getWood()))
                    .add(key(crop.getStrippedWood()));
            // make this crop log burnable
            burnableLog.addTag(crop.getLogBlockTag());
        }
    }

    protected void generateLeaves() {
        TagAppender<Block> leaves = this.tag(BlockTags.LEAVES);
        TagAppender<Block> hoe = this.tag(BlockTags.MINEABLE_WITH_HOE);
        for (TreeCrop crop : TreeCrop.TREE_CROPS) {
            leaves.add(key(crop.getLeaves()));
            hoe.add(key(crop.getLeaves()));
        }
        for (Tree crop : Tree.copy()) {
            leaves.add(key(crop.getLeaves()));
            hoe.add(key(crop.getLeaves()));
        }
    }

    protected void generateCrops() {
        TagAppender<Block> crops = this.tag(BlockTags.CROPS);
        for (FarmlandCrop crop : FarmlandCrop.copy()) {
            crops.add(key(crop.asBlock()));
        }
        for (TreeCrop crop : TreeCrop.copy()) {
            crops.add(key(crop.asBlock()));
        }
    }

    protected void generateMisc() {
        ResourceKey<Block> saltOre = key(Content.SALT_ORE_BLOCK);
        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(saltOre);
        tag(BlockTags.AZALEA_ROOT_REPLACEABLE).add(saltOre);
        tag(BlockTags.DRIPSTONE_REPLACEABLE).add(saltOre);
        tag(BlockTags.ENDERMAN_HOLDABLE).add(saltOre);
    }

    private static ResourceKey<Block> key(Block block) {
        return block.builtInRegistryHolder().key();
    }
}
