package com.SaeedKhoury.DBCaT;

import com.SaeedKhoury.GUI.Sign_in;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Super {
    private String USER_ID = Sign_in.getUSER_ID();
    public String getUSER_ID() {
        return USER_ID;
    }
    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }
    public static Connection connection() {
        Connection con=null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ROOT", "root");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Connection Failed");
        }
        return con;
    }
}