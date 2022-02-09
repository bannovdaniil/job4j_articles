package ru.job4j.ocp;

public class Picture {
    String name;

    public Picture(String name) {
        this.name = name;
    }

    public boolean saveFile() {
        System.out.println("Сохраняю картинку в формате PNG.");
        return false;
    }
}
