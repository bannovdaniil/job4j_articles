package ru.job4j.lspstore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Shop implements FoodStore {
    private final List<Food> foods;
    private double discount;

    public Shop(double discount) {
        this.discount = discount;
        this.foods = new ArrayList<>();
    }

    public void setDiscount(double discount) {
        this.discount = discount;
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
        if (percent >= 25 && percent <= 75) {
            foods.add(food);
        } else if (percent > 75 && percent < 100) {
            food.setDiscount(discount);
            foods.add(food);
        }
    }

}
