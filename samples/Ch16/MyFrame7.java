// MyFrame7.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyFrame7 extends JFrame {
	JButton showButton;

	// 建構子
	public MyFrame7() {
		super("GUI 主視窗");
 		showButton = new JButton("按我");

		this.getContentPane().setLayout(new GridLayout(3, 1));
		this.getContentPane().add(new Label("這是個按鈕:"));  
		this.getContentPane().add(showButton);
		this.getContentPane().add(new Label("(沒啥了不起!)")); 

		this.setSize(200, 100);

		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 建立並顯示對話盒
				MyDialog my = new MyDialog(MyFrame7.this);
			}
		});

		// 一定要將呼叫 setVisible 的動作放在建構子「最後」
		// 要是不這麼做的話, 監聽者就有可能無法正常運作
		this.setVisible(true);
	}

	// 內部類別
	class MyDialog extends JDialog {
		JButton okButton;

		// 建構子
		public MyDialog(JFrame parent) {
			// 讓它強制回應
			super(parent, "強制回應的對話盒", true); 

			okButton = new JButton("OK");

			this.getContentPane().setLayout(new GridLayout(3, 3));
			this.getContentPane().add(new Label(""));  
			this.getContentPane().add(new Label(""));  
			this.getContentPane().add(new Label(""));  
			this.getContentPane().add(new Label(""));  
			this.getContentPane().add(okButton);
			this.getContentPane().add(new Label(""));  
			this.getContentPane().add(new Label(""));  
			this.getContentPane().add(new Label(""));  
			this.getContentPane().add(new Label("")); 

			this.setSize(200, 100);

			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 關閉對話盒
					System.out.println("按了 OK");
					MyDialog.this.dispose();
				}
			});

			// 一定要將呼叫 setVisible 的動作放在建構子「最後」
			// 要是不這麼做的話, 監聽者就有可能無法正常運作
			this.setVisible(true);
		}
	}

	// 測試用
	public static void main(String[] args) {
		MyFrame7 mf = new MyFrame7();
	}
}

