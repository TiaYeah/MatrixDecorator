package ru.tiayeah.matrixdecorator2;

public class OrdinaryMatrix extends AbstractMatrix {

    public OrdinaryMatrix(int rowCount, int colCount) {
        super(rowCount, colCount);
    }

    @Override
    protected IVector createVector(int colCount) {
        return new OrdinaryVector(colCount);
    }

    @Override
    public void draw(IDrawer drawer, boolean showBroder) {
        if (showBroder) {
            drawer.drawBorder(this);
        }
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < rows[i].getSize(); j++) {
                drawer.drawCell(rows[i].getValue(j), i, j, this);
            }
            //drawer.drawRow(i, rows[i]);
        }
        drawer.printResult();
    }
}
