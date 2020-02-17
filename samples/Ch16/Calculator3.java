// Calculator3.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; // �H�K�B�z�ƥ�

public class Calculator3 extends JFrame {
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
	public Calculator3() {	
		// �I�s�x���� JFrame �غc�l
		super("Simple Calculator");

		// �N���e�O�e���]���ݩ�. ���o�䤣�@�w�n�� this,
		// �ڭ̥i�H�����N���g��:
		// contentPane = getContentPane();
		contentPane = this.getContentPane();
		this.setSize(250, 150);

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

		// �[�J�欰! �Яd�N�ڭ̨ϥεL�W�������O���覡.

		// ����, �ڭ̫إߤ@�Ӻ�ť�̪���B�z�u�[�k�v���s ...

		ActionListener l = new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			double d1 = 
			    Double.parseDouble(input1TextField.getText());
			double d2 = 
			    Double.parseDouble(input2TextField.getText());
			answerLabel.setText("" + (d1 + d2));
		    }
		};

		// ... �M��V����������n���o�Ӻ�ť��

		plusButton.addActionListener(l);

		// �]���k���s�p�k���s

		l = new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			double d1 = 
			    Double.parseDouble(input1TextField.getText());
			double d2 = 
			    Double.parseDouble(input2TextField.getText());
			answerLabel.setText("" + (d1 - d2));
		    }
		};

		minusButton.addActionListener(l);


		// �b�n����ť�̡u����v�~�������ܥX��
		// �]�� 1.2.2 �����ӯ���, �b��ܤ���~���W����ť��
		// �����| "����"

  		this.setVisible(true);

  	}

	public static void main(String[] args) {
		// �N�p�����{��!
		new Calculator3();
	}
}
