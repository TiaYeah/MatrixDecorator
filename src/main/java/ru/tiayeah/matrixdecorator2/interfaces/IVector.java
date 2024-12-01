package ru.tiayeah.matrixdecorator2.interfaces;

import ru.tiayeah.matrixdecorator2.vectorImpl.Cell;

public interface IVector {
    int getSize();
    int getValue(int index);
    void setValue(int index, int value);
    Cell getCell(int index);
}
