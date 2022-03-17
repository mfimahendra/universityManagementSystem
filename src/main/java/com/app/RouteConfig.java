package com.app;

import com.views.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RouteConfig {
    String directory;
    String title;

    //route
    public void routing(ActionEvent mouseEvent) {
        String action = mouseEvent.getSource().toString();
        System.out.println(action);
        switch (action) {
            //Route for AddStudent
            case "Button[id=btn_addStudent, styleClass=button]'Add Student'":
            case "MenuItem[id=nav_addStudent, styleClass=[menu-item]]":
                directory = "addStudent-view.fxml";
                title = "Add Student";
                loadStage(directory,title);
                break;
        }
    }

    //load stage
    private void loadStage(String fxml,String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load(), 300, 160);
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }
}
