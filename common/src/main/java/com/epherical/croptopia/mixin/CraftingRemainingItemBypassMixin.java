package com.epherical.croptopia.mixin;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Item.class)
public interface CraftingRemainingItemBypassMixin {

    @Accessor("craftingRemainingItem")
    @Mutable @Final
    void croptopia$setCraftingRemainingItem(ItemStackTemplate craftingRemainingItem);
}
