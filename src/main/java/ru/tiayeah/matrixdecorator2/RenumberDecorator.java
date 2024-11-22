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
        while (row1 == row2) {
            row2 = rand.nextInt(rows);
        }

        for (int i = 0; i < matrix.getCols(); i++) {
            int tmp = matrix.getValue(row1, i);
            matrix.setValue(row1, i, matrix.getValue(row2, i));
            matrix.setValue(row2, i, tmp);
        }

        int col1 = rand.nextInt(cols);
        int col2 = rand.nextInt(cols);
        while (col1 == col2) {
            col2 = rand.nextInt(cols);
        }

        for (int i = 0; i < matrix.getRows(); i++) {
            int tmp = matrix.getValue(i, col1);
            matrix.setValue(i, col1, matrix.getValue(i, col2));
            matrix.setValue(i, col2, tmp);
        }

        System.out.println("Поменялись " + (row1 + 1) + " и " + (row2 + 1)+ " строки");
        System.out.println("Поменялись " + (col1 + 1) + " и " + (col2 + 1) + " столбцы");
    }

    @Override
    public int getValue(int row, int col) {
        return matrix.getValue(row, col);
    }

    @Override
    public void setValue(int row, int col, int value) {
        matrix.setValue(row, col, value);
    }

    @Override
    public void draw(IDrawer drawer, boolean showBorder, int offsetX, int offsetY) {
        matrix.draw(drawer, showBorder, offsetX, offsetY);
//        if (showBorder) {
//            drawer.drawBorder(this);
//        }
//        for (int i = 0; i < matrix.getRows(); i++) {
//            for (int j = 0; j < matrix.getCols(); j++) {
//                fillCell(drawer, i, j, getValue(i,j));
//                drawCell(drawer, i, j, getValue(i,j));
//            }
//        }
//        drawer.printResult();
    }


    @Override
    public IMatrix getComponent() {
        return matrix.getComponent();
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
