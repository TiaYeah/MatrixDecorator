package ru.tiayeah.matrixdecorator2.decorators;

import ru.tiayeah.matrixdecorator2.Colors;
import ru.tiayeah.matrixdecorator2.interfaces.IDrawer;
import ru.tiayeah.matrixdecorator2.interfaces.IMatrix;
import ru.tiayeah.matrixdecorator2.interfaces.IPrintableMatrix;
import ru.tiayeah.matrixdecorator2.vectorImpl.Cell;

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
            drawer.drawBorder(this, offsetX, offsetY);
        }
        int matrixOffsetX = offsetX;

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
        int currentRow = 0;

        for (IPrintableMatrix matrix : matrixList) {
            if (row < currentRow + matrix.getRows()) {
                if (col >= matrix.getCols()) {
                    Cell zeroCell = new Cell(col, 0, Colors.AQUA);
                    zeroCell.setI(row - currentRow);
                    return zeroCell;
                }
                return matrix.getCell(row - currentRow, col);
            }
            currentRow += matrix.getRows();
        }
        throw new IndexOutOfBoundsException("Индекс выходит за пределы матрицы");
    }

    @Override
    public void drawCell(IDrawer drawer, int i, int j, int value, int offsetX, int offsetY) {
        int currentCol = 0;

        for (IPrintableMatrix matrix : matrixList) {
            if (i < currentCol + matrix.getRows()) {
                if (j >= matrix.getCols()) {
                    drawer.drawCell(value, i, j, matrix, offsetX, offsetY);
                    return;
                }
                matrix.drawCell(drawer, i - currentCol, j, value, offsetX, offsetY + currentCol);
                return;
            }
            currentCol += matrix.getRows();
        }
    }

    @Override
    public void fillCell(IDrawer drawer, int i, int j, int value, int offsetX, int offsetY) {
        int currentCol = 0;

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

    @Override
    public void letCellDraw(IDrawer drawer, int i, int j, int value, int offsetX, int offsetY) {
        int currentCol = 0;

        for (IPrintableMatrix matrix : matrixList) {
            if (i < currentCol + matrix.getRows()) {

                if (j >= matrix.getCols()) {
                    getCell(i, j).drawYourself(drawer, i, j, value, offsetX, offsetY);
                    return;
                }

                matrix.letCellDraw(drawer, i - currentCol, j, value, offsetX, offsetY + currentCol);
                return;

            }
            currentCol += matrix.getRows();

        }
    }
}
