package com.SaeedKhoury.GUI;

import com.SaeedKhoury.DBCaT.Users;
import org.jdatepicker.JDatePicker;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;

public class Sign_up extends GUI {
    JFrame sign_up = new JFrame("Sign Up");
    JLabel full_name = new JLabel("Full name");
    JLabel first_name = new JLabel("First name");
    JLabel last_name = new JLabel("Last name");
    JLabel username = new JLabel("Username");
    JLabel email = new JLabel("Email");
    JLabel other_language_name = new JLabel("Other Language Name");
    JLabel password = new JLabel("Password");
    JLabel con_pass = new JLabel(" Confirm Password");
    JLabel gender = new JLabel("Gender");
    JLabel birthdate = new JLabel("Date of Birth");
    JPasswordField passwordField = new JPasswordField();
    JDatePicker BIRTHDATE = new JDatePicker();
    JCheckBox show_password = new JCheckBox("Show Password");
    JPanel panel = new JPanel(null);
    JTextField FullName = new JTextField();
    JTextField FirstName = new JTextField();
    JTextField LastName = new JTextField();
    JTextField OtherLang = new JTextField();
    JTextField Username = new JTextField();
    JTextField Email = new JTextField();
    JButton submit = new JButton("Submit");
    JComboBox Gender = new JComboBox(new String[]{"Male", "Female"});
    JPasswordField passwordField1 = new JPasswordField();
    Component[] arr = {full_name, FullName, first_name, FirstName, last_name, LastName, username, Username, email, Email, other_language_name, OtherLang, password, passwordField, con_pass, passwordField1, show_password, gender, Gender, birthdate, BIRTHDATE, submit};

    @Override
    void view() {
        sign_up.setLocation(500, 100);
        panel.setBorder(BorderFactory.createTitledBorder("Add User"));
        panel.setBounds(200, 10, 800, 800);
        sign_up.setVisible(true);
        sign_up.setSize(1000, 1200);
        sign_up.setLayout(null);
        sign_up.add(panel);
        addComponents();
        setFont();
        setBound();
        sign_up.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        show_password.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (show_password.isSelected()) {
                    passwordField.setEchoChar('\0');
                    passwordField1.setEchoChar('\0');
                } else {
                    passwordField.setEchoChar('*');
                    passwordField1.setEchoChar('*');
                }
            }
        });
        submit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You cannot submit in null fields");
                } else if (!Email.getText().contains("@")) {
                    JOptionPane.showMessageDialog(null, "Your Email is not correct");
                }else if(!getPass(passwordField.getPassword()).equals(getPass(passwordField1.getPassword()))){
                    JOptionPane.showMessageDialog(null, "Your Password is not confirmed");
                }else {
                    Users user = new Users();
                    Object[] data = new Object[]{Username.getText(), FullName.getText(), OtherLang.getText(), getPass(passwordField.getPassword()), String.valueOf(String.valueOf(Gender.getSelectedItem()).charAt(0)), dateFromJDatePicker(BIRTHDATE)};
                    try {
                        user.insertData(data);
                        JOptionPane.showMessageDialog(null, "Successfully");
                        sign_up.setVisible(false);
                        Sign_in.sign_in.setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    boolean isEmpty() {
        String pass = Arrays.toString(passwordField.getPassword());
        String con_pass = Arrays.toString(passwordField1.getPassword());
        return FullName.equals("") || FirstName.equals("") || LastName.equals("") || Username.equals("") || Email.equals("") || OtherLang.equals("") || pass.equals("") || con_pass.equals("") || BIRTHDATE.getFormattedTextField().getText().equals("");
    }

    @Override
    void addComponents() {
        for (Component comp : arr) {
            panel.add(comp);
        }
    }

    void setFont() {
        JLabel[] labels = {full_name, first_name, last_name, username, email, other_language_name, password, con_pass, gender, birthdate};
        for (JLabel l : labels) {
            l.setFont(font);
        }
    }

    java.sql.Date dateFromJDatePicker(@NotNull JDatePicker datePicker) {
        return new java.sql.Date(datePicker.getModel().getYear()-1900, datePicker.getModel().getMonth(), datePicker.getModel().getDay());
    }

    void setBound() {
        FullName.setBounds(400, 42, 280, 30);
        full_name.setBounds(100, 42, 280, 30);
        FirstName.setBounds(400, 95, 280, 30);
        first_name.setBounds(100, 95, 280, 30);
        LastName.setBounds(400, 150, 280, 30);
        last_name.setBounds(100, 150, 280, 30);
        Username.setBounds(400, 200, 280, 30);
        username.setBounds(100, 200, 280, 30);
        Email.setBounds(400, 250, 280, 30);
        email.setBounds(100, 250, 280, 30);
        OtherLang.setBounds(400, 300, 280, 30);
        other_language_name.setBounds(100, 300, 280, 30);
        passwordField.setBounds(400, 351, 280, 30);
        password.setBounds(100, 351, 280, 30);
        passwordField1.setBounds(400, 400, 280, 30);
        con_pass.setBounds(95, 400, 280, 30);
        show_password.setBounds(400, 450, 150, 30);
        gender.setBounds(100, 500, 280, 30);
        birthdate.setBounds(100, 550, 280, 30);
        BIRTHDATE.setBounds(400, 550, 280, 40);
        Gender.setBounds(400, 500, 280, 30);
        submit.setBounds(230, 600, 280, 50);
    }

    String getPass(char[] pass) {
        StringBuilder password = new StringBuilder();
        for (char c : pass) {
            password.append(c);
        }
        return password.toString();
    }
}