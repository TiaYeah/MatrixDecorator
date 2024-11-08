package ru.tiayeah.matrixdecorator2;

public class SparseMatrix extends AbstractMatrix {

    public SparseMatrix(int rowCount, int colCount) {
        super(rowCount, colCount);
    }

    @Override
    protected IVector createVector(int colCount) {
        return new SparseVector(colCount);
    }

    @Override
    public void draw(IDrawer drawer, boolean showBroder) {
        if (showBroder) {
            drawer.drawBorder(this);
        }
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < rows[i].getSize(); j++) {
                if (rows[i].getValue(j) != 0) {
                    drawer.drawCell(rows[i].getValue(j), i , j, this);
                }
            }
            //drawer.drawRow(i, rows[i]);
        }
        drawer.printResult();
    }
}
