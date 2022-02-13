package com.mycompany.project2;

import com.SaeedKhoury.project2.Users;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.SqlDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;

public class Sign_up extends GUI{
    JFrame sign_up = new JFrame("Sign Up");
    JLabel label1 = new JLabel("Full name");
    JLabel label2 = new JLabel("First name");
    JLabel label3 = new JLabel("Last name");
    JLabel label4 = new JLabel("Username");
    JLabel label5 = new JLabel("Email");
    JLabel label6 = new JLabel("Phone 1");
    JLabel label7 = new JLabel("Phone 2");
    JLabel label8 = new JLabel("Password");
    JLabel label9 = new JLabel(" Confirm Password");
    JLabel label10 = new JLabel("Gender");
    JLabel label11 =new JLabel("Date of Birth");
    JPasswordField passwordField = new JPasswordField();
    JDatePicker BIRTHDATE = new JDatePicker();
    JCheckBox checkBox = new JCheckBox("Show Password");
    JPanel panel = new JPanel(null);
    JTextField FullName = new JTextField();
    JTextField FirstName = new JTextField();
    JTextField LastName = new JTextField();
    JTextField Username = new JTextField();
    JTextField Email = new JTextField();
    JTextField Phone1 = new JTextField();
    JTextField Phone2 = new JTextField();
    JButton button = new JButton("Submit");
    JComboBox comboBox = new JComboBox(new String[]{"Male","Female"});
    JPasswordField passwordField1 = new JPasswordField();
    Font newFont = new Font("Arial", Font.BOLD, 15);
    Component [] arr = {label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,button, BIRTHDATE,passwordField,passwordField1,checkBox,comboBox, FullName, FirstName, LastName, Username, Email, Phone1, Phone2};
    @Override
    void view(){
        sign_up.setLocation(500,100);
        panel.setBorder(BorderFactory.createTitledBorder("Add User"));
        panel.setBounds(200, 10, 800, 1200);
        sign_up.setVisible(true);
        sign_up.setSize(1000, 1200);
        sign_up.setLayout(null);
        sign_up.add(panel);
        addComponents();
        setFont();
        setBound();
        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (checkBox.isSelected()){
                    passwordField.setEchoChar('\0');
                    passwordField1.setEchoChar('\0');
                }else {
                    passwordField.setEchoChar('*');
                    passwordField1.setEchoChar('*');
                }
            }
        });
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isEmpty()){
                    JOptionPane.showMessageDialog(null,"You cannot submit in null fields");
                }else if(!Email.getText().contains("@")){
                    JOptionPane.showMessageDialog(null,"Your Email is not correct");
                }else{
                    Users user = new Users();
                    Object[] data = new Object[]{Username.getText(),FullName.getText(),null, Arrays.toString(passwordField.getPassword()),comboBox.toString().charAt(0),dateFromJDatePicker(BIRTHDATE)};
                    try {
                        user.insertData(data);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
    boolean isEmpty(){
        String pass = Arrays.toString(passwordField.getPassword());
        String con_pass = Arrays.toString(passwordField1.getPassword());
        return FullName.equals("")|| FirstName.equals("")|| LastName.equals("")|| Username.equals("")|| Email.equals("")|| Phone1.equals("")|| Phone2.equals("")||pass.equals("")||con_pass.equals("")|| BIRTHDATE.getFormattedTextField().getText().equals("");
    }
    @Override
    void addComponents() {
        for (Component comp:arr) {
            panel.add(comp);
        }
    }
    void setFont(){
        for (int i = 0; i < 11; i++) {
            arr[i].setFont(newFont);
        }
    }
    java.sql.Date dateFromJDatePicker(JDatePicker datePicker){
        SqlDateModel data = new SqlDateModel();
        data.setValue(new java.sql.Date(datePicker.getModel().getYear(),datePicker.getModel().getMonth(),datePicker.getModel().getDay()));
        return data.getValue();
    }
    void setBound(){
        FullName.setBounds(400, 42, 280, 30);
        label1.setBounds(100, 42, 280, 30);
        FirstName.setBounds(400, 95, 280, 30);
        label2.setBounds(100, 95, 280, 30);
        LastName.setBounds(400, 150, 280, 30);
        label3.setBounds(100, 150, 280, 30);
        Username.setBounds(400, 200, 280, 30);
        label4.setBounds(100, 200, 280, 30);
        Email.setBounds(400, 250, 280, 30);
        label5.setBounds(100, 250, 280, 30);
        Phone1.setBounds(400, 300, 280, 30);
        label6.setBounds(100, 300, 280, 30);
        Phone2.setBounds(400, 350, 280, 30);
        label7.setBounds(100, 351, 280, 30);
        passwordField.setBounds(400, 400, 280, 30);
        label8.setBounds(100, 402, 280, 30);
        passwordField1.setBounds(400, 450, 280, 30);
        label9.setBounds(95, 452, 280, 30);
        checkBox.setBounds(400, 490, 150, 30);
        label10.setBounds(100, 610, 280, 30);
        label11.setBounds(100,550,280,30);
        BIRTHDATE.setBounds(400, 550, 280, 40);
        comboBox.setBounds(400, 610, 280, 30);
        button.setBounds(230, 700, 280, 50);
    }
}