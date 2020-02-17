// Calculator1.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;

public class Calculator1 {
	public static void main(String[ ] args) {
		JFrame aFrame = new JFrame("�p���");
		Container contentPane = aFrame.getContentPane();
		aFrame.setSize(250, 100);

		// �ڭ̤����� JFrame �����e�O�]�w�G���޲z�� -
		// �����w�]�ȴN�O BorderLayout �F

		// �b�ù��W�m����ܵ������ޥ�

		Dimension frameSize = aFrame.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		aFrame.setLocation((screenSize.width - frameSize.width)/2, 
			             (screenSize.height - frameSize.height)/2);

		// ���ڭ̫إߥ������O. �Яd�N�ڭ̬�����諸�W��
		// �����̱o�H�ۧڻ���

		JPanel leftPanel = new JPanel();

		// �ڭ̱N�����O���w�@�� GridLayout (���M���|�ιw�]�� FlowLayout)

		leftPanel.setLayout(new GridLayout(3, 1));

		// �ڭ̱N�إߤT�Ӽ��Ҩé�쭱�O��; 
		// �ڭ̤��������o�Ǽ��Ҫ���W���`, �]���ڭ̤�����H�{���X�ק復��

		leftPanel.add(new JLabel("��J #1:  "));
		leftPanel.add(new JLabel("��J #2:  "));
		leftPanel.add(new JLabel("�ѵ�:  "));

		// ���۱N���O���������

		contentPane.add(leftPanel, BorderLayout.WEST);

		// ���ۥH�P�ˤ�k�B�z�������O

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3, 1));
		JTextField input1TextField = new JTextField(10);
		JTextField input2TextField = new JTextField(10);

		// �ڭ̥H JLabel ��ܭp�⵲�G;
		// ���]��Τ����\�s�誺 JTextField ���o���

		JLabel answerLabel = new JLabel();
		centerPanel.add(input1TextField);
		centerPanel.add(input2TextField);
		centerPanel.add(answerLabel);
		contentPane.add(centerPanel, BorderLayout.CENTER);

		// �ĤT��, �]�O�̫�@�ӭ��O

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 1));
		JButton plusButton = new JButton("+");
		JButton minusButton = new JButton("-");
		buttonPanel.add(plusButton);
		buttonPanel.add(minusButton);
		contentPane.add(buttonPanel, BorderLayout.EAST);

  		aFrame.setVisible(true);
  	}
}
