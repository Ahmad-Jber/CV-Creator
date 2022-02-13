package com.mycompany.project2;

import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;

public abstract class GUI {
        void signUp(){

        }
        void signIn(){

        }
        JFrame frame1 = new JFrame("Insert user data");

        public void skills() {
            JLabel l1 = new JLabel("Enter your Skills title");
            JTextField t1 = new JTextField();
            JLabel l2 = new JLabel("Description of your skills");
            JTextArea t2 = new JTextArea();
            JButton b1 = new JButton("Add Another Skills");
            frame1.add(l1);
            frame1.add(t1);
            frame1.add(l2);
            frame1.add(t2);
            frame1.add(b1);
            frame1.setSize(1000,1000);
            frame1.setLayout(null);
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame1.setVisible(true);
            l1.setBounds(100,40,130,30);
            t1.setBounds(400,40,240,27);
            l2.setBounds(100,80,150,30);
            t2.setBounds(400,80,240,27);
            b1.setBounds(100,125,145,30);
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    skills();
                }
            });
        }

        public void cert() {
            JLabel ll1 = new JLabel("Enter title of your Certifecation");
            JTextField tt1 = new JTextField();
            JLabel ll2 = new JLabel("Cert source");
            JTextField tt2 = new JTextField();
            JLabel ll3 = new JLabel("Cert Type ");
            JTextField tt3 = new JTextField();
            JButton b2 = new JButton("Add Another Cert");
            frame1.add(ll1);
            frame1.add(tt1);
            frame1.add(ll2);
            frame1.add(tt2);
            frame1.add(ll3);
            frame1.add(tt3);
            frame1.add(b2);
            ll1.setBounds(100,190,180,30);
            tt1.setBounds(400,190,240,27);
            ll2.setBounds(100,230,190,30);
            tt2.setBounds(400,230,240,27);
            ll3.setBounds(100,270,145,30);
            tt3.setBounds(400,270,240,27);
            b2.setBounds(100,310,145,30);

            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cert();
                }
            });


        }

        public void language() {
            JLabel lll1 = new JLabel("Lang1");
            JTextField ttt1 = new JTextField();
            JLabel lll2 = new JLabel("lang 2");
            JTextField ttt2 = new JTextField();
            JButton b3 = new JButton("Add another language");
            frame1.add(lll1);
            frame1.add(ttt1);
            frame1.add(lll2);
            frame1.add(ttt2);
            frame1.add(b3);
            lll1.setBounds(100,380,145,30);
            ttt1.setBounds(400,380,240,27);
            lll2.setBounds(100,415,145,30);
            ttt2.setBounds(400,415,240,27);
            b3.setBounds(100,460,160,30);
            b3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    language();
                }
            });
        }
        public void contact() {
            JLabel llll1 = new JLabel("Phone1");
            JTextField tttt1 = new JTextField();
            JLabel llll2 = new JLabel("Fax");
            JTextField tttt2 = new JTextField();
            JButton b4 = new JButton("Add another");
            frame1.add(llll1);
            frame1.add(tttt1);
            frame1.add(llll2);
            frame1.add(tttt2);
            frame1.add(b4);
            llll1.setBounds(100,540,145,30);
            tttt1.setBounds(400,540,240,27);
            llll2.setBounds(100,575,145,30);
            tttt2.setBounds(400,575,240,27);
            b4.setBounds(100,615,145,30);
            b4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    contact();
                }
            });
        }
        abstract void view();
        abstract void addComponents();
    }