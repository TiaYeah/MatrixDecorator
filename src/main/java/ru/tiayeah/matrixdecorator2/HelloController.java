package ru.tiayeah.matrixdecorator2;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import ru.tiayeah.matrixdecorator2.decorators.AMatrixDecorator;
import ru.tiayeah.matrixdecorator2.decorators.RenumberDecorator;
import ru.tiayeah.matrixdecorator2.decorators.TransposeDecorator;
import ru.tiayeah.matrixdecorator2.decorators.VerticalGroupDecorator;
import ru.tiayeah.matrixdecorator2.drawers.ConsoleDrawer;
import ru.tiayeah.matrixdecorator2.drawers.GUIDrawer;
import ru.tiayeah.matrixdecorator2.interfaces.IPrintableMatrix;
import ru.tiayeah.matrixdecorator2.matrixImpl.HorizontalMatrixGroup;
import ru.tiayeah.matrixdecorator2.matrixImpl.MatrixInitializer;
import ru.tiayeah.matrixdecorator2.matrixImpl.OrdinaryMatrix;
import ru.tiayeah.matrixdecorator2.matrixImpl.SparseMatrix;

import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    private CheckBox BorderCheckbox;
    @FXML
    private AnchorPane AnchorPane;
    private IPrintableMatrix matrix;
    private VerticalGroupDecorator verticalGroupDecorator;
    private List<IPrintableMatrix> matrixList = new ArrayList<>();
    private AMatrixDecorator decorator;
    private int rowCount = 3, colCount = 10;
    private double k = 0.75;

    @FXML
    protected void onDefaultCreateButtonClick() {
        System.out.println();
        AnchorPane.getChildren().clear();
        matrix = new OrdinaryMatrix(rowCount, colCount);
        MatrixInitializer.fillMatrix(matrix, (int) (colCount * rowCount * k), 10);

        //matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected(), 0, 0);
        matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected(), 0, 0);
    }

    @FXML
    protected void onSparseCreateMatrixClick() {
        System.out.println();
        AnchorPane.getChildren().clear();
        matrix = new SparseMatrix(rowCount, colCount);
        MatrixInitializer.fillMatrix(matrix, (int) (colCount * rowCount * k), 10);

        //matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected(), 0, 0);
        matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected(), 0, 0);
    }

    @FXML
    protected void onHorizontalGroupClick() {
        System.out.println();
        matrixList = new ArrayList<>();
        AnchorPane.getChildren().clear();
        HorizontalMatrixGroup matrixGroup1 = new HorizontalMatrixGroup();
        HorizontalMatrixGroup matrixGroup2 = new HorizontalMatrixGroup();
        HorizontalMatrixGroup matrixGroup3 = new HorizontalMatrixGroup();
        VerticalGroupDecorator verticalGroup = new VerticalGroupDecorator();

        IPrintableMatrix matrix1, matrix2, matrix3, matrix4, matrix5, matrix6;

        matrix1 = new OrdinaryMatrix(2, 2);
        MatrixInitializer.fillMatrix(matrix1, (int) (matrix1.getCols() * matrix1.getRows() * k), 10);

        matrix2 = new SparseMatrix(4, 3);
        MatrixInitializer.fillMatrix(matrix2, (int) (matrix2.getCols() * matrix2.getRows() * k), 10);

        matrix3 = new OrdinaryMatrix(1, 3);
        MatrixInitializer.fillMatrix(matrix3, (int) (matrix3.getCols() * matrix3.getRows() * k), 10);

        matrix4 = new OrdinaryMatrix(2, 4);
        MatrixInitializer.fillMatrix(matrix4, (int) (matrix4.getCols() * matrix4.getRows() * k), 10);

        matrix5 = new SparseMatrix(1, 3);
        MatrixInitializer.fillMatrix(matrix5, (int) (matrix5.getCols() * matrix5.getRows() * k), 10);

        matrix6 = new SparseMatrix(1, 1);
        MatrixInitializer.fillMatrix(matrix6, (int) (matrix6.getCols() * matrix6.getRows()), 10);

        matrixGroup1.addMatrix(matrix1);
        matrixGroup1.addMatrix(matrix2);
        matrixGroup1.addMatrix(matrix3);

        matrixGroup2.addMatrix(matrix4);
        matrixGroup2.addMatrix(matrix5);

        matrixGroup3.addMatrix(matrix6);
        //matrixGroup3.addMatrix(matrixGroup2);

        verticalGroup.addMatrix(matrix1);
        verticalGroup.addMatrix(matrix2);
        verticalGroup.addMatrix(matrix3);

        //matrixList.add(matrix1);
        //matrixList.add(matrix2);
        //matrixList.add(matrix3);
        //matrixList.add(matrix4);
        //matrixList.add(matrix5);
        //matrixList.add(matrix6);
        matrixList.add(matrixGroup1);
        matrixList.add(matrixGroup2);
        matrixList.add(matrixGroup3);

        //verticalGroup.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected(), 0, 0);

        matrix = matrixGroup1;

        //matrixGroup1.draw(new ConsoleDrawer(), BorderCheckbox.isSelected(),0 ,0);
        matrixGroup1.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected(), 0, 0);
        matrixGroup2.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected(), 0, matrixGroup1.getRows() + 1);
        matrixGroup3.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected(), 0, matrixGroup1.getRows() + matrixGroup2.getRows() + 2);
    }

    @FXML
    protected void onCheckBoxClick() {
        AnchorPane.getChildren().clear();
        if (matrix != null) {
            matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected(), 0, 0);
            System.out.println();
            matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected(), 0, 0);
        }
    }

    @FXML
    protected void createVerticalGroup() {
        AnchorPane.getChildren().clear();
        if (matrix != null) {
//            verticalGroupDecorator = new RenumberDecorator(matrix);
//            verticalGroupDecorator.renumber();
//            matrix = verticalGroupDecorator;
            verticalGroupDecorator = new VerticalGroupDecorator(matrixList);
            matrix = verticalGroupDecorator;

            matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected(), 0, 0);
            System.out.println();
            // matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected(), 0, 0);
        }
    }


    @FXML
    protected void renumber() {
        AnchorPane.getChildren().clear();
        if (matrix != null) {
//            renumberDecorator = new RenumberDecorator(matrix);
//            renumberDecorator.renumber();
//            matrix = renumberDecorator;
            RenumberDecorator reDecorator = new RenumberDecorator(matrix);
            reDecorator.renumber();
            decorator = reDecorator;
            matrix = decorator;


            matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected(), 0, 0);
            System.out.println();
        }
    }

    @FXML
    protected void transpose() {
        AnchorPane.getChildren().clear();
        if (matrix != null) {
            decorator = new TransposeDecorator(matrix);
            matrix = decorator;

            matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected(), 0, 0);
            System.out.println();
        }
    }

    @FXML
    protected void refresh() {
        AnchorPane.getChildren().clear();

        if (decorator != null) {
            matrix = (IPrintableMatrix) decorator.getComponent();
        }

        if (matrix != null) {
            matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected(), 0, 0);
            System.out.println();
            //matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected(), 0, 0);
        }
    }

    @FXML
    protected void colorize() {
        AnchorPane.getChildren().clear();
        MatrixInitializer.colorizeMatrix(matrix);

        if (matrix != null) {
            matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected(), 0, 0);
        }
    }
}