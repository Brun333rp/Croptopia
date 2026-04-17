package com.epherical.croptopia.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.Random;
import java.util.function.Consumer;

public class ReferenceInfiniteItem extends Item {

    private final Component[] component;
    private int index = 0;

    private final Random random = new Random();

    public ReferenceInfiniteItem(Properties properties, Component... component) {
        super(properties);
        this.component = component;
        this.index = random.nextInt(component.length);
    }


    /*@Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        FoodProperties foodproperties = stack.get(DataComponents.FOOD);
        ItemStack itemStack = stack.transmuteCopy(stack.getItem());
        livingEntity.eat(level, itemStack, foodproperties);
        return stack;
    }*/

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
        builder.accept(component[index]);
    }
}
