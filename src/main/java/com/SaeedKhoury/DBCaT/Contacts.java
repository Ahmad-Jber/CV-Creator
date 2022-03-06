package com.SaeedKhoury.DBCaT;

import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Contacts extends Super{
    public void insertData(String CONTACT_ADDRESS){
        final String insertSQL = "insert into USER_CONTACTS(USER_ID,CONTACT_ADDRESS) values (?,?)";
        try {
            PreparedStatement stmt = connection().prepareCall(insertSQL);
            stmt.setString(1,getUSER_ID());
            stmt.setString(2,CONTACT_ADDRESS);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateData(Object @NotNull [] oldData, Object @NotNull [] currentData) throws Exception {

    }
    public void deleteData() throws Exception {

    }
    public void selectData() throws Exception {

    }
}
