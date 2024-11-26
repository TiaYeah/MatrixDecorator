package ru.tiayeah.matrixdecorator2;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import ru.tiayeah.matrixdecorator2.decorators.AMatrixDecorator;
import ru.tiayeah.matrixdecorator2.decorators.TransposeDecorator;
import ru.tiayeah.matrixdecorator2.drawers.ConsoleDrawer;
import ru.tiayeah.matrixdecorator2.drawers.GUIDrawer;
import ru.tiayeah.matrixdecorator2.interfaces.IMatrix;
import ru.tiayeah.matrixdecorator2.interfaces.IPrintable;
import ru.tiayeah.matrixdecorator2.interfaces.IPrintableMatrix;
import ru.tiayeah.matrixdecorator2.matrixImpl.HorizontalMatrixGroup;
import ru.tiayeah.matrixdecorator2.matrixImpl.MatrixInitializer;
import ru.tiayeah.matrixdecorator2.matrixImpl.OrdinaryMatrix;
import ru.tiayeah.matrixdecorator2.matrixImpl.SparseMatrix;

public class HelloController {
    @FXML
    private CheckBox BorderCheckbox;
    @FXML
    private AnchorPane AnchorPane;
    private IPrintableMatrix matrix;
    private AMatrixDecorator decorator;
    private TransposeDecorator transposeDecorator;
    private int rowCount = 5, colCount = 5;

    @FXML
    protected void onDefaultCreateButtonClick() {
        System.out.println();
        AnchorPane.getChildren().clear();
        matrix = new OrdinaryMatrix(rowCount, colCount);
        MatrixInitializer.fillMatrix(matrix, 15, 10);

        matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected(), 0, 0);
        matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected(), 0, 0);
    }

    @FXML
    protected void onSparseCreateMatrixClick() {
        System.out.println();
        AnchorPane.getChildren().clear();
        matrix = new SparseMatrix(rowCount, colCount);
        MatrixInitializer.fillMatrix(matrix, 15, 10);

        matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected(), 0, 0);
        matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected(), 0, 0);
    }

    @FXML
    protected void onHorizontalGroupClick() {
        System.out.println();
        AnchorPane.getChildren().clear();
        HorizontalMatrixGroup matrix = new HorizontalMatrixGroup();

        IPrintableMatrix matrix1 = new OrdinaryMatrix(4, 4);
        MatrixInitializer.fillMatrix(matrix1, 10, 10);
        IPrintableMatrix matrix2 = new OrdinaryMatrix(3, 3);
        MatrixInitializer.fillMatrix(matrix2, 5, 10);

        matrix.addMatrix(matrix1);
        matrix.addMatrix(matrix2);

        matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected(),0 ,0);
        matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected(),0, 0);
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
    protected void renumber() {
        AnchorPane.getChildren().clear();
        if (matrix != null) {
//            decorator = new RenumberDecorator(matrix);
//            decorator.renumber();
//            matrix = decorator;
            decorator = new TransposeDecorator(matrix);
            matrix = decorator;

            matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected(), 0, 0);
            System.out.println();
            matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected(), 0, 0);
        }
    }

    @FXML
    protected void refresh() {
        AnchorPane.getChildren().clear();

        matrix = (IPrintableMatrix) decorator.getComponent();

        if (matrix != null) {
            matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected(), 0, 0);
            System.out.println();
            matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected(), 0, 0);
        }
    }
}