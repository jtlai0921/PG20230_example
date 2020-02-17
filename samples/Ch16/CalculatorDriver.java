// CalculatorDriver.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

public class CalculatorDriver {
	// 我們可在此以 public static 屬性讓 "整個程式" 都能存取某些資料/物件.
	// 在這個範例之內沒有這種需求; 但是在開發 SRS GUI 的時候會用到.

	public static void main(String[] args) {
		// 將主視窗具現化 -- Calculator2 的建構子會完成剩下的工作!
		new Calculator2();
	}
}

