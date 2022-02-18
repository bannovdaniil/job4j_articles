package ru.job4j.div;

import java.util.*;

public class Div {
    public static void main(String[] args) {
        Integer[] arr = {10, 68, 30, 28, 34, 74, 52, 20, 176, 18, 86, 14, 22, 4}; // исходный массив
        Arrays.sort(arr, Collections.reverseOrder()); // сортируем по значениям в обратном порядке
        int halfSum = 0;
        for (Integer num : arr) {
            halfSum += num;
        }
        halfSum /= 2; // высчитываем сумму значений и делим на две примерно равные части
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        int sumLeft = 0; // сумма первого массива для сравнения
        int sumRight = 0; // сумма второго массива для сравнения
// перебираем отсортированный исходный массив
        for (Integer num : arr) {
             // сумма первого массива меньше второго
            // и сумма второго массива больше или равна половине общей суммы
            // то очередное значение добавляется в первый массив
            // в ином случае - во второй массив
            if (sumLeft <= sumRight || sumRight >= halfSum) {
                left.add(num);
                sumLeft += num;
            } else {
                right.add(num);
                sumRight += num;
            }
        }
//выводим суммы обоих массивов
        System.out.println("sumRight = " + sumRight);
        System.out.println("sumLeft = " + sumLeft);
// сами массивы
        System.out.println("right = " + right);
        System.out.println("left = " + left);
    }

}
