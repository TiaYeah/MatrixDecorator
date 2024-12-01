package ru.tiayeah.matrixdecorator2.decorators;

import ru.tiayeah.matrixdecorator2.interfaces.IDrawer;
import ru.tiayeah.matrixdecorator2.interfaces.IMatrix;
import ru.tiayeah.matrixdecorator2.interfaces.IPrintableMatrix;
import ru.tiayeah.matrixdecorator2.vectorImpl.Cell;

public abstract class AMatrixDecorator implements IPrintableMatrix {
    protected IPrintableMatrix matrix;

    public AMatrixDecorator(IPrintableMatrix matrix) {
        this.matrix = matrix;
    }

    @Override
    public int getRows() {
        return matrix.getRows();
    }

    @Override
    public int getCols() {
        return matrix.getCols();
    }

    public abstract int getValue(int row, int col);

    public abstract void setValue(int row, int col, int value);


    @Override
    public IMatrix getComponent() {
        return matrix.getComponent();
    }

    @Override
    public void drawCell(IDrawer drawer, int i, int j, int value, int offsetX, int offsetY) {
        matrix.drawCell(drawer, i, j, value, offsetX, offsetY);
    }

    @Override
    public void fillCell(IDrawer drawer, int i, int j, int value, int offsetX, int offsetY) {
        matrix.fillCell(drawer, i, j, value, offsetX, offsetY);
    }

    @Override
    public void draw(IDrawer drawer, boolean showBorder, int offsetX, int offsetY) {
        if (showBorder) {
            drawer.drawBorder(this, offsetX, offsetY);
        }
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                letCellDraw(drawer, i, j, getValue(i, j), offsetX, offsetY);

                // matrix.letCellDraw(drawer, i, j, getValue(rowIndex[i], colIndex[j]), offsetX + colIndex[j] - j, offsetY + rowIndex[i] - i);

                //matrix.letCellDraw(drawer, rowIndex[i], colIndex[j], getValue(i, j), offsetX, offsetY);
            }
        }
        drawer.printResult();
    }

    @Override
    public void letCellDraw(IDrawer drawer, int i, int j, int value, int offsetX, int offsetY) {
        if (getCell(i, j) != null) {
            getCell(i, j).drawYourself(drawer, i, j, getValue(i, j), offsetX, offsetY);
        }
    }
}
