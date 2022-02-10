package ru.job4j.lsp;

public class Car {
    private int door;
    private boolean isOpen;

    public Car(int door) {
        this.door = door;
        this.isOpen = true;
    }

    public void move() {
        if (!isOpen) {
            System.out.println("Drive");
        } else {
            System.out.println("Close door");
        }
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
