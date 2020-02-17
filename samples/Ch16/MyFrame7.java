// MyFrame7.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyFrame7 extends JFrame {
	JButton showButton;

	// �غc�l
	public MyFrame7() {
		super("GUI �D����");
 		showButton = new JButton("����");

		this.getContentPane().setLayout(new GridLayout(3, 1));
		this.getContentPane().add(new Label("�o�O�ӫ��s:"));  
		this.getContentPane().add(showButton);
		this.getContentPane().add(new Label("(�Sԣ�F���_!)")); 

		this.setSize(200, 100);

		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �إߨ���ܹ�ܲ�
				MyDialog my = new MyDialog(MyFrame7.this);
			}
		});

		// �@�w�n�N�I�s setVisible ���ʧ@��b�غc�l�u�̫�v
		// �n�O���o�򰵪���, ��ť�̴N���i��L�k���`�B�@
		this.setVisible(true);
	}

	// �������O
	class MyDialog extends JDialog {
		JButton okButton;

		// �غc�l
		public MyDialog(JFrame parent) {
			// �����j��^��
			super(parent, "�j��^������ܲ�", true); 

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
					// ������ܲ�
					System.out.println("���F OK");
					MyDialog.this.dispose();
				}
			});

			// �@�w�n�N�I�s setVisible ���ʧ@��b�غc�l�u�̫�v
			// �n�O���o�򰵪���, ��ť�̴N���i��L�k���`�B�@
			this.setVisible(true);
		}
	}

	// ���ե�
	public static void main(String[] args) {
		MyFrame7 mf = new MyFrame7();
	}
}

