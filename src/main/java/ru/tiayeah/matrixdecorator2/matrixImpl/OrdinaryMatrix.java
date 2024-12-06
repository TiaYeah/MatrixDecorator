package ru.tiayeah.matrixdecorator2.matrixImpl;

import ru.tiayeah.matrixdecorator2.Colors;
import ru.tiayeah.matrixdecorator2.interfaces.IDrawer;
import ru.tiayeah.matrixdecorator2.interfaces.IMatrix;
import ru.tiayeah.matrixdecorator2.interfaces.IVector;
import ru.tiayeah.matrixdecorator2.vectorImpl.OrdinaryVector;

public class OrdinaryMatrix extends AbstractMatrix {

    public OrdinaryMatrix(int rowCount, int colCount) {
        super(rowCount, colCount);

        color = Colors.RED;
    }

    public OrdinaryMatrix(IMatrix ordinaryMatrix) {
        super(ordinaryMatrix);
    }


    @Override
    protected IVector createVector(int colCount) {
        return new OrdinaryVector(colCount);
    }



    @Override
    public void letCellDraw(IDrawer drawer, int i, int j, int value, int offsetX, int offsetY) {
            rows[i].getCell(j).drawYourself(drawer, i, j, offsetX, offsetY);

    }


}
