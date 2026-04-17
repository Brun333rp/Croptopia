package com.epherical.croptopia;

import com.epherical.croptopia.client.ClientFunctions;
import net.fabricmc.api.ClientModInitializer;

public class CroptopiaClient implements ClientModInitializer {
    private static final ClientFunctions FUNCTIONS = new ClientFunctions();

    @Override
    public void onInitializeClient() {
        /*FUNCTIONS.registerBlockLayers(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.cutoutMipped()));
        ColorProviderRegistry.ITEM.register(FUNCTIONS.registerItemColors(), FUNCTIONS.items());
        ColorProviderRegistry.BLOCK.register(FUNCTIONS.registerLeafColors(), FUNCTIONS.leaves());*/
    }
}
