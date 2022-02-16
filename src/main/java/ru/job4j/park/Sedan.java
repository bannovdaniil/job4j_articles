package ru.job4j.park;

public class Sedan implements Transport{

    private String name;

    public Sedan(String name) {
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
