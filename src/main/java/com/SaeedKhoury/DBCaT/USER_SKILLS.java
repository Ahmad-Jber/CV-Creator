package com.SaeedKhoury.DBCaT;

import com.SaeedKhoury.GUI.AddData;
import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class USER_SKILLS extends Skills{
    private static int SKILL_ID;
    private String
            SKILL_TITLE,
            SKILL_DESC;

    public void setSKILL_TITLE(String SKILL_TITLE) {
        this.SKILL_TITLE = SKILL_TITLE;
    }

    public void setSKILL_DESC(String SKILL_DESC) {
        this.SKILL_DESC = SKILL_DESC;
    }

    public static int getSKILL_ID() {
        PreparedStatement stat = null;
        try {
            String getText = AddData.userSkills.getText();
            stat = Super.connection().prepareStatement("select SKILL_ID from SKILLS where TITLE= ?");
            stat.setString(1,getText);
            ResultSet rs = stat.executeQuery();
            boolean result = rs.next() || rs.getRow() != 0;
            if (result){
                SKILL_ID = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SKILL_ID;
    }

    public String getSKILL_TITLE() {
        return SKILL_TITLE;
    }

    public String getSKILL_DESC() {
        return SKILL_DESC;
    }
    public void insertData(String SKILL_TITLE, String SKILL_DESC) {
        setSKILL_TITLE(SKILL_TITLE);
        setSKILL_DESC(SKILL_DESC);
        insertData();

    }
    private void insertData(){
        String insertSQL = "INSERT INTO USER_SKILLS VALUES(?,?,?,?)";
        PreparedStatement stmt;
        try {
            stmt = connection().prepareCall(insertSQL);
            stmt.setString(1,getUSER_ID());
            stmt.setInt(2,getSKILL_ID());
            stmt.setString(3,getSKILL_TITLE());
            stmt.setString(4,getSKILL_DESC());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
