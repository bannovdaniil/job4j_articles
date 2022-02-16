package ru.job4j.lspstore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trash implements FoodStore {
    private final List<Food> foods;

    public Trash() {
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
    public boolean putFood(Food food, Calendar checkDate) {
        boolean result = false;
        double percent = food.getPercent(checkDate);
        System.out.println(percent);
        if (percent > 100) {
            foods.add(food);
            result = true;
        }
        return result;
    }

}
