package ru.tiayeah.matrixdecorator2;

import java.util.Random;

public class RenumberDecorator implements IMatrix {
    private IMatrix matrix;
    private int[] rowIndex;
    private int[] colIndex;

    public RenumberDecorator(IMatrix matrix) {
        this.matrix = matrix;
        fillIndexes();
    }

    private void fillIndexes() {
        rowIndex = new int[matrix.getRows()];
        colIndex = new int[matrix.getCols()];

        for (int i = 0; i < matrix.getRows(); i++) { rowIndex[i] = i; }
        for (int i = 0; i < matrix.getCols(); i++) { colIndex[i] = i; }
    }

    @Override
    public int getRows() {
        return matrix.getRows();
    }

    @Override
    public int getCols() {
        return matrix.getCols();
    }

    public void renumber() {
        Random rand = new Random();
        int rows = rowIndex.length;
        int cols = colIndex.length;

        int row1 = rand.nextInt(rows);
        int row2 = rand.nextInt(rows);
        int temp = rowIndex[row1];
        rowIndex[row1] = rowIndex[row2];
        rowIndex[row2] = temp;

        int col1 = rand.nextInt(cols);
        int col2 = rand.nextInt(cols);
        temp = colIndex[col1];
        colIndex[col1] = colIndex[col2];
        colIndex[col2] = temp;
    }

    public void refresh() {
        for (int i = 0; i < matrix.getRows(); i++) { rowIndex[i] = i; }
        for (int i = 0; i < matrix.getCols(); i++) { colIndex[i] = i; }
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
    public void draw(IDrawer drawer, boolean showBorder) {
        if (showBorder) {
            drawer.drawBorder(this);
        }
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                drawer.drawCell(getValue(i, j), i, j, this);
            }
            //drawer.drawRow(i, rows[i]);
        }
        drawer.printResult();
    }

    public void print() {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                System.out.print(matrix.getValue(rowIndex[i], colIndex[j]) + " ");
            }
            System.out.println();
        }
    }
}