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
    public void draw(IDrawer drawer, boolean showBorder, int offsetX, int offsetY) {
        if (showBorder) {
            drawer.drawBorder(this);
        }
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                drawer.fillCell(i, j, color, offsetX, offsetY);
                drawer.drawCell(getValue(i, j), i, j, this, offsetX, offsetY);
            }
        }
        drawer.printResult();
    }
}
