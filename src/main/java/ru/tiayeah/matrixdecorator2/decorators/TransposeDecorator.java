package ru.tiayeah.matrixdecorator2.decorators;

import ru.tiayeah.matrixdecorator2.interfaces.IDrawer;
import ru.tiayeah.matrixdecorator2.interfaces.IPrintableMatrix;

public class TransposeDecorator extends AMatrixDecorator {

    public TransposeDecorator(IPrintableMatrix matrix) {
        super(matrix);
    }

    @Override
    public int getRows() {
        return matrix.getCols();
    }

    @Override
    public int getCols() {
        return matrix.getRows();
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
            drawer.drawBorder(this, offsetX, offsetY);
        }


        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                fillCell(drawer, i, j, getValue(i, j), offsetX, offsetY);
                drawCell(drawer, i, j, getValue(i, j), offsetX, offsetY);
            }
        }
        drawer.printResult();
    }
}
