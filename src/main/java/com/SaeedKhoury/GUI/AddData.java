package com.SaeedKhoury.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddData{
    public static void main(String[] args) {
        JFrame frame = new JFrame("CardLayout demo");           // أي قمنا بإنشاء نافذة مع وضع عنوان لها JFrame هنا أنشأنا كائن من الكلاس
        frame.setSize(400, 200);                                // هنا قمنا بتحديد حجم النافذة. عرضها 400 و طولها 200
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // هنا جعلنا زر الخروج من النافذة يغلق البرنامج
        frame.setLayout(new GridBagLayout());                   // لترتيب الأشياء التي نضيفها بداخلها GridBagLayout هنا جعلنا النافذة تستخدم الـ

        // اليمنى Panel اليسرى و الـ Panel هنا قمنا بتعريف الـ
        JPanel panel_L = new JPanel();
        JPanel panel_R = new JPanel();

        // في النافذة panel_R و الـ panel_L لتحديد مكان و حجم الـ GridBagConstraints هنا قمنا بتعريف كائن من الكلاس
        GridBagConstraints gbc = new GridBagConstraints();

        // يتأثر بكامل المساحة المتوفرة من النافذة بالإتجاهين الأفقي و العامودي gbc هنا جعلنا الـ
        gbc.fill = GridBagConstraints.BOTH;

        // هنا جعلنا نسبة الجذب الأفقية و العامودية متساوي حتى يكون المحتوى دائماً مطابق لحجم الشاشة
        gbc.weightx = 1;
        gbc.weighty = 1;

        // في يسار النافذة panel_L هنا أضفنا الـ
        frame.add(panel_L, gbc);

        // في يمين النافذة مع إعطائها حجم جذب أكبر بعشر مرات panel_R هنا أضفنا الـ
        gbc.weightx = 10;
        frame.add(panel_R, gbc);

        // إلى 4 أقسام بالطول panel_L هنا قمنا بتقسيم الـ
        panel_L.setLayout(new GridLayout(5, 1));

        // هنا قمنا بتعريف 4 أزرار
        JButton next = new JButton("Next");
        JButton previous = new JButton("Previous");

        // panel_L هنا قمنا بإضافة الأزرار في الـ
        panel_L.add(next);
        panel_L.add(previous);

        // // لترتيب الأشياء التي نضيفها بداخلها فوق بعضها البعض CardLayout تستخدم الـ panel_R هنا جعلنا الـ
        CardLayout card = new CardLayout();
        Container container = panel_R;
        container.setLayout(card);

        // Panels هنا قمنا بتعريف 4
        JPanel Skills = new JPanel();
        JPanel Certifications = new JPanel();
        JPanel Languages = new JPanel();
        JPanel Contacts = new JPanel();

        // منهم Panel هنا قمنا بإضافة عنوان في كل
        Skills.add(new JLabel("Panel 1"));
        Certifications.add(new JLabel("Panel 2"));
        Languages.add(new JLabel("Panel 3"));
        Contacts.add(new JLabel("Panel 4"));

        // panel_R الأربعة في الـ Panels هنا قمنا بإضافة الـ
        panel_R.add(Skills);
        panel_R.add(Certifications);
        panel_R.add(Languages);
        panel_R.add(Contacts);

        // التالية Panel سيتم عرض الـ next هنا قلنا أنه عند النقر على الزر
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.next(container);
            }
        });

        // السابقة Panel سيتم عرض الـ previous هنا قلنا أنه عند النقر على الزر
        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.previous(container);
            }
        });
        // هنا جعلنا النافذة مرئية
        frame.setVisible(true);
    }
}