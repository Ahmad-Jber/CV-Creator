package com.SaeedKhoury.DBCaT;

import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;

public class UserLanguages extends Super{
    protected final static int USER_LANGUAGES_COLUM_NUMBER=4;
    @Override
    public void insertData(Object @NotNull [] data) throws Exception {
        String insertSQL = "INSERT INTO USER_LANGUAGES VALUES (?,?,?)";
        PreparedStatement stmt = connection().prepareCall(insertSQL);
        for (int i = 1; i <= data.length; i++) {
            stmt.setObject(i,data[i-1]);
        }
        stmt.execute();
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