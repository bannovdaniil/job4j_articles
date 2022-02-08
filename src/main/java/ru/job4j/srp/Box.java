package ru.job4j.srp;

/**
 * Вернуть количество вершин фигуры, но при этом еще и устанавливаем угол.
 * Нарушение принципа разделения ответственности.
 */
public class Box implements Figure {
    int corners = 4;
    int angle = 90;

    @Override
    public int getCorners(int angle) {
        this.angle = angle;
        return corners;
    }
}
