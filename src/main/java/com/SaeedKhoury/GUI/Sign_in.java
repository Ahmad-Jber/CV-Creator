package com.SaeedKhoury.GUI;

import com.SaeedKhoury.DBCaT.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Sign_in extends GUI {
    public static String User_ID;
    static JFrame sign_in =new JFrame("Sign in");
    JLabel Username = new JLabel("Username"),
           password1 = new JLabel("Password");
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JButton signIn = new JButton("Sign in");
    JButton signUp = new JButton("Sign Up");
    JCheckBox show_password = new JCheckBox("Show Password");
    @Override
    void view(){
        sign_in.setVisible(true);
        sign_in.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Username.setBackground(Color.BLACK);
        Username.setFont(font);
        password1.setFont(font);
        sign_in.setLayout(null);
        addComponents();
        setBound();
        actions();
        show_password.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(show_password.isSelected())
                    password.setEchoChar('\0');
                else
                    password.setEchoChar('*');
            }
        });
    }
    String getPass(char[]pass){
        StringBuilder password = new StringBuilder();
        for (char c : pass){
            password.append(c);
        }
        return password.toString();
    }
    void actions(){
        signUp.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Sign_up().view();
                sign_in.setVisible(false);
            }
        });
        signIn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "SELECT * FROM USERS";
                try {
                    PreparedStatement stmt = new Users().connection().prepareCall(sql);
                    ResultSet rs =stmt.executeQuery(sql);
                    if(isEmpty()){
                        JOptionPane.showMessageDialog(null,"Please fill the empty fields");
                    }else if (validateUserName(username.getText(),rs,stmt)){
                        if (validateUser(username.getText(),getPass(password.getPassword()),rs,stmt)){
                        JOptionPane.showMessageDialog(null,"Successfully login");
                        sign_in.setVisible(false);
                        new AddData().view();
                        }else{
                            JOptionPane.showMessageDialog(null,"Enter password again");
                        }
                    }else{
                        int option = JOptionPane.showConfirmDialog(null,"You don't have account, Do you want to create one?","Invalid Username",JOptionPane.YES_NO_CANCEL_OPTION);
                        if (option==JOptionPane.YES_OPTION){
                            new Sign_up().view();
                            sign_in.setVisible(false);
                        }else if (option==JOptionPane.NO_OPTION){
                            System.exit(JOptionPane.NO_OPTION);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    public boolean validateUser(String username,String password,ResultSet rs,PreparedStatement pstat){
        boolean result=false;
        try {
            pstat = new Users().connection().prepareStatement("SELECT USER_ID,PASS FROM USERS FROM USER_ID= ? AND PASS = ?");
            pstat.setString(1,username);
            pstat.setString(2,password);
            rs = pstat.executeQuery();
            result = rs.next() || rs.getRow() != 0;
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error while login");
        }
        if(result){
            User_ID=username;
        }
        return result;
    }
    public boolean validateUserName(String username,ResultSet rs,PreparedStatement pstat){
        boolean result=false;
        try {
            pstat = new Users().connection().prepareStatement("SELECT USER_ID FROM USERS WHERE USER_ID= ?");
            pstat.setString(1,username);
            rs = pstat.executeQuery();
            result = rs.next() || rs.getRow() != 0;
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error while login");
        }
        return result;
    }
    public boolean isEmpty(){
        return username.getText().equals("") || getPass(password.getPassword()).equals("");
    }
    @Override
    void addComponents() {
        Component[] arr = {Username,password1,username,password,signIn,signUp,show_password};
        for (Component component : arr) {
            sign_in.add(component);
        }
    }
    void setBound(){
        Username.setBounds(100,20,100,20);
        username.setBounds(230,20,250,25);
        password1.setBounds(100,80,100,20);
        password.setBounds(230,80,250,25);
        signIn.setBounds(200,180,90,40);
        show_password.setBounds( 230,110,250,25);
        signUp.setBounds(300,180,90,40);
        sign_in.setSize(500, 500);
    }
}