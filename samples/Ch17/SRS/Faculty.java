// Faculty.java - Chapter 15, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 這是個「實作」類別


// 第 14 章曾經提過，我們打算將 Professor 的群集封裝在 Faculty 類別內，
// 就像我們在第 14 章把 Section 的群集封裝到 ScheduleOfClasses 類別一樣。
// 這樣可以讓應用程式多一層抽象性。

import java.util.*;
import java.io.*;

public class Faculty {
	//------
	// 屬性
	//------

	// 這個 HashMap 存放了 Professor 物件參考
	// 並以 Professor 的社會保險編號 (String) 當成鍵值

	private HashMap<String, Professor> professors;

	//--------
	// 建構子
	//--------

	public Faculty() {
		// 我們將輔助的空群集具現化

		professors = new HashMap<String, Professor>();
	}

	//----------
	// 存取方法
	//----------

	// 沒有!

	//----------
	// 雜項方法
	//----------

	public void display() {
		// 逐項處理 HashMap 並顯示每個項目

		for (Professor p : professors.values()) {
			p.display();
			System.out.println();
		}
	}

	public void addProfessor(Professor p) {
		professors.put(p.getSsn(), p);
	}

	public Professor findProfessor(String ssn) {
		return (Professor) professors.get(ssn);
	}

	public boolean isEmpty() {
		if (professors.size() == 0) return true;
		else return false;
	}
}
