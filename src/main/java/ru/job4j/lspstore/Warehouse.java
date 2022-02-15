package ru.job4j.lspstore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Warehouse implements FoodStore {
    private final List<Food> foods;

    public Warehouse() {
        this.foods = new ArrayList<>();
    }

    @Override
    public void removeFood(Food food) {
        foods.remove(food);
    }

    public List<Food> getFoods() {
        return new ArrayList<>(foods);
    }

    @Override
    public void putFood(Food food, Calendar checkDate) {
        double percent = food.getPercent(checkDate);
        System.out.println(percent);
        if (percent < 25) {
            foods.add(food);
        }
    }

}
