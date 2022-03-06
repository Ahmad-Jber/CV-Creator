package com.SaeedKhoury.DBCaT;

import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Skills extends Super{
    private String Title;
    public void setTitle(String title) {
        Title = title;
    }
    public String getTitle() {
        return Title;
    }
    public void insertData(String Title){
        setTitle(Title);
        insertData();
    }
    private void insertData(){
        String insertSQL="INSERT INTO SKILLS (TITLE) VALUES(?)";
        try {
            PreparedStatement stmt = connection().prepareStatement(insertSQL);
            stmt.setString(1,getTitle());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}