// JOptionPaneDemo.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;

public class JOptionPaneDemo {
	public static void main(String[] args) {
		// 我們只示範一種 JOptionPane: 也就是訊息對話盒,
		// 它會顯示一段訊息, 並提供關閉對話盒用的 OK 按鈕

		// 這個靜態方法呼叫需要 4 個引數:
		//
		// 第一個是 "父" 元件的參考, 可留 null.
		//
		// 第二個是訊息文字.
		//
		// 第三個是對話盒標題.
		//
		// 第四個是 JOptionPane 定義的常數, 用以指定圖示種類

		JOptionPane.showMessageDialog(
			null, 
			"準備好之後，請點選這個對話盒。",
			"隨時都行",
			JOptionPane.INFORMATION_MESSAGE);
	}
}
