package ru.tiayeah.matrixdecorator2.decorators;

import ru.tiayeah.matrixdecorator2.interfaces.IDrawer;
import ru.tiayeah.matrixdecorator2.interfaces.IPrintableMatrix;
import ru.tiayeah.matrixdecorator2.vectorImpl.Cell;

public class TransposeDecorator extends AMatrixDecorator {

    public TransposeDecorator(IPrintableMatrix matrix) {
        super(matrix);
    }

    @Override
    public int getRows() {
        return matrix.getCols();
    }

    @Override
    public int getCols() {
        return matrix.getRows();
    }

    @Override
    public int getValue(int row, int col) {
        return matrix.getValue(col, row);
    }

    @Override
    public void setValue(int row, int col, int value) {
        matrix.setValue(col, row, value);
    }



    @Override
    public Cell getCell(int row, int col) {
        return matrix.getCell(col, row);
    }


}
