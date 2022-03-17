package com.controller;

import com.dao.StudentDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
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

    @FXML
    public void insertStudent(ActionEvent event) throws ClassNotFoundException {
        StudentDAO student = new StudentDAO();

        try {
            student.addStudent(addStudent_field_id.getText(), addStudent_field_name.getText(), addStudent_field_country.getText());
            System.out.println("Student added");
            addStudent_field_id.setText("");
            addStudent_field_name.setText("");
            addStudent_field_country.setText("");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Student not added");
        }
    }
}
