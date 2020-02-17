// Student.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 這是個「模型」類別


import java.util.ArrayList;
import java.util.Collection;

public class Student extends Person {
	//------
	// 屬性
	//------

	private String major;
	private String degree;
	private Transcript transcript;
	private ArrayList<Section> attends; 
	
	//--------
	// 建構子
	//--------

	public Student(String name, String ssn, String major, String degree) {
		// 重新利用父類別的建構子程式碼

		super(name, ssn);

		this.setMajor(major);
		this.setDegree(degree);

		// 建立全新的 Transcript 當成 Student 的成績單

		this.setTranscript(new Transcript(this));

		// 請留意, 我們在此將支援用的空群集具現化

		attends = new ArrayList<Section>();
	}
	
	// 第二種比較簡單的建構子

	public Student(String ssn) {
		// 重新利用第一個 Student 建構子的程式碼

		this("TBD", ssn, "TBD", "TBD");
	}

	//----------
	// 存取方法
	//----------

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getDegree() {
		return degree;
	}

	public void setTranscript(Transcript t) {
		transcript = t;
	}

	public Transcript getTranscript() {
		return transcript;
	}

	//----------
	// 雜項方法
	//----------

	public void display() {
		// 首先, 顯示一般的 Person 資訊

		super.display();
		
		// 接著再顯示 Student 專有的資訊

		System.out.println("Student 專屬資訊:");
		System.out.println("\t主修: " + this.getMajor());
		System.out.println("\t學位: " + this.getDegree());
		this.displayCourseSchedule();
		this.printTranscript();

		// 最後再加上一行空行
		System.out.println();
	}	
	
	// 我們被迫設計這個方法, 因為我們的父類別 (Person) 將之定義為抽象方法;
	// 如果沒有這麼做的話, 就會使 Student 也成為抽象類別
	//
	// 對 Student 來說, 我們希望傳回格式如下的字串:
	//
	// Joe Blow (123-45-6789) [Master of Science - Math]

	public String toString() {
		return this.getName() + " (" + this.getSsn() + ") [" + this.getDegree() +
		       " - " + this.getMajor() + "]";
	}

	public void displayCourseSchedule() {
		// 先顯示標題

		System.out.println(this.getName() + " 的課表:");
		
		// 逐項處理 ArrayList 裡面存放的 Section 物件

		for (Section s : attends) {
			// 由於 attends 這個 ArrayList 包含了 Student 過去與目前
			// 選過的所有 Section, 因此我們只想顯示那些還沒有打過成績
			// 的課程

			if (s.getGrade(this) == null) {
				System.out.println("\t科目編號: " + 
					s.getRepresentedCourse().getCourseNo());
				System.out.println("\t課程編號: " + 
					s.getSectionNo());
				System.out.println("\t科目名稱: " + 
					s.getRepresentedCourse().getCourseName());
				System.out.println("\t上課時間: "  +
					s.getDayOfWeek() + " - " +
					s.getTimeOfDay());
				System.out.println("\t上課教室: "  +
					s.getRoom());
				System.out.println("\t教授姓名: " +
					s.getInstructor().getName());
				System.out.println("\t-----");
			}
		}
	}
	
	public void addSection(Section s) {
		attends.add(s);
	}
	
	public void dropSection(Section s) {
		attends.remove(s);
	}
	
	// 判斷 Student 是否已經選了「這堂」Section

	public boolean isEnrolledIn(Section s) {
		if (attends.contains(s)) return true;
		else return false;
	}
		
	// 判斷 Student 是否選過「同一個」科目的「任何」課程

	public boolean isCurrentlyEnrolledInSimilar(Section s1) {
		boolean foundMatch = false;

		Course c1 = s1.getRepresentedCourse();

		for (Section s2 : attends) {
			Course c2 = s2.getRepresentedCourse();
			if (c1 == c2) {
				// 在 ArrayList attends 裡面, 的確有個同一門科目的其他課程
				// 檢查學生是否目前「正在選修」 (也就是檢查他是否有拿到成績)
				// 如果還沒有成績的話, 代表目前正在選修;
				// 如果有成績的話, 代表學生已在過去修完這門課了
				if (s2.getGrade(this) == null) {
					// 還沒有成績! 這代表學生目前正在選修同一個科目的另一門課
					foundMatch = true;
					break;
				}
			}
		}

		return foundMatch;
	}
		
	public void printTranscript() {
		this.getTranscript().display();
	}

	public Collection<Section> getEnrolledSections() {
		return attends;
	}
}
