package com.SaeedKhoury.DBCaT;

import com.SaeedKhoury.GUI.AddData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CERTIFICATIONS extends Super {
    private static int CERT_ID;
    private static String Type,Title;
    public static void setCERT_ID(int CERT_ID) {
        CERTIFICATIONS.CERT_ID = CERT_ID;
    }
    public static int getCERT_ID() {
        return CERT_ID;
    }
    public void setType(String type) {
        Type = type;
    }
    public String getType() {
        return Type;
    }
    public static void setTitle(String title) {
        Title = title;
    }
    public static String getTitle() {
        return Title;
    }
     public void insertData(String Type, String Title){
        setType(Type);
        setTitle(Title);
        insertData();
    }
    private void insertData(){
        final String insertSQL = "insert into CERTIFICATIONS (TYPE,TITLE) values (?,?)";
        try {
            PreparedStatement stmt = connection().prepareCall(insertSQL);
            stmt.setString(1,getType());
            stmt.setString(2,getTitle());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
