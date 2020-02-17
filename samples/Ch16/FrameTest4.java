// FrameTest4.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;
import java.awt.*;

public class FrameTest4 {
	public static void main(String[] args) {
		// �I�s�A���غc�l�إ߮ج[ (�ڭ̶ǤJ�ج[�����D)

		JFrame theFrame = new JFrame("Whee!!!");

		// �N�j�p�վ㬰�X�z�� (JFrame �w�]���j�p�O 0 �����e, 0 ������;
		// �򥻤W����ݤ���)

		theFrame.setSize(200, 200);  // �e��, ���׹���

		Dimension frameSize = theFrame.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		theFrame.setLocation((screenSize.width - frameSize.width)/2, 
				         (screenSize.height - frameSize.height)/2);

		// ���ڭ̫إ�, �[�J�@�Ӥ���

		Container contentPane = theFrame.getContentPane( );
		JLabel stuff = new JLabel("I am a label");
		contentPane.add(stuff, BorderLayout.NORTH);

		// �������X�{�b�ù��W.

		theFrame.setVisible(true);
	}
}
