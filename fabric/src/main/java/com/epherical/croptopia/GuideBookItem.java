package com.epherical.croptopia;

import com.epherical.croptopia.platform.Services;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vazkii.patchouli.api.PatchouliAPI;

public class GuideBookItem extends Item {

    public GuideBookItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        ItemStack stack = user.getItemInHand(hand);

        if (user instanceof ServerPlayer player && Services.PLATFORM.isModLoaded("patchouli")) {
            PatchouliAPI.get().openBookGUI(player, BuiltInRegistries.ITEM.getKey(this));
        }

        return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
    }
}
