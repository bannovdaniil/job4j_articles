package ru.job4j.lsp;

public class Ford extends Car {
    public Ford(int door) {
        super(door);
    }

    public void move() {
        System.out.println("Drive");
    }

    public static void main(String[] args) {
        Car car = new Car(4);
        car.setOpen(true);
        car.move();

        Ford ford = new Ford(3);
        ford.setOpen(true);
        ford.move();
    }
}
