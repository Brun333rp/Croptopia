package com.epherical.croptopia.datagen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import static com.epherical.croptopia.CroptopiaNeoForge.MODID;
import static com.epherical.croptopia.common.Tags.*;
import static com.epherical.croptopia.common.generator.PlacedFeatureKeys.*;

public class CroptopiaWorldBiomeSelection {
    public static final ResourceKey<BiomeModifier> ADD_ALMOND_TREE_TO_BIOMES = createKey("add_almond_tree_to_biome");
    public static final ResourceKey<BiomeModifier> ADD_APPLE_TREE_TO_BIOMES = createKey("add_apple_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_APRICOT_TREE_TO_BIOMES = createKey("add_apricot_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_AVOCADO_TREE_TO_BIOMES = createKey("add_avocado_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_BANANA_TREE_TO_BIOMES = createKey("add_banana_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_CASHEW_TREE_TO_BIOMES = createKey("add_cashew_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_CHERRY_TREE_TO_BIOMES = createKey("add_cherry_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_COCONUT_TREE_TO_BIOMES = createKey("add_coconut_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_DATE_TREE_TO_BIOMES = createKey("add_date_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_DRAGONFRUIT_TREE_TO_BIOMES = createKey("add_dragonfruit_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_FIG_TREE_TO_BIOMES = createKey("add_fig_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_GRAPEFRUIT_TREE_TO_BIOMES = createKey("add_grapefruit_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_KUMQUAT_TREE_TO_BIOMES = createKey("add_kumquat_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_LEMON_TREE_TO_BIOMES = createKey("add_lemon_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_LIME_TREE_TO_BIOMES = createKey("add_lime_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_MANGO_TREE_TO_BIOMES = createKey("add_mango_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_NECTARINE_TREE_TO_BIOMES = createKey("add_nectarine_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_NUTMEG_TREE_TO_BIOMES = createKey("add_nutmeg_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_ORANGE_TREE_TO_BIOMES = createKey("add_orange_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_PEACH_TREE_TO_BIOMES = createKey("add_peach_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_PEAR_TREE_TO_BIOMES = createKey("add_pear_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_PECAN_TREE_TO_BIOMES = createKey("add_pecan_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_PERSIMMON_TREE_TO_BIOMES = createKey("add_persimmon_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_PLUM_TREE_TO_BIOMES = createKey("add_plum_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_STARFRUIT_TREE_TO_BIOMES = createKey("add_starfruit_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_WALNUT_TREE_TO_BIOMES = createKey("add_walnut_tree_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_CINNAMON_TREE_TO_BIOMES = createKey("add_cinnamon_tree_to_biomes");

    public static final ResourceKey<BiomeModifier> ADD_ARTICHOKE_CROP_TO_BIOMES = createKey("add_artichoke_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_ASPARAGUS_CROP_TO_BIOMES = createKey("add_asparagus_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_BARLEY_CROP_TO_BIOMES = createKey("add_barley_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_BASIL_CROP_TO_BIOMES = createKey("add_basil_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_BELLPEPPER_CROP_TO_BIOMES = createKey("add_bellpepper_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_BLACKBEAN_CROP_TO_BIOMES = createKey("add_blackbean_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_BLACKBERRY_CROP_TO_BIOMES = createKey("add_blackberry_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_BLUEBERRY_CROP_TO_BIOMES = createKey("add_blueberry_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_BROCCOLI_CROP_TO_BIOMES = createKey("add_broccoli_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_CABBAGE_CROP_TO_BIOMES = createKey("add_cabbage_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_CANTALOUPE_CROP_TO_BIOMES = createKey("add_cantaloupe_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_CAULIFLOWER_CROP_TO_BIOMES = createKey("add_cauliflower_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_CELERY_CROP_TO_BIOMES = createKey("add_celery_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_CHILE_PEPPER_CROP_TO_BIOMES = createKey("add_chile_pepper_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_COFFEE_BEANS_CROP_TO_BIOMES = createKey("add_coffee_beans_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_CORN_CROP_TO_BIOMES = createKey("add_corn_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_CRANBERRY_CROP_TO_BIOMES = createKey("add_cranberry_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_CUCUMBER_CROP_TO_BIOMES = createKey("add_cucumber_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_CURRANT_CROP_TO_BIOMES = createKey("add_currant_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_EGGPLANT_CROP_TO_BIOMES = createKey("add_eggplant_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_ELDERBERRY_CROP_TO_BIOMES = createKey("add_elderberry_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_GARLIC_CROP_TO_BIOMES = createKey("add_garlic_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_GINGER_CROP_TO_BIOMES = createKey("add_ginger_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_GRAPE_CROP_TO_BIOMES = createKey("add_grape_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_GREENBEAN_CROP_TO_BIOMES = createKey("add_greenbean_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_GREENONION_CROP_TO_BIOMES = createKey("add_greenonion_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_HONEYDEW_CROP_TO_BIOMES = createKey("add_honeydew_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_HOPS_CROP_TO_BIOMES = createKey("add_hops_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_KALE_CROP_TO_BIOMES = createKey("add_kale_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_KIWI_CROP_TO_BIOMES = createKey("add_kiwi_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_LEEK_CROP_TO_BIOMES = createKey("add_leek_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_LETTUCE_CROP_TO_BIOMES = createKey("add_lettuce_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_MUSTARD_CROP_TO_BIOMES = createKey("add_mustard_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_OAT_CROP_TO_BIOMES = createKey("add_oat_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_OLIVE_CROP_TO_BIOMES = createKey("add_olive_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_ONION_CROP_TO_BIOMES = createKey("add_onion_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_PEANUT_CROP_TO_BIOMES = createKey("add_peanut_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_PEPPER_CROP_TO_BIOMES = createKey("add_pepper_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_PINEAPPLE_CROP_TO_BIOMES = createKey("add_pineapple_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_RADISH_CROP_TO_BIOMES = createKey("add_radish_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_RASPBERRY_CROP_TO_BIOMES = createKey("add_raspberry_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_RHUBARB_CROP_TO_BIOMES = createKey("add_rhubarb_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_RICE_CROP_TO_BIOMES = createKey("add_rice_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_RUTABAGA_CROP_TO_BIOMES = createKey("add_rutabaga_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_SAGUARO_CROP_TO_BIOMES = createKey("add_saguaro_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_SOYBEAN_CROP_TO_BIOMES = createKey("add_soybean_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_SPINACH_CROP_TO_BIOMES = createKey("add_spinach_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_SQUASH_CROP_TO_BIOMES = createKey("add_squash_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_STRAWBERRY_CROP_TO_BIOMES = createKey("add_strawberry_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_SWEETPOTATO_CROP_TO_BIOMES = createKey("add_sweetpotato_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_TEA_LEAVES_CROP_TO_BIOMES = createKey("add_tea_leaves_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_TOMATILLO_CROP_TO_BIOMES = createKey("add_tomatillo_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_TOMATO_CROP_TO_BIOMES = createKey("add_tomato_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_TURMERIC_CROP_TO_BIOMES = createKey("add_turmeric_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_TURNIP_CROP_TO_BIOMES = createKey("add_turnip_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_VANILLA_CROP_TO_BIOMES = createKey("add_vanilla_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_YAM_CROP_TO_BIOMES = createKey("add_yam_crop_to_biomes");
    public static final ResourceKey<BiomeModifier> ADD_ZUCCHINI_CROP_TO_BIOMES = createKey("add_zucchini_crop_to_biomes");

    public static final ResourceKey<BiomeModifier> ADD_SALT_TO_BIOMES = createKey("add_salt_to_biomes");




    public CroptopiaWorldBiomeSelection(BootstrapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        new BiomeMod(context, biomes, placedFeatures, ALMOND_TREE_PLACED_KEY, ADD_ALMOND_TREE_TO_BIOMES, HAS_ALMOND);
        new BiomeMod(context, biomes, placedFeatures, APPLE_TREE_PLACED_KEY, ADD_APPLE_TREE_TO_BIOMES, HAS_APPLE);
        new BiomeMod(context, biomes, placedFeatures, APRICOT_TREE_PLACED_KEY, ADD_APRICOT_TREE_TO_BIOMES, HAS_APRICOT);
        new BiomeMod(context, biomes, placedFeatures, AVOCADO_TREE_PLACED_KEY, ADD_AVOCADO_TREE_TO_BIOMES, HAS_AVOCADO);
        new BiomeMod(context, biomes, placedFeatures, BANANA_TREE_PLACED_KEY, ADD_BANANA_TREE_TO_BIOMES, HAS_BANANA);
        new BiomeMod(context, biomes, placedFeatures, CASHEW_TREE_PLACED_KEY, ADD_CASHEW_TREE_TO_BIOMES, HAS_CASHEW);
        new BiomeMod(context, biomes, placedFeatures, CHERRY_TREE_PLACED_KEY, ADD_CHERRY_TREE_TO_BIOMES, HAS_CHERRY);
        new BiomeMod(context, biomes, placedFeatures, COCONUT_TREE_PLACED_KEY, ADD_COCONUT_TREE_TO_BIOMES, HAS_COCONUT);
        new BiomeMod(context, biomes, placedFeatures, DATE_TREE_PLACED_KEY, ADD_DATE_TREE_TO_BIOMES, HAS_DATE);
        new BiomeMod(context, biomes, placedFeatures, DRAGONFRUIT_TREE_PLACED_KEY, ADD_DRAGONFRUIT_TREE_TO_BIOMES, HAS_DRAGONFRUIT);
        new BiomeMod(context, biomes, placedFeatures, FIG_TREE_PLACED_KEY, ADD_FIG_TREE_TO_BIOMES, HAS_FIG);
        new BiomeMod(context, biomes, placedFeatures, GRAPEFRUIT_TREE_PLACED_KEY, ADD_GRAPEFRUIT_TREE_TO_BIOMES, HAS_GRAPEFRUIT);
        new BiomeMod(context, biomes, placedFeatures, KUMQUAT_TREE_PLACED_KEY, ADD_KUMQUAT_TREE_TO_BIOMES, HAS_KUMQUAT);
        new BiomeMod(context, biomes, placedFeatures, LEMON_TREE_PLACED_KEY, ADD_LEMON_TREE_TO_BIOMES, HAS_LEMON);
        new BiomeMod(context, biomes, placedFeatures, LIME_TREE_PLACED_KEY, ADD_LIME_TREE_TO_BIOMES, HAS_LIME);
        new BiomeMod(context, biomes, placedFeatures, MANGO_TREE_PLACED_KEY, ADD_MANGO_TREE_TO_BIOMES, HAS_MANGO);
        new BiomeMod(context, biomes, placedFeatures, NECTARINE_TREE_PLACED_KEY, ADD_NECTARINE_TREE_TO_BIOMES, HAS_NECTARINE);
        new BiomeMod(context, biomes, placedFeatures, NUTMEG_TREE_PLACED_KEY, ADD_NUTMEG_TREE_TO_BIOMES, HAS_NUTMEG);
        new BiomeMod(context, biomes, placedFeatures, ORANGE_TREE_PLACED_KEY, ADD_ORANGE_TREE_TO_BIOMES, HAS_ORANGE);
        new BiomeMod(context, biomes, placedFeatures, PEACH_TREE_PLACED_KEY, ADD_PEACH_TREE_TO_BIOMES, HAS_PEACH);
        new BiomeMod(context, biomes, placedFeatures, PEAR_TREE_PLACED_KEY, ADD_PEAR_TREE_TO_BIOMES, HAS_PEAR);
        new BiomeMod(context, biomes, placedFeatures, PECAN_TREE_PLACED_KEY, ADD_PECAN_TREE_TO_BIOMES, HAS_PECAN);
        new BiomeMod(context, biomes, placedFeatures, PERSIMMON_TREE_PLACED_KEY, ADD_PERSIMMON_TREE_TO_BIOMES, HAS_PERSIMMON);
        new BiomeMod(context, biomes, placedFeatures, PLUM_TREE_PLACED_KEY, ADD_PLUM_TREE_TO_BIOMES, HAS_PLUM);
        new BiomeMod(context, biomes, placedFeatures, STARFRUIT_TREE_PLACED_KEY, ADD_STARFRUIT_TREE_TO_BIOMES, HAS_STARFRUIT);
        new BiomeMod(context, biomes, placedFeatures, WALNUT_TREE_PLACED_KEY, ADD_WALNUT_TREE_TO_BIOMES, HAS_WALNUT);
        new BiomeMod(context, biomes, placedFeatures, CINNAMON_TREE_PLACED_KEY, ADD_CINNAMON_TREE_TO_BIOMES, HAS_CINNAMON);

        new BiomeMod(context, biomes, placedFeatures, ARTICHOKE_CROP_PLACED_KEY, ADD_ARTICHOKE_CROP_TO_BIOMES, HAS_ARTICHOKE);
        new BiomeMod(context, biomes, placedFeatures, ASPARAGUS_CROP_PLACED_KEY, ADD_ASPARAGUS_CROP_TO_BIOMES, HAS_ASPARAGUS);
        new BiomeMod(context, biomes, placedFeatures, BARLEY_CROP_PLACED_KEY, ADD_BARLEY_CROP_TO_BIOMES, HAS_BARLEY);
        new BiomeMod(context, biomes, placedFeatures, BASIL_CROP_PLACED_KEY, ADD_BASIL_CROP_TO_BIOMES, HAS_BASIL);
        new BiomeMod(context, biomes, placedFeatures, BELLPEPPER_CROP_PLACED_KEY, ADD_BELLPEPPER_CROP_TO_BIOMES, HAS_BELLPEPPER);
        new BiomeMod(context, biomes, placedFeatures, BLACKBEAN_CROP_PLACED_KEY, ADD_BLACKBEAN_CROP_TO_BIOMES, HAS_BLACKBEAN);
        new BiomeMod(context, biomes, placedFeatures, BLACKBERRY_CROP_PLACED_KEY, ADD_BLACKBERRY_CROP_TO_BIOMES, HAS_BLACKBERRY);
        new BiomeMod(context, biomes, placedFeatures, BLUEBERRY_CROP_PLACED_KEY, ADD_BLUEBERRY_CROP_TO_BIOMES, HAS_BLUEBERRY);
        new BiomeMod(context, biomes, placedFeatures, BROCCOLI_CROP_PLACED_KEY, ADD_BROCCOLI_CROP_TO_BIOMES, HAS_BROCCOLI);
        new BiomeMod(context, biomes, placedFeatures, CABBAGE_CROP_PLACED_KEY, ADD_CABBAGE_CROP_TO_BIOMES, HAS_CABBAGE);
        new BiomeMod(context, biomes, placedFeatures, CANTALOUPE_CROP_PLACED_KEY, ADD_CANTALOUPE_CROP_TO_BIOMES, HAS_CANTALOUPE);
        new BiomeMod(context, biomes, placedFeatures, CAULIFLOWER_CROP_PLACED_KEY, ADD_CAULIFLOWER_CROP_TO_BIOMES, HAS_CAULIFLOWER);
        new BiomeMod(context, biomes, placedFeatures, CELERY_CROP_PLACED_KEY, ADD_CELERY_CROP_TO_BIOMES, HAS_CELERY);
        new BiomeMod(context, biomes, placedFeatures, COFFEE_BEANS_CROP_PLACED_KEY, ADD_COFFEE_BEANS_CROP_TO_BIOMES, HAS_COFFEE_BEANS);
        new BiomeMod(context, biomes, placedFeatures, CORN_CROP_PLACED_KEY, ADD_CORN_CROP_TO_BIOMES, HAS_CORN);
        new BiomeMod(context, biomes, placedFeatures, CRANBERRY_CROP_PLACED_KEY, ADD_CRANBERRY_CROP_TO_BIOMES, HAS_CRANBERRY);
        new BiomeMod(context, biomes, placedFeatures, CUCUMBER_CROP_PLACED_KEY, ADD_CUCUMBER_CROP_TO_BIOMES, HAS_CUCUMBER);
        new BiomeMod(context, biomes, placedFeatures, CURRANT_CROP_PLACED_KEY, ADD_CURRANT_CROP_TO_BIOMES, HAS_CURRANT);
        new BiomeMod(context, biomes, placedFeatures, EGGPLANT_CROP_PLACED_KEY, ADD_EGGPLANT_CROP_TO_BIOMES, HAS_EGGPLANT);
        new BiomeMod(context, biomes, placedFeatures, ELDERBERRY_CROP_PLACED_KEY, ADD_ELDERBERRY_CROP_TO_BIOMES, HAS_ELDERBERRY);
        new BiomeMod(context, biomes, placedFeatures, GARLIC_CROP_PLACED_KEY, ADD_GARLIC_CROP_TO_BIOMES, HAS_GARLIC);
        new BiomeMod(context, biomes, placedFeatures, GINGER_CROP_PLACED_KEY, ADD_GINGER_CROP_TO_BIOMES, HAS_GINGER);
        new BiomeMod(context, biomes, placedFeatures, GRAPE_CROP_PLACED_KEY, ADD_GRAPE_CROP_TO_BIOMES, HAS_GRAPE);
        new BiomeMod(context, biomes, placedFeatures, GREENBEAN_CROP_PLACED_KEY, ADD_GREENBEAN_CROP_TO_BIOMES, HAS_GREENBEAN);
        new BiomeMod(context, biomes, placedFeatures, GREENONION_CROP_PLACED_KEY, ADD_GREENONION_CROP_TO_BIOMES, HAS_GREENONION);
        new BiomeMod(context, biomes, placedFeatures, HONEYDEW_CROP_PLACED_KEY, ADD_HONEYDEW_CROP_TO_BIOMES, HAS_HONEYDEW);
        new BiomeMod(context, biomes, placedFeatures, HOPS_CROP_PLACED_KEY, ADD_HOPS_CROP_TO_BIOMES, HAS_HOPS);
        new BiomeMod(context, biomes, placedFeatures, KALE_CROP_PLACED_KEY, ADD_KALE_CROP_TO_BIOMES, HAS_KALE);
        new BiomeMod(context, biomes, placedFeatures, KIWI_CROP_PLACED_KEY, ADD_KIWI_CROP_TO_BIOMES, HAS_KIWI);
        new BiomeMod(context, biomes, placedFeatures, LEEK_CROP_PLACED_KEY, ADD_LEEK_CROP_TO_BIOMES, HAS_LEEK);
        new BiomeMod(context, biomes, placedFeatures, LETTUCE_CROP_PLACED_KEY, ADD_LETTUCE_CROP_TO_BIOMES, HAS_LETTUCE);
        new BiomeMod(context, biomes, placedFeatures, MUSTARD_CROP_PLACED_KEY, ADD_MUSTARD_CROP_TO_BIOMES, HAS_MUSTARD);
        new BiomeMod(context, biomes, placedFeatures, OAT_CROP_PLACED_KEY, ADD_OAT_CROP_TO_BIOMES, HAS_OAT);
        new BiomeMod(context, biomes, placedFeatures, OLIVE_CROP_PLACED_KEY, ADD_OLIVE_CROP_TO_BIOMES, HAS_OLIVE);
        new BiomeMod(context, biomes, placedFeatures, ONION_CROP_PLACED_KEY, ADD_ONION_CROP_TO_BIOMES, HAS_ONION);
        new BiomeMod(context, biomes, placedFeatures, PEANUT_CROP_PLACED_KEY, ADD_PEANUT_CROP_TO_BIOMES, HAS_PEANUT);
        new BiomeMod(context, biomes, placedFeatures, CHILE_PEPPER_CROP_PLACED_KEY, ADD_CHILE_PEPPER_CROP_TO_BIOMES, HAS_CHILE_PEPPER);
        new BiomeMod(context, biomes, placedFeatures, PINEAPPLE_CROP_PLACED_KEY, ADD_PINEAPPLE_CROP_TO_BIOMES, HAS_PINEAPPLE);
        new BiomeMod(context, biomes, placedFeatures, RADISH_CROP_PLACED_KEY, ADD_RADISH_CROP_TO_BIOMES, HAS_RADISH);
        new BiomeMod(context, biomes, placedFeatures, RASPBERRY_CROP_PLACED_KEY, ADD_RASPBERRY_CROP_TO_BIOMES, HAS_RASPBERRY);
        new BiomeMod(context, biomes, placedFeatures, RHUBARB_CROP_PLACED_KEY, ADD_RHUBARB_CROP_TO_BIOMES, HAS_RHUBARB);
        new BiomeMod(context, biomes, placedFeatures, RICE_CROP_PLACED_KEY, ADD_RICE_CROP_TO_BIOMES, HAS_RICE);
        new BiomeMod(context, biomes, placedFeatures, RUTABAGA_CROP_PLACED_KEY, ADD_RUTABAGA_CROP_TO_BIOMES, HAS_RUTABAGA);
        new BiomeMod(context, biomes, placedFeatures, SAGUARO_CROP_PLACED_KEY, ADD_SAGUARO_CROP_TO_BIOMES, HAS_SAGUARO);
        new BiomeMod(context, biomes, placedFeatures, SOYBEAN_CROP_PLACED_KEY, ADD_SOYBEAN_CROP_TO_BIOMES, HAS_SOYBEAN);
        new BiomeMod(context, biomes, placedFeatures, SPINACH_CROP_PLACED_KEY, ADD_SPINACH_CROP_TO_BIOMES, HAS_SPINACH);
        new BiomeMod(context, biomes, placedFeatures, SQUASH_CROP_PLACED_KEY, ADD_SQUASH_CROP_TO_BIOMES, HAS_SQUASH);
        new BiomeMod(context, biomes, placedFeatures, STRAWBERRY_CROP_PLACED_KEY, ADD_STRAWBERRY_CROP_TO_BIOMES, HAS_STRAWBERRY);
        new BiomeMod(context, biomes, placedFeatures, SWEETPOTATO_CROP_PLACED_KEY, ADD_SWEETPOTATO_CROP_TO_BIOMES, HAS_SWEETPOTATO);
        new BiomeMod(context, biomes, placedFeatures, TOMATILLO_CROP_PLACED_KEY, ADD_TOMATILLO_CROP_TO_BIOMES, HAS_TOMATILLO);
        new BiomeMod(context, biomes, placedFeatures, TOMATO_CROP_PLACED_KEY, ADD_TOMATO_CROP_TO_BIOMES, HAS_TOMATO);
        new BiomeMod(context, biomes, placedFeatures, TURMERIC_CROP_PLACED_KEY, ADD_TURMERIC_CROP_TO_BIOMES, HAS_TURMERIC);
        new BiomeMod(context, biomes, placedFeatures, TURNIP_CROP_PLACED_KEY, ADD_TURNIP_CROP_TO_BIOMES, HAS_TURNIP);
        new BiomeMod(context, biomes, placedFeatures, YAM_CROP_PLACED_KEY, ADD_YAM_CROP_TO_BIOMES, HAS_YAM);
        new BiomeMod(context, biomes, placedFeatures, ZUCCHINI_CROP_PLACED_KEY, ADD_ZUCCHINI_CROP_TO_BIOMES, HAS_ZUCCHINI);
        new BiomeMod(context, biomes, placedFeatures, VANILLA_CROP_PLACED_KEY, ADD_VANILLA_CROP_TO_BIOMES, HAS_VANILLA);
        new BiomeMod(context, biomes, placedFeatures, PEPPER_CROP_PLACED_KEY, ADD_PEPPER_CROP_TO_BIOMES, HAS_PEPPER);
        new BiomeMod(context, biomes, placedFeatures, TEA_LEAVES_CROP_PLACED_KEY, ADD_TEA_LEAVES_CROP_TO_BIOMES, HAS_TEA_LEAVES);


        new BiomeMod(context, biomes, placedFeatures, DISK_SALT_PLACED_KEY, ADD_SALT_TO_BIOMES, HAS_SALT);


    }


    public static ResourceKey<BiomeModifier> createKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(MODID, name));
    }

    public static class BiomeMod {
        public BiomeMod(BootstrapContext<BiomeModifier> modifier,
                        HolderGetter<Biome> biomeGetter, HolderGetter<PlacedFeature> feature,
                        ResourceKey<PlacedFeature> featureKey, ResourceKey<BiomeModifier> biomeModifier, TagKey<Biome> biomes) {
            modifier.register(biomeModifier,
                    new BiomeModifiers.AddFeaturesBiomeModifier(
                            biomeGetter.getOrThrow(biomes),
                            //HolderSet.direct(Stream.of(biomeTag).map(biomeGetter::getOrThrow).toList()),
                            HolderSet.direct(feature.getOrThrow(featureKey)),
                            GenerationStep.Decoration.VEGETAL_DECORATION
                    ));

        }

    }
}
