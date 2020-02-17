// JListDemo3C.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*; 

public class JListDemo3C extends JFrame {
    // 把 JList 的宣告放在這邊, 讓它成為類別整體的屬性, 就能避免
    // 在內部 ListSelectionListener 類別取用它的問題
    private JList myList;

    public JListDemo3C() {
        super("Sample JList");
        Container contentPane = this.getContentPane();

        // 建立 Student 的群集
        Student[] v = new Student[3];
        v[0] = new Student("123456789", "Joe Blow");
        v[1] = new Student("987654321", "Fred Schnurd");
        v[2] = new Student("000000000", "Englebert Humperdink");

        // 以這個群集建立清單 (把 myList 提升為 JListDemo3C 類別的
        // 屬性, 就能避免宣告 "final" 變數)
        myList = new JList(v);
        contentPane.add(myList);

        // 加個監聽者, 以便在選取項目的時候收到通知
        ListSelectionListener lsl = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                // 當這個清單的某個項目被選取 (點選!) 的時候,
                // 就在命令提示字元視窗顯示出來

                // 為了避免「雙重顯示」, 先做一次檢查
                if (!myList.getValueIsAdjusting()) {
                    Student s = (Student) myList.getSelectedValue();
                    System.out.println("選擇了 " + s);
                }
            }
        };

        myList.addListSelectionListener(lsl);

        this.setSize(300, 100);  
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JListDemo3C();
    }
}
