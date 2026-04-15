package com.epherical.croptopia;

import com.epherical.croptopia.client.ClientFunctions;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.RenderType;

public class CroptopiaClient implements ClientModInitializer {
    private static final ClientFunctions FUNCTIONS = new ClientFunctions();

    @Override
    public void onInitializeClient() {
        FUNCTIONS.registerBlockLayers(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.cutoutMipped()));
        ColorProviderRegistry.ITEM.register(FUNCTIONS.registerItemColors(), FUNCTIONS.items());
        ColorProviderRegistry.BLOCK.register(FUNCTIONS.registerLeafColors(), FUNCTIONS.leaves());
    }
}
