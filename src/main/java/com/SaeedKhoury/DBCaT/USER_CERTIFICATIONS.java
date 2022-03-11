package com.SaeedKhoury.DBCaT;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.SaeedKhoury.GUI.AddData;

public class USER_CERTIFICATIONS extends CERTIFICATIONS {
    private String
            CERT_TITLE ,
            CERT_SOURCE;
    private static int CERT_ID;
    public static int getCERT_ID() {
        return CERTIFICATIONS.getCERT_ID();
    }
    public static void setCERT_ID(int CERT_ID){
        USER_CERTIFICATIONS.CERT_ID = CERT_ID;
    }
    public String getCERT_TITLE() {
        return CERT_TITLE;
    }
    public void setCERT_TITLE(String CERT_TITLE) {
        this.CERT_TITLE = CERT_TITLE;
    }
    public String getCERT_SOURCE() {
        return CERT_SOURCE;
    }
    public void setCERT_SOURCE(String CERT_SOURCE) {
        this.CERT_SOURCE = CERT_SOURCE;
    }
    @Override
    public void insertData(String CERT_TITLE, String CERT_SOURCE){
        setCERT_ID(USER_CERTIFICATIONS.getCERT_ID());
        setCERT_TITLE(CERT_TITLE);
        setCERT_SOURCE(CERT_SOURCE);
        insertData();
    }
    private void insertData(){
        final String insertSQL = "insert into USER_CERTIFICATIONS values (?,?,?,?)";
        PreparedStatement stmt;
        try {
            stmt = connection().prepareCall(insertSQL);
            stmt.setString(1,getUSER_ID());
            stmt.setInt(2,getCERT_ID());
            stmt.setString(3,getCERT_TITLE());
            stmt.setString(4,getCERT_SOURCE());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
