package ru.job4j.park;

public enum TypeTransport {
    SEDAN("sedan"),
    TRUCK("truck");

    public final String value;

    TypeTransport(String type) {
        this.value = type;
    }

    public String getValue() {
        return value;
    }
}
