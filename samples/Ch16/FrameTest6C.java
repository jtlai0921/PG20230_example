// FrameTest6C.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;
import java.awt.*;

public class FrameTest6C {
	public static void main(String[] args) {
		// �I�s�A���غc�l�إ߮ج[ (�ڭ̶ǤJ�ج[�����D)

		JFrame theFrame = new JFrame("Whee!!!");

		// �N�j�p�վ㬰�X�z�� (JFrame �w�]���j�p�O 0 �����e, 0 ������;
		// �򥻤W����ݤ���)

		theFrame.setSize(300, 300);  // �e��, ���׹���

		// �b�ù��W�m����ܵ������ޥ�

		Dimension frameSize = theFrame.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		theFrame.setLocation((screenSize.width - frameSize.width)/2, 
				         (screenSize.height - frameSize.height)/2);

		// ���������w���G��, �����w�]����ɧG��

		Container contentPane = theFrame.getContentPane( );
		contentPane.setLayout(new GridLayout(3, 2));  // 3 �C, 2 ��

		// �إߤ@�Ǥ����i�h

		JLabel l1 = new JLabel("�m�W:");
		JLabel l2 = new JLabel("Fred");
		JLabel l3 = new JLabel("SSN:");
		JLabel l4 = new JLabel("123-45-6789");

		// ����, �C���W���ǩ�i����

		contentPane.add(l1);
		contentPane.add(l2);

		// �إߨ�Ӫťժ��L�W���ҷ��u��R���v, �M��⥦�̩�i�ĤG�C

		contentPane.add(new JLabel(""));
		contentPane.add(new JLabel(""));

		contentPane.add(l3);
		contentPane.add(l4);

		theFrame.setSize(200, 200);
		theFrame.setVisible(true);
	}
}
