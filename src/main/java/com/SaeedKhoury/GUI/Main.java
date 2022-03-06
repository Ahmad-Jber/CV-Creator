package com.SaeedKhoury.GUI;

import com.SaeedKhoury.DBCaT.Super;

import java.sql.*;

import static com.SaeedKhoury.DBCaT.Super.connection;

public class Main {
    public static void main(String[] args){
        new Sign_in().view();
    }
}