package com.epherical.croptopia.datagen;


import com.epherical.croptopia.register.Content;
import com.epherical.croptopia.register.helpers.IceCream;
import com.epherical.croptopia.register.helpers.Jam;
import com.epherical.croptopia.register.helpers.Pie;
import com.epherical.croptopia.register.helpers.Tree;
import com.epherical.croptopia.register.helpers.TreeCrop;
import com.epherical.croptopia.register.helpers.Utensil;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagAppender;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.Tags;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import static com.epherical.croptopia.CroptopiaCommon.seeds;
import static com.epherical.croptopia.CroptopiaNeoForge.MODID;

public class CroptopiaItemTagProvider extends CroptopiaIndependentItemTagProvider {

    public CroptopiaItemTagProvider(PackOutput output, ResourceKey<? extends Registry<Item>> registryKey,
                                    CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, registryKey, lookupProvider);
    }


    @Override
    protected void addTags(HolderLookup.@NonNull Provider arg) {
        super.addTags(arg);
        generateSaplings();
        generateBarkLogs();
        generateAdvancementFoodCrafted();
        // currently, only generates air, but leaves item tag isn't used by vanilla anyway
        // generateLeaves();
        generateMisc();
        generateSeedsEatenByTag(ItemTags.CHICKEN_FOOD);
        generateSeedsEatenByTag(ItemTags.PARROT_FOOD);

        tag(ItemTags.PIG_FOOD)
                .add(key(Content.YAM.asItem()))
                .add(key(Content.SWEETPOTATO.asItem()));

        tag(ItemTags.COW_FOOD)
                .add(key(Content.BARLEY.asItem()))
                .add(key(Content.CORN.asItem()));

        generateToolsTags(Tags.Items.TOOLS);

    }

    protected void generateToolsTags(TagKey<Item> key) {
        TagAppender<Item> tag = tag(key);
        for (Utensil utensil : Utensil.copy()) {
            tag.add(key(utensil.asItem()));
        }
        TagAppender<Item> c = tag(TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", "tools/knife")));
        c.add(key(Content.KNIFE.asItem()));
    }

    protected void generateSeedsEatenByTag(TagKey<Item> key) {
        TagAppender<Item> tag = tag(key);
        for (Item seed : seeds) {
            tag.add(key(seed));
        }
    }


    protected void generateSaplings() {
        TagAppender<Item> saplings = tag(BlockItemTags.SAPLINGS.item());
        for (TreeCrop crop : TreeCrop.copy()) {
            saplings.add(key(crop.getSaplingItem()));
        }
        for (Tree crop : Tree.copy()) {
            saplings.add(key(crop.getSapling()));
        }
    }

    protected void generateBarkLogs() {
        TagAppender<Item> burnableLog = tag(BlockItemTags.LOGS_THAT_BURN.item());
        for (Tree crop : Tree.copy()) {
            // add different log types to log tag of this crop
            tag(crop.getLogItemTag())
                    .add(key(crop.getLog().asItem()))
                    .add(key(crop.getStrippedLog().asItem()))
                    .add(key(crop.getWood().asItem()))
                    .add(key(crop.getStrippedWood().asItem()));
            // make this crop log burnable
            burnableLog.addTag(crop.getLogItemTag());
        }
    }

    protected void generateLeaves() {
        TagAppender<Item> leaves = tag(BlockItemTags.LEAVES.item());
        for (TreeCrop crop : TreeCrop.copy()) {
            leaves.add(key(crop.getLeaves().asItem()));
        }
        for (Tree crop : Tree.copy()) {
            leaves.add(key(crop.getLeaves().asItem()));
        }
    }

    protected void generateMisc() {
        TagAppender<Item> crops = tag(ItemTags.VILLAGER_PLANTABLE_SEEDS);
        for (Item seed : seeds) {
            crops.add(key(seed));
        }
        // explicitly used as dolphin food in vanilla
        TagAppender<Item> fishes = tag(ItemTags.FISHES);
        fishes.add(key(Content.ANCHOVY.asItem()));
        fishes.add(key(Content.CALAMARI.asItem()));
        fishes.add(key(Content.GLOWING_CALAMARI.asItem()));
        fishes.add(key(Content.CLAM.asItem()));
        fishes.add(key(Content.CRAB.asItem()));
        fishes.add(key(Content.OYSTER.asItem()));
        fishes.add(key(Content.ROE.asItem()));
        fishes.add(key(Content.SHRIMP.asItem()));
        fishes.add(key(Content.TUNA.asItem()));
        // fox food: all berries added by croptopia
        TagAppender<Item> foxFood = tag(ItemTags.FOX_FOOD);
        foxFood.add(key(Content.BLACKBERRY.asItem()));
        foxFood.add(key(Content.BLUEBERRY.asItem()));
        foxFood.add(key(Content.CRANBERRY.asItem()));
        foxFood.add(key(Content.ELDERBERRY.asItem()));
        foxFood.add(key(Content.RASPBERRY.asItem()));
        foxFood.add(key(Content.STRAWBERRY.asItem()));
        // piglin food: more cannibalism (which already happens in vanilla)
        TagAppender<Item> piglinFood = tag(ItemTags.PIGLIN_FOOD);
        piglinFood.add(key(Content.HAM_SANDWICH));
        piglinFood.add(key(Content.PEPPERONI));
        piglinFood.add(key(Content.PORK_AND_BEANS));
        piglinFood.add(key(Content.PORK_JERKY));
        piglinFood.add(key(Content.RAW_BACON));
        piglinFood.add(key(Content.COOKED_BACON.asItem()));
    }

    protected void generateAdvancementFoodCrafted() {
        TagAppender<Item> craftedFoods = tag(croptopiaTag("advancements_food_crafted"));

        for (Jam jam : Jam.copy()) {
            craftedFoods.add(key(jam.asItem()));
        }
        for (IceCream iceCream : IceCream.copy()) {
            craftedFoods.add(key(iceCream.asItem()));
        }
        for (Pie pie : Pie.copy()) {
            craftedFoods.add(key(pie.asItem()));
        }

        craftedFoods.addAll(Stream.of(
                Content.ALMOND_BRITTLE,
                Content.ARTICHOKE_DIP,
                Content.BANANA_CREAM_PIE,
                Content.BANANA_NUT_BREAD,
                Content.BLT,
                Content.BROWNIES,
                Content.BURRITO,
                Content.CANDIED_KUMQUATS,
                Content.ROASTED_PUMPKIN_SEEDS,
                Content.ROASTED_SUNFLOWER_SEEDS,
                Content.PUMPKIN_BARS,
                Content.CORN_BREAD,
                Content.PUMPKIN_SOUP,
                Content.MERINGUE,
                Content.CABBAGE_ROLL,
                Content.BORSCHT,
                Content.GOULASH,
                Content.BEETROOT_SALAD,
                Content.STEAMED_CRAB,
                Content.DEEP_FRIED_SHRIMP,
                Content.TUNA_ROLL,
                Content.FRIED_CALAMARI,
                Content.CRAB_LEGS,
                Content.STEAMED_CLAMS,
                Content.GRILLED_OYSTERS,
                Content.ANCHOVY_PIZZA,
                Content.MASHED_POTATOES,
                Content.TORTILLA,
                Content.SWEET_CREPES,
                Content.BAKED_CREPES,
                Content.QUICHE,
                Content.DAUPHINE_POTATOES,
                Content.CROQUE_MONSIEUR,
                Content.CROQUE_MADAME,
                Content.SUNNY_SIDE_EGGS,
                Content.MACARON,
                Content.THE_BIG_BREAKFAST,
                Content.GROUND_PORK,
                Content.SAUSAGE,
                Content.CINNAMON_ROLL,
                Content.HASHED_BROWN,
                Content.BEEF_JERKY,
                Content.PORK_JERKY,
                Content.DRAGON_EGG_OMELETTE,
                Content.NETHER_STAR_CAKE,
                Content.TRANSCENDENTAL_BREAKFAST,
                Content.BUTTER,
                Content.BUTTERED_TOAST,
                Content.CAESAR_SALAD,
                Content.CANDIED_NUTS,
                Content.CANDY_CORN,
                Content.CARNITAS,
                Content.CASHEW_CHICKEN,
                Content.CHEESE,
                Content.CHEESEBURGER,
                Content.CHEESE_PIZZA,
                Content.CHICKEN_AND_DUMPLINGS,
                Content.CHICKEN_AND_NOODLES,
                Content.CHICKEN_AND_RICE,
                Content.CHILI_RELLENO,
                Content.CHIMICHANGA,
                Content.CHOCOLATE,
                Content.CHURROS,
                Content.CORN_HUSK,
                Content.CREMA,
                Content.CUCUMBER_SALAD,
                Content.DOUGH,
                Content.DOUGHNUT,
                Content.EGG_ROLL,
                Content.ENCHILADA,
                Content.FAJITAS,
                Content.FLOUR,
                Content.FRENCH_FRIES,
                Content.FRIED_CHICKEN,
                Content.FRUIT_SALAD,
                Content.GRILLED_CHEESE,
                Content.HAMBURGER,
                Content.HAM_SANDWICH,
                Content.KALE_CHIPS,
                Content.LEAFY_SALAD,
                Content.LEEK_SOUP,
                Content.NOODLE,
                Content.NOUGAT,
                Content.NUTTY_COOKIE,
                Content.OATMEAL,
                Content.OLIVE_OIL,
                Content.ONION_RINGS,
                Content.PAPRIKA,
                Content.PEANUT_BUTTER_AND_JAM,
                Content.PEPPERONI,
                Content.PINEAPPLE_PEPPERONI_PIZZA,
                Content.PIZZA,
                Content.PORK_AND_BEANS,
                Content.POTATO_CHIPS,
                Content.PROTEIN_BAR,
                Content.QUESADILLA,
                Content.OATMEAL_COOKIE,
                Content.RAVIOLI,
                Content.REFRIED_BEANS,
                Content.RUM_RAISIN_ICE_CREAM,
                Content.SALSA,
                Content.SAUCY_CHIPS,
                Content.SCRAMBLED_EGGS,
                Content.AJVAR,
                Content.AJVAR_TOAST,
                Content.AVOCADO_TOAST,
                Content.RAW_BACON,
                Content.BEEF_STEW,
                Content.BEEF_STIR_FRY,
                Content.BEEF_WELLINGTON,
                Content.BUTTERED_GREEN_BEANS,
                Content.CHEESY_ASPARAGUS,
                Content.CHOCOLATE_ICE_CREAM,
                Content.CORNISH_PASTY,
                Content.EGGPLANT_PARMESAN,
                Content.ETON_MESS,
                Content.FIGGY_PUDDING,
                Content.FISH_AND_CHIPS,
                Content.FRUIT_CAKE,
                Content.GRILLED_EGGPLANT,
                Content.KIWI_SORBET,
                Content.LEMON_COCONUT_BAR,
                Content.NETHER_WART_STEW,
                Content.PEANUT_BUTTER,
                Content.PEANUT_BUTTER_W_CELERY,
                Content.POTATO_SOUP,
                Content.RATATOUILLE,
                Content.RHUBARB_CRISP,
                Content.ROASTED_ASPARAGUS,
                Content.ROASTED_RADISHES,
                Content.ROASTED_SQUASH,
                Content.ROASTED_TURNIPS,
                Content.SCONES,
                Content.SHEPHERDS_PIE,
                Content.STEAMED_BROCCOLI,
                Content.STEAMED_GREEN_BEANS,
                Content.STICKY_TOFFEE_PUDDING,
                Content.STIR_FRY,
                Content.STUFFED_ARTICHOKE,
                Content.TOAST_SANDWICH,
                Content.SNICKER_DOODLE,
                Content.SOY_SAUCE,
                Content.SPAGHETTI_SQUASH,
                Content.STEAMED_RICE,
                Content.STUFFED_POBLANOS,
                Content.SUPREME_PIZZA,
                Content.SUSHI,
                Content.SWEET_POTATO_FRIES,
                Content.TACO,
                Content.TAMALES,
                Content.TOAST_WITH_JAM,
                Content.TOFU,
                Content.TOFUBURGER,
                Content.TOFU_AND_DUMPLINGS,
                Content.TOSTADA,
                Content.TRAIL_MIX,
                Content.TRES_LECHE_CAKE,
                Content.VEGGIE_SALAD,
                Content.WHIPPING_CREAM,
                Content.YAM_JAM,
                Content.YOGHURT,
                Content.CARROT_CAKE,
                Content.PICKLED_CUCUMBER,
                Content.PICKLED_BEETS,
                Content.PICKLED_RADISH,
                Content.PICKLED_GARLIC,
                Content.PICKLED_ONIONS,
                Content.PICKLED_GINGER,
                Content.KIMCHI,
                Content.SAUERKRAUT,
                Content.PICKLED_ANCHOVIES,
                Content.PICKLED_EGGS,
                Content.BIBIMBAP,
                Content.BIBIM_NENGMYUM,
                Content.EGG_FRIED_RICE,
                Content.FRIED_RICE,
                Content.VEGGIE_FRIED_RICE,
                Content.ORANGE_CHICKEN,
                Content.PINEAPPLE_CHICKEN,
                Content.TERYAKI_CHICKEN,
                Content.COOKING_OIL
        ).map(CroptopiaItemTagProvider::key));
    }

    private static TagKey<Item> croptopiaTag(String name) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name));
    }

    private static ResourceKey<Item> key(Item item) {
        return item.builtInRegistryHolder().key();
    }

}
