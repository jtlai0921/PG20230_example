// FrameTest1.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;

public class FrameTest1 {
	public static void main(String[] args) {
		// �I�s�A���غc�l�إ߮ج[ (�ڭ̶ǤJ�ج[�����D)

		JFrame theFrame = new JFrame("Whee!!!");

		// �N�j�p�վ㬰�X�z�� (JFrame �w�]���j�p�O 0 �����e, 0 ������;
		// �򥻤W����ݤ���)

		theFrame.setSize(200, 200);  // �e��, ���׹���

		// �N���������W���w���y�� (300, 400) �B

		theFrame.setLocation(300, 400);

		// �������X�{�b�ù��W

		theFrame.setVisible(true);
	}
}
