// FrameTest2.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;

// �q AWT API �פJ�X�����O

import java.awt.Dimension;
import java.awt.Toolkit;

public class FrameTest2 {
	public static void main(String[] args) {
		// �I�s�A���غc�l�إ߮ج[ (�ڭ̶ǤJ�ج[�����D)

		JFrame theFrame = new JFrame("Whee!!!");

		// �N�j�p�վ㬰�X�z�� (JFrame �w�]���j�p�O 0 �����e, 0 ������;
		// �򥻤W����ݤ���)

		theFrame.setSize(200, 200);  // �e��, ���׹���

		// �b�ù��W�m����ܵ������ޥ�

		// ����, ���o�n�m���������j�p. �b Component �W���I�s getSize ��k
		// �N���� Dimension ����, ������� public int �ݩ�:
		// width (�����e��) �P height (��������)

		Dimension frameSize = theFrame.getSize();

		// ���۩I�s Toolkit ���O�� static getDefaultToolkit ��k,
		// ���o�o�ӥ��x�� AWT Toolkit ���󴤬`,
		// �M��I�s���� getScreenSize() ��k���o�ĤG�� Dimension ����

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// �p��ù������I

		int centerX = screenSize.width/2;
		int centerY = screenSize.height/2;

		// �ڭ̷Q���b�ӵ����d�b���I����, �b�ӵ����b���I�W��

		int halfWidth = frameSize.width/2;
		int halfHeight = frameSize.height/2;
		theFrame.setLocation(centerX - halfWidth, centerY - halfHeight);

		// �������X�{�b�ù��W.

		theFrame.setVisible(true);
 	}
}
