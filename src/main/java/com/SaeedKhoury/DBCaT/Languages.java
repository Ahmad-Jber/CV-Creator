package com.SaeedKhoury.DBCaT;

import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;

public abstract class Languages extends Super{
    public static void insertData(String data) throws Exception {
        String insertSQL = "INSERT INTO LANGUAGES (LANG_NAME) VALUES (?)";
        PreparedStatement stmt = Super.connection().prepareCall(insertSQL);
            stmt.setObject(1,data);
        stmt.execute();
    }
}