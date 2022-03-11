package com.SaeedKhoury.GUI;

import com.SaeedKhoury.DBCaT.Super;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AddOrShowData extends GUI{
    JFrame addOrShow = new JFrame("Dashboard");
    JLabel UserName = new JLabel();
    JButton show = new JButton("Show your data");
    JButton insert = new JButton("Insert Data");
    JButton sign_out = new JButton("Sign out");
    @Override
    void view() {
        addOrShow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addOrShow.setLayout(new GridLayout(6,1,0,30));
        addOrShow.setVisible(true);
        addOrShow.setLocation(300,300);
        addOrShow.setSize(400,400);
        addComponents();
        insert.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddData.insertData.setVisible(false);
                addOrShow.setVisible(false);
                new AddData().view();
                System.out.println("Open data insert successfully");
            }
        });
        show.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowData.showData.setVisible(false);
                addOrShow.setVisible(false);
                new ShowData().view();
                System.out.println("Open data view successfully");
            }
        });
        sign_out.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOrShow.setVisible(false);
                Sign_in.username.setText("");
                Sign_in.password.setText("");
                ShowData.showData.getContentPane().removeAll();
                ShowData.showData.repaint();
                AddData.insertData.getContentPane().removeAll();
                AddData.insertData.repaint();
                new Sign_in().view();
                System.out.println("Sign out successfully");
            }
        });
        ResultSet rs;
        PreparedStatement ps;
        try {
            ps = Super.connection().prepareStatement("SELECT * From USERS WHERE USER_ID = ?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ps.setString(1,Sign_in.getUSER_ID());
            rs = ps.executeQuery();
            rs.first();
            UserName.setText("Welcome "+rs.getString("FULL_NAME"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    void addComponents() {
        Component [] comp = {UserName,show,insert,sign_out};
        for (Component c:comp) {
            addOrShow.add(c);
        }
    }
}
