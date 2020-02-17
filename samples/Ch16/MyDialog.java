// MyDialog.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyDialog extends JDialog {
	// 把元件宣告為屬性

	JButton okButton;

	// 建構子
        
	// 我們必須傳進顯示這個對話盒的「父」視窗參考, 因為我們必須將它
	// 轉交給 JDialog 建構子 (詳見建構子第一行).

	public MyDialog(JFrame parent) {
		// 讓我們呼叫泛型 JDialog 建構子, 並在最後一個引數傳入 true,
		// 強制使用者回應這個對話盒. 我們也以第一個引數傳入父視窗的參考.

		super(parent, "Modal Dialog", true); 

		okButton = new JButton("OK");

		this.getContentPane().setLayout(new GridLayout(3, 1));
		this.getContentPane().add(new Label(""));  
		this.getContentPane().add(okButton);
		this.getContentPane().add(new Label("")); 

		this.setSize(200, 100);
		
		// 把 ActionListener 掛到按鈕上,
		// 在按下按鈕的時候關閉對話盒

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 關閉對話盒
				System.out.println("OK clicked");
				MyDialog.this.setVisible(false);
				MyDialog.this.dispose();

				// 留意我們「不」呼叫 System.exit(0),
				// 因為這麼做的話, 關閉對話盒的時候就會
				// 把整個程式結束掉. 不!!!!!
				// System.exit(0);
			}
		});

		// 如果我們也想用視窗右上角的關閉按鈕關掉對話盒的話,
		// 就得一併提供 WindowListener.
		WindowListener w = new WindowAdapter() { 
			public void windowClosing(WindowEvent e) {
				// 在 "this." 的前面要加上外部類別名稱
				MyDialog.this.setVisible(false);
				MyDialog.this.dispose();

				// 留意我們「不」呼叫 System.exit(0),
				// 因為這麼做的話, 關閉對話盒的時候就會
				// 把整個程式結束掉. 不!!!!!
				// System.exit(0);
			}
		};  

		this.addWindowListener(w);

		// 一定要將呼叫 setVisible 的動作放在建構子「最後」
		// 要是不這麼做的話, 監聽者就有可能無法正常運作

		this.setVisible(true);
	}
}
