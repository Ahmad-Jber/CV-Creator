package com.SaeedKhoury.DBCaT;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public abstract class Super {
    public Connection connection() {
        Connection con=null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ROOT", "root");
            JOptionPane.showMessageDialog(null,"Connection Success");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Connection Failed");
        }
        return con;
    }
    public abstract  void insertData(Object @NotNull [] data) throws Exception;
    public abstract void updateData(Object @NotNull [] oldData,Object @NotNull [] currentData) throws Exception;
    public abstract void deleteData() throws Exception;
    public abstract void selectData() throws Exception;

}