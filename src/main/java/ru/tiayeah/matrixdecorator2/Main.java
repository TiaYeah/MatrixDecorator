package ru.tiayeah.matrixdecorator2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IVector vector = new SparseVector(5);
        for (int i = 0; i < 5; i++) {
            vector.setValue(i, i);
        }
        vector.setValue(4, 12);
        System.out.println(vector);

        int rowCount = 5;
        int colCount = 5;

        IMatrix ordinaryMatrix = new OrdinaryMatrix(rowCount, colCount);
        IMatrix sparseMatrix = new SparseMatrix(rowCount, colCount);

        MatrixInitializer.fillMatrix(ordinaryMatrix, 10, 15);
        MatrixInitializer.fillMatrix(sparseMatrix, 10, 15);

        System.out.println(ordinaryMatrix);
        //System.out.println(sparseMatrix);

        RenumberDecorator decoratedMatrix = new RenumberDecorator(ordinaryMatrix);
        decoratedMatrix.renumber();
        decoratedMatrix.print();


        Main main = new Main();
        main.Rectangle();
    }

    public void Rectangle() {
        String temp;
        String brush, horizontalBrush;
        int height, width;
        Scanner keyboard = new Scanner(System.in);
        brush = Character.toString((char) 0x250D);
        horizontalBrush = Character.toString((char) 0x2500);
        height = 5;
        width = 5;
        for (int i = 0; i < height; i++) {
            //System.out.print(brush);
            for (int k = 0; k < width; k++) {
                System.out.print(" ");
                if (i == 0 & k == 0) {
                    System.out.print(Character.toString((char) 0x2554));
                } else if (i == 0 & k == width - 1) {
                    System.out.print(Character.toString((char) 0x2557));
                } else if (i == height - 1 && k == 0) {
                    System.out.print(Character.toString((char) 0x255A));
                } else if (i == height - 1 && k == width - 1) {
                    System.out.print(Character.toString((char) 0x255D));
                } else if (i == 0 || i == (height - 1)) {
                    System.out.print(Character.toString((char) 0x2550));
                } else if (k == 0 || k == (width - 1)) {
                    System.out.print(Character.toString((char) 0x2551));
                } else {
                    System.out.print(" ");

                }
            }
            System.out.print(" ");//this was needed to keep it aesthetically in line with the rest of the spacing. otherwise you have an extra brush stroke and no spacing.
            //System.out.print(brush);
            System.out.print("\n");
        }
    }
}
