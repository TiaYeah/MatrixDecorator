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
    public void draw(IDrawer drawer, boolean showBorder, int offsetX, int offsetY) {
        if (showBorder) {
            drawer.drawBorder(this);
        }
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (getValue(i, j) != 0) {
                    drawer.fillCell(i, j, color, offsetX, offsetY);
                    drawer.drawCell(getValue(i, j), i, j, this, offsetX, offsetY);
                }
            }
        }
        drawer.printResult();
    }
}
