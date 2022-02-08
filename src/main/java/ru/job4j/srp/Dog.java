package ru.job4j.srp;

/**
 * Не так явно, вроде мы поедаем, а за одно еще и говорим, какой стал вес.
 * Отдельно надо кушать, отдельно взвешиваться.
 */
public class Dog implements Animal {
    private int weight = 100;

    @Override
    public int eat(int calories) {
        weight += calories;
        return weight;
    }
}
