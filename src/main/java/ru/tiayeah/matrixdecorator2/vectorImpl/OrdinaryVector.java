package ru.tiayeah.matrixdecorator2.vectorImpl;

import ru.tiayeah.matrixdecorator2.Colors;
import ru.tiayeah.matrixdecorator2.interfaces.IVector;

import java.util.Arrays;

public class OrdinaryVector implements IVector {
    private Cell[] data;
    private int size;

    public OrdinaryVector(int size) {
        data = new Cell[size];
        for (int i = 0; i < size; i++) {
            data[i] = new Cell(i, 0, Colors.RED);
        }
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getValue(int index) {
        return data[index].getValue();
    }

    @Override
    public void setValue(int index, int value) {
        data[index].setValue(value);
    }

    @Override
    public Cell getCell(int index) {
        return data[index];
    }

    @Override
    public String toString() {
        return "OrdinaryVector{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

}
