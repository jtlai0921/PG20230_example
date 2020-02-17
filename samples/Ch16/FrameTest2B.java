// FrameTest2B.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;

// 從 AWT API 匯入幾個類別

import java.awt.Dimension;
import java.awt.Toolkit;

public class FrameTest2B {
	public static void main(String[] args) {
		// 呼叫適當的建構子建立框架 (我們傳入框架的標題)

		JFrame theFrame = new JFrame("Whee!!!");

		// 將大小調整為合理值 (JFrame 預設的大小是 0 像素寬, 0 像素高;
		// 基本上等於看不到)

		theFrame.setSize(200, 200);  // 寬度, 高度像素

		// 在螢幕上置中顯示視窗的技巧
                                                                                  
		// 首先, 取得要置中的視窗大小. 在 Component 上面呼叫 getSize 方法
		// 將拿到 Dimension 物件, 它有兩個 public int 屬性:
		// width (像素寬度) 與 height (像素高度)

		Dimension frameSize = theFrame.getSize();

		// 接著呼叫 Toolkit 類別的 static getDefaultToolkit 方法,
		// 取得這個平台的 AWT Toolkit 物件握柄,
		// 然後呼叫它的 getScreenSize() 方法取得第二個 Dimension 物件

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// 我們想讓視窗左上角「切割」螢幕大小與視窗大小的差異

		theFrame.setLocation((screenSize.width - frameSize.width)/2, 
			             (screenSize.height - frameSize.height)/2);

		// 讓視窗出現在螢幕上.

		theFrame.setVisible(true);
	}
}
