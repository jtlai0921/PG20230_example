// Calculator2B.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;

public class Calculator2B extends JFrame {
	// �⤸����ݩʹ��, �����O���Ҧ���k���ݱo�쥦��

	private Container contentPane;

	// �ɶq�������ܨ�ƴy�z�ʪ��W��, �o�|�����᪺�u�@���P����!

	private JPanel leftPanel; 
	private JPanel centerPanel; 
	private JPanel buttonPanel; 
	private JTextField input1TextField; 
	private JTextField input2TextField; 
	private JLabel answerLabel; 
	private JButton plusButton; 
	private JButton minusButton; 

	// �غc�l
	// �o��O�ڭ̫إߩҦ�����, �ñN���̱��� JFrame ���a��

	public Calculator2B() {	
		// �I�s�x���� JFrame �غc�l
		super("Simple Calculator");

		// �N���e�O�e���]���ݩ�. ���o�䤣�@�w�n�� this,
		// �ڭ̥i�H�����N���g��:
		// contentPane = getContentPane();
		contentPane = this.getContentPane();
		this.setSize(250, 100);

		// �b�ù��W�m����ܵ������ޥ�
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width)/2, 
			             (screenSize.height - frameSize.height)/2);

		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(3, 1));
		leftPanel.add(new JLabel("��J #1:  "));
		leftPanel.add(new JLabel("��J #2:  "));
		leftPanel.add(new JLabel("�ѵ�:  "));
		contentPane.add(leftPanel, BorderLayout.WEST);

		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3, 1));
		input1TextField = new JTextField(10);
		input2TextField = new JTextField(10);
		answerLabel = new JLabel();
		centerPanel.add(input1TextField);
		centerPanel.add(input2TextField);
		centerPanel.add(answerLabel);
		contentPane.add(centerPanel, BorderLayout.CENTER);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 1));
		plusButton = new JButton("+");
		minusButton = new JButton("-");
		buttonPanel.add(plusButton);
		buttonPanel.add(minusButton);
		contentPane.add(buttonPanel, BorderLayout.EAST);

		// �ڭ��ٻݭn���w�欰!

  		this.setVisible(true);
  	}

	// �u�{�ɴ��եΡv�� main ��k
	public static void main(String[] args) {
		// �N�p�����{��!
		new Calculator2B();
	}
}
