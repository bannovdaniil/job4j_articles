package ru.job4j.park;

public interface Park {
    boolean addTransport(Transport transport);

    int getPlace();

    int getSedanPlace();

    int getTruckPlace();

    boolean removeTransport(Transport transport);
}
