package com.SaeedKhoury.project2;

import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;

public class Languages extends Super{
    Object [] data = new Object[2];
    String sql1 = "INSERT INTO LANGUAGE VALUES (?,?)";
    @Override
    public void insertData(Object @NotNull [] data) throws Exception {
        PreparedStatement stmt = connection().prepareCall(sql1);

    }
}