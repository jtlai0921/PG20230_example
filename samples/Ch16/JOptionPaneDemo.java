// JOptionPaneDemo.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;

public class JOptionPaneDemo {
	public static void main(String[] args) {
		// �ڭ̥u�ܽd�@�� JOptionPane: �]�N�O�T����ܲ�,
		// ���|��ܤ@�q�T��, �ô���������ܲ��Ϊ� OK ���s

		// �o���R�A��k�I�s�ݭn 4 �Ӥ޼�:
		//
		// �Ĥ@�ӬO "��" ���󪺰Ѧ�, �i�d null.
		//
		// �ĤG�ӬO�T����r.
		//
		// �ĤT�ӬO��ܲ����D.
		//
		// �ĥ|�ӬO JOptionPane �w�q���`��, �ΥH���w�ϥܺ���

		JOptionPane.showMessageDialog(
			null, 
			"�ǳƦn����A���I��o�ӹ�ܲ��C",
			"�H�ɳ���",
			JOptionPane.INFORMATION_MESSAGE);
	}
}
