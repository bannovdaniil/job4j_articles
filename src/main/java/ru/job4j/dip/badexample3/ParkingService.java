package ru.job4j.dip.badexample3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Нарушение принципа DIP, сервис зависит от реализации, а не от абстракции.
 */
public class ParkingService {
    private Map<Long, Car> parkingList;

    public List<Car> findAll() {
        return new ArrayList<>(parkingList.values());
    }
}
