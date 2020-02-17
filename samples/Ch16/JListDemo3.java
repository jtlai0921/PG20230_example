// JListDemo3.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*; 

public class JListDemo3 extends JFrame {
    public JListDemo3() {
        super("Sample JList");
        Container contentPane = this.getContentPane();

        // �إ� Student ���s��
        Student[] v = new Student[3];
        v[0] = new Student("123456789", "Joe Blow");
        v[1] = new Student("987654321", "Fred Schnurd");
        v[2] = new Student("000000000", "Englebert Humperdink");

        // �ھڳo�Ӹs���إ߲M��. (�ڭ̥����N myList �ŧi�� final �ܼ�;
        // �_�h�sĶ���N�|�b�y��H�������O�إߺ�ť�̦s�������ɭԩ��)
        final JList myList = new JList(v);
        contentPane.add(myList);

        // �[�Ӻ�ť��, �H�K�b������ت��ɭԦ���q��
        ListSelectionListener lsl = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                // ��ϥΪ̿���M�椺�Y�Ӷ��ت��ɭ�
                // �N����ܦb���O�C
                Student s = (Student) myList.getSelectedValue();
                System.out.println("��ܤF " + s);
            }
        };

        myList.addListSelectionListener(lsl);

        this.setSize(300, 100);  
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JListDemo3();
    }
}
