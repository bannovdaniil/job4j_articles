package ru.job4j.park;

public class Sedan implements Transport {
    private final int size = 1;
    private String name;

    public Sedan(String name) {
        this.name = name;
    }

    @Override
    public int getSize() {
        return size;
    }


}
