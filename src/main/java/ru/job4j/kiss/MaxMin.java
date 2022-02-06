package ru.job4j.kiss;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return getElement(value, comparator, x -> (x < 0));
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return getElement(value, comparator, x -> (x > 0));
    }

    private <T> T getElement(List<T> value, Comparator<T> comparator, IntPredicate minmax) {
        if (value.size() == 0) {
            return null;
        }
        T element = value.get(0);
        for (T t : value) {
            if (minmax.test(comparator.compare(element, t))) {
                element = t;
            }
        }
        return element;
    }

    public static void main(String[] args) {
        MaxMin maxMin = new MaxMin();
        System.out.println(maxMin.max(new ArrayList<String>(), Comparator.naturalOrder()));
        System.out.println(maxMin.min(List.of(1, 2, 5, -2), Comparator.naturalOrder()));
        System.out.println(maxMin.max(List.of(1, 2, 5, -2), Comparator.naturalOrder()));
        System.out.println(maxMin.max(List.of("a", "b", "f", "e"), Comparator.naturalOrder()));
    }
}
