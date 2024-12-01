package ru.tiayeah.matrixdecorator2.interfaces;

import ru.tiayeah.matrixdecorator2.Colors;

public interface IDrawer {
    void drawCell(int value, int i, int j, IMatrix matrix, int offsetX, int offsetY);
    void printResult();
    void drawBorder(IMatrix matrix, int offsetX, int offsetY);
    void fillCell(int i, int j, Colors color, int offsetX, int offsetY);
    void drawCell(int value, int i, int j, int offsetX, int offsetY);
}
