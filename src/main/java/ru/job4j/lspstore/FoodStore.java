package ru.job4j.lspstore;

import java.util.Calendar;
import java.util.List;

public interface FoodStore {
    Food removeFood(Food food);

    List<Food> getFoods();

    boolean accept(Food food, Calendar checkDate, double discount);
}
