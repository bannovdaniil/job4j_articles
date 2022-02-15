package ru.job4j.lspstore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ControllQuality {
    private final List<FoodStore> foodStores;

    public ControllQuality(Shop shop, Trash trash, Warehouse warehouse) {
        foodStores = new ArrayList<>();
        foodStores.add(shop);
        foodStores.add(trash);
        foodStores.add(warehouse);
    }

    public void sortFood(Food food, Calendar checkDate, double discount) {
        for (FoodStore foodStore : foodStores) {
           foodStore.putFood(food, checkDate);
        }
    }

    public FoodStore getShop() {
        return foodStores.get(0);
    }

    public FoodStore getTrash() {
        return foodStores.get(1);
    }

    public FoodStore getWarehouse() {
        return foodStores.get(2);
    }
}
