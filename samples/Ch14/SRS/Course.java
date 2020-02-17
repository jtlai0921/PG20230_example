// Course.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 這是個「模型」類別


import java.util.ArrayList;
import java.util.Collection;

public class Course {
	//------
	// 屬性
	//------

	private String courseNo;
	private String courseName;
	private double credits;
	private ArrayList<Section> offeredAsSection; 
	private ArrayList<Course> prerequisites; 
	
	//----------------
	// 各式建構子
	//----------------

	public Course(String cNo, String cName, double credits) {
		setCourseNo(cNo);
		setCourseName(cName);
		setCredits(credits);

		// 我們將幾個輔助群集具現化

		offeredAsSection = new ArrayList<Section>();
		prerequisites = new ArrayList<Course>();
	}

	//------------------
	// 存取方法
	//------------------

	public void setCourseNo(String cNo) {
		courseNo = cNo;
	}
	
	public String getCourseNo() {
		return courseNo;
	}
	
	public void setCourseName(String cName) {
		courseName = cName;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCredits(double c) {
		credits = c;
	}
	
	public double getCredits() {
		return credits;
	}
	
	//-----------------------------
	// 其它雜項方法
	//-----------------------------

	public void display() {
		System.out.println("科目資訊:");
		System.out.println("\t科目編號: " + getCourseNo());
		System.out.println("\t科目名稱: " + getCourseName());
		System.out.println("\t　學分數: " + getCredits());
		System.out.println("\t先修科目:");

		for (Course c : prerequisites) {
			System.out.println("\t\t" + c.toString());
		}

		// 留意下面運用 print 與 println 的方式

		System.out.print("\t開設課程: ");
		for (Section s : offeredAsSection) {
			System.out.print(s.getSectionNo() + " ");
		}

		// 最後加上一行空行

		System.out.println();
	}
	
	public String toString() {
		return getCourseNo() + ": " + getCourseName();
	}

	public void addPrerequisite(Course c) {
		prerequisites.add(c);
	}

	public boolean hasPrerequisites() {
		if (prerequisites.size() > 0) return true;
		else return false;
	}

	public Collection<Course> getPrerequisites() {
		return prerequisites;
	}

	public Section scheduleSection(char day, String time, String room,
				       int capacity) {

		// 建立一個新 Section (留意我們指派課程編號的創意作法) ...
		Section s = new Section(offeredAsSection.size() + 1, 
				day, time, this, room, capacity);
		
		// ... 然後把它記下來!

		addSection(s);
		
		return s;
	}

	public void addSection(Section s) {
		offeredAsSection.add(s);
	}
}
