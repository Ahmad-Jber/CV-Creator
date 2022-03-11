package com.SaeedKhoury.GUI;

import com.SaeedKhoury.DBCaT.CERTIFICATIONS;
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
    JLabel showCertificationTitle = new JLabel();
    JLabel showCertificationType = new JLabel();
    JLabel showCertificationSource = new JLabel();
    JLabel showName3 = new JLabel("Languages");
    JLabel showLanguage1 = new JLabel();
    JLabel showLanguage2 = new JLabel();
    JLabel showName4 = new JLabel("Contacts");
    JLabel showContact = new JLabel();
    JPanel panel_L = new JPanel();
    JPanel panel_R = new JPanel();
    public void view(){
        showSkills();
        showCertifications();
        showLanguages();
        showContacts();
        showData.setSize(400,200);
        showData.setLayout(new GridBagLayout());
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
        JPanel skillsPanel = new JPanel();
        JPanel certificationsPanel = new JPanel();
        JPanel languagesPanel = new JPanel();
        JPanel contactsPanel = new JPanel();
        skillsPanel.add(showName1);
        skillsPanel.add(showSkillsTitle);
        skillsPanel.add(showSkillsDesc);
        certificationsPanel.add(showName2);
        certificationsPanel.add(showCertificationTitle);
        certificationsPanel.add(showCertificationType);
        certificationsPanel.add(showCertificationSource);
        languagesPanel.add(showName3);
        languagesPanel.add(showLanguage1);
        languagesPanel.add(showLanguage2);
        contactsPanel.add(showName4);
        contactsPanel.add(showContact);
        skillsPanel.setLayout(new GridLayout(4,1));
        certificationsPanel.setLayout(new GridLayout(4,1));
        languagesPanel.setLayout(new GridLayout(4,1));
        contactsPanel.setLayout(new GridLayout(4,1));
        panel_R.add(skillsPanel);
        panel_R.add(certificationsPanel);
        panel_R.add(languagesPanel);
        panel_R.add(contactsPanel);
        /*panel_R.add(label);*/
        next.addActionListener(e -> card.next(panel_R));
        previous.addActionListener(e -> card.previous(panel_R));
        showData.setVisible(true);
        showName1.setFont(font);
        showName2.setFont(font);
        showName3.setFont(font);
        showName4.setFont(font);
        panel_L.setBackground(Color.white);
        panel_R.setBackground(Color.white);
        next.setBackground(Color.white);
        previous.setBackground(Color.white);
        next.setFont(font);
        previous.setFont(font);
        next.setForeground(Color.black);
        previous.setForeground(Color.black);
        showName1.setFont(font);
        System.out.println("Show data successfully");
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
            System.out.println("Show skills successfully");
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
            showCertificationTitle.setText(rs.getString("CERT_TITLE"));
            showCertificationSource.setText(rs.getString("CERT_SOURCE"));
            showCertificationType.setText(getCertificationType());
            System.out.println("Show certifications successfully");
        } catch (SQLException e) {
            System.out.println("Error while showing the Certifications data");
            e.printStackTrace();
        }
    }
    private String getCertificationType() {
        try {
            preparedStatement = Super.connection().prepareStatement("SELECT * FROM CERTIFICATIONS WHERE CERT_ID = (SELECT CERT_ID FROM USER_CERTIFICATIONS WHERE USER_ID =?)",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setString(1, Sign_in.getUSER_ID());
            rs = preparedStatement.executeQuery();
            rs.first();
            return rs.getString("TYPE");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
            System.out.println("Show languages successfully");
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
            System.out.println("Show contacts successfully");
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
