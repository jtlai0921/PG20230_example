// Calculator5.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; // added

public class Calculator5 extends JFrame {
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
	public Calculator5() {	
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

		// 加入行為!

		ActionListener l = new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			double d1 = 
			    Double.parseDouble(input1TextField.getText());
			double d2 = 
			    Double.parseDouble(input2TextField.getText());
			if (e.getSource() == plusButton)
				answerLabel.setText("" + (d1 + d2));
			else answerLabel.setText("" + (d1 - d2));
		    }
		};

		plusButton.addActionListener(l);
		minusButton.addActionListener(l);

		// 我們希望以 WindowListener 在使用者關閉視窗的時候
		// 讓整個程式跟著結束; 因此我們將以無名內部類別的形式
		// 建立監聽者 ...

		WindowListener w = new WindowListener() { 
			public void windowClosing(WindowEvent e) {
				// 請留意在 this 前面要加上外部類別的名稱
				Calculator5.this.dispose();
				System.exit(0);
			}
		
			// 我們不在意 WindowListener 的其他六個方法,
			// 所以留下 "stub" 就好
		    
			public void windowOpened(WindowEvent e) { }
			public void windowClosed(WindowEvent e) { }
			public void windowIconified(WindowEvent e) { }
			public void windowDeiconified(WindowEvent e) { }
			public void windowActivated(WindowEvent e) { }
			public void windowDeactivated(WindowEvent e) { }
		};  

		// ... 然後向視窗註冊它, 因為產生視窗關閉事件的是 JFrame.

		this.addWindowListener(w);

  		this.setVisible(true);
  	}

	public static void main(String[] args) {
		// 將計算機具現化!
		new Calculator5();
	}
}
