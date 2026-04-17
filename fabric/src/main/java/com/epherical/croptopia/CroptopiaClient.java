package com.epherical.croptopia;

import com.epherical.croptopia.client.ClientFunctions;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;

import java.util.List;

public class CroptopiaClient implements ClientModInitializer {
    private static final ClientFunctions FUNCTIONS = new ClientFunctions();

    @Override
    public void onInitializeClient() {
        BlockColorRegistry.register(List.of(FUNCTIONS.registerLeafColors()), FUNCTIONS.leaves());
    }
}
