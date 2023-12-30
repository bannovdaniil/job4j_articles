package ru.job4j.dip.badexample3;

public class Car {
    private Long id;
    private String number;
    private String name;
    private String color;

    public Car(Long id, String number, String name, String color) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
