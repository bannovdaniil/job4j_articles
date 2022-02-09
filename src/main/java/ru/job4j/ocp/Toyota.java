package ru.job4j.ocp;

public class Toyota {
    private int door;

    public Toyota(int door) {
        this.door = door;
    }

    public void openDoor() {
        if (door == 5) {
            System.out.println("Багажник открыт.");
        }
    }
}
