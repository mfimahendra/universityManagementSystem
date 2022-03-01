module com.nuist.universitymanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.view to javafx.fxml;
    opens com.model to javafx.base;
    exports com.view;
}