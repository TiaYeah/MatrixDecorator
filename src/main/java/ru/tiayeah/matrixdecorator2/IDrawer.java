package ru.tiayeah.matrixdecorator2;

public interface IDrawer {
    void drawCell(int value, int i, int j, IMatrix matrix, int offsetX, int offsetY);
    void printResult();
    void drawBorder(IMatrix matrix);
    void fillCell(int i, int j, Colors color, int offsetX, int offsetY);
}
