package com.buuz135.sushigocrafting.api;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public enum FoodType implements IFoodType {

    MAKI("maki", new int[]{2},
            integer -> Pair.of(integer * 20, 20), of(FoodIngredient.DRY_SEAWEED),
            of(FoodIngredient.RICE),
            of(FoodIngredient.SALMON_FILLET, FoodIngredient.TUNA_FILLET, FoodIngredient.AVOCADO, FoodIngredient.CUCUMBER, FoodIngredient.CRAB)),
    URAMAKI("uramaki", new int[]{0, 4},
            integer -> Pair.of(20, integer * 20), of(FoodIngredient.SALMON_FILLET, FoodIngredient.SESAME),
            of(FoodIngredient.RICE),
            of(FoodIngredient.DRY_SEAWEED),
            of(FoodIngredient.AVOCADO),
            of(FoodIngredient.TUNA_FILLET, FoodIngredient.SALMON_FILLET, FoodIngredient.CRAB));

    private final int[] index;
    private final String name;
    private List<IFoodIngredient[]> ingredients;
    private final Function<Integer, Pair<Integer, Integer>> slotPos;

    FoodType(String name, int[] index, Function<Integer, Pair<Integer, Integer>> slotPos, IFoodIngredient[]... ingredients) {
        this.index = index;
        this.name = name;
        this.slotPos = slotPos;
        this.ingredients = new ArrayList<>();
        if (ingredients != null) {
            for (IFoodIngredient[] ingredient : ingredients) {
                this.ingredients.add(ingredient);
            }
        }
    }

    public static IFoodIngredient[] of(IFoodIngredient... ingredients) {
        return ingredients;
    }

    @Override
    public List<IFoodIngredient[]> getFoodIngredients() {
        return ingredients;
    }

    @Override
    public int[] getNameIndex() {
        return index;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Function<Integer, Pair<Integer, Integer>> getSlotPosition() {
        return slotPos;
    }
}