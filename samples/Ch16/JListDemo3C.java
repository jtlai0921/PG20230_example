// JListDemo3C.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*; 

public class JListDemo3C extends JFrame {
    // �� JList ���ŧi��b�o��, �����������O���骺�ݩ�, �N���קK
    // �b���� ListSelectionListener ���O���Υ������D
    private JList myList;

    public JListDemo3C() {
        super("Sample JList");
        Container contentPane = this.getContentPane();

        // �إ� Student ���s��
        Student[] v = new Student[3];
        v[0] = new Student("123456789", "Joe Blow");
        v[1] = new Student("987654321", "Fred Schnurd");
        v[2] = new Student("000000000", "Englebert Humperdink");

        // �H�o�Ӹs���إ߲M�� (�� myList ���ɬ� JListDemo3C ���O��
        // �ݩ�, �N���קK�ŧi "final" �ܼ�)
        myList = new JList(v);
        contentPane.add(myList);

        // �[�Ӻ�ť��, �H�K�b������ت��ɭԦ���q��
        ListSelectionListener lsl = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                // ��o�ӲM�檺�Y�Ӷ��سQ��� (�I��!) ���ɭ�,
                // �N�b�R�O���ܦr��������ܥX��

                // ���F�קK�u������ܡv, �����@���ˬd
                if (!myList.getValueIsAdjusting()) {
                    Student s = (Student) myList.getSelectedValue();
                    System.out.println("��ܤF " + s);
                }
            }
        };

        myList.addListSelectionListener(lsl);

        this.setSize(300, 100);  
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JListDemo3C();
    }
}
