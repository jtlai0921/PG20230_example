// FrameTest3B.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 留意我們可以分別匯入各個類別, 更明確地說明我們用的每個類別是從何而來的

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.Dimension;

public class FrameTest3B {
	public static void main(String[] args) {
		// 呼叫適當的建構子建立框架 (我們傳入框架的標題)

		JFrame theFrame = new JFrame("Whee!!!");

		// 將大小調整為合理值 (JFrame 預設的大小是 0 像素寬, 0 像素高;
		// 基本上等於看不到)

		theFrame.setSize(200, 200);  // 寬度, 高度像素

		// 在螢幕上置中顯示視窗的技巧

		Dimension frameSize = theFrame.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		theFrame.setLocation((screenSize.width - frameSize.width)/2, 
				         (screenSize.height - frameSize.height)/2);

		// 讓我們建立, 加入一個元件

		Container contentPane = theFrame.getContentPane( );
		JLabel stuff = new JLabel("I am a label");
		contentPane.add(stuff);

		// 讓視窗出現在螢幕上.

		theFrame.setVisible(true);
	}
}
