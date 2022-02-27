package com.SaeedKhoury.DBCaT;

import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;

public class Users extends Super {
    @Override
    public void insertData(Object @NotNull [] data) throws Exception {
        final String insertSQL = "insert into USERS values (?,?,?,?,?,?)";
        PreparedStatement stmt = connection().prepareCall(insertSQL);
        for (int i = 1; i <= data.length-1; i++){
            stmt.setObject(i,data[i-1]);
        }
        stmt.setDate(6, (java.sql.Date) data[5]);
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
