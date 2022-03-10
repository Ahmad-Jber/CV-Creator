package com.SaeedKhoury.GUI;

import com.SaeedKhoury.DBCaT.Super;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.xml.stream.events.Comment;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;

public class AddOrShowData extends GUI{
    JFrame addOrShow = new JFrame("Add or Insert Data");
    JLabel UserName = new JLabel();
    JButton show = new JButton("Show your data");
    JButton insert = new JButton("Insert Data");
    @Override
    void view() {
        addOrShow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addOrShow.setLayout(new FlowLayout());
        addOrShow.setVisible(true);
        addOrShow.setLocation(300,300);
        addOrShow.setSize(400,400);
        addComponents();
        insert.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddData().view();
            }
        });
        show.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowData().view();
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
        Component [] comp = {UserName,show,insert};
        for (Component c:comp) {
            addOrShow.add(c);
        }
    }
}
