package com.SaeedKhoury.DBCaT;

import com.SaeedKhoury.GUI.AddData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class USER_LANGUAGES extends Languages{
    private int LANG_ID;
    private String LANG_NAME;
    public int getLANG_ID() {
        PreparedStatement pstat;
        try {
                pstat = Super.connection().prepareStatement("select LANG_ID from LANGUAGES where LANG_NAME= ?");
                pstat.setString(1,getLANG_NAME());
                ResultSet rs = pstat.executeQuery();
                boolean result = rs.next() || rs.getRow() != 0;
                if (result){
                    LANG_ID = rs.getInt(1);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return LANG_ID;
    }

    public String getLANG_NAME() {
        return LANG_NAME;
    }
    public void setLANG_NAME(String LANG_NAME1) {
        this.LANG_NAME = LANG_NAME1;
    }

    public void insertData(String lang){
        setLANG_NAME(lang);
        insertData();
    }
    private void insertData(){
        final String insertSQL = "insert into USER_LANGUAGES values (?,?,?)";
        PreparedStatement stmt;
        try {
                stmt = connection().prepareCall(insertSQL);
                stmt.setString(1,getUSER_ID());
                stmt.setInt(2,getLANG_ID());
                stmt.setString(3, getLANG_NAME());
                stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
