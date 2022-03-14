package com.dao;

import com.app.DatabaseConfig;
import com.model.Courses;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseDAO {

    public ObservableList<Courses> getCoursesList() throws SQLException, ClassNotFoundException {
        ObservableList<Courses> coursesList = FXCollections.observableArrayList();
        DatabaseConfig conn = new DatabaseConfig();
        conn.getConnection();
        String query = "SELECT * FROM courses";
        Statement st;
        ResultSet rs;

        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Courses courses;
            while(rs.next()){
                courses = new Courses(rs.getString(1), rs.getString(2), rs.getString(3));
                coursesList.add(courses);
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return coursesList;
    }
}
