// JListDemo3.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*; 

public class JListDemo3 extends JFrame {
    public JListDemo3() {
        super("Sample JList");
        Container contentPane = this.getContentPane();

        // 建立 Student 的群集
        Student[] v = new Student[3];
        v[0] = new Student("123456789", "Joe Blow");
        v[1] = new Student("987654321", "Fred Schnurd");
        v[2] = new Student("000000000", "Englebert Humperdink");

        // 根據這個群集建立清單. (我們必須將 myList 宣告為 final 變數;
        // 否則編譯器就會在稍後以內部類別建立監聽者存取它的時候抱怨)
        final JList myList = new JList(v);
        contentPane.add(myList);

        // 加個監聽者, 以便在選取項目的時候收到通知
        ListSelectionListener lsl = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                // 當使用者選取清單內某個項目的時候
                // 將它顯示在指令列
                Student s = (Student) myList.getSelectedValue();
                System.out.println("選擇了 " + s);
            }
        };

        myList.addListSelectionListener(lsl);

        this.setSize(300, 100);  
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JListDemo3();
    }
}
