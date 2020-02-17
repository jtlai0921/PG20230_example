// JListDemo.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;
import java.awt.*;

public class JListDemo {
	public static void main(String[] args) {
		JFrame theFrame = new JFrame("Sample JList");
		Container contentPane = theFrame.getContentPane( );

		// �إ� Student ���s��
		Student[] v = new Student[3];
		v[0] = new Student("123456789", "Joe Blow");
		v[1] = new Student("987654321", "Fred Schnurd");
		v[2] = new Student("000000000", "Englebert Humperdink");

		// �ھڳo�Ӹs���إ߲M��. �ڭ̥i�H�o�򰵪��z�ѬO Student ���O
		// �w�q�F toString() ��k, �o�|���C�� Student ����H
		// �m�W, SSN �r�ꪺ�Φ��X�{�b�M�椺.
		JList myList = new JList(v);
		contentPane.add(myList);

		theFrame.setSize(300, 100);  
		theFrame.setVisible(true);
	}
}
