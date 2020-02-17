// MyDialog.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyDialog extends JDialog {
	// �⤸��ŧi���ݩ�

	JButton okButton;

	// �غc�l
        
	// �ڭ̥����Ƕi��ܳo�ӹ�ܲ����u���v�����Ѧ�, �]���ڭ̥����N��
	// ��浹 JDialog �غc�l (�Ԩ��غc�l�Ĥ@��).

	public MyDialog(JFrame parent) {
		// ���ڭ̩I�s�x�� JDialog �غc�l, �æb�̫�@�Ӥ޼ƶǤJ true,
		// �j��ϥΪ̦^���o�ӹ�ܲ�. �ڭ̤]�H�Ĥ@�Ӥ޼ƶǤJ���������Ѧ�.

		super(parent, "Modal Dialog", true); 

		okButton = new JButton("OK");

		this.getContentPane().setLayout(new GridLayout(3, 1));
		this.getContentPane().add(new Label(""));  
		this.getContentPane().add(okButton);
		this.getContentPane().add(new Label("")); 

		this.setSize(200, 100);
		
		// �� ActionListener ������s�W,
		// �b���U���s���ɭ�������ܲ�

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ������ܲ�
				System.out.println("OK clicked");
				MyDialog.this.setVisible(false);
				MyDialog.this.dispose();

				// �d�N�ڭ̡u���v�I�s System.exit(0),
				// �]���o�򰵪���, ������ܲ����ɭԴN�|
				// ���ӵ{��������. ��!!!!!
				// System.exit(0);
			}
		});

		// �p�G�ڭ̤]�Q�ε����k�W�����������s������ܲ�����,
		// �N�o�@�ִ��� WindowListener.
		WindowListener w = new WindowAdapter() { 
			public void windowClosing(WindowEvent e) {
				// �b "this." ���e���n�[�W�~�����O�W��
				MyDialog.this.setVisible(false);
				MyDialog.this.dispose();

				// �d�N�ڭ̡u���v�I�s System.exit(0),
				// �]���o�򰵪���, ������ܲ����ɭԴN�|
				// ���ӵ{��������. ��!!!!!
				// System.exit(0);
			}
		};  

		this.addWindowListener(w);

		// �@�w�n�N�I�s setVisible ���ʧ@��b�غc�l�u�̫�v
		// �n�O���o�򰵪���, ��ť�̴N���i��L�k���`�B�@

		this.setVisible(true);
	}
}
