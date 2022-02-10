package ru.job4j.lsp;

public class Dishes {
    public enum FoodType {
        FISH,
        SOUP,
        TUNA,
        CUCUMBER
    }

    private int cook;
    private float price;

    public Dishes(FoodType food) {
        if (food.equals(FoodType.FISH)) {
            this.cook = 10;
            this.price = 100.59F;
        } else if (food.equals(FoodType.SOUP)) {
            this.cook = 25;
            this.price = 50.99F;
        } else if (food.equals(FoodType.TUNA)) {
            this.cook = 20;
            this.price = 149.99F;
        }
    }

    public static void main(String[] args) {
        Dishes dishes = new Dishes(FoodType.CUCUMBER);
    }
}