// JListDemo2.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*; // added

public class JListDemo2 {
	public static void main(String[] args) {
		JFrame theFrame = new JFrame("Sample JList");
		Container contentPane = theFrame.getContentPane();

		// 建立 Student 的群集
		Student[] v = new Student[3];
		v[0] = new Student("123456789", "Joe Blow");
		v[1] = new Student("987654321", "Fred Schnurd");
		v[2] = new Student("000000000", "Englebert Humperdink");

		// 根據這個群集建立清單
		JList myList = new JList(v);
		contentPane.add(myList);

		// 加個監聽者, 以便在選取項目的時候收到通知
		ListSelectionListener lListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// 當使用者選取清單內某個項目的時候
				// 將它顯示在指令列
				JList list = (JList) e.getSource();

				if (!(list.isSelectionEmpty())) {
				    Student s = (Student) list.getSelectedValue();
				    System.out.println("選擇了 " + s);
				}
				else System.out.println("未選擇任何項目");
			}
		};

		myList.addListSelectionListener(lListener);

		theFrame.setSize(300, 100); 
		theFrame.setVisible(true);
	}
}
