package ru.tiayeah.matrixdecorator2.interfaces;

public interface IPrintable {

    void drawCell(IDrawer drawer, int i, int j, int value, int offsetX, int offsetY);

    void fillCell(IDrawer drawer, int i, int j, int value, int offsetX, int offsetY);

    void letCellDraw(IDrawer drawer, int i, int j, int value, int offsetX, int offsetY);
}
