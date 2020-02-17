// PasswordPopup.java - Chapter 16 version.

// Copyright 2000 by Jacquie Barker - all rights reserved.

// 這是個 GUI 類別

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class PasswordPopup extends JDialog {
	private String password;

	// 代表各個 GUI 元件的屬性

	private Container contentPane;
	private JLabel passwordLabel;
	private JPasswordField passwordField;

	// 建構子
	public PasswordPopup(Frame parent) {
		// 先呼叫 JDialog 的泛型建構子

		super(parent, "輸入密碼", true);

		contentPane = this.getContentPane();
		contentPane.setLayout(new GridLayout(1, 2));

		passwordLabel = new JLabel("密碼:  ", JLabel.RIGHT);
		passwordLabel.setForeground(Color.black);

		passwordField = new JPasswordField();
		ActionListener aListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 取回密碼
				char[] pw = passwordField.getPassword();
				password = new String(pw).trim();

				// 將視窗隱藏起來, 但不將之拋棄 ...
				// 我們必須讓客戶程式碼有機會以 getPassword 方法
				// 取回使用者輸入的密碼
				PasswordPopup.this.setVisible(false);
			}
		};
		passwordField.addActionListener(aListener);

		contentPane.add(passwordLabel);
		contentPane.add(passwordField);

		this.setSize(200, 80);

		// 顯示在螢幕正中央
		Dimension screenSize = Toolkit.getDefaultToolkit().
					    getScreenSize();
		Dimension popupSize = this.getSize();
		int width = popupSize.width;
		int height = popupSize.height;
		this.setLocation((screenSize.width - width)/2, 
		                 (screenSize.height - height)/2);

		this.setVisible(true);
	}

	public String getPassword() {
		return password;
	}

	// 測試用
	public static void main(String[] args) {
		PasswordPopup pp = new PasswordPopup(new JFrame());
		System.out.println("輸入的密碼:  " + pp.getPassword());
		pp.dispose();
		System.exit(0);
	}
}
