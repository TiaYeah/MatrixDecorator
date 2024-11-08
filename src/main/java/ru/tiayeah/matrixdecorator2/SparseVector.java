package ru.tiayeah.matrixdecorator2;

import java.util.HashMap;

public class SparseVector implements IVector {
    private HashMap<Integer, Integer> data;
    private int size;

    public SparseVector(int size) {
        this.size = size;
        data = new HashMap<>();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getValue(int index) {
        return data.getOrDefault(index, 0);
    }

    @Override
    public void setValue(int index, int value) {
        if ( data.size() == size && !data.containsKey(index)) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы вектора");
        } else {
            data.put(index, value);
        }
    }

    @Override
    public String toString() {
        return "SparseVector{" +
                "data=" + data +
                '}';
    }
}
