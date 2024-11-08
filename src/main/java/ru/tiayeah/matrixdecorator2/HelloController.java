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
    private IMatrix matrixBeforeDecoration;

    @FXML
    protected void onDefaultCreateButtonClick() {
        System.out.println();
        AnchorPane.getChildren().clear();
        matrix = new OrdinaryMatrix(5, 5);
        matrixBeforeDecoration = matrix;
        MatrixInitializer.fillMatrix(matrix, 15, 10);
        matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected());
        matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected());
    }

    @FXML
    protected void onSparseCreateMatrixClick() {
        System.out.println();
        AnchorPane.getChildren().clear();
        matrix = new SparseMatrix(5, 5);
        matrixBeforeDecoration = matrix;
        MatrixInitializer.fillMatrix(matrix, 15, 10);
        matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected());
        matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected());
    }

    @FXML
    protected void onCheckBoxClick() {
        AnchorPane.getChildren().clear();
        if (matrix != null) {
            matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected());
            System.out.println();
            matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected());
        }
    }

    @FXML
    protected void renumber() {
        AnchorPane.getChildren().clear();
        if (matrix != null) {
            RenumberDecorator decorator = new RenumberDecorator(matrix);
            decorator.renumber();
            matrix = decorator;
            matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected());
            System.out.println();
            matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected());
        }
    }

    @FXML
    protected void refresh() {
        AnchorPane.getChildren().clear();
        matrix = matrixBeforeDecoration;
        if (matrix != null) {
            matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected());
            System.out.println();
            matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected());
        }
    }
}