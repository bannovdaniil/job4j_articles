package ru.job4j.park;

public interface Park {
    boolean parkSedan();

    boolean parkTruck();

    int getSedanPlace();

    int getTruckPlace();

    boolean removeSedan();

    boolean removeTruck();
}
