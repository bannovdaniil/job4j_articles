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
    private ControllQuality controllQuality;

    @Before
    public void fillFoodArray() {
        controllQuality = new ControllQuality(new Shop(), new Trash(), new Warehouse());
        foods = new ArrayList<>();
        foods.add(new Food("Свекла",
                new GregorianCalendar(2022, GregorianCalendar.JANUARY, 1),
                new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 2),
                10, 50));
        foods.add(new Food("Колбаса",
                new GregorianCalendar(2022, GregorianCalendar.JANUARY, 30),
                new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 1),
                10, 50));
        foods.add(new Food("Сыр",
                new GregorianCalendar(2022, GregorianCalendar.JANUARY, 1),
                new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 22),
                10, 50));
        foods.add(new Food("Виноград",
                new GregorianCalendar(2022, GregorianCalendar.JANUARY, 10),
                new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 10),
                10, 50));
        foods.add(new Food("Апельсин",
                new GregorianCalendar(2022, GregorianCalendar.JANUARY, 1),
                new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 4),
                10, 50));
        foods.add(new Food("Апельсин",
                new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 2),
                new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 10),
                10, 50));
    }

    @After
    public void showArray() {
        System.out.println("shop");
        controllQuality.getShop().getFoods().forEach(System.out::println);
        System.out.println("trash");
        controllQuality.getTrash().getFoods().forEach(System.out::println);
        System.out.println("ware");
        controllQuality.getWarehouse().getFoods().forEach(System.out::println);
    }

    @Test
    public void whenDateExpiredTwoFoodInTrash() {
        Calendar checkDate = new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 3);
        controllQuality.sortFood(foods, checkDate);
        assertThat(2, is(controllQuality.getTrash().getFoods().size()));
    }

    @Test
    public void whenDateTwentyFiveThenOneFoodInWarehouse() {
        Calendar checkDate = new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 3);
        controllQuality.sortFood(foods, checkDate);
        assertThat(1, is(controllQuality.getWarehouse().getFoods().size()));
    }

    @Test
    public void whenDateSeventyFiveThenDiscount() {
        Calendar checkDate = new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 3);
        double expected = 5.0;
        controllQuality.sortFood(foods, checkDate);
        Food result = controllQuality.getShop().getFoods().get(1);
        assertThat(expected, closeTo(result.getPrice(), 0.001));
    }

    @Test
    public void whenDateBetweenThenOutDiscount() {
        Calendar checkDate = new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 3);
        double expected = 10.0;
        controllQuality.sortFood(foods, checkDate);
        Food result = controllQuality.getShop().getFoods().get(0);
        assertThat(expected, closeTo(result.getPrice(), 0.001));
    }

    @Test
    public void whenDateOkThenThreeInShop() {
        Calendar checkDate = new GregorianCalendar(2022, GregorianCalendar.FEBRUARY, 3);
        controllQuality.sortFood(foods, checkDate);
        assertThat(3, is(controllQuality.getShop().getFoods().size()));
    }

}