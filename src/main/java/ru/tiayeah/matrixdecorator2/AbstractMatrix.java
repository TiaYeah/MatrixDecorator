package ru.tiayeah.matrixdecorator2;

import java.util.Arrays;

public abstract class AbstractMatrix implements IMatrix {
    protected int rowCount;
    protected int colCount;
    protected IVector[] rows;
    private IDrawer drawer;

    public AbstractMatrix(int rowCount, int colCount) {
        this.rowCount = rowCount;
        this.colCount = colCount;
        rows = new IVector[rowCount];
        for( int i = 0; i < rowCount; i++) {
            rows[i] = createVector(colCount);
        }
    }

    abstract protected IVector createVector(int colCount);

    @Override
    public int getRows() {
        return rowCount;
    }

    @Override
    public int getValue(int row, int col) {
        return rows[row].getValue(col);
    }

    @Override
    public void setValue(int row, int col, int value) {
        rows[row].setValue(col, value);
    }

    @Override
    public int getCols() {
        return colCount;
    }

    @Override
    public String toString() {
        return "AbstractMatrix{" +
                "rows=" + Arrays.toString(rows) +
                '}';
    }
}
