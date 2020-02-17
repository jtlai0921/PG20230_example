// FrameTest6B.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;
import java.awt.*;

public class FrameTest6B {
	public static void main(String[] args) {
		// 呼叫適當的建構子建立框架 (我們傳入框架的標題)

		JFrame theFrame = new JFrame("Whee!!!");

		// 將大小調整為合理值 (JFrame 預設的大小是 0 像素寬, 0 像素高;
		// 基本上等於看不到)

		theFrame.setSize(400, 400);  // 寬度, 高度像素

		// 在螢幕上置中顯示視窗的技巧

		Dimension frameSize = theFrame.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		theFrame.setLocation((screenSize.width - frameSize.width)/2, 
			             (screenSize.height - frameSize.height)/2);

		// 為視窗指定表格佈局, 換掉預設的邊界佈局

		Container contentPane = theFrame.getContentPane( );
		contentPane.setLayout(new GridLayout(3, 2));  // 3 列, 2 欄

		// 建立一些元件放進去

		JLabel l = new JLabel("姓名:");
		JLabel l2 = new JLabel("地址:");
		JLabel l3 = new JLabel("SSN:");

		// 下面這個元件是個多行的文字區域;
		// 我們希望它「高」 6 行, 寬 20 個字元

		JTextArea t = new JTextArea("這是個「跨行」文字區域，" +
					    "可以包含許多文字內容。" +
					    "  我們要它沿著單字邊界斷行。",
					    6, 20);

		// 打開 JTextArea 元件的換行 ...
		t.setLineWrap(true);

		// ... 以及單字邊界
		t.setWrapStyleWord(true);

		// 建立兩個單行文字欄位

		JTextField t2 = new JTextField("這是個「單行」文字欄位。");
		JTextField t3 = new JTextField("又一個文字欄位。");

		// 照欄, 列遞增順序放進元件

		contentPane.add(l);	// 第 1 列, 第 1 欄
		contentPane.add(t);	// 第 1 列, 第 2 欄
		contentPane.add(l2);	// 第 2 列, 第 1 欄 (餘類推)
 		contentPane.add(t2);
 		contentPane.add(l3);
 		contentPane.add(t3);

		// 建立一個多餘的元件!

		JTextField t4 = new JTextField("多了一個! :op");

		// 即使真的沒空間了, 還是把它放進去

		contentPane.add(t4);

		theFrame.setVisible(true);
	}
}
