// FrameTest6C.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;
import java.awt.*;

public class FrameTest6C {
	public static void main(String[] args) {
		// 呼叫適當的建構子建立框架 (我們傳入框架的標題)

		JFrame theFrame = new JFrame("Whee!!!");

		// 將大小調整為合理值 (JFrame 預設的大小是 0 像素寬, 0 像素高;
		// 基本上等於看不到)

		theFrame.setSize(300, 300);  // 寬度, 高度像素

		// 在螢幕上置中顯示視窗的技巧

		Dimension frameSize = theFrame.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		theFrame.setLocation((screenSize.width - frameSize.width)/2, 
				         (screenSize.height - frameSize.height)/2);

		// 為視窗指定表格佈局, 換掉預設的邊界佈局

		Container contentPane = theFrame.getContentPane( );
		contentPane.setLayout(new GridLayout(3, 2));  // 3 列, 2 欄

		// 建立一些元件放進去

		JLabel l1 = new JLabel("姓名:");
		JLabel l2 = new JLabel("Fred");
		JLabel l3 = new JLabel("SSN:");
		JLabel l4 = new JLabel("123-45-6789");

		// 照欄, 列遞增順序放進元件

		contentPane.add(l1);
		contentPane.add(l2);

		// 建立兩個空白的無名標籤當成「填充物」, 然後把它們放進第二列

		contentPane.add(new JLabel(""));
		contentPane.add(new JLabel(""));

		contentPane.add(l3);
		contentPane.add(l4);

		theFrame.setSize(200, 200);
		theFrame.setVisible(true);
	}
}
