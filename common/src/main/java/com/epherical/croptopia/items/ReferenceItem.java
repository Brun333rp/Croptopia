package com.epherical.croptopia.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;
import java.util.Random;

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
    public void appendHoverText(ItemStack item, TooltipContext level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(item, level, tooltip, flag);
        tooltip.add(component[index]);
    }
}
