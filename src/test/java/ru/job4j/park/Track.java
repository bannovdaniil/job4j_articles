package ru.job4j.park;

public class Track implements Transport {
    private final int size;
    private String name;

    public Track(String name) {
        this.size = 2;
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
