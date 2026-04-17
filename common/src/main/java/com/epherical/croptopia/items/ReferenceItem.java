package com.epherical.croptopia.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class ReferenceItem extends Item {

    private final Component[] component;
    private int index = 0;

    private final Random random = new Random();
    public ReferenceItem(Properties properties, Component... component) {
        super(properties);
        this.component = component;
        this.index = random.nextInt(component.length);
    }


    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
        builder.accept(component[index]);
    }
}
