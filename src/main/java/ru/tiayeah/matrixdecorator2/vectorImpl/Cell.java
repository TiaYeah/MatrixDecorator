package ru.tiayeah.matrixdecorator2.vectorImpl;

import ru.tiayeah.matrixdecorator2.Colors;
import ru.tiayeah.matrixdecorator2.interfaces.IDrawer;

public class Cell {
    private int i;
    private int j;
    private int value;
    private Colors color;

    public Cell(int j, int value, Colors color) {
        this.j = j;
        this.value = value;
        this.color = color;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public void drawYourself(IDrawer drawer, int i, int j, int offsetX, int offsetY) {
        drawer.fillCell(i, j, color, offsetX, offsetY);
        drawer.drawCell(value, i, j, offsetX, offsetY);
    }


}
