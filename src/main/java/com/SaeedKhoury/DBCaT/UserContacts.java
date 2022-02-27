package com.SaeedKhoury.DBCaT;

import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;

public class UserContacts extends Super{
    protected final static int USER_CONTACTS_COLUM_NUMBER=5;
    @Override
    public void insertData(Object @NotNull [] data) throws Exception {
        final String insertSQL = "insert into USER_CONTACTS values (?,?,?,?,?)";
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
