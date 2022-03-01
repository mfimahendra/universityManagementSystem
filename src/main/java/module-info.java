module com.nuist.universitymanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.view to javafx.fxml;
    exports com.view;
}