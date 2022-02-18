package ru.job4j.park;

import java.util.ArrayList;
import java.util.List;

public class ParkTransport implements Park {
    private int size;
    private List<Transport> trucks;
    private List<Transport> sedans;
    private int truckPlace;
    private int sedanPlace;
    ParkingInfo parkingInfo;

    public ParkTransport(int truckPlace, int sedanPlace) {
        ParkingInfo parkingInfo = new ParkingInfo();
        trucks = new ArrayList<>();
        sedans = new ArrayList<>();
        this.truckPlace = truckPlace;
        this.sedanPlace = sedanPlace;
        this.size = truckPlace + sedanPlace;
    }

    public ParkingInfo getParkInfo() {
        return parkingInfo;
    }

    @Override
    public boolean addTransport(Transport transport) {
        return false;
    }


    @Override
    public boolean removeTransport(Transport transport) {
        return false;
    }

    public int getSize() {
        return size;
    }

    public class ParkingInfo {
        public int getPlace() {
            return size - (truckPlace + sedanPlace);
        }

        public int getSedanPlace() {
            return sedanPlace;
        }

        public int getTruckPlace() {
            return truckPlace;
        }
    }

}
