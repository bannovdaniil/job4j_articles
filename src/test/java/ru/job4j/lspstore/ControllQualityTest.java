package ru.job4j.lspstore;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;


public class ControllQualityTest {
    private List<Food> foods;
    private Shop shop;
    private Trash trash;
    private Warehouse warehouse;
    private ControllQuality controllQuality;

    @Before
    public void fillFoodArray() {
        shop = new Shop();
        trash = new Trash();
        warehouse = new Warehouse();
        controllQuality = new ControllQuality(shop, trash, warehouse);
        foods = new ArrayList<>();
        foods.add(new Food("Свекла",
                new GregorianCalendar(2022, GregorianCalendar.JANUARY, 01),
                new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 02),
                10, 0));
        foods.add(new Food("Колбаса",
                new GregorianCalendar(2022, GregorianCalendar.JANUARY, 30),
                new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 01),
                10, 0));
        foods.add(new Food("Сыр",
                new GregorianCalendar(2022, GregorianCalendar.JANUARY, 01),
                new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 22),
                10, 0));
        foods.add(new Food("Виноград",
                new GregorianCalendar(2022, GregorianCalendar.JANUARY, 10),
                new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 10),
                10, 0));
        foods.add(new Food("Апельсин",
                new GregorianCalendar(2022, GregorianCalendar.JANUARY, 01),
                new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 04),
                10, 0));
        foods.add(new Food("Апельсин",
                new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 02),
                new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 10),
                10, 0));
    }

    @After
    public void showArray() {
        System.out.println("shop");
        controllQuality.getShop().foods.forEach(System.out::println);
        System.out.println("trash");
        controllQuality.getTrash().foods.forEach(System.out::println);
        System.out.println("ware");
        controllQuality.getWarehouse().foods.forEach(System.out::println);
    }

    @Test
    public void whenDateExpiredTwoFoodInTrash() {
        Calendar checkDate = new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 3);
        for (Food food : foods) {
            Calendar dateExpired = food.getExpiryDate();
            long dayBetween = dateExpired.getTimeInMillis() - checkDate.getTimeInMillis();
            double allTime = dateExpired.getTimeInMillis() - food.getCreateDate().getTimeInMillis();
            if (allTime == 0) {
                allTime = 0.0001D;
            }
            controllQuality.sortFood(dayBetween * 100.0 / allTime, food);
        }
        assertThat(2, is(controllQuality.getTrash().foods.size()));
    }

    @Test
    public void whenDateTwentyFiveThenOneFoodInWarehouse() {
        Calendar checkDate = new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 3);
        for (Food food : foods) {
            Calendar dateExpired = food.getExpiryDate();
            long dayBetween = dateExpired.getTimeInMillis() - checkDate.getTimeInMillis();
            double allTime = dateExpired.getTimeInMillis() - food.getCreateDate().getTimeInMillis();
            if (allTime == 0) {
                allTime = 0.0001D;
            }
            controllQuality.sortFood(dayBetween * 100.0 / allTime, food);
        }
        assertThat(1, is(controllQuality.getWarehouse().foods.size()));
    }

    @Test
    public void whenDateSeventyFiveThenDiscount() {
        Calendar checkDate = new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 3);
        for (Food food : foods) {
            Calendar dateExpired = food.getExpiryDate();
            long dayBetween = dateExpired.getTimeInMillis() - checkDate.getTimeInMillis();
            double allTime = dateExpired.getTimeInMillis() - food.getCreateDate().getTimeInMillis();
            if (allTime == 0) {
                allTime = 0.0001D;
            }
            controllQuality.sortFood(dayBetween * 100.0 / allTime, food);
        }
        double discount = controllQuality.getShop().foods.get(1).getDiscount();
        assertThat(50.0, closeTo(discount, 0.001));
    }

    @Test
    public void whenDateBetweenThenOutDiscount() {
        Calendar checkDate = new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 3);
        for (Food food : foods) {
            Calendar dateExpired = food.getExpiryDate();
            long dayBetween = dateExpired.getTimeInMillis() - checkDate.getTimeInMillis();
            double allTime = dateExpired.getTimeInMillis() - food.getCreateDate().getTimeInMillis();
            if (allTime == 0) {
                allTime = 0.0001D;
            }
            controllQuality.sortFood(dayBetween * 100.0 / allTime, food);
        }
        double discount = controllQuality.getShop().foods.get(0).getDiscount();
        assertThat(0.0, closeTo(discount, 0.001));
    }

    @Test
    public void whenDateOkThenThreeInShop() {
        Calendar checkDate = new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 3);
        for (Food food : foods) {
            Calendar dateExpired = food.getExpiryDate();
            long dayBetween = dateExpired.getTimeInMillis() - checkDate.getTimeInMillis();
            double allTime = dateExpired.getTimeInMillis() - food.getCreateDate().getTimeInMillis();
            if (allTime == 0) {
                allTime = 0.0001D;
            }
            controllQuality.sortFood(dayBetween * 100.0 / allTime, food);
        }
        assertThat(3, is(controllQuality.getShop().foods.size()));
    }

}