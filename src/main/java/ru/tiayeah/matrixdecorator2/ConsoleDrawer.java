package ru.tiayeah.matrixdecorator2;

import java.util.ArrayList;
import java.util.List;

public class ConsoleDrawer implements IDrawer {
    private List<List<String>> matrixToPrint;
    private int previousRow = 0;
    private int previousCol = -1;
    private boolean drawBorder = false;



    @Override
    public void drawCell(int value, int y, int x, IMatrix matrix) {
        if (matrixToPrint == null) {
            matrixToPrint = new ArrayList<>();
            for (int i = 0; i < matrix.getRows() * 2 - 1; i++) {
                matrixToPrint.add(new ArrayList<>());
            }
            for (int i = 0; i < matrixToPrint.size(); i++) {
                for (int j = 0; j < matrix.getCols() * 2 - 1; j++) {
                    matrixToPrint.get(i).add("  ");
                }
            }
        }
//        if (y > previousRow) {
//            previousRow = y;
//            if (drawBorder) {
//                drawRightBorder(matrix.getCols());
//            }
//            previousCol = -1;
//            System.out.print("\n");
//            if (drawBorder) {
//                drawLeftBorder();
//            }
//        }
//        if (previousCol != -1) {
//            for (int i = 0; i < x - previousCol - 1; i++) {
//                System.out.print("  ");
//            }
//        } else {
//            for (int i = 0; i < x; i++) {
//                System.out.print("  ");
//            }
//        }
//        //System.out.print(" ");
//        previousCol = x;
//        System.out.print(value + " ");
//        if (value != 0) {
//            nonZeroCount--;
//        }
//        if (drawBorder && (nonZeroCount == 0 || printedCount == matrix.getCols() * matrix.getRows())) {
//            drawRightBorder(matrix.getCols());
//            System.out.print("\n-");
//            for (int i = 0; i < matrix.getCols(); i++) {
//                System.out.print("--");
//            }
//            System.out.print("-");
//        }

        if (!drawBorder) {
//            if (y > previousRow) {
//                previousRow = y;
//                previousCol = -1;
//                while (matrixToPrint.get(y - 1).size() != matrix.getCols()) {
//                    matrixToPrint.get(y - 1).add("  ");
//                }
//            }
//            if (previousCol != -1) {
//                for (int i = 0; i < x - previousCol - 1; i++) {
//                    matrixToPrint.get(y).add("  ");
//                }
//            } else {
//                for (int i = 0; i < x; i++) {
//                    matrixToPrint.get(y).add("  ");
//                }
//            }
            matrixToPrint.get(y * 2).set(x * 2, value + " ");
            if (x != matrix.getCols() - 1) {
                matrixToPrint.get(y).set(x * 2 + 1, "  ");
            }
            if (y != matrix.getRows() - 1) {
                matrixToPrint.get(y * 2 + 1).set(x, "  ");
            }
            previousCol = x;
        } else {
            matrixToPrint.get(y * 2 + 1).set(x * 2 + 1, value + " ");
            if (x != matrix.getCols() - 1) {
                matrixToPrint.get(y + 1).set(x * 2 + 2, "  ");
            }
            if (y != matrix.getRows() - 1) {
                matrixToPrint.get(y * 2 + 2).set(x * 2 + 1, "  ");
            }
            previousCol = x;
        }
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

//    @Override
//    public void drawBorder(IMatrix matrix) {
//        drawBorder = true;
//        matrixToPrint = new ArrayList<>();
//        for (int i = 0; i < matrix.getRows() + 2; i++) {
//            matrixToPrint.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < matrix.getRows() + 2; i++) {
//            for (int j = 0; j < matrix.getCols() + 2; j++) {
//                if (i == 0 || i == matrix.getRows() + 1) {
//                    matrixToPrint.get(i).add("* ");
//                } else if (j == 0 || j == matrix.getCols() + 1) {
//                    matrixToPrint.get(i).add("* ");
//                } else {
//                    matrixToPrint.get(i).add("  ");
//                }
//            }
//        }
//    }
@Override
public void drawBorder(IMatrix matrix) {
    drawBorder = true;
    matrixToPrint = new ArrayList<>();
    for (int i = 0; i < matrix.getRows() * 2 + 1; i++) {
        matrixToPrint.add(new ArrayList<>());
    }

    for (int i = 0; i < matrix.getRows() * 2 + 1; i++) {
        for (int j = 0; j < matrix.getCols() * 2 + 1; j++) {
            if (i == 0 || i == matrix.getRows() * 2) {
                matrixToPrint.get(i).add("* ");
            } else if (j == 0 || j == matrix.getCols() * 2) {
                matrixToPrint.get(i).add("* ");
            } else {
                matrixToPrint.get(i).add("  ");
            }
        }
    }
}

}
