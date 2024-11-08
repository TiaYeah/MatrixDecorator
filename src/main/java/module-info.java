module ru.tiayeah.matrixdecorator2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.tiayeah.matrixdecorator2 to javafx.fxml;
    exports ru.tiayeah.matrixdecorator2;
}