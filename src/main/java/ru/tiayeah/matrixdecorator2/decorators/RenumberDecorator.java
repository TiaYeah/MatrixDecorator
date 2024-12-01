package ru.tiayeah.matrixdecorator2.decorators;

import ru.tiayeah.matrixdecorator2.interfaces.IDrawer;
import ru.tiayeah.matrixdecorator2.interfaces.IPrintableMatrix;
import ru.tiayeah.matrixdecorator2.vectorImpl.Cell;

import java.util.Random;

public class RenumberDecorator extends AMatrixDecorator {
    private int[] rowIndex;
    private int[] colIndex;

    public RenumberDecorator(IPrintableMatrix matrix) {
        super(matrix);
        fillIndexes();
    }

    private void fillIndexes() {
        rowIndex = new int[matrix.getRows()];
        colIndex = new int[matrix.getCols()];

        for (int i = 0; i < matrix.getRows(); i++) {
            rowIndex[i] = i;
        }
        for (int i = 0; i < matrix.getCols(); i++) {
            colIndex[i] = i;
        }
    }

    public void renumber() {
        Random rand = new Random();
        int rows = rowIndex.length;
        int cols = colIndex.length;

        int row1 = rand.nextInt(rows);
        int row2 = rand.nextInt(rows);
        while (row1 == row2) {
            row2 = rand.nextInt(rows);
        }
        int temp = rowIndex[row1];
        rowIndex[row1] = rowIndex[row2];
        rowIndex[row2] = temp;

        int col1 = rand.nextInt(cols);
        int col2 = rand.nextInt(cols);
        while (col1 == col2) {
            col2 = rand.nextInt(cols);
        }
        temp = colIndex[col1];
        colIndex[col1] = colIndex[col2];
        colIndex[col2] = temp;
        System.out.println("Поменялись " + (row1 + 1) + " и " + (row2 + 1) + " строки");
        System.out.println("Поменялись " + (col1 + 1) + " и " + (col2 + 1) + " столбцы");
    }

    @Override
    public int getValue(int row, int col) {
        return matrix.getValue(rowIndex[row], colIndex[col]);
    }

    @Override
    public void setValue(int row, int col, int value) {
        matrix.setValue(rowIndex[row], colIndex[col], value);
    }





    @Override
    public Cell getCell(int row, int col) {
        return matrix.getCell(rowIndex[row], colIndex[col]);
    }

    public void print() {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                System.out.print(matrix.getValue(i, j) + " ");
            }
            System.out.println();
        }
    }

}
