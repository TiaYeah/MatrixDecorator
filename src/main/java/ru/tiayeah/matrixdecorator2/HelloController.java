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
    private RenumberDecorator decorator;

    @FXML
    protected void onDefaultCreateButtonClick() {
        System.out.println();
        AnchorPane.getChildren().clear();
        matrix = new OrdinaryMatrix(3, 3);
        MatrixInitializer.fillMatrix(matrix, 5, 10);
        matrixBeforeDecoration = new OrdinaryMatrix(matrix);

        matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected());
        matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected());
    }

    @FXML
    protected void onSparseCreateMatrixClick() {
        System.out.println();
        AnchorPane.getChildren().clear();
        matrix = new SparseMatrix(3, 3);
        MatrixInitializer.fillMatrix(matrix, 5, 10);
        matrixBeforeDecoration = new SparseMatrix(matrix);

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
            decorator = new RenumberDecorator(matrix);
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

        matrix = decorator.getOriginalMatrix();
        if (decorator.getOriginalMatrix().getClass() == RenumberDecorator.class) {
            decorator = (RenumberDecorator) decorator.getOriginalMatrix();
        }

        if (matrix != null) {
            matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected());
            System.out.println();
            matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected());
        }
    }
}