package ru.tiayeah.matrixdecorator2.vectorImpl;

import ru.tiayeah.matrixdecorator2.Colors;
import ru.tiayeah.matrixdecorator2.interfaces.IVector;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SparseVector implements IVector {
    private HashMap<Integer, Cell> data;
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
        return data.get(index) != null ? data.get(index).getValue() : 0;
    }

    @Override
    public void setValue(int index, int value) {
        if ( data.size() == size && !data.containsKey(index)) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы вектора");
        } else {
            data.put(index, new Cell(index, value, Colors.GREEN));
        }
    }

    @Override
    public Cell getCell(int index) {
        return data.get(index);
    }

    @Override
    public String toString() {
        return "SparseVector{" +
                "data=" + data +
                '}';
    }


}
