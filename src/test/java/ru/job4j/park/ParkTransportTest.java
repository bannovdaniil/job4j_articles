package ru.job4j.park;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParkTransportTest {
    private List<Transport> transports;
    private Park park;
    private int truckPlace = 3;
    private int sedanPlace = 1;

    @Before
    public void initParkTransport() {
        transports = new ArrayList<>();
        truckPlace = 1;
        sedanPlace = 2;
        park = new ParkTransport(truckPlace, sedanPlace);
    }

    @Test
    public void OneCar() {
        int expected = 1;
        Transport tracks1 = new Track("name");
        Transport sedans1 = new Sedan("name");

        park.addTransport(tracks1);
        park.addTransport(sedans1);
        int result = park.getSedanPlace();

        assertEquals(expected, result);
    }

}