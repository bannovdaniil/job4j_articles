package ru.job4j.park;

public interface Park {
    boolean addTransport(Transport transport);

    boolean removeTransport(Transport transport);

    int getSedanPlace();

    int getTruckPlace();
}