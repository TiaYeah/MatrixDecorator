package ru.tiayeah.matrixdecorator2.drawers;

import ru.tiayeah.matrixdecorator2.Colors;
import ru.tiayeah.matrixdecorator2.interfaces.IDrawer;
import ru.tiayeah.matrixdecorator2.interfaces.IMatrix;

import java.util.ArrayList;
import java.util.List;

public class ConsoleDrawer implements IDrawer {
    private List<List<String>> matrixToPrint;
    private int previousCol = -1;
    private boolean drawBorder = false;

    @Override
    public void drawCell(int value, int y, int x, IMatrix matrix, int offsetX, int offsetY) {
        if (matrixToPrint == null) {
            matrixToPrint = new ArrayList<>();
            for (int i = 0; i < matrix.getRows() * 2 + 1; i++) {
                matrixToPrint.add(new ArrayList<>());
            }
            for (int i = 0; i < matrixToPrint.size(); i++) {
                for (int j = 0; j < matrix.getCols() * 2 + 1; j++) {
                    matrixToPrint.get(i).add("  ");
                }
            }
        }
        matrixToPrint.get(y * 2 + 1).set(x * 2 + 1, value + " ");
        if (x != matrix.getCols() - 1) {
            matrixToPrint.get(y + 1).set(x * 2 + 2, "  ");
        }
        if (y != matrix.getRows() - 1) {
            matrixToPrint.get(y * 2 + 2).set(x * 2 + 1, "  ");
        }

        previousCol = x;
    }

    @Override
    public void printResult() {
        for (int i = 0; i < matrixToPrint.size(); i++) {
            for (int j = 0; j < matrixToPrint.get(i).size(); j++) {
                System.out.print(matrixToPrint.get(i).get(j));
            }
            System.out.println();
        }
    }

    @Override
    public void drawBorder(IMatrix matrix, int offsetX, int offsetY) {
        drawBorder = true;
        matrixToPrint = new ArrayList<>();
        for (int i = 0; i < matrix.getRows() * 2 + 1; i++) {
            matrixToPrint.add(new ArrayList<>());
        }

        for (int i = 0; i < matrix.getRows() * 2 + 1; i++) {
            for (int j = 0; j < matrix.getCols() * 2 + 1; j++) {
                if (i == 0 || i == matrix.getRows() * 2) {
                    matrixToPrint.get(i).add("# ");
                } else if (j == 0 || j == matrix.getCols() * 2) {
                    matrixToPrint.get(i).add("# ");
                } else {
                    matrixToPrint.get(i).add("  ");
                }
            }
        }
    }

    @Override
    public void fillCell(int i, int j, Colors color, int offsetX, int offsetY) {

    }


}
