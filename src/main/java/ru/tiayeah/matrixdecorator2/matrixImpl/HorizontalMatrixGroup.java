package ru.tiayeah.matrixdecorator2.matrixImpl;

import ru.tiayeah.matrixdecorator2.interfaces.IDrawer;
import ru.tiayeah.matrixdecorator2.interfaces.IMatrix;
import ru.tiayeah.matrixdecorator2.interfaces.IPrintableMatrix;

import java.util.ArrayList;
import java.util.List;

public class HorizontalMatrixGroup implements IPrintableMatrix {
    private List<IPrintableMatrix> matrixList = new ArrayList<>();


    public void addMatrix(IPrintableMatrix matrix) {
        matrixList.add(matrix);
    }

    @Override
    public int getRows() {
        return matrixList.isEmpty() ? 0 : matrixList.stream().mapToInt(IPrintableMatrix::getRows).max().getAsInt();
    }

    @Override
    public int getCols() {
        return matrixList.isEmpty() ? 0 : matrixList.stream().mapToInt(IPrintableMatrix::getCols).sum();
    }

    @Override
    public int getValue(int row, int col) {
        int currentCol = 0;
        for (IPrintableMatrix matrix : matrixList) {
            if (col < currentCol + matrix.getCols()) {
                return matrix.getValue(row, col - currentCol);
            }
            currentCol += matrix.getCols();
        }
        throw new IndexOutOfBoundsException("Индекс выходит за пределы матрицы");
    }

    @Override
    public void setValue(int row, int col, int value) {
        int currentCol = 0;
        for (IPrintableMatrix matrix : matrixList) {
            if (col < currentCol + matrix.getCols()) {
                matrix.setValue(row, col - currentCol, value);
                return;
            }
            currentCol += matrix.getCols();
        }
        throw new IndexOutOfBoundsException("Индекс выходит за пределы матрицы");
    }

    @Override
    public void draw(IDrawer drawer, boolean showBorder, int offsetX, int offsetY) {
        if (showBorder) {
            drawer.drawBorder(this);
        }
        int matrixOffsetX = offsetX;
        for (int i = 0; i < matrixList.size(); i++) {
            if (i != 0) {
                matrixOffsetX += matrixList.get(i - 1).getCols();
            }
            //matrixList.get(i).fillCell(drawer, matrixOffsetX, offsetY);

        }
        drawer.printResult();

    }

    @Override
    public IMatrix getComponent() {
        return this;
    }

    @Override
    public void drawCell(IDrawer drawer, int i, int j, int value) {

    }

    @Override
    public void fillCell(IDrawer drawer, int i, int j, int value) {

    }
}
