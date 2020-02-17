// FrameTest7.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;
import java.awt.*;

public class FrameTest7 {
	public static void main(String[] args) {
		// 呼叫適當的建構子建立框架 (我們傳入框架的標題)

		JFrame theFrame = new JFrame("Whee!!!");

		// 在螢幕上置中顯示視窗的技巧

		Dimension frameSize = theFrame.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		theFrame.setLocation((screenSize.width - frameSize.width)/2, 
				         (screenSize.height - frameSize.height)/2);

		// 換掉預設的佈局管理者

		Container contentPane = theFrame.getContentPane( );
		contentPane.setLayout(new FlowLayout());

		// 建立幾個標籤

		JLabel l1 = new JLabel("一個短標籤");
		JLabel l2 = new JLabel("一個有點長的標籤");
		JLabel l3 = new JLabel("一個長到實在不可思議的標籤");

		// 玩一玩色彩

		l1.setBackground(Color.cyan);
		l1.setForeground(Color.black);
		l2.setBackground(Color.white);
		l2.setForeground(Color.black);
		l3.setBackground(Color.yellow);
		l3.setForeground(Color.black);

		// 讓標籤變得不透明 (預設是透明)
		// 這樣背景色才會顯示出來

		l1.setOpaque(true);
		l2.setOpaque(true);
		l3.setOpaque(true);

		// 將它們放到介面內

		contentPane.add(l1);
		contentPane.add(l2);
		contentPane.add(l3);

		// 將大小調整為合理值 (JFrame 預設的大小是 0 像素寬, 0 像素高;
		// 基本上等於看不到)

		theFrame.setSize(200, 200);  // 寬度, 高度像素

		// 讓視窗出現在螢幕上

		theFrame.setVisible(true);
	}
}
