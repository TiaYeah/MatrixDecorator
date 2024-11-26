package ru.tiayeah.matrixdecorator2;

public class TransposeDecorator extends AMatrixDecorator {

    public TransposeDecorator(IPrintableMatrix matrix) {
        super(matrix);
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
    public void draw(IDrawer drawer, boolean showBorder, int offsetX, int offsetY) {
        if (showBorder) {
            drawer.drawBorder(this);
        }
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                fillCell(drawer, i, j, getValue(i, j));
                drawCell(drawer, i, j, getValue(i, j));
            }
        }
        drawer.printResult();
    }
}
