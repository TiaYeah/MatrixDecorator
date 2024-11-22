package ru.tiayeah.matrixdecorator2;

import java.util.ArrayList;
import java.util.List;

public class HorizontalMatrixGroup implements IMatrix {
    private List<IMatrix> matrixList = new ArrayList<IMatrix>();


    public void addMatrix(IMatrix matrix) {
        matrixList.add(matrix);
    }

    @Override
    public int getRows() {
        return matrixList.isEmpty() ? 0 : matrixList.stream().mapToInt(IMatrix::getRows).max().getAsInt();
    }

    @Override
    public int getCols() {
        return matrixList.isEmpty() ? 0 : matrixList.stream().mapToInt(IMatrix::getCols).sum();
    }

    @Override
    public int getValue(int row, int col) {
        int currentCol = 0;
        for (IMatrix matrix : matrixList) {
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
        for (IMatrix matrix : matrixList) {
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
            matrixList.get(i).draw(drawer, false, matrixOffsetX, offsetY);
        }
        drawer.printResult();
    }

    @Override
    public IMatrix getComponent() {
        return null;
    }
}
