package ru.job4j.park;

public class ParkTransport implements Park {
    private int truckPlace;
    private int sedanPlace;

    public ParkTransport(int truckPlace, int sedanPlace) {
        this.truckPlace = truckPlace;
        this.sedanPlace = sedanPlace;
    }

    @Override
    public boolean addTransport(Transport transport) {
        return false;
    }

    @Override
    public int getSedanPlace() {
        return 0;
    }

    @Override
    public int getTruckPlace() {
        return 0;
    }

    @Override
    public boolean removeTransport(Transport transport) {
        return false;
    }
}
