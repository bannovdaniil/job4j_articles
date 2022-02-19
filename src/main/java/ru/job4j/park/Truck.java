package ru.job4j.park;

public class Truck implements Transport {
    private int size;
    private final TypeTransport type;
    private final String name;

    public Truck(String name) {
        this.size = 2;
        this.type = TypeTransport.TRUCK;
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
        return size;
    }

    @Override
    public TypeTransport getType() {
        return this.type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Truck truck = (Truck) o;

        if (size != truck.size) {
            return false;
        }
        if (type != truck.type) {
            return false;
        }
        return name != null ? name.equals(truck.name) : truck.name == null;
    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
