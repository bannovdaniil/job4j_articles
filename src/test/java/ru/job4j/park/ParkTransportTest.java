package ru.job4j.park;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParkTransportTest {
    private List<Transport> transports;
    private Park park;

    @Before
    public void initParkTransport() {
        transports = new ArrayList<>();
        int truckPlace = 4;
        int sedanPlace = 2;
        park = new ParkTransport(truckPlace, sedanPlace);
    }

    @Test(expected = IllegalArgumentException.class)
    public void badArgumentForTruck() {
        Transport truck = new Truck("Truck1", 1);
    }

    @Test
    public void whenOneSedanThenTwo() {
        int expected = 1;
        Transport truck1 = new Truck("tr1");
        Transport sedan1 = new Sedan("sd1");
        park.addTransport(truck1);
        park.addTransport(sedan1);
        int result = park.getSedanPlace();
        assertEquals(expected, result);
    }

    @Test
    public void whenOneTruckThenTwo() {
        int expected = 2;
        Transport truck1 = new Truck("tr1");
        park.addTransport(truck1);
        int result = park.getTruckPlace();
        assertEquals(expected, result);
    }

    @Test
    public void whenThreeSedanThenZeroSedanThreeTruck() {
        int expectedSedan = 0;
        int expectedtruck = 3;
        Transport sedan1 = new Sedan("sd1");
        Transport sedan2 = new Sedan("sd2");
        Transport sedan3 = new Sedan("sd3");
        park.addTransport(sedan1);
        park.addTransport(sedan2);
        park.addTransport(sedan3);
        int resultSedan = park.getSedanPlace();
        int resultTruck = park.getTruckPlace();
        assertEquals(expectedSedan, resultSedan);
        assertEquals(expectedtruck, resultTruck);
    }

    @Test
    public void whenTwoTruckThenZero() {
        int expectedTruck = 0;
        Transport truck1 = new Truck("tr1");
        Transport truck2 = new Truck("tr2");
        park.addTransport(truck1);
        park.addTransport(truck2);
        int result = park.getTruckPlace();
        assertEquals(expectedTruck, result);
    }

    @Test
    public void whenThreeTruckThenFalseSedanFree() {
        int expectedSedan = 2;
        Transport truck1 = new Truck("tr2");
        Transport truck2 = new Truck("tr2");
        Transport truck3 = new Truck("tr3");
        park.addTransport(truck1);
        park.addTransport(truck2);
        int result = park.getSedanPlace();
        assertFalse(park.addTransport(truck3));
        assertEquals(expectedSedan, result);
    }

    @Test
    public void whenMoreThenPlaceThenFalse() {
        Transport truck1 = new Truck("tr2");
        Transport truck2 = new Truck("tr2");
        Transport sedan1 = new Sedan("sd1");
        Transport sedan2 = new Sedan("sd2");
        Transport sedan3 = new Sedan("sd2");
        park.addTransport(truck1);
        park.addTransport(truck2);
        park.addTransport(sedan1);
        park.addTransport(sedan2);
        assertFalse(park.addTransport(sedan3));
    }

    @Test
    public void whenLessThenTrue() {
        Transport truck1 = new Truck("tr2");
        Transport truck2 = new Truck("tr2");
        Transport sedan1 = new Sedan("sd1");
        park.addTransport(truck1);
        park.addTransport(truck2);
        assertTrue(park.addTransport(sedan1));
    }

    @Test
    public void whenBigTruckThreeThenOne() {
        int expected = 1;
        Transport truck1 = new Truck("tr2", 3);
        park.addTransport(truck1);
        assertEquals(expected, park.getTruckPlace());
    }

    @Test
    public void whenAddTruckAndRemoveThenTrue() {
        int expected = 2;
        Transport truck1 = new Truck("tr2");
        Transport truck2 = new Truck("tr2");
        park.addTransport(truck1);
        park.addTransport(truck2);
        park.removeTransport(truck1);
        assertEquals(expected, park.getTruckPlace());
    }

    @Test
    public void whenAddTwoSedanAndRemoveThenOne() {
        int expected = 1;
        Transport sedan1 = new Sedan("s1");
        Transport sedan2 = new Sedan("s2");
        park.addTransport(sedan1);
        park.addTransport(sedan2);
        park.removeTransport(sedan1);
        assertEquals(expected, park.getSedanPlace());
    }

    @Test
    public void whenRemoveNoParkTransportThenFalse() {
        Transport truck1 = new Truck("tr2", 3);
        assertFalse(park.removeTransport(truck1));
    }

    @Test
    public void whenRemoveParkTransportThenTrue() {
        Transport truck1 = new Truck("tr2", 3);
        park.addTransport(truck1);
        assertTrue(park.removeTransport(truck1));
    }

}