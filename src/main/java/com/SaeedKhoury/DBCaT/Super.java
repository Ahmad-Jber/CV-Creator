package com.SaeedKhoury.DBCaT;

import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class Super {
    public Connection connection() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
        return con;
    }
    public abstract void insertData(Object @NotNull [] data) throws Exception;
}