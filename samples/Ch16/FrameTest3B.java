// FrameTest3B.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// �d�N�ڭ̥i�H���O�פJ�U�����O, ����T�a�����ڭ̥Ϊ��C�����O�O�q��ӨӪ�

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.Dimension;

public class FrameTest3B {
	public static void main(String[] args) {
		// �I�s�A���غc�l�إ߮ج[ (�ڭ̶ǤJ�ج[�����D)

		JFrame theFrame = new JFrame("Whee!!!");

		// �N�j�p�վ㬰�X�z�� (JFrame �w�]���j�p�O 0 �����e, 0 ������;
		// �򥻤W����ݤ���)

		theFrame.setSize(200, 200);  // �e��, ���׹���

		// �b�ù��W�m����ܵ������ޥ�

		Dimension frameSize = theFrame.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		theFrame.setLocation((screenSize.width - frameSize.width)/2, 
				         (screenSize.height - frameSize.height)/2);

		// ���ڭ̫إ�, �[�J�@�Ӥ���

		Container contentPane = theFrame.getContentPane( );
		JLabel stuff = new JLabel("I am a label");
		contentPane.add(stuff);

		// �������X�{�b�ù��W.

		theFrame.setVisible(true);
	}
}
