package com.view;

import com.config.Database;
import com.model.Students;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;



public class MainController implements Initializable {

    @FXML
    private Button btn_addCourses;

    @FXML
    private Button btn_addEnrollment;

    @FXML
    private Button btn_addStudent;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            showStudents();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public ObservableList<Students> getStudentList() throws SQLException, ClassNotFoundException {
        ObservableList<Students> studentsList = FXCollections.observableArrayList();
        Database conn = new Database();
        conn.getConnection();
        String query = "SELECT * FROM students";
        Statement st;
        ResultSet rs;

        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Students students;
            while(rs.next()){
                students = new Students(rs.getString(1), rs.getString(2), rs.getString(3));
                studentsList.add(students);
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return studentsList;
    }

    public void showStudents() throws SQLException, ClassNotFoundException {
        ObservableList<Students> list = getStudentList();

        table_students_id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        table_students_name.setCellValueFactory(new PropertyValueFactory<>( "Name"));
        table_students_country.setCellValueFactory(new PropertyValueFactory<>( "Country"));

        table_students.setItems(list);
    }


}