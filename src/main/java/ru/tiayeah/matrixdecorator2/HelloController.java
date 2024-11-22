package ru.tiayeah.matrixdecorator2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;

public class HelloController {
    @FXML
    private CheckBox BorderCheckbox;
    @FXML
    private AnchorPane AnchorPane;
    private IMatrix matrix;
    private IMatrix save;
    private RenumberDecorator decorator;

    @FXML
    protected void onDefaultCreateButtonClick() {
        System.out.println();
        AnchorPane.getChildren().clear();
        matrix = new OrdinaryMatrix(3, 3);
        MatrixInitializer.fillMatrix(matrix, 5, 10);

        matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected(), 0, 0);
        matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected(), 0, 0);
    }

    @FXML
    protected void onSparseCreateMatrixClick() {
        System.out.println();
        AnchorPane.getChildren().clear();
        matrix = new SparseMatrix(3, 3);
        MatrixInitializer.fillMatrix(matrix, 5, 10);

        matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected(), 0, 0);
        matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected(), 0, 0);
    }

    @FXML
    protected void onHorizontalGroupClick() {
        System.out.println();
        AnchorPane.getChildren().clear();
        HorizontalMatrixGroup matrix = new HorizontalMatrixGroup();

        IMatrix matrix1 = new OrdinaryMatrix(4, 4);
        MatrixInitializer.fillMatrix(matrix1, 10, 10);
        IMatrix matrix2 = new OrdinaryMatrix(3, 3);
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
            save = matrix;

            decorator = new RenumberDecorator(matrix);
            decorator.renumber();
            matrix = decorator;
            matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected(), 0, 0);
            System.out.println();
            matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected(), 0, 0);
        }
    }

    @FXML
    protected void refresh() {
        AnchorPane.getChildren().clear();

        //matrix = decorator.getComponent();
        matrix = save;
        if (matrix != null) {
            matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected(), 0, 0);
            System.out.println();
            matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected(), 0, 0);
        }
    }
}