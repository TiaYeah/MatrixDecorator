package ru.tiayeah.matrixdecorator2;

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
    public void drawCell(IDrawer drawer, int i, int j, int value) {
        drawer.drawCell(value, i, j, this);
    }

    @Override
    public void fillCell(IDrawer drawer, int i, int j, int value) {
        drawer.fillCell(i, j, color);
    }
}
