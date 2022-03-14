module com.nuist.universitymanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.views to javafx.fxml;
    opens com.model to javafx.base;
    exports com.views;
    opens com.app to javafx.base;
    exports com.controller;
    opens com.controller to javafx.fxml;
    exports com.dao;
    opens com.dao to javafx.fxml;
}