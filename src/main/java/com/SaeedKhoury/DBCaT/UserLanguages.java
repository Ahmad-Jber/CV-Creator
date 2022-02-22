package com.SaeedKhoury.DBCaT;

import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;

public class UserLanguages extends Super{
    protected final static int USER_LANGUAGES_COLUM_NUMBER=4;
    @Override
    public void insertData(Object @NotNull [] data) throws Exception {
        String insertSQL = "INSERT INTO LANGUAGE VALUES (?,?)";
        PreparedStatement stmt = connection().prepareCall(insertSQL);

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