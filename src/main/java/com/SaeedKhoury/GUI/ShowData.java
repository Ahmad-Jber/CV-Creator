package com.SaeedKhoury.GUI;

import com.SaeedKhoury.DBCaT.Super;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowData extends GUI{
    PreparedStatement preparedStatement;
    ResultSet rs;
    JFrame showData = new JFrame("Show Your Data");
    JLabel showName1 = new JLabel("Skills");
    JLabel showSkillsTitle = new JLabel();
    JLabel showSkillsDesc = new JLabel();
    JLabel showName2 = new JLabel("Certifications");
    JLabel showCertification = new JLabel();
    JLabel showName3 = new JLabel("Languages");
    JLabel showLanguage1 = new JLabel();
    JLabel showLanguage2 = new JLabel();
    JLabel showName4 = new JLabel("Contacts");
    JLabel showContact = new JLabel();
    public void view(){
        showSkills();
        showCertifications();
        showLanguages();
        showContacts();
        showData.setSize(400,200);
        showData.setLayout(new GridBagLayout());
        JPanel panel_L = new JPanel();
        JPanel panel_R = new JPanel();
        panel_R.setBorder(BorderFactory.createTitledBorder(""));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        showData.add(panel_L,gbc);
        gbc.weightx = 5;
        showData.add(panel_R,gbc);
        panel_L.setLayout(new GridLayout(4, 1));
        JButton next = new JButton("Next");
        JLabel label2 = new JLabel();
        JLabel label= new JLabel();
        label.setText(getFULL_NAME());
        JButton previous = new JButton("Previous");
        panel_L.add(label);
        panel_L.add(next);
        /*panel_L.add(label);*/
        panel_L.add(label2);
        panel_L.add(previous);
        CardLayout card = new CardLayout();
        panel_R.setLayout(card);
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        p1.add(showName1);
        p1.add(showSkillsTitle);
        p2.add(showName2);
        p2.add(showCertification);
        p3.add(showName3);
        p3.add(showLanguage1);
        p4.add(showName4);
        p4.add(showContact);
        p1.setLayout(new GridLayout());
        p2.setLayout(new GridLayout());
        p3.setLayout(new GridLayout());
        p4.setLayout(new GridLayout());
        panel_R.add(p1);
        panel_R.add(p2);
        panel_R.add(p3);
        panel_R.add(p4);
/*
        panel_R.add(label);
*/
        next.addActionListener(e -> card.next(panel_R));
        previous.addActionListener(e -> card.previous(panel_R));
        Font newFont = new Font("Times New Roman (Headings CS)", Font.BOLD, 20);
        showData.setVisible(true);
        showName1.setFont(newFont);
        showName2.setFont(newFont);
        showName3.setFont(newFont);
        showName4.setFont(newFont);
        panel_L.setBackground(Color.white);
        panel_R.setBackground(Color.white);
        next.setBackground(Color.white);
        previous.setBackground(Color.white);
        next.setFont(newFont);
        previous.setFont(newFont);
        next.setForeground(Color.black);
        previous.setForeground(Color.black);
        showName1.setFont(newFont);
    }
    @Override
    void addComponents() {

    }
    private void showSkills(){
        try {
            preparedStatement = Super.connection().prepareStatement("SELECT * FROM USER_SKILLS WHERE USER_ID = ?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setString(1,Sign_in.getUSER_ID());
            rs = preparedStatement.executeQuery();
            rs.first();
            showSkillsTitle.setText(rs.getString("SKILL_TITLE"));
            showSkillsDesc.setText(rs.getString("SKILL_DESC"));
        } catch (SQLException e) {
            System.out.println("Error while showing the Skills data");
            e.printStackTrace();
        }
    }
    private void showCertifications(){
        try {
            preparedStatement = Super.connection().prepareStatement("SELECT * FROM USER_CERTIFICATIONS WHERE USER_ID = ?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setString(1,Sign_in.getUSER_ID());
            rs = preparedStatement.executeQuery();
            rs.first();
            showCertification.setText(rs.getString(2)+rs.getString(3));
        } catch (SQLException e) {
            System.out.println("Error while showing the Certifications data");
            e.printStackTrace();
        }
    }
    private void showLanguages(){
        try {
            preparedStatement = Super.connection().prepareStatement("SELECT * FROM USER_LANGUAGES WHERE USER_ID = ?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setString(1,Sign_in.getUSER_ID());
            rs = preparedStatement.executeQuery();
            rs.first();
            showLanguage1.setText(rs.getString("LANG_NAME"));
            rs.next();
            showLanguage2.setText(rs.getString("LANG_NAME"));
        }catch (SQLException e){
            System.out.println("Error while showing the languages");
            e.printStackTrace();
        }
    }
    private void showContacts(){
        try {
            preparedStatement = Super.connection().prepareStatement("SELECT * FROM USER_CONTACTS WHERE USER_ID = ?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setString(1,Sign_in.getUSER_ID());
            rs = preparedStatement.executeQuery();
            rs.first();
            showContact.setText(rs.getString("CONTACT_ADDRESS"));
        } catch (SQLException e) {
            System.out.println("Error while showing the Contacts data");
            e.printStackTrace();
        }
    }
    private String getFULL_NAME(){
        String FULL_NAME = null;
        try {
            String sql = "SELECT * FROM USERS WHERE USER_ID = ?";
            rs.first();
            preparedStatement = Super.connection().prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setString(1,Sign_in.getUSER_ID());
            ResultSet rs = preparedStatement.executeQuery();
            rs.first();
            FULL_NAME= rs.getString("FULL_NAME");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FULL_NAME;
    }
}
