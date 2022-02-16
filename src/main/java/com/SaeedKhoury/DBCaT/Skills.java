package com.SaeedKhoury.DBCaT;

import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;

public class Skills extends Super {
    private final String sql1 = "insert into USERS values (?,?,?)";
    @Override
    public void insertData(Object @NotNull [] data) throws Exception {
        PreparedStatement stmt = connection().prepareCall(sql1);
        for (int i = 1; i <= data.length; i++) {
            stmt.setObject(i,data[i-1]);
        }
        stmt.execute();
    }
}