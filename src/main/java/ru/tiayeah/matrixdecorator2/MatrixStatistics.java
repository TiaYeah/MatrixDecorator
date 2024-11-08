package ru.tiayeah.matrixdecorator2;

class MatrixStatistics {
    private int sum;
    private double average;
    private int max;
    private int nonZeroCount;

    public MatrixStatistics(IMatrix matrix) {
        calculateStatistics(matrix);
    }

    public void calculateStatistics(IMatrix matrix) {
        int rowCount = matrix.getRows();
        int colCount = matrix.getCols();
        sum = 0;
        max = Integer.MIN_VALUE;
        nonZeroCount = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                int element = matrix.getValue(i, j);
                sum += element;

                if (element > max) {
                    max = element;
                }

                if (element != 0) {
                    nonZeroCount++;
                }
            }
        }

        average = (double) sum / (rowCount * colCount);
    }

    public int getSum() {
        return sum;
    }

    public double getAverage() {
        return average;
    }

    public int getMax() {
        return max;
    }

    public int getNonZeroCount() {
        return nonZeroCount;
    }

    //    public int getSum() {
//        int sum = 0;
//        for (int i = 0; i < matrix.getRows(); i++) {
//            for (int j = 0; j < matrix.getCols(); j++) {
//                sum += matrix.getValue(i, j);
//            }
//        }
//        return sum;
//    }
//
//    public double getAverage() {
//        return getSum() / (double) (matrix.getRows() * matrix.getCols());
//    }
//
//    public int getMax() {
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < matrix.getRows(); i++) {
//            for (int j = 0; j < matrix.getCols(); j++) {
//                max = Math.max(max, matrix.getValue(i, j));
//            }
//        }
//        return max;
//    }
//
//    public int getnonZeroCount() {
//        int count = 0;
//        for (int i = 0; i < matrix.getRows(); i++) {
//            for (int j = 0; j < matrix.getCols(); j++) {
//                if (matrix.getValue(i, j) != 0) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
}