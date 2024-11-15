package ru.tiayeah.matrixdecorator2;

public interface IMatrix {
    int getRows();

    int getCols();

    int getValue(int row, int col);

    void setValue(int row, int col, int value);

    void draw(IDrawer drawer, boolean showBorder);

    void drawCell(IDrawer drawer, int i, int j, int value);

    void fillCell(IDrawer drawer, int i, int j, int value);
}
