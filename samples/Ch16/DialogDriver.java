// DialogDriver.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;

public class DialogDriver {
	public static void main(String[] args) {
		// �إߵ���, �H�K����ܲ���������
		JFrame theFrame = new JFrame("Daddy Frame");
		theFrame.setSize(200, 200);  // �e��, ���׹���
		theFrame.setVisible(true);

		// ���۫إ�, ��ܧڭ̪��ۭq��ܲ�!
		// �ѩ��ܲ����غc�l�|������ܥX��, �]���ڭ̤����������B�~�ʧ@
		MyDialog theDialog = new MyDialog(theFrame);
	}
}
