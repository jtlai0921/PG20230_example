// DialogDriver.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;

public class DialogDriver {
	public static void main(String[] args) {
		// 建立視窗, 以便當成對話盒的父視窗
		JFrame theFrame = new JFrame("Daddy Frame");
		theFrame.setSize(200, 200);  // 寬度, 高度像素
		theFrame.setVisible(true);

		// 接著建立, 顯示我們的自訂對話盒!
		// 由於對話盒的建構子會讓它顯示出來, 因此我們不必做什麼額外動作
		MyDialog theDialog = new MyDialog(theFrame);
	}
}
