package ru.tiayeah.matrixdecorator2.interfaces;

public interface IMatrix {
    int getRows();

    int getCols();

    int getValue(int row, int col);

    void setValue(int row, int col, int value);

    void draw(IDrawer drawer, boolean showBorder, int offsetX, int offsetY);

    IMatrix getComponent();
}
