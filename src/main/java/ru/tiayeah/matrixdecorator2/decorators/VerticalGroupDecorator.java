package ru.tiayeah.matrixdecorator2.decorators;

import ru.tiayeah.matrixdecorator2.Colors;
import ru.tiayeah.matrixdecorator2.interfaces.IDrawer;
import ru.tiayeah.matrixdecorator2.interfaces.IMatrix;
import ru.tiayeah.matrixdecorator2.interfaces.IPrintableMatrix;

import java.util.ArrayList;
import java.util.List;

public class VerticalGroupDecorator implements IPrintableMatrix {
    private List<IPrintableMatrix> matrixList = new ArrayList<>();

    public VerticalGroupDecorator() {
    }

    public VerticalGroupDecorator(List<IPrintableMatrix> matrixList) {
        this.matrixList = matrixList;
    }

    public void addMatrix(IPrintableMatrix matrix) {
        matrixList.add(matrix);
    }

    @Override
    public int getRows() {
        return matrixList.isEmpty() ? 0 : matrixList.stream().mapToInt(IPrintableMatrix::getRows).sum();
    }

    @Override
    public int getCols() {
        return matrixList.isEmpty() ? 0 : matrixList.stream().mapToInt(IPrintableMatrix::getCols).max().getAsInt();
    }

    @Override
    public int getValue(int row, int col) {
        int currentRow = 0;
        for (IPrintableMatrix matrix : matrixList) {
            if (row < currentRow + matrix.getRows()) {
                if (col >= matrix.getCols()) {
                    return 0;
                }
                return matrix.getValue(row - currentRow, col);
            }
            currentRow += matrix.getRows();
        }
        throw new IndexOutOfBoundsException("Индекс выходит за пределы матрицы");
    }

    @Override
    public void setValue(int row, int col, int value) {
        int currentRow = 0;
        for (IPrintableMatrix matrix : matrixList) {
            if (row < currentRow + matrix.getRows()) {
                matrix.setValue(row - currentRow, col, value);
                return;
            }
            currentRow += matrix.getRows();
        }
        throw new IndexOutOfBoundsException("Индекс выходит за пределы матрицы");
    }

    @Override
    public void draw(IDrawer drawer, boolean showBorder, int offsetX, int offsetY) {
        if (showBorder) {
            drawer.drawBorder(this);
        }
//        for (int i = 0; i < matrixList.size(); i++) {
//            if (i != 0) {
//                matrixOffsetX += matrixList.get(i - 1).getCols();
//            }
//            for (int j = 0; j < matrixList.get(i).getRows(); j++) {
//                for (int k = 0; k < matrixList.get(i).getCols(); k++) {
//                    matrixList.get(i).fillCell(drawer, j, k, matrixList.get(i).getValue(j, k), matrixOffsetX, offsetY);
//                    matrixList.get(i).drawCell(drawer, j, k, matrixList.get(i).getValue(j, k), matrixOffsetX, offsetY);
//                }
//            }
//
//        }
        System.out.println(matrixList.size());
        System.out.println(getRows() + " " + getCols());

        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                fillCell(drawer, i, j, getValue(i, j), offsetX, offsetY);
                drawCell(drawer, i, j, getValue(i, j), offsetX, offsetY);
            }
        }

        drawer.printResult();
    }

    @Override
    public IMatrix getComponent() {
        return this;
    }

    @Override
    public void drawCell(IDrawer drawer, int i, int j, int value, int offsetX, int offsetY) {
        int currentCol = 0;
        boolean isTranspose = i >= getRows();

        for (IPrintableMatrix matrix : matrixList) {
            if (i < currentCol + matrix.getRows()) {
                if (j >= matrix.getCols()) {
                    drawer.drawCell(0, i, j, matrix, offsetX, offsetY);
                    return;
                }
                matrix.drawCell(drawer, i, j, value, offsetX, offsetY);
                return;
            }
            currentCol += matrix.getRows();
        }
    }

    @Override
    public void fillCell(IDrawer drawer, int i, int j, int value, int offsetX, int offsetY) {
        int currentCol = 0;
        boolean isTranspose = i >= getRows();

        for (IPrintableMatrix matrix : matrixList) {
            if (i < currentCol + matrix.getRows()) {
                if (j >= matrix.getCols()) {
                    drawer.fillCell(i, j, Colors.AQUA, offsetX, offsetY);
                    return;
                }
                matrix.fillCell(drawer, i - currentCol, j, value, offsetX, offsetY + currentCol);
                return;
            }
            currentCol += matrix.getRows();
        }
    }
}
