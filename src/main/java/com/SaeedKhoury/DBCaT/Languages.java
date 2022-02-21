package com.SaeedKhoury.DBCaT;

import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;

public class Languages extends Super{
    String sql1 = "INSERT INTO LANGUAGE VALUES (?,?)";
    @Override
    public void insertData(Object @NotNull [] data) throws Exception {
        PreparedStatement stmt = connection().prepareCall(sql1);

    }

    @Override
    public void updateData(Object @NotNull [] oldData, Object @NotNull [] currentData) throws Exception {

    }

    @Override
    public void deleteData() throws Exception {

    }

    @Override
    public void selectData() throws Exception {

    }
}