package com.SaeedKhoury.DBCaT;

import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;

public class Skills extends Super{
    public final static int SKILLS_COLUM_NUMBER=3;
    private final String sql1 = "insert into  SKILLS values (?,?,?)";
    @Override
    public void insertData(Object @NotNull [] data) throws Exception {
        PreparedStatement stmt = connection().prepareCall(sql1);
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
