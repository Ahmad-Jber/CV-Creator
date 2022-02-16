package com.mycompany.project2;

import com.SaeedKhoury.project2.Users;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Sign_in extends GUI {
    /*if (userName.equalsIgnoreCase("Test") && password.equalsIgnoreCase("1234@.")){
        System.out.println("Logged in");
    }*/
    JFrame sign_in =new JFrame("Sign in");
    JLabel Username = new JLabel("Username"),
            password1 = new JLabel("Password");
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JButton signIn = new JButton("Sign in");
    JButton signUp =new JButton("Sign Up");
    JCheckBox show_password =new JCheckBox("Show Password");
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
                    }else if (validateUser(username.getText(),getPass(password.getPassword()),rs,stmt)){
                        JOptionPane.showMessageDialog(null,"Successfully login");
                        sign_in.setVisible(false);
                        new AddData().view();
                    }else{
                        JOptionPane.showMessageDialog(null,"Login ","",JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    public boolean validateUser(String username, String password,ResultSet rs,PreparedStatement pstat){
        boolean result=false;
        try {
            pstat = new Users().connection().prepareStatement("select USER_ID,PASS from USERS where USER_ID= ? and PASS = ?");
            pstat.setString(1,username);
            pstat.setString(2,password);
            rs = pstat.executeQuery();
            if(!rs.next() && rs.getRow() == 0) {
                result = false;
            }
            else{
                result = true;
            }
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
    @Override
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
        /*    public boolean validateUser(String username, String password) {
        Connection conn = ConnectDB.getConnection();

        //write the query, executed, and return if the user can login or not
        try {
            pstat = conn.prepareStatement("select username,password from user where username='"+ username + "' and password = '"+password+ "'");

            pstat.setString(1,username);
            pstat.setString(2,password);
            rs = pstat.executeQuery();

            if(!rs.next() && rs.getRow() == 0) {
                result = false;
            }
            else{
                result = true;
            }
        }
        catch (Exception ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
        }
        return result;
    }*/
}
            /*  PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;
                String email = home.user.getText().toString();
                String password = home.pass.getText().toString();
                String sql = "SELECT * FROM login WHERE user = ? and pass = ?";
                    try{
                            preparedStatement = db.getConnection().prepareStatement(sql);
                            preparedStatement.setString(1, email);
                            preparedStatement.setString(2, password);
                            resultSet = preparedStatement.executeQuery();
                            if(!resultSet.next()){
                            Alert log=new Alert(Alert.AlertType.WARNING);
                            log.setHeaderText("الرجاء التاكد من كلمة المرور او اسم المستخدم ");
                            log.setContentText("لديك 3 محاولات قبل ان يتم حضرك لمدة اسبوع");
                            log.show();
                            }else{
                            stage.setScene(hom);
                            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
                            stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
                            stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
                            }
                            }catch(Exception e){
                            e.printStackTrace();
                            }   */