package ru.job4j.park;

public class Sedan implements Transport {
    private final int size;
    private String name;

    public Sedan(String name) {
        this.size = 1;
        this.name = name;
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
