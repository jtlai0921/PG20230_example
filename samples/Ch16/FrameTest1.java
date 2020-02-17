// FrameTest1.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;

public class FrameTest1 {
	public static void main(String[] args) {
		// 呼叫適當的建構子建立框架 (我們傳入框架的標題)

		JFrame theFrame = new JFrame("Whee!!!");

		// 將大小調整為合理值 (JFrame 預設的大小是 0 像素寬, 0 像素高;
		// 基本上等於看不到)

		theFrame.setSize(200, 200);  // 寬度, 高度像素

		// 將視窗的左上角定位於座標 (300, 400) 處

		theFrame.setLocation(300, 400);

		// 讓視窗出現在螢幕上

		theFrame.setVisible(true);
	}
}
