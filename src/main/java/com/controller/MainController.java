package com.controller;

import com.app.RouteConfig;
import com.dao.CourseDAO;
import com.dao.StudentDAO;
import com.model.Courses;
import com.model.Students;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class MainController implements Initializable {

    @FXML
    private Button btn_addCourses;

    @FXML
    private Button btn_addEnrollment;

    @FXML
    public Button btn_addStudent;

    @FXML
    private Button btn_editCourses;

    @FXML
    private Button btn_editEnrollment;

    @FXML
    private Button btn_editStudent;

    @FXML
    private Button btn_searchCourses;

    @FXML
    private Button btn_searchEnrollment;

    @FXML
    private Button btn_searchStudent;

    @FXML
    private Tab tab_courses;

    @FXML
    private Tab tab_enrollments;

    @FXML
    private Tab tab_students;

    @FXML
    private TextField txtfield_searchCourses;

    @FXML
    private TextField txtfield_searchEnrollment;

    @FXML
    private TextField txtfield_searchStudent;

    @FXML
    private TableView<Students> table_students;

    @FXML
    private TableColumn<Students, String> table_students_country;

    @FXML
    private TableColumn<Students, String> table_students_id;

    @FXML
    private TableColumn<Students, String> table_students_name;

    @FXML
    private TableView<Courses> table_courses;

    @FXML
    private TableColumn<Courses, String> table_courses_id;

    @FXML
    private TableColumn<Courses, String> table_courses_major;

    @FXML
    private TableColumn<Courses, String> table_courses_name;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            showStudents();
            showCourses();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Main Routing
    public void route(ActionEvent actionEvent) {
        RouteConfig route = new RouteConfig();
        route.routing(actionEvent) ;
    }

    //Table View
    StudentDAO students = new StudentDAO();
    CourseDAO courses = new CourseDAO();

    public void showStudents() throws SQLException, ClassNotFoundException {
        ObservableList<Students> list = students.getStudentList();

        table_students_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        table_students_name.setCellValueFactory(new PropertyValueFactory<>( "name"));
        table_students_country.setCellValueFactory(new PropertyValueFactory<>( "country"));

        table_students.setItems(list);
    }

    public void showCourses() throws SQLException, ClassNotFoundException {
        ObservableList<Courses> list = courses.getCoursesList();

        table_courses_id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        table_courses_name.setCellValueFactory(new PropertyValueFactory<>( "Name"));
        table_courses_major.setCellValueFactory(new PropertyValueFactory<>( "Major"));

        table_courses.setItems(list);
    }

    @FXML
    void refresh(ActionEvent event) {
        try {
            showStudents();
            showCourses();
            System.out.println("Refreshed");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}