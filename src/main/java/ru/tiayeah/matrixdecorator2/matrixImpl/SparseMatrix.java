package ru.tiayeah.matrixdecorator2.matrixImpl;

import ru.tiayeah.matrixdecorator2.Colors;
import ru.tiayeah.matrixdecorator2.interfaces.IDrawer;
import ru.tiayeah.matrixdecorator2.interfaces.IMatrix;
import ru.tiayeah.matrixdecorator2.interfaces.IVector;
import ru.tiayeah.matrixdecorator2.vectorImpl.SparseVector;

public class SparseMatrix extends AbstractMatrix {

    public SparseMatrix(int rowCount, int colCount) {
        super(rowCount, colCount);
        color = Colors.GREEN;
    }

    public SparseMatrix(IMatrix sparseMatrix) {
        super(sparseMatrix);
    }

    @Override
    protected IVector createVector(int colCount) {
        return new SparseVector(colCount);
    }


    @Override
    public void letCellDraw(IDrawer drawer, int i, int j, int value, int offsetX, int offsetY) {
        if (value!= 0) {
            rows[i].getCell(j).drawYourself(drawer, i,  j, offsetX, offsetY);
        }
    }
}
