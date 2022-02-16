package ru.job4j.park;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParkTransportTest {
    List<Transport> transports;
    Park park;

    @Before
    public void initParkTransport(){
        transports = new ArrayList<>();
        int truckPlace = 3;
        int sedanPlace = 1;
        park = new ParkTransport(truckPlace, sedanPlace);
    }

   @Test
    public void OneCar(){
       Transport tracks1 = new Track("name");
       Transport sedans1 = new Sedan("name");

       park.addTransport(tracks1);
       park.addTransport(sedans1);


   }

}