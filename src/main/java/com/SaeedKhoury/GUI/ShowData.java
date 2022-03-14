package com.SaeedKhoury.GUI;

import com.SaeedKhoury.DBCaT.Super;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowData extends GUI{
    PreparedStatement preparedStatement;
    ResultSet rs;
    public static JFrame showData = new JFrame("Show Your Data");
    JLabel skills = new JLabel("Skills");
    JLabel showSkillsTitle = new JLabel();
    JLabel showSkillsDesc = new JLabel();
    JLabel certifications = new JLabel("Certifications");
    JLabel showCertificationTitle = new JLabel();
    JLabel showCertificationType = new JLabel();
    JLabel showCertificationSource = new JLabel();
    JLabel languages = new JLabel("Languages");
    JLabel showLanguage1 = new JLabel();
    JLabel showLanguage2 = new JLabel();
    JLabel contacts = new JLabel("Contacts");
    JLabel showContact = new JLabel();
    JPanel controllers = new JPanel();
    JPanel viewData = new JPanel();
    JButton backButton = new JButton("Back To Dashboard");
    public void view(){
        showSkills();
        showCertifications();
        showLanguages();
        showContacts();
        showData.setSize(400,200);
        showData.setLayout(new GridBagLayout());
        showData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewData.setBorder(BorderFactory.createTitledBorder(""));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        showData.add(controllers,gbc);
        gbc.weightx = 5;
        showData.add(viewData,gbc);
        controllers.setLayout(new GridLayout(4, 1));
        JButton next = new JButton("Next");
        JLabel showFull_Name= new JLabel(getFULL_NAME());
        JButton previous = new JButton("Previous");
        controllers.add(showFull_Name);
        controllers.add(next);
        controllers.add(previous);
        controllers.add(backButton);
        CardLayout card = new CardLayout();
        viewData.setLayout(card);
        JPanel skillsPanel = new JPanel();
        JPanel certificationsPanel = new JPanel();
        JPanel languagesPanel = new JPanel();
        JPanel contactsPanel = new JPanel();
        skillsPanel.add(skills);
        skillsPanel.add(showSkillsTitle);
        skillsPanel.add(showSkillsDesc);
        certificationsPanel.add(certifications);
        certificationsPanel.add(showCertificationTitle);
        certificationsPanel.add(showCertificationType);
        certificationsPanel.add(showCertificationSource);
        languagesPanel.add(languages);
        languagesPanel.add(showLanguage1);
        languagesPanel.add(showLanguage2);
        contactsPanel.add(contacts);
        contactsPanel.add(showContact);
        skillsPanel.setLayout(new GridLayout(4,1));
        certificationsPanel.setLayout(new GridLayout(4,1));
        languagesPanel.setLayout(new GridLayout(4,1));
        contactsPanel.setLayout(new GridLayout(4,1));
        viewData.add(skillsPanel);
        viewData.add(certificationsPanel);
        viewData.add(languagesPanel);
        viewData.add(contactsPanel);
        next.addActionListener(e -> card.next(viewData));
        previous.addActionListener(e -> card.previous(viewData));
        showData.setVisible(true);
        skills.setFont(font);
        certifications.setFont(font);
        languages.setFont(font);
        contacts.setFont(font);
        controllers.setBackground(Color.white);
        viewData.setBackground(Color.white);
        next.setBackground(Color.white);
        previous.setBackground(Color.white);
        backButton.setBackground(Color.white);
        next.setFont(font);
        previous.setFont(font);
        backButton.setFont(font);
        next.setForeground(Color.black);
        previous.setForeground(Color.black);
        backButton.setForeground(Color.black);
        backButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showData.setVisible(false);
                showData.getContentPane().removeAll();
                showData.repaint();
                new AddOrShowData().view();
                System.out.println("Successfully back to dashboard");
            }
        });
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
