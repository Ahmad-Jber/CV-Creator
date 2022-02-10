package com.SaeedKhoury.project2;

import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;

public class Certifications extends Super {
    private final String sql1 = "insert into CERTIFICATIONS values (?,?,?,?)";
    private Object[] data = new Object[4];
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
    public void insertData() throws Exception{
        PreparedStatement stmt = connection().prepareCall(sql1);
        for (int i = 1; i <= data.length; i++) {
            System.out.println("CERTIFICATIONS");
            stmt.setObject(i,data[i-1]);
        }
        stmt.execute();
    }
}
