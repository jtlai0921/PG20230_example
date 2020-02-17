// CourseCatalog.java - Chapter 15, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 這是個「實作」類別


// 第 14 章曾經提過，我們打算將 Course 的群集封裝在 CourseCatalog 類別內，
// 就像我們在第 14 章把 Section 的群集封裝到 ScheduleOfClasses 類別一樣。
// 這樣可以讓應用程式多一層抽象性。

import java.util.*;
import java.io.*;

public class CourseCatalog {
	//------
	// 屬性
	//------

	// 這個 HashMap 存了 Course 物件參考
	// 並以 Course 的科目編號 (String) 當成鍵值

	private HashMap<String, Course> courses;

	//--------
	// 建構子
	//--------

	public CourseCatalog() {
		// 我們將輔助的空群集具現化
		courses = new HashMap<String, Course>();
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

		for (Course c : courses.values()) {
			c.display();
			System.out.println();
		}
	}

	public void addCourse(Course c) {
		// 我們以科目編號當成鍵值

		String key = c.getCourseNo();
		courses.put(key, c);
	}

	public Course findCourse(String courseNo) {
		return courses.get(courseNo);
	}

	public boolean isEmpty() {
		if (courses.size() == 0) return true;
		else return false;
	}
}
