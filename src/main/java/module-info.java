module com.nuist.universitymanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.view to javafx.fxml;
    opens com.model to javafx.base;
    exports com.view;
    opens com.config to javafx.base;
}