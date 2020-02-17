// FrameTest2B.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;

// �q AWT API �פJ�X�����O

import java.awt.Dimension;
import java.awt.Toolkit;

public class FrameTest2B {
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

		// �ڭ̷Q���������W���u���Ρv�ù��j�p�P�����j�p���t��

		theFrame.setLocation((screenSize.width - frameSize.width)/2, 
			             (screenSize.height - frameSize.height)/2);

		// �������X�{�b�ù��W.

		theFrame.setVisible(true);
	}
}
