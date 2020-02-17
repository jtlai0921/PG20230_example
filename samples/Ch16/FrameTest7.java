// FrameTest7.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;
import java.awt.*;

public class FrameTest7 {
	public static void main(String[] args) {
		// �I�s�A���غc�l�إ߮ج[ (�ڭ̶ǤJ�ج[�����D)

		JFrame theFrame = new JFrame("Whee!!!");

		// �b�ù��W�m����ܵ������ޥ�

		Dimension frameSize = theFrame.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		theFrame.setLocation((screenSize.width - frameSize.width)/2, 
				         (screenSize.height - frameSize.height)/2);

		// �����w�]���G���޲z��

		Container contentPane = theFrame.getContentPane( );
		contentPane.setLayout(new FlowLayout());

		// �إߴX�Ӽ���

		JLabel l1 = new JLabel("�@�ӵu����");
		JLabel l2 = new JLabel("�@�Ӧ��I��������");
		JLabel l3 = new JLabel("�@�Ӫ����b���i��ĳ������");

		// ���@����m

		l1.setBackground(Color.cyan);
		l1.setForeground(Color.black);
		l2.setBackground(Color.white);
		l2.setForeground(Color.black);
		l3.setBackground(Color.yellow);
		l3.setForeground(Color.black);

		// �������ܱo���z�� (�w�]�O�z��)
		// �o�˭I����~�|��ܥX��

		l1.setOpaque(true);
		l2.setOpaque(true);
		l3.setOpaque(true);

		// �N���̩�줶����

		contentPane.add(l1);
		contentPane.add(l2);
		contentPane.add(l3);

		// �N�j�p�վ㬰�X�z�� (JFrame �w�]���j�p�O 0 �����e, 0 ������;
		// �򥻤W����ݤ���)

		theFrame.setSize(200, 200);  // �e��, ���׹���

		// �������X�{�b�ù��W

		theFrame.setVisible(true);
	}
}
