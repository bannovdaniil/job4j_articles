package ru.job4j.lspstore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ControllQuality {
    private Shop shop;
    private Trash trash;
    private Warehouse warehouse;

    public ControllQuality(Shop shop, Trash trash, Warehouse warehouse) {
        this.shop = shop;
        this.trash = trash;
        this.warehouse = warehouse;
    }

    private void putFood(FoodStore store, Food food) {
        store.putFood(food);
    }

    public void sortFood(double percent, Food food) {
        System.out.println(percent);
        if (percent <= 0) {
            putFood(trash, food);
        } else if (percent < 25) {
            food.setDiscount(50);
            putFood(shop, food);
        } else if (percent >= 25 && percent <= 75) {
            putFood(shop, food);
        } else if (percent > 75) {
            putFood(warehouse, food);
        }
    }

    public Shop getShop() {
        return shop;
    }

    public Trash getTrash() {
        return trash;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }
}
