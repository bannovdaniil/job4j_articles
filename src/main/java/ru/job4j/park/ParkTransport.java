package ru.job4j.park;

import java.util.ArrayList;
import java.util.List;

public class ParkTransport implements Park {
    private List<Transport> trucks;
    private List<Transport> sedans;
    private final int truckPlace;
    private final int sedanPlace;

    public ParkTransport(int truckPlace, int sedanPlace) {
        trucks = new ArrayList<>();
        sedans = new ArrayList<>();
        this.truckPlace = truckPlace;
        this.sedanPlace = sedanPlace;
    }

    @Override
    public boolean addTransport(Transport transport) {
        boolean result = false;
        int size = transport.getSize();
        switch (transport.getType()) {
            case SEDAN:
                if (getSedanPlace() - size >= 0) {
                    sedans.add(transport);
                    result = true;
                    break;
                }
            case TRUCK:
                if (getTruckPlace() - size >= 0) {
                    trucks.add(transport);
                    result = true;
                }
                break;
            default:
        }
        return result;
    }

    @Override
    public boolean removeTransport(Transport transport) {
        boolean result = false;
        switch (transport.getType()) {
            case SEDAN:
                for (int i = 0; i < sedans.size(); i++) {
                    if (transport.equals(sedans.get(i))) {
                        sedans.remove(i);
                        result = true;
                        break;
                    }
                }
            case TRUCK:
                for (int i = 0; i < trucks.size(); i++) {
                    if (transport.equals(trucks.get(i))) {
                        trucks.remove(i);
                        result = true;
                        break;
                    }
                }
                break;
            default:
        }
        return result;
    }

    public int getSedanPlace() {
        int size = 0;
        for (Transport sedan : sedans) {
            size += sedan.getSize();
        }
        return sedanPlace - size;
    }

    public int getTruckPlace() {
        int size = 0;
        for (Transport truck : trucks) {
            size += truck.getSize();
        }
        return truckPlace - size;
    }

}
