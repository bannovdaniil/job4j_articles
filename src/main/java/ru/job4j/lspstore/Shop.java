package ru.job4j.lspstore;

import java.util.ArrayList;
import java.util.List;

public class Shop implements FoodStore {
    List<Food> foods;

    public Shop() {
        this.foods = new ArrayList<>();
    }

    @Override
    public Food removeFood(Food food) {
        if (foods.contains(food)) {
            foods.remove(food);
        }
        return food;
    }

    @Override
    public void putFood(Food food) {
        foods.add(food);
    }
}
