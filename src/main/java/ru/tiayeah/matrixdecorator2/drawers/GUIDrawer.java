package ru.tiayeah.matrixdecorator2.drawers;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import ru.tiayeah.matrixdecorator2.Colors;
import ru.tiayeah.matrixdecorator2.interfaces.IDrawer;
import ru.tiayeah.matrixdecorator2.interfaces.IMatrix;

public class GUIDrawer implements IDrawer {
    private AnchorPane anchorPane;

    public GUIDrawer(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }



    @Override
    public void drawCell(int value, int y, int x, IMatrix matrix, int offsetX, int offsetY) {
        int baseMarginX = (int) anchorPane.localToScene(anchorPane.getBoundsInLocal()).getMinX();
        int baseMarginY = (int) anchorPane.localToScene(anchorPane.getBoundsInLocal()).getMinY() + 20;
        Text text = new Text(baseMarginX + 30 * offsetX + 30 * x, baseMarginY + 30 * offsetY + 30 * y, Integer.toString(value));
        text.setFont(new Font(25));
        anchorPane.getChildren().add(text);
    }

    @Override
    public void printResult() {

    }

    @Override
    public void drawBorder(IMatrix matrix, int offsetX, int offsetY) {
        int baseMarginX = (int) anchorPane.localToScene(anchorPane.getBoundsInLocal()).getMinX() - 10;
        int baseMarginY = (int) anchorPane.localToScene(anchorPane.getBoundsInLocal()).getMinY() - 10;

        Line topSide = new Line(baseMarginX, baseMarginY + 30 * offsetY, baseMarginX + 30 * matrix.getCols() + 10, baseMarginY + 30 * offsetY);
        topSide.setStrokeWidth(2);
        Line bottomSide = new Line(baseMarginX, baseMarginY + 30 * matrix.getRows() + 10 + 30 * offsetY, baseMarginX + 30 * matrix.getCols() + 10, baseMarginY + 30 * matrix.getRows() + 10 + 30 * offsetY);
        bottomSide.setStrokeWidth(2);
        Line leftSide = new Line(baseMarginX, baseMarginY + 30 * offsetY, baseMarginX, baseMarginY + 30 * matrix.getRows() + 10 + 30 * offsetY);
        leftSide.setStrokeWidth(2);
        Line rightSide = new Line(baseMarginX + 30 * matrix.getCols() + 10, baseMarginY + 30 * offsetY, baseMarginX + 30 * matrix.getCols() + 10, baseMarginY + 30 * matrix.getRows() + 10 + 30 * offsetY);
        rightSide.setStrokeWidth(2);
        anchorPane.getChildren().add(topSide);
        anchorPane.getChildren().add(bottomSide);
        anchorPane.getChildren().add(leftSide);
        anchorPane.getChildren().add(rightSide);
    }

    @Override
    public void fillCell(int i, int j, Colors color, int offsetX, int offsetY) {
        int baseMarginX = (int) anchorPane.localToScene(anchorPane.getBoundsInLocal()).getMinX() - 10;
        int baseMarginY = (int) anchorPane.localToScene(anchorPane.getBoundsInLocal()).getMinY() - 10;
        Rectangle rect = new Rectangle(baseMarginX + 30 * offsetX + 30 * j + 2, baseMarginY + 30 * offsetY + 30 * i + 5, 30, 30);
        rect.setFill(Paint.valueOf(color.toString()));
        anchorPane.getChildren().add(rect);
    }


}
