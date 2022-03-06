package com.SaeedKhoury.DBCaT;

import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Languages extends Super{
    public void insertData(String lang){
        String insertSQL = "INSERT INTO LANGUAGES (LANG_NAME) VALUES (?)";
        PreparedStatement stmt = null;
        try {
            stmt = connection().prepareCall(insertSQL);
            stmt.setObject(1,lang);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}