package com.epherical.croptopia.world;

import com.epherical.croptopia.CroptopiaCommon;
import com.epherical.croptopia.common.Tags;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class FabricBiomeModifiers {
    private static final String CROP_PREFIX = "has_crop/";
    private static final String TREE_PREFIX = "has_tree/";
    private static final String SALT_PREFIX = "has_salt/";

    public static void register() {
        for (TagKey<Biome> biomeTag : Tags.getCroptopiaBiomeTags()) {
            BiomeModifications.addFeature(
                    context -> matches(context, biomeTag),
                    GenerationStep.Decoration.VEGETAL_DECORATION,
                    getPlacedFeatureKey(biomeTag)
            );
        }
    }

    private static boolean matches(BiomeSelectionContext context, TagKey<Biome> biomeTag) {
        return context.hasTag(biomeTag) && (!isSaltTag(biomeTag) || !context.hasTag(ConventionalBiomeTags.IS_SWAMP));
    }

    private static ResourceKey<PlacedFeature> getPlacedFeatureKey(TagKey<Biome> biomeTag) {
        String path = biomeTag.location().getPath();
        if (path.startsWith(CROP_PREFIX)) {
            return createPlacedFeatureKey(path.substring(CROP_PREFIX.length()) + "_crop_placed");
        }
        if (path.startsWith(TREE_PREFIX)) {
            return createPlacedFeatureKey(path.substring(TREE_PREFIX.length()) + "_tree_placed");
        }
        if (path.startsWith(SALT_PREFIX)) {
            return createPlacedFeatureKey("disk_salt_placed");
        }
        throw new IllegalArgumentException("Unsupported Croptopia biome tag: " + biomeTag.location());
    }

    private static boolean isSaltTag(TagKey<Biome> biomeTag) {
        return biomeTag.location().getPath().startsWith(SALT_PREFIX);
    }

    private static ResourceKey<PlacedFeature> createPlacedFeatureKey(String path) {
        return ResourceKey.create(Registries.PLACED_FEATURE, CroptopiaCommon.createIdentifier(path));
    }
}
