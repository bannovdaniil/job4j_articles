package ru.job4j.park;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParkTransportTest {
    private List<Transport> transports;
    private Park park;
    private int truckPlace = 2;
    private int sedanPlace = 1;

    @Before
    public void initParkTransport() {
        transports = new ArrayList<>();
        truckPlace = 1;
        sedanPlace = 2;
        park = new ParkTransport(truckPlace, sedanPlace);
    }

    @Ignore
    @Test
    public void whenOneSedanOneTruckThenTwo() {
        int expected = 2;
        Transport track1 = new Truck("tr1");
        Transport sedan1 = new Sedan("sd1");
        park.addTransport(track1);
        park.addTransport(sedan1);
        int result = park.getParkInfo().getSedanPlace();
        assertEquals(expected, result);
    }

    @Ignore
    @Test
    public void whenOneSedanThenFore() {
        int expected = 4;
        Transport sedan1 = new Sedan("sd1");
        park.addTransport(sedan1);
        int result = park.getParkInfo().getSedanPlace();
        assertEquals(expected, result);
    }

    @Ignore
    @Test
    public void whenTwoTruckThenOne() {
        int expected = 1;
        Transport track1 = new Truck("tr2");
        Transport track2 = new Sedan("tr2");
        park.addTransport(track1);
        park.addTransport(track2);
        int result = park.getParkInfo().getSedanPlace();
        assertEquals(expected, result);
    }

    @Ignore
    @Test
    public void whenTwoTruckOneSedanThenZero() {
        int expected = 0;
        Transport track1 = new Truck("tr2");
        Transport track2 = new Sedan("tr2");
        Transport sedan1 = new Sedan("sd1");
        park.addTransport(track1);
        park.addTransport(track2);
        park.addTransport(sedan1);
        int result = park.getParkInfo().getSedanPlace();
        assertEquals(expected, result);
    }

    @Ignore
    @Test
    public void whenMoreThenPlaceThenFalse() {
        Transport track1 = new Truck("tr2");
        Transport track2 = new Sedan("tr2");
        Transport sedan1 = new Sedan("sd1");
        park.addTransport(track1);
        park.addTransport(track2);
        park.addTransport(sedan1);
        int result = park.getParkInfo().getSedanPlace();
        assertFalse(park.addTransport(sedan1));
    }

    @Ignore
    @Test
    public void whenLessThenTrue() {
        Transport track1 = new Truck("tr2");
        Transport track2 = new Sedan("tr2");
        Transport sedan1 = new Sedan("sd1");
        park.addTransport(track1);
        park.addTransport(track2);
        int result = park.getParkInfo().getSedanPlace();
        assertTrue(park.addTransport(sedan1));
    }

}