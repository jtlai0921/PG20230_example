// Calculator1.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;

public class Calculator1 {
	public static void main(String[ ] args) {
		JFrame aFrame = new JFrame("計算機");
		Container contentPane = aFrame.getContentPane();
		aFrame.setSize(250, 100);

		// 我們不必為 JFrame 的內容板設定佈局管理者 -
		// 它的預設值就是 BorderLayout 了

		// 在螢幕上置中顯示視窗的技巧

		Dimension frameSize = aFrame.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		aFrame.setLocation((screenSize.width - frameSize.width)/2, 
			             (screenSize.height - frameSize.height)/2);

		// 讓我們建立左側面板. 請留意我們為元件選的名稱
		// 讓它們得以自我說明

		JPanel leftPanel = new JPanel();

		// 我們將為面板指定一個 GridLayout (不然它會用預設的 FlowLayout)

		leftPanel.setLayout(new GridLayout(3, 1));

		// 我們將建立三個標籤並放到面板內; 
		// 我們不必持有這些標籤的具名握柄, 因為我們不打算以程式碼修改它們

		leftPanel.add(new JLabel("輸入 #1:  "));
		leftPanel.add(new JLabel("輸入 #2:  "));
		leftPanel.add(new JLabel("解答:  "));

		// 接著將面板掛到視窗裡

		contentPane.add(leftPanel, BorderLayout.WEST);

		// 接著以同樣方法處理中央面板

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3, 1));
		JTextField input1TextField = new JTextField(10);
		JTextField input2TextField = new JTextField(10);

		// 我們以 JLabel 顯示計算結果;
		// 其實也能用不允許編輯的 JTextField 做這件事

		JLabel answerLabel = new JLabel();
		centerPanel.add(input1TextField);
		centerPanel.add(input2TextField);
		centerPanel.add(answerLabel);
		contentPane.add(centerPanel, BorderLayout.CENTER);

		// 第三個, 也是最後一個面板

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
