package ru.tiayeah.matrixdecorator2;

import java.util.Arrays;

public class OrdinaryVector implements IVector {
    private int[] data;
    private int size;

    public OrdinaryVector(int size) {
        data = new int[size];
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getValue(int index) {
        return data[index];
    }

    @Override
    public void setValue(int index, int value) {
        data[index] = value;
    }

    @Override
    public String toString() {
        return "OrdinaryVector{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
