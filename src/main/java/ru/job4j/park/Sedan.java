package ru.job4j.park;

public class Sedan implements Transport {
    private final int size = 1;
    private final String name;

    public Sedan(String name) {
        this.name = name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Sedan sedan = (Sedan) o;

        if (size != sedan.size) {
            return false;
        }
        return name != null ? name.equals(sedan.name) : sedan.name == null;
    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
