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
    public void drawCell(IDrawer drawer, int i, int j, int value, int offsetX, int offsetY) {
        drawer.drawCell(value, i, j, this, offsetX, offsetY);
    }

    @Override
    public void fillCell(IDrawer drawer, int i, int j, int value, int offsetX, int offsetY) {
        drawer.fillCell(i, j, color, offsetX, offsetY);
    }
}
