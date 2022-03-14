package com.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

    @FXML
    private Button addStudent_btn_submit;

    @FXML
    private TextField addStudent_field_country;

    @FXML
    private TextField addStudent_field_id;

    @FXML
    private TextField addStudent_field_name;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
