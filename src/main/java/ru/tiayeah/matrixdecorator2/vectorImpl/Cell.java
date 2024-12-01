package ru.tiayeah.matrixdecorator2.vectorImpl;

import ru.tiayeah.matrixdecorator2.Colors;
import ru.tiayeah.matrixdecorator2.interfaces.IDrawer;

import java.util.Objects;

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

    public void drawYourself(IDrawer drawer, int i, int j, int value, int offsetX, int offsetY) {
        drawer.fillCell(i, j, color, offsetX, offsetY);
        drawer.drawCell(value, i, j, offsetX, offsetY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;
        return i == cell.i && j == cell.j && value == cell.value && color == cell.color;
    }

    @Override
    public int hashCode() {
        int result = i;
        result = 31 * result + j;
        result = 31 * result + value;
        result = 31 * result + Objects.hashCode(color);
        return result;
    }
}
