package com.mycompany.project2;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

import com.SaeedKhoury.project2.Super;
import com.SaeedKhoury.project2.Users;

public class Main {
    public static void main(String[] args)throws Exception{
      /*  String pass = new String();
        Users u = new Users();
        Statement stmt=u.connection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=stmt.executeQuery("select PASS from USERS");
        while (rs.next()){
            pass =rs.getObject("PASS").toString();
            System.out.println(pass);
        }*/
        new Sign_in().view();
    }
}