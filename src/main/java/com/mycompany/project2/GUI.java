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
    Font font = new Font(Font.SANS_SERIF,Font.BOLD,15);
        abstract void view();
        abstract void addComponents();
        abstract void setBound();
    }