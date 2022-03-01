package com.SaeedKhoury.DBCaT;

import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Skills extends Super{
    public final static int USER_SKILLS_COLUM_NUMBER=4;
    @Override
    public void insertData(Object @NotNull [] data) {
        final String insertSQL = "INSERT INTO SKILLS (TITLE) VALUES (?)";
        PreparedStatement stmt = null;
        try {
            stmt = connection().prepareCall(insertSQL);
            for (int i = 0; i < data.length; i++) {
                stmt.setObject(i+1,data[i]);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
