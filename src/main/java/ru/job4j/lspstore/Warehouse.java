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
    public Food removeFood(Food food) {
        foods.remove(food);
        return food;
    }

    public List<Food> getFoods() {
        return new ArrayList<>(foods);
    }

    @Override
    public boolean accept(Food food, Calendar checkDate, double discount) {
        boolean result = false;
        double percent = food.getPercent(checkDate);
        System.out.println(percent);
        if (percent > 75) {
            foods.add(food);
            result = true;
        }
        return result;

    }

    @Override
    public void putFood(Food food) {
        foods.add(food);
    }

}
