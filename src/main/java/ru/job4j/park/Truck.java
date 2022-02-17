package ru.job4j.park;

public class Truck implements Transport {
    private int size;
    private String name;

    public Truck(String name) {
        this.name = name;
    }

    public Truck(String name, int size) {
        this(name);
        if (size < 2) {
            throw new IllegalArgumentException("Error size must be more then 2.");
        }
        this.size = size;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isPark() {
        return false;
    }
}
