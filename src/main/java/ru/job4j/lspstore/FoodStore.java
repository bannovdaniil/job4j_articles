package ru.job4j.lspstore;

import java.util.Calendar;
import java.util.List;

public interface FoodStore {
    void removeFood(Food food);

    void clearFoodsList();

    List<Food> getFoods();

    boolean putFood(Food food, Calendar checkDate);
}
