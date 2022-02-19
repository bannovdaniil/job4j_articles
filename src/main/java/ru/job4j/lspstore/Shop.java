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
        if (percent >= 25 && percent <= 75) {
            foods.add(food);
            result = true;
        } else if (percent > 75 && percent < 100) {
            food.setPrice(food.getPrice() * food.getDiscount() / 100);
            foods.add(food);
            result = true;
        }
        return result;
    }

}
