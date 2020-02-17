// PasswordPopup.java - Chapter 16 version.

// Copyright 2000 by Jacquie Barker - all rights reserved.

// �o�O�� GUI ���O

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class PasswordPopup extends JDialog {
	private String password;

	// �N��U�� GUI �����ݩ�

	private Container contentPane;
	private JLabel passwordLabel;
	private JPasswordField passwordField;

	// �غc�l
	public PasswordPopup(Frame parent) {
		// ���I�s JDialog ���x���غc�l

		super(parent, "��J�K�X", true);

		contentPane = this.getContentPane();
		contentPane.setLayout(new GridLayout(1, 2));

		passwordLabel = new JLabel("�K�X:  ", JLabel.RIGHT);
		passwordLabel.setForeground(Color.black);

		passwordField = new JPasswordField();
		ActionListener aListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���^�K�X
				char[] pw = passwordField.getPassword();
				password = new String(pw).trim();

				// �N�������ð_��, �����N���߱� ...
				// �ڭ̥������Ȥ�{���X�����|�H getPassword ��k
				// ���^�ϥΪ̿�J���K�X
				PasswordPopup.this.setVisible(false);
			}
		};
		passwordField.addActionListener(aListener);

		contentPane.add(passwordLabel);
		contentPane.add(passwordField);

		this.setSize(200, 80);

		// ��ܦb�ù�������
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

	// ���ե�
	public static void main(String[] args) {
		PasswordPopup pp = new PasswordPopup(new JFrame());
		System.out.println("��J���K�X:  " + pp.getPassword());
		pp.dispose();
		System.exit(0);
	}
}
