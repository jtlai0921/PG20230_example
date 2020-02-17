// Professor.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 這是個「模型」類別


import java.util.ArrayList;

public class Professor extends Person {
	//------
	// 屬性
	//------

	private String title;
	private String department;
	private ArrayList<Section> teaches; 

	//--------
	// 建構子
	//--------

	public Professor(String name, String ssn, String title, String dept) {
		// 重新利用父類別的雙引數建構子

		super(name, ssn);

		setTitle(title);
		setDepartment(dept);

		// 將輔助群集具現化

		teaches = new ArrayList<Section>();
	}
	
	//----------
	// 存取方法
	//----------

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	public void setDepartment(String dept) {
		department = dept;
	}

	public String getDepartment() {
		return department;
	}

	//----------
	// 雜項方法
	//----------

	public void display() {
		// 首先顯示 Person 的一般資訊

		super.display();
		
		// 然後顯示 Professor 的專屬資訊

		System.out.println("Professor 專屬資訊:");
		System.out.println("\t職稱: " + getTitle());
		System.out.println("\t任職系所: " + getDepartment());
		displayTeachingAssignments();

		// 最後加上空行

		System.out.println();
	}
	
	// 由於父類別 (Person) 將之定義為抽象方法, 因此我們必須設計出
	// 這個方法; 如果不這麼做的話, Professor 也會變成抽象類別.
	//
	// 我們希望 Professor 傳回下列格式的字串:
	//
	// 	Josephine Blow (Associate Professor, Math)

	public String toString() {
		return getName() + " (" + getTitle() + ", " +
		       getDepartment() + ")";
	}

	public void displayTeachingAssignments() {
		System.out.println(getName() + " 任教的課程:");
		
		// 我們將逐項處理 teaches 這個 ArrayList 的內容,
		// 一次處理一個 Section 物件

		if (teaches.size() == 0) {
			System.out.println("\t(無)");
		}

		else for (Section s : teaches) {
			// 留意我們呼叫 Section 物件為我們處理不少工作!

			System.out.println("\t科目編號: " +
				s.getRepresentedCourse().getCourseNo());
			System.out.println("\t課程編號: " + 
				s.getSectionNo());
			System.out.println("\t科目名稱: " +
				s.getRepresentedCourse().getCourseName());
			System.out.println("\t上課時間: " +
				s.getDayOfWeek() + " - " + 
				s.getTimeOfDay());
			System.out.println("\t-----");
		}
	}
	
	public void agreeToTeach(Section s) {
		teaches.add(s);

		// 我們希望雙向連結這些物件

		s.setInstructor(this);
	}
}
