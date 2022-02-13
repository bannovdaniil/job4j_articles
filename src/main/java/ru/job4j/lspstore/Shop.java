package ru.job4j.lspstore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Shop implements FoodStore {
    private final List<Food> foods;

    public Shop() {
        this.foods = new ArrayList<>();
    }

    @Override
    public Food removeFood(Food food) {
        foods.remove(food);
        return food;
    }

    public List<Food> getFoods() {
        return foods;
    }

    @Override
    public void putFood(Food food) {
        foods.add(food);
    }

    @Override
    public boolean accept(Food food, Calendar checkDate, double discount) {
        boolean result = false;
        double percent = food.getPercent(checkDate);
        System.out.println(percent);
        if (percent > 0 && percent < 25) {
            food.setDiscount(discount);
            foods.add(food);
            result = true;
        } else if (percent >= 25 && percent <= 75) {
            foods.add(food);
            result = true;
        }
        return result;
    }

}
