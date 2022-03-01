package com.SaeedKhoury.DBCaT;

import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;

public class USER_CERTIFICATIONS extends Super{
    public void insertData(Object @NotNull [] data) throws Exception {
        final String insertSQL = "insert into USER_CERTIFICATIONS (USER_ID,CERT_TITLE,CERT_SOURCE) values (?,?,?)";
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
