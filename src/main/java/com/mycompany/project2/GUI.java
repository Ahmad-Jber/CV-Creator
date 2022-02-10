package com.mycompany.project2;

import org.jdatepicker.DateComponentFormatter;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.spi.DateFormatProvider;
import java.util.Arrays;
import java.util.Date;

public class GUI {
    JDatePicker jDatePicker = new JDatePicker();
    JPanel p = new JPanel();
        void signUp(){
            JFrame sign_up = new JFrame("Sign Up");
            sign_up.setLocation(500,100);
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
            JLabel label12=new JLabel();
            JPasswordField passwordField = new JPasswordField();
            JDatePicker jDatePicker = new JDatePicker();
            JCheckBox checkBox = new JCheckBox("Show Password");
            JPanel panel = new JPanel(null);
            panel.setBorder(BorderFactory.createTitledBorder("Add User"));
            panel.setBounds(200, 10, 800, 1200);
            JTextField textField1 = new JTextField();
            JTextField textField2 = new JTextField();
            JTextField textField3 = new JTextField();
            JTextField textField4 = new JTextField();
            JTextField textField5 = new JTextField();
            JTextField textField6 = new JTextField();
            JTextField textField7 = new JTextField();
            JButton button = new JButton("SUBMIT");
            JComboBox comboBox = new JComboBox(new String[]{"Male","Female"});
            JPasswordField passwordField1 = new JPasswordField();
            Font newFont = new Font("Arial", Font.BOLD, 15);
            sign_up.setVisible(true);
            sign_up.setSize(1000, 1200);
            sign_up.setLayout(null);
            sign_up.add(panel);
            label1.setFont(newFont);
            label2.setFont(newFont);
            label3.setFont(newFont);
            label4.setFont(newFont);
            label5.setFont(newFont);
            label6.setFont(newFont);
            label7.setFont(newFont);
            label8.setFont(newFont);
            label9.setFont(newFont);
            label10.setFont(newFont);
            label11.setFont(newFont);
            panel.add(label1);
            panel.add(label2);
            panel.add(label3);
            panel.add(label4);
            panel.add(label5);
            panel.add(label6);
            panel.add(label7);
            panel.add(label8);
            panel.add(label9);
            panel.add(label10);
            panel.add(label11);
            panel.add(label12);
            panel.add(button);
            panel.add(jDatePicker);
            panel.add(passwordField);
            panel.add(passwordField1);
            panel.add(checkBox);
            panel.add(comboBox);
            panel.add(textField1);
            panel.add(textField2);
            panel.add(textField3);
            panel.add(textField4);
            panel.add(textField5);
            panel.add(textField6);
            panel.add(textField7);
            textField1.setBounds(400, 42, 280, 30);
            label1.setBounds(100, 42, 280, 30);
            textField2.setBounds(400, 95, 280, 30);
            label2.setBounds(100, 95, 280, 30);
            textField3.setBounds(400, 150, 280, 30);
            label3.setBounds(100, 150, 280, 30);
            textField4.setBounds(400, 200, 280, 30);
            label4.setBounds(100, 200, 280, 30);
            textField5.setBounds(400, 250, 280, 30);
            label5.setBounds(100, 250, 280, 30);
            textField6.setBounds(400, 300, 280, 30);
            label6.setBounds(100, 300, 280, 30);
            textField7.setBounds(400, 350, 280, 30);
            label7.setBounds(100, 351, 280, 30);
            passwordField.setBounds(400, 400, 280, 30);
            label8.setBounds(100, 402, 280, 30);
            passwordField1.setBounds(400, 450, 280, 30);
            label9.setBounds(95, 452, 280, 30);
            checkBox.setBounds(400, 490, 150, 30);
            label10.setBounds(100, 610, 280, 30);
            label11.setBounds(100,550,280,30);
            jDatePicker.setBounds(400, 550, 280, 40);
            comboBox.setBounds(400, 610, 280, 30);
            button.setBounds(230, 700, 280, 50);
            label12.setBounds(230, 750, 280, 50);
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
                    String pass = Arrays.toString(passwordField.getPassword());
                    String con_pass = Arrays.toString(passwordField1.getPassword());
                    try {
                        if(textField1.equals("")||textField2.equals("")||textField3.equals("")||textField4.equals("")||textField5.equals("")||textField6.equals("")||textField7.equals("")||pass.equals("")||con_pass.equals("")||jDatePicker.getFormattedTextField().getText().equals(""));
                    }catch (Exception err){

                    }
                }
            });
        }
        void signIn(){
            JFrame sign_in =new JFrame("Sign in");
            JLabel l1 = new JLabel("Username"),
                    l2 = new JLabel("Password");
            JTextField t1 = new JTextField();
            JPasswordField t2 = new JPasswordField();
            JButton b = new JButton("Sign in");
            JButton b1 =new JButton("Sign Up");
            JCheckBox checkBox=new JCheckBox("Show Password");
            Component[] arr = {l1,l2,t1,t2,b};
            for (int i = 0; i < arr.length; i++) {
                sign_in.add(arr[i]);
                sign_in.add(l1);
                sign_in.add(l2);
                sign_in.add(t1);
                sign_in.add(t2);
                sign_in.add(b);
                sign_in.add(b1);
                sign_in.add(checkBox);
            }
            sign_in.setVisible(true);
            l1.setBounds(100,20,100,20);
            t1.setBounds(230,20,250,25);
            l2.setBounds(100,80,100,20);
            t2.setBounds(230,80,250,25);
            b.setBounds(200,180,90,40);
            checkBox.setBounds( 230,110,250,25);
            b1.setBounds(300,180,90,40);
            sign_in.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            sign_in.setSize(500, 500);
            l1.setBackground(Color.BLACK);
            Font font  = new Font(Font.SANS_SERIF,Font.BOLD,15);
            l1.setFont(font);
            l2.setFont(font);
            sign_in.setLayout(null);
            b1.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    signUp();
                }
            });
            checkBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(checkBox.isSelected())
                        t2.setEchoChar('\0');
                    else
                        t2.setEchoChar('*');
                }
            });
        }
        public static void main(String[] args) {
            GUI g = new GUI();
            g.signIn();
        }
    }