package ru.tiayeah.matrixdecorator2;

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
    public void drawCell(IDrawer drawer, int i, int j, int value) {
        if (value != 0) {
            drawer.drawCell(value, i, j, this,0,0);
        }

    }

    @Override
    public void fillCell(IDrawer drawer, int i, int j, int value) {
        if (value!= 0) {
            drawer.fillCell(i, j, color, 0, 0);
        }
    }
}
