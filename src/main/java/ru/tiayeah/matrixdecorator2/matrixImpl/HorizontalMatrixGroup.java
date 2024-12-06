package ru.tiayeah.matrixdecorator2.matrixImpl;

import ru.tiayeah.matrixdecorator2.Colors;
import ru.tiayeah.matrixdecorator2.interfaces.IDrawer;
import ru.tiayeah.matrixdecorator2.interfaces.IMatrix;
import ru.tiayeah.matrixdecorator2.interfaces.IPrintableMatrix;
import ru.tiayeah.matrixdecorator2.vectorImpl.Cell;

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
                if (row >= matrix.getRows()) {
                    return 0;
                }
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
            drawer.drawBorder(this, offsetX, offsetY);
        }
        int matrixOffsetX = offsetX;
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

        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
//                fillCell(drawer, i, j, getValue(i, j), offsetX, offsetY);
//                drawCell(drawer, i, j, getValue(i, j), offsetX, offsetY);
                letCellDraw(drawer, i, j, getValue(i, j), offsetX, offsetY);
            }
        }

        drawer.printResult();
    }

    @Override
    public IMatrix getComponent() {
        return this;
    }

    @Override
    public Cell getCell(int row, int col) {
        int currentCol = 0;
        for (IPrintableMatrix matrix : matrixList) {
            if (col < currentCol + matrix.getCols()) {
                if (row >= matrix.getRows()) {
                    Cell zeroCell = new Cell(col - currentCol, 0, Colors.AQUA);
                    zeroCell.setI(row);
                    return zeroCell;
                }
                return matrix.getCell(row, col - currentCol);
            }
            currentCol += matrix.getCols();
        }
        throw new IndexOutOfBoundsException("Индекс выходит за пределы матрицы");
    }


    @Override
    public void letCellDraw(IDrawer drawer, int i, int j, int value, int offsetX, int offsetY) {
        int currentCol = 0;

        for (IPrintableMatrix matrix : matrixList) {
            if (j < currentCol + matrix.getCols()) {

                if (i >= matrix.getRows()) {
//                    drawer.drawCell(value, i, j, matrix, offsetX, offsetY);
//                    drawer.fillCell(i, j, Colors.AQUA, offsetX, offsetY);
                    getCell(i, j).drawYourself(drawer, i, j, offsetX, offsetY);
                    return;
                }

                matrix.letCellDraw(drawer, i, j - currentCol, value, offsetX + currentCol, offsetY);
                return;

            }
            currentCol += matrix.getCols();

        }
    }
}
