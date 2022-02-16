package com.SaeedKhoury.GUI;

import javax.swing.*;
import java.awt.*;

public class AddData extends GUI{
    JFrame insertUserData = new JFrame("Insert user data");
    JPanel panel = new JPanel();
    JScrollPane bar = new JScrollPane(panel);
    JLabel skillsTitle = new JLabel("Enter your Skills title");
    JTextField userSkills = new JTextField();
    JLabel yourSkills = new JLabel("Description of your skills");
    JTextArea descriptionOfYourSkills = new JTextArea();
    JButton addSkills = new JButton("Add Another Skills");
    JLabel certTitle = new JLabel("Enter title of your Certification");
    JTextField certificationTitle = new JTextField();
    JLabel certSource = new JLabel("Certification source");
    JTextField certificationSource = new JTextField();
    JLabel certType = new JLabel("Certification Type");
    JTextField certificationType = new JTextField();
    JButton addCertification = new JButton("Add Another Certification");
    JLabel langView1 = new JLabel("Lang1");
    JTextField languageInput1 = new JTextField();
    JLabel langView2 = new JLabel("lang 2");
    JTextField languageInput2 = new JTextField();
    JButton addLanguage = new JButton("Add another language");
    JLabel phone1 = new JLabel("Phone1");
    JTextField phoneInput = new JTextField();
    JLabel fax = new JLabel("Fax");
    JTextField faxInput = new JTextField();
    JButton addContact = new JButton("Add another contact");
    void view(){
        insertUserData.setVisible(true);
        insertUserData.setLayout(null);
        insertUserData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponents();
        setBound();
    }
    @Override
    void addComponents() {
        Component [] components = {skillsTitle,userSkills,yourSkills,yourSkills,descriptionOfYourSkills,addSkills, certTitle,certificationTitle,certSource,certificationSource,certType,certificationType,addCertification,langView1,languageInput1,langView2,languageInput2,addLanguage,phone1,phoneInput,fax,faxInput,addContact};
        for (Component com:components) {
            panel.add(com);
        }
        insertUserData.add(panel);
        insertUserData.add(bar);
    }
    @Override
    void setBound() {
        skillsTitle.setBounds(100,40,130,30);
        userSkills.setBounds(400,40,240,27);
        yourSkills.setBounds(100,80,150,30);
        descriptionOfYourSkills.setBounds(400,80,240,27);
        addSkills.setBounds(100,125,145,30);
        certTitle.setBounds(100,190,180,30);
        certificationTitle.setBounds(400,190,240,27);
        certSource.setBounds(100,230,190,30);
        certificationSource.setBounds(400,230,240,27);
        certType.setBounds(100,270,145,30);
        certificationType.setBounds(400,270,240,27);
        addCertification.setBounds(100,310,145,30);
        phone1.setBounds(100,540,145,30);
        phoneInput.setBounds(400,540,240,27);
        fax.setBounds(100,575,145,30);
        faxInput.setBounds(400,575,240,27);
        addContact.setBounds(100,615,145,30);
        langView1.setBounds(100,380,145,30);
        languageInput1.setBounds(400,380,240,27);
        langView2.setBounds(100,415,145,30);
        languageInput2.setBounds(400,415,240,27);
        addLanguage.setBounds(100,460,160,30);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setAlignmentY(Component.CENTER_ALIGNMENT);
    }
}