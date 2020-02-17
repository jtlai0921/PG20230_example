// JListDemo.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;
import java.awt.*;

public class JListDemo {
	public static void main(String[] args) {
		JFrame theFrame = new JFrame("Sample JList");
		Container contentPane = theFrame.getContentPane( );

		// 建立 Student 的群集
		Student[] v = new Student[3];
		v[0] = new Student("123456789", "Joe Blow");
		v[1] = new Student("987654321", "Fred Schnurd");
		v[2] = new Student("000000000", "Englebert Humperdink");

		// 根據這個群集建立清單. 我們可以這麼做的理由是 Student 類別
		// 定義了 toString() 方法, 這會讓每個 Student 物件以
		// 姓名, SSN 字串的形式出現在清單內.
		JList myList = new JList(v);
		contentPane.add(myList);

		theFrame.setSize(300, 100);  
		theFrame.setVisible(true);
	}
}
