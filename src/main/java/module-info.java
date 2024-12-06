module ru.tiayeah.matrixdecorator2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens ru.tiayeah.matrixdecorator2 to javafx.fxml;
    exports ru.tiayeah.matrixdecorator2;
    exports ru.tiayeah.matrixdecorator2.interfaces;
    opens ru.tiayeah.matrixdecorator2.interfaces to javafx.fxml;
    exports ru.tiayeah.matrixdecorator2.vectorImpl;
    opens ru.tiayeah.matrixdecorator2.vectorImpl to javafx.fxml;
    exports ru.tiayeah.matrixdecorator2.matrixImpl;
    opens ru.tiayeah.matrixdecorator2.matrixImpl to javafx.fxml;
    exports ru.tiayeah.matrixdecorator2.decorators;
    opens ru.tiayeah.matrixdecorator2.decorators to javafx.fxml;
    exports ru.tiayeah.matrixdecorator2.drawers;
    opens ru.tiayeah.matrixdecorator2.drawers to javafx.fxml;
}