package ru.tiayeah.matrixdecorator2;

public interface IPrintable {

    void drawCell(IDrawer drawer, int i, int j, int value);

    void fillCell(IDrawer drawer, int i, int j, int value);
}
