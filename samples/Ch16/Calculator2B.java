// Calculator2B.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;

public class Calculator2B extends JFrame {
	// 把元件當成屬性對待, 讓類別的所有方法都看得到它們

	private Container contentPane;

	// 盡量為元件選擇具備描述性的名稱, 這會讓往後的工作輕鬆不少!

	private JPanel leftPanel; 
	private JPanel centerPanel; 
	private JPanel buttonPanel; 
	private JTextField input1TextField; 
	private JTextField input2TextField; 
	private JLabel answerLabel; 
	private JButton plusButton; 
	private JButton minusButton; 

	// 建構子
	// 這邊是我們建立所有元件, 並將它們掛到 JFrame 的地方

	public Calculator2B() {	
		// 呼叫泛型的 JFrame 建構子
		super("Simple Calculator");

		// 將內容板容器設給屬性. 其實這邊不一定要用 this,
		// 我們可以直接將之寫成:
		// contentPane = getContentPane();
		contentPane = this.getContentPane();
		this.setSize(250, 100);

		// 在螢幕上置中顯示視窗的技巧
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width)/2, 
			             (screenSize.height - frameSize.height)/2);

		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(3, 1));
		leftPanel.add(new JLabel("輸入 #1:  "));
		leftPanel.add(new JLabel("輸入 #2:  "));
		leftPanel.add(new JLabel("解答:  "));
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

		// 我們還需要指定行為!

  		this.setVisible(true);
  	}

	// 「臨時測試用」的 main 方法
	public static void main(String[] args) {
		// 將計算機具現化!
		new Calculator2B();
	}
}
