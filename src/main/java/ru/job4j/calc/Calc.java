package ru.job4j.calc;

import java.util.ArrayList;
import java.util.List;

/**
 * числа только int, допускается, что числа будут отрицательными
 * выражение может как заканчиваться =, так и быть без него
 * действия происходят последовательно потоком, как в обычном калькуляторе,
 * без учета математических приоритетов.
 * <p>
 * throws IllegalArgumentException
 */
public class Calc {
    public int calculator(String expression) {
        return getResult(getElements(expression.replace(" ", "")));
    }

    /**
     * четные элементы это цифры, не четные операции...
     *
     * @return - результат вычисления выражения
     * throws - IllegalArgumentException Возможно произойдет ошибка преобразования строки в число.
     */
    private int getResult(List<String> elements) {
        Integer result = null;
        int index = 0;
        String action = "";
        for (var value : elements) {
            if (index % 2 == 0) {
                try {
                    int number = Integer.parseInt(value);
                    if (action.isEmpty()) {
                        result = number;
                    } else {
                        result = doAction(action, result, number);
                    }
                    index++;
                } catch (NumberFormatException err) {
                    throw new IllegalArgumentException("Error: bad number in expression");
                }
            } else {
                action = value;
                index++;
            }
        }
        if (result == null) {
            throw new IllegalArgumentException("Error: Can't given result.");
        }
        return result;
    }

    /**
     * состояния:
     * firstMinusOrNumber - ожидаем минус или число
     * endOfExpression - пришел "=", значит и строка должна закончиться
     * negativeNumber - нашли первым -, значит ожидаем числа.
     * number - собираем число
     * на выходе всегда будет четное количество элементов, иначе ошибка.
     * последний элемент всегда будет "="
     *
     * @throws IllegalArgumentException - все, что не входит в нашу логику.
     */
    private List<String> getElements(String noSpace) {
        List<String> elements = new ArrayList<>();
        String status = "firstMinusOrNumber";
        StringBuilder element = new StringBuilder();
        for (String subChar : noSpace.split("")) {
            char ch = subChar.charAt(0);
            if ("endOfExpression".equals(status)) {
                throw new IllegalArgumentException("Error: bad expression.");
            }
            if ("firstMinusOrNumber".equals(status)) {
                if (ch == '-') {
                    element.append(ch);
                    status = "negativeNumber";
                    continue;
                }
            }
            if (ch >= '0' && ch <= '9') {
                element.append(ch);
                status = "number";
            } else {
                if (!"number".equals(status)) {
                    throw new IllegalArgumentException("Error: bad expression, expect - " + status);
                }
                elements.add(element.toString());
                element = new StringBuilder();
                if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                    elements.add(subChar);
                    status = "firstMinusOrNumber";
                } else if (ch == '=') {
                    status = "endOfExpression";
                } else {
                    throw new IllegalArgumentException("Error: bad expression");
                }
            }
        }
        if (!element.isEmpty()) {
            elements.add(element.toString());
        }
        if (!"=".equals(elements.get(elements.size() - 1))) {
            elements.add("=");
        }
        if (elements.size() % 2 != 0) {
            throw new IllegalArgumentException("Error: bad count elements of expression");
        }
        return elements;
    }

    /**
     * взависимости от символа, делаем действие c переданными параметрами.
     */
    private int doAction(String action, int firstNum, int secondNum) {
        int result = firstNum;
        switch (action) {
            case ("+"):
                result += secondNum;
                break;
            case ("-"):
                result -= secondNum;
                break;
            case ("*"):
                result *= secondNum;
                break;
            case ("/"):
                if (secondNum == 0) {
                    throw new IllegalArgumentException("Error: Expression contain divided by zero");
                }
                result /= secondNum;
                break;
            default:
        }
        return result;
    }

    public static void main(String[] args) {
        Calc calc = new Calc();
        System.out.println(calc.calculator("-1+2*3/0"));
    }
}
