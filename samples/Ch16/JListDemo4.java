// JListDemo4.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 

public class JListDemo4 extends JFrame {
    private JList myList;

    public JListDemo4() {
        super("Sample JList");
        Container contentPane = this.getContentPane();

        // 建立存放學生的群集
        Student[] v = new Student[3];
        v[0] = new Student("123456789", "Joe Blow");
        v[1] = new Student("987654321", "Fred Schnurd");
        v[2] = new Student("000000000", "Englebert Humperdink");

        // 以這個群集建立清單
        myList = new JList(v);
        contentPane.add(myList, BorderLayout.CENTER);

        // 建立一個按鈕, 並在它被按下的時候取出
        // 清單目前選取的項目
        JButton selectButton = new JButton("選擇");
        contentPane.add(selectButton, BorderLayout.SOUTH);

	// 為按鈕加上監聽者
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student s = (Student) myList.getSelectedValue();
                System.out.println("選擇了 " + s);
            }
        };

        selectButton.addActionListener(listener);

        this.setSize(300, 130);  
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JListDemo4();
    }
}
