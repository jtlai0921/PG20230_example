// FrameTest6B.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;
import java.awt.*;

public class FrameTest6B {
	public static void main(String[] args) {
		// �I�s�A���غc�l�إ߮ج[ (�ڭ̶ǤJ�ج[�����D)

		JFrame theFrame = new JFrame("Whee!!!");

		// �N�j�p�վ㬰�X�z�� (JFrame �w�]���j�p�O 0 �����e, 0 ������;
		// �򥻤W����ݤ���)

		theFrame.setSize(400, 400);  // �e��, ���׹���

		// �b�ù��W�m����ܵ������ޥ�

		Dimension frameSize = theFrame.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		theFrame.setLocation((screenSize.width - frameSize.width)/2, 
			             (screenSize.height - frameSize.height)/2);

		// ���������w���G��, �����w�]����ɧG��

		Container contentPane = theFrame.getContentPane( );
		contentPane.setLayout(new GridLayout(3, 2));  // 3 �C, 2 ��

		// �إߤ@�Ǥ����i�h

		JLabel l = new JLabel("�m�W:");
		JLabel l2 = new JLabel("�a�}:");
		JLabel l3 = new JLabel("SSN:");

		// �U���o�Ӥ���O�Ӧh�檺��r�ϰ�;
		// �ڭ̧Ʊ楦�u���v 6 ��, �e 20 �Ӧr��

		JTextArea t = new JTextArea("�o�O�ӡu���v��r�ϰ�A" +
					    "�i�H�]�t�\�h��r���e�C" +
					    "  �ڭ̭n���u�۳�r����_��C",
					    6, 20);

		// ���} JTextArea ���󪺴��� ...
		t.setLineWrap(true);

		// ... �H�γ�r���
		t.setWrapStyleWord(true);

		// �إߨ�ӳ���r���

		JTextField t2 = new JTextField("�o�O�ӡu���v��r���C");
		JTextField t3 = new JTextField("�S�@�Ӥ�r���C");

		// ����, �C���W���ǩ�i����

		contentPane.add(l);	// �� 1 �C, �� 1 ��
		contentPane.add(t);	// �� 1 �C, �� 2 ��
		contentPane.add(l2);	// �� 2 �C, �� 1 �� (�l����)
 		contentPane.add(t2);
 		contentPane.add(l3);
 		contentPane.add(t3);

		// �إߤ@�Ӧh�l������!

		JTextField t4 = new JTextField("�h�F�@��! :op");

		// �Y�ϯu���S�Ŷ��F, �٬O�⥦��i�h

		contentPane.add(t4);

		theFrame.setVisible(true);
	}
}
