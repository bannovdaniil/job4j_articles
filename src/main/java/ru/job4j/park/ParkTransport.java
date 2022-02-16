package ru.job4j.park;

import java.util.ArrayList;
import java.util.List;

public class ParkTransport implements Park {
    List<Transport> trucks;
    List<Transport> sedans;
    private int truckPlace;
    private int sedanPlace;

    public ParkTransport(int truckPlace, int sedanPlace) {
        trucks = new ArrayList<>();
        sedans = new ArrayList<>();
        this.truckPlace = truckPlace;
        this.sedanPlace = sedanPlace;
    }

    @Override
    public boolean addTransport(Transport transport) {
        return false;
    }

    @Override
    public int getPlace() {
        return truckPlace + sedanPlace;
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
