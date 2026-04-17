package com.epherical.croptopia.register.helpers;

import com.epherical.croptopia.register.Content;
import com.epherical.croptopia.util.FoodConstructor;
import com.epherical.croptopia.util.ItemConvertibleWithPlural;
import com.epherical.croptopia.util.RegisterFunction;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.ArrayList;
import java.util.List;

import static com.epherical.croptopia.CroptopiaCommon.createGroup;
import static com.epherical.croptopia.CroptopiaCommon.createIdentifier;

public class Seafood implements ItemConvertibleWithPlural {
    private static final List<Seafood> INSTANCES = new ArrayList<>();

    private final String name;
    private final boolean plural;
    private Item item;

    public Seafood(String name, boolean plural, FoodConstructor foodConstructor) {
        Content.ITEM_REGISTER.reg(registerFunction -> this.registerItem(registerFunction, foodConstructor));
        this.name = name;
        this.plural = plural;
        INSTANCES.add(this);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean hasPlural() {
        return plural;
    }

    @Override
    public Item asItem() {
        return item;
    }

    public static List<Seafood> copy() {
        return INSTANCES;
    }

    public void registerItem(RegisterFunction<Item> register, FoodConstructor foodConstructor) {
        item = register.register(createIdentifier(name), (id) -> {
            if (name.contains("GLOWING")) {
                return new Item(createGroup(id).food(FoodConstructor.createBuilder(foodConstructor).build(),
                        Consumable.builder()
                                .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.GLOWING, 4000, 1), 1.0F))
                                .build()));
            } else {
                return new Item(createGroup(id).food(FoodConstructor.createFood(foodConstructor)));
            }
        });
    }
}
