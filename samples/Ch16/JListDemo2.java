// JListDemo2.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*; // added

public class JListDemo2 {
	public static void main(String[] args) {
		JFrame theFrame = new JFrame("Sample JList");
		Container contentPane = theFrame.getContentPane();

		// �إ� Student ���s��
		Student[] v = new Student[3];
		v[0] = new Student("123456789", "Joe Blow");
		v[1] = new Student("987654321", "Fred Schnurd");
		v[2] = new Student("000000000", "Englebert Humperdink");

		// �ھڳo�Ӹs���إ߲M��
		JList myList = new JList(v);
		contentPane.add(myList);

		// �[�Ӻ�ť��, �H�K�b������ت��ɭԦ���q��
		ListSelectionListener lListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// ��ϥΪ̿���M�椺�Y�Ӷ��ت��ɭ�
				// �N����ܦb���O�C
				JList list = (JList) e.getSource();

				if (!(list.isSelectionEmpty())) {
				    Student s = (Student) list.getSelectedValue();
				    System.out.println("��ܤF " + s);
				}
				else System.out.println("����ܥ��󶵥�");
			}
		};

		myList.addListSelectionListener(lListener);

		theFrame.setSize(300, 100); 
		theFrame.setVisible(true);
	}
}
