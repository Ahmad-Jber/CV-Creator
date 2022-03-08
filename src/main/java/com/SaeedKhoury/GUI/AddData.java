package com.SaeedKhoury.GUI;
import com.SaeedKhoury.DBCaT.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
    public class AddData extends GUI{
        JFrame insertData = new JFrame("Insert CV Data");
        JPanel panel_1 = new JPanel();
        JPanel panel_2 = new JPanel();
        JPanel panel_3 = new JPanel();
        JPanel panel_4 = new JPanel();
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        JLabel skillsTitle = new JLabel("Enter your Skills title");
        public static JTextField userSkills = new JTextField();
        JLabel yourSkills = new JLabel("Description of your skills");
        public static JTextArea descriptionOfYourSkills = new JTextArea();
        JLabel certTitle = new JLabel("Enter title of your Certification");
        public static JTextField certificationTitle = new JTextField();
        JLabel certSource = new JLabel("Certification source");
        public static JTextField certificationSource = new JTextField();
        JLabel certType = new JLabel("Certification Type");
        public static JTextField certificationType = new JTextField();
        JLabel langView1 = new JLabel("Lang1");
        public static JTextField languageInput1 = new JTextField();
        JLabel langView2 = new JLabel("lang 2");
        public static JTextField languageInput2 = new JTextField();
        JLabel phone = new JLabel("Phone Number");
        public static JTextField phoneInput = new JTextField();
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
            panel_4.add(phone);
            panel_4.add(phoneInput);
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
                        Super s = new Super();
                        s.setUSER_ID(Sign_in.getUSER_ID());
                        CERTIFICATIONS cert = new CERTIFICATIONS();
                        Skills skill = new Skills();
                        Contacts cont = new Contacts();
                        Languages language = new Languages();
                        USER_CERTIFICATIONS uc = new USER_CERTIFICATIONS();
                        USER_SKILLS us = new USER_SKILLS();
                        USER_LANGUAGES ul = new USER_LANGUAGES();
                        try {
                            skill.insertData(userSkills.getText());
                            cert.insertData(certificationType.getText(),certificationTitle.getText());
                            language.insertData(languageInput1.getText());
                            language.insertData(languageInput2.getText());
                            cont.insertData(phoneInput.getText());
                            uc.insertData(certificationTitle.getText(),certificationSource.getText());
                            us.insertData(userSkills.getText(),descriptionOfYourSkills.getText());
                            ul.insertData(languageInput1.getText());
                            ul.insertData(languageInput2.getText());
                            JOptionPane.showMessageDialog(null,"Save Data Successfully");
                            insertData.setVisible(false);
                            System.out.println("Data inserted Successfully");
                            new ShowData().view();
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
            return userSkills.getText().equals("") || descriptionOfYourSkills.getText().equals("") || certificationTitle.getText().equals("") || certificationType.getText().equals("") || certificationSource.getText().equals("") || phone.getText().equals("");
        }
}