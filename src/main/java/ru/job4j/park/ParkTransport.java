package ru.job4j.park;

import java.util.ArrayList;
import java.util.List;

public class ParkTransport implements Park {
    private int size;
    List<Transport> trucks;
    List<Transport> sedans;
    private int truckPlace;
    private int sedanPlace;

    public ParkTransport(int truckPlace, int sedanPlace) {
        trucks = new ArrayList<>();
        sedans = new ArrayList<>();
        this.truckPlace = truckPlace;
        this.sedanPlace = sedanPlace;
        this.size = truckPlace + sedanPlace;
    }

    @Override
    public boolean addTransport(Transport transport) {
        return false;
    }

    @Override
    public int getPlace() {
        return size - (truckPlace + sedanPlace);
    }

    public int getSize() {
        return size;
    }

    @Override
    public int getSedanPlace() {
        return sedanPlace;
    }

    @Override
    public int getTruckPlace() {
        return truckPlace;
    }

    @Override
    public boolean removeTransport(Transport transport) {
        return false;
    }


}
