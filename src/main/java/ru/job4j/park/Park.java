package ru.job4j.park;

public interface Park {
    boolean addTransport(Transport transport);

    ParkTransport.ParkingInfo getParkInfo();

    boolean removeTransport(Transport transport);
}
