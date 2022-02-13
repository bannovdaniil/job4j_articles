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
        if (percent <= 0) {
            foods.add(food);
            result = true;
        }
        return result;
    }

}
