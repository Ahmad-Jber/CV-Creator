package com.SaeedKhoury.DBCaT;

import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;

public class UserSkills extends Super{
    protected final static int USER_SKILLS_COLUM_NUMBER=4;
    @Override
    public void insertData(Object @NotNull [] data) throws Exception {
        final String insertSQL = "insert into  SKILLS values (?,?,?)";
        PreparedStatement stmt = connection().prepareCall(insertSQL);
        for (int i = 0; i < data.length; i++) {
            stmt.setObject(i+1,data[i]);
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
