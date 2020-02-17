// ScheduleOfClasses.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 這是個「模型」類別


import java.util.ArrayList;
import java.util.HashMap;

public class ScheduleOfClasses {
	//------
	// 屬性
	//------

	private String semester;

	// 這個 HashMap 存放了 Section 物件參考,
	// 鍵值是將科目編號與課程編號串接的結果, 如 "MATH101 - 1".

	private HashMap<String, Section> sectionsOffered; 

	//--------
	// 建構子
	//--------

	public ScheduleOfClasses(String semester) {
		setSemester(semester);
		
		// 我們將輔助群集具現化

		sectionsOffered = new HashMap<String, Section>();
	}

	//----------
	// 存取方法
	//----------

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getSemester() {
		return semester;
	}

	public HashMap<String, Section> getSectionsOffered() {
		return sectionsOffered;
	}

	//----------
	// 雜項方法
	//----------

	public void display() {
		System.out.println(getSemester() + "學期課表:");
		System.out.println();

		// 逐項處理 HashMap 的所有內容

		for (Section s : sectionsOffered.values()) {
			s.display();
			System.out.println();
		}
	}

	public void addSection(Section s) {
		// 我們把科目編號與課程編號串起來, 中間加上連字號, 當成鍵值

		String key = s.getRepresentedCourse().getCourseNo() + 
			     " - " + s.getSectionNo();
		sectionsOffered.put(key, s);

		// 把 ScheduleOfClasses 雙向連回 Section

		s.setOfferedIn(this);
	}

	// 完整的課程編號, 是將科目編號與課程編號串接, 中間加上連字號
	// 如 "ART101 - 1".

	public Section findSection(String fullSectionNo) {
		return sectionsOffered.get(fullSectionNo);
	}

	public boolean isEmpty() {
		if (sectionsOffered.size() == 0) return true;
		else return false;
	}
}
