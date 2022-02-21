package com.SaeedKhoury.DBCaT;

import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;

public class Certifications extends Super {
    private final String sql1 = "insert into CERTIFICATIONS values (?,?,?,?)";
    @Override
    public void insertData(Object @NotNull [] data) throws Exception {
        PreparedStatement stmt = connection().prepareCall(sql1);
        for (int i = 1; i <= data.length; i++) {
            System.out.println("CERTIFICATIONS");
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
