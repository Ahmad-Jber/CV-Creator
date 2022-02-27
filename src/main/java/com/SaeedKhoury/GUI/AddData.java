package com.SaeedKhoury.GUI;
import com.SaeedKhoury.DBCaT.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.*;
    public class AddData extends GUI{
        JFrame insertData = new JFrame("Insert CV Data");
        JPanel panel_1 = new JPanel();
        JPanel panel_2 = new JPanel();
        JPanel panel_3 = new JPanel();
        JPanel panel_4 = new JPanel();
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        JLabel skillsTitle = new JLabel("Enter your Skills title");
        JTextField userSkills = new JTextField();
        JLabel yourSkills = new JLabel("Description of your skills");
        JTextArea descriptionOfYourSkills = new JTextArea();
        JLabel certTitle = new JLabel("Enter title of your Certification");
        JTextField certificationTitle = new JTextField();
        JLabel certSource = new JLabel("Certification source");
        JTextField certificationSource = new JTextField();
        JLabel certType = new JLabel("Certification Type");
        JTextField certificationType = new JTextField();
        JLabel langView1 = new JLabel("Lang1");
        JTextField languageInput1 = new JTextField();
        JLabel langView2 = new JLabel("lang 2");
        JTextField languageInput2 = new JTextField();
        JLabel phone1 = new JLabel("Phone1");
        JTextField phoneInput = new JTextField();
        JLabel fax = new JLabel("Fax");
        JTextField faxInput = new JTextField();
        JButton submit = new JButton("Submit");
        @Override
        void addComponents() {
            panel_1.add(skillsTitle);
            panel_1.add(userSkills);
            panel_1.add(yourSkills);
            panel_1.add(descriptionOfYourSkills);
            panel_2.add(certTitle);
            panel_2.add(certificationTitle);
            panel_2.add(certSource);
            panel_2.add(certificationSource);
            panel_2.add(certType);
            panel_2.add(certificationType);
            panel_3.add(langView1);
            panel_3.add(languageInput1);
            panel_3.add(langView2);
            panel_3.add(languageInput2);
            panel_4.add(phone1);
            panel_4.add(phoneInput);
            panel_4.add(fax);
            panel_4.add(faxInput);
            tabbedPane.addTab("Skills", panel_1);
            tabbedPane.addTab("Certification", panel_2);
            tabbedPane.addTab("Languages", panel_3);
            tabbedPane.addTab("Contact", panel_4);
            insertData.add(tabbedPane);
            insertData.add(submit);
        }
        @Override
        public void view() {
            addComponents();
            setLayout();
            insertData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            tabbedPane.setLocation(JTabbedPane.CENTER,JTabbedPane.CENTER);
            descriptionOfYourSkills.setSize(200,600);
            insertData.setVisible(true);
            insertData.pack();
            insertData.setLocation(500,300);
            descriptionOfYourSkills.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.GRAY));
            submit.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (isEmpty()){
                        JOptionPane.showMessageDialog(null,"Can not submit null data");
                    }else{
                        try {
                            PreparedStatement stmt = new Users().connection().prepareCall("INSERT INTO SKILLS (DESCRIPTION) VALUES (?)");
                            stmt.setString(1,descriptionOfYourSkills.getText());
                            System.out.println(stmt.execute());;

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        descriptionOfYourSkills.getText();
                        Object [] UserSkills={Sign_in.User_ID,0,0,userSkills.getText()};
                        Object [] UserLang={Sign_in.User_ID,0,languageInput1.getText()};
                        Object [] User_Cert={Sign_in.User_ID,0,certificationTitle.getText()};
                        String [] Cont = {faxInput.getText(),phoneInput.getText()};
                        try {
                            new UserSkills().insertData(UserSkills);
                            new UserCertifications().insertData(User_Cert);
                            new UserLanguages().insertData(UserLang);
                            for (String s : Cont) {
                                Object[] User_Cont = {Sign_in.User_ID, 0, 0, s};
                                new UserContacts().insertData(User_Cont);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });
        }
        public void setLayout(){
            insertData.setLayout(new FlowLayout());
            panel_1.setLayout(new GridLayout(3,1));
            panel_2.setLayout(new GridLayout(4,2));
            panel_3.setLayout(new GridLayout(3,2));
            panel_4.setLayout(new GridLayout(3,2));
        }
        boolean isEmpty() {
            return userSkills.getText().equals("") || descriptionOfYourSkills.getText().equals("") || certificationTitle.getText().equals("") || certificationType.getText().equals("") || certificationSource.getText().equals("") || phone1.getText().equals("") || fax.getText().equals("");
        }
}