package ru.job4j.srp;

/**
 * Гудок и заправка автомобиля, явное объединение ответственностей.
 */
public class Sedan implements Car {
    private int fuel = 0;

    @Override
    public void beep() {
        System.out.println("Bi-Bip");
    }

    @Override
    public int fullGas(int count) {
        fuel += count;
        return fuel;
    }
}
