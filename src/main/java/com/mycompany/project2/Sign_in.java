package com.mycompany.project2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Sign_in extends GUI {
    JFrame frame =new JFrame("J1");
    JLabel l1 = new JLabel("Username"),
            l2 = new JLabel("Password");
    JTextField t1 = new JTextField();
    JPasswordField t2 = new JPasswordField();
    JButton b = new JButton("Sign in");
    JButton b1 =new JButton("Sign Up");
    JCheckBox checkBox=new JCheckBox("SHOW Password");
    @Override
    void view(){

        Component[] arr = {l1,l2,t1,t2,b,b1,checkBox};
        for (Component component : arr) {
            frame.add(component);
        }
        frame.setVisible(true);
        l1.setBounds(100,20,100,20);
        t1.setBounds(230,20,250,25);
        l2.setBounds(100,80,100,20);
        t2.setBounds(230,80,250,25);
        b.setBounds(200,180,90,40);
        checkBox.setBounds( 230,110,250,25);
        b1.setBounds(300,180,90,40);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        l1.setBackground(Color.BLACK);
        Font font  = new Font(Font.SANS_SERIF,Font.BOLD,15);
        l1.setFont(font);
        l2.setFont(font);
        frame.setLayout(null);

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

    @Override
    void addComponents() {

    }
}
