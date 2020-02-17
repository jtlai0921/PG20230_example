// CenteredFrame.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;
import java.awt.*;

// 這個 JFrame 的特殊子類別會自動把自己顯示在正中央!
// 任何使用 JFrame 的時機都能以它替代; 客戶程式碼看起來大概像這樣:
/*
	CenteredFrame myFrame = new CenteredFrame("Self-Centering Frame", 200, 200);

	// 加入我們需要用到的其它元件, 就跟使用 JFrame 的時候一樣
	// (因為 CenteredFrame 就「是」 JFrame) ... 細節略

	// 把視窗顯示出來
	myFrame.setVisible(true);
*/

public class CenteredFrame extends JFrame {
	// 建構子
	public CenteredFrame(String title, int width, int height) {
		super(title);
           	super.setSize(width, height);  

		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// 計算螢幕中心位置
		int centerX = screenSize.width/2;
		int centerY = screenSize.height/2;

		// 我們希望視窗有一半在中線左邊, 一半在中線以上
		int halfWidth = frameSize.width/2;
		int halfHeight = frameSize.height/2;
		this.setLocation(centerX - halfWidth, centerY - halfHeight);

		// 我們不會讓視窗出現在螢幕上; 我們將讓使用這個類別的
		// 客戶程式碼完成這項工作
      	}

	// 測試用 main 方法
	public static void main(String[] args) {
		CenteredFrame cf = new CenteredFrame("Taa daa", 200, 200);
		cf.setVisible(true);
	}
}
