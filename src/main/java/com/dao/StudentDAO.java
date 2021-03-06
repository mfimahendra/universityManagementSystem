package com.dao;

import com.app.DatabaseConfig;
import com.model.Students;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {

    public ObservableList<Students> getStudentList() throws SQLException, ClassNotFoundException {
        ObservableList<Students> studentsList = FXCollections.observableArrayList();
        DatabaseConfig conn = new DatabaseConfig();
        conn.getConnection();
        String query = "SELECT * FROM students ORDER BY id";
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

    public void addStudent(String student_id, String student_name, String student_country) throws SQLException, ClassNotFoundException {
        DatabaseConfig conn = new DatabaseConfig();
        conn.getConnection();
        String query = "INSERT INTO students (id, name, country) VALUES ('"+student_id+"', '"+student_name+"', '"+student_country+"')";
        System.out.println(query);
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
