package com.epherical.croptopia;

import com.epherical.croptopia.common.ItemNamesV2;
import com.epherical.croptopia.common.MiscNames;
import com.epherical.croptopia.config.CroptopiaConfig;
import com.epherical.croptopia.config.IdentifierSerializer;
import com.epherical.croptopia.config.TreeConfiguration;
import com.epherical.croptopia.listeners.BlockBreakEvent;
import com.epherical.croptopia.loot.FabricLootModifiers;
import com.epherical.croptopia.register.Content;
import com.epherical.croptopia.register.helpers.FarmlandCrop;
import com.epherical.croptopia.register.helpers.TreeCrop;
import com.epherical.croptopia.register.helpers.Utensil;
import com.epherical.croptopia.world.FabricBiomeModifiers;
import com.epherical.epherolib.libs.org.spongepowered.configurate.hocon.HoconConfigurationLoader;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.Comparator;
import java.util.List;

import static com.epherical.croptopia.CroptopiaCommon.createGroup;
import static com.epherical.croptopia.CroptopiaCommon.createIdentifier;

public class CroptopiaFabric implements ModInitializer {
    //public static final CroptopiaConfig config = new CroptopiaConfig(HoconConfigurationLoader.builder(), "croptopia_v3.conf");


    @Override
    public void onInitialize() {
        CroptopiaCommon.init();
        loadConfig();
        registerBlocks();
        registerItems();
        registerCreativeTab();
        registerVanillaTabs();
        BlockBreakEvent.register();
        FabricBiomeModifiers.register();
        FabricLootModifiers.register();
    }

    private static void loadConfig() {
        //config.addSerializer(TreeConfiguration.class, TreeConfiguration.Serializer.INSTANCE);
        //config.addSerializer(Identifier.class, IdentifierSerializer.INSTANCE);
        //config.loadConfig(MiscNames.MOD_ID);
    }

    private static void registerBlocks() {
        Content.registerBlocks((id, supplier) -> {
            if (Content.BLOCK_REGISTER.getManipulations().containsKey(id)) {
                supplier = Content.BLOCK_REGISTER.getManipulations().get(id);
            }

            Block block = supplier.get();
            Registry.register(BuiltInRegistries.BLOCK, id, block);
            return block;
        });

        FlammableBlockRegistry flammables = FlammableBlockRegistry.getDefaultInstance();
        flammables.add(Content.CINNAMON.getLog(), 5, 5);
        flammables.add(Content.CINNAMON.getWood(), 5, 5);
        flammables.add(Content.CINNAMON.getStrippedLog(), 5, 5);
        flammables.add(Content.CINNAMON.getStrippedWood(), 5, 5);
    }

    private static void registerItems() {
        Content.GUIDE = Registry.register(BuiltInRegistries.ITEM, createIdentifier(ItemNamesV2.GUIDE), new GuideBookItem(createGroup()));

        Content.registerItems((id, supplier) -> {
            if (Content.ITEM_REGISTER.getManipulations().containsKey(id)) {
                supplier = Content.ITEM_REGISTER.getManipulations().get(id);
            }

            Item item = supplier.get();
            Registry.register(BuiltInRegistries.ITEM, id, item);
            if (item instanceof ItemNameBlockItem blockItem) {
                blockItem.registerBlocks(Item.BY_BLOCK, item);
            }
            return item;
        });
    }

    private static void registerCreativeTab() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, createIdentifier(MiscNames.MOD_ID),
                FabricItemGroup.builder()
                        .title(Component.translatable("itemGroup.croptopia"))
                        .displayItems((parameters, output) ->
                                BuiltInRegistries.ITEM.entrySet().stream()
                                        .filter(entry -> entry.getKey().location().getNamespace().equals(MiscNames.MOD_ID))
                                        .sorted(Comparator.comparing(entry -> BuiltInRegistries.ITEM.getId(entry.getValue())))
                                        .forEach(entry -> output.accept(entry.getValue())))
                        .icon(() -> new ItemStack(Content.COFFEE))
                        .build());
    }

    private static void registerVanillaTabs() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entries -> {
            entries.addAfter(Items.MANGROVE_PROPAGULE, List.of(new ItemStack(Content.CINNAMON.getSapling())), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.addAfter(Items.FLOWERING_AZALEA,
                    TreeCrop.TREE_CROPS.stream().map(TreeCrop::getSaplingItem).map(ItemStack::new).toList(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.addAfter(Items.NETHER_WART,
                    FarmlandCrop.FARMLAND_CROPS.stream().map(FarmlandCrop::getSeedItem).map(ItemStack::new).toList(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.addBefore(Items.COAL_ORE, List.of(new ItemStack(Content.SALT_ORE)), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        });

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries ->
                entries.addAfter(Items.FLINT_AND_STEEL,
                        Utensil.copy().stream().map(ItemStack::new).toList(),
                        CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
    }
}
