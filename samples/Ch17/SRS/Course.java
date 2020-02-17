// Course.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// �o�O�ӡu�ҫ��v���O


import java.util.ArrayList;
import java.util.Collection;

public class Course {
	//------
	// �ݩ�
	//------

	private String courseNo;
	private String courseName;
	private double credits;
	private ArrayList<Section> offeredAsSection; 
	private ArrayList<Course> prerequisites; 
	
	//----------------
	// �U���غc�l
	//----------------

	public Course(String cNo, String cName, double credits) {
		setCourseNo(cNo);
		setCourseName(cName);
		setCredits(credits);

		// �ڭ̱N�X�ӻ��U�s����{��

		offeredAsSection = new ArrayList<Section>();
		prerequisites = new ArrayList<Course>();
	}

	//------------------
	// �s����k
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
	// �䥦������k
	//-----------------------------

	public void display() {
		System.out.println("��ظ�T:");
		System.out.println("\t��ؽs��: " + getCourseNo());
		System.out.println("\t��ئW��: " + getCourseName());
		System.out.println("\t�@�Ǥ���: " + getCredits());
		System.out.println("\t���׬��:");

		for (Course c : prerequisites) {
			System.out.println("\t\t" + c.toString());
		}

		// �d�N�U���B�� print �P println ���覡

		System.out.print("\t�}�]�ҵ{: ");
		for (Section s : offeredAsSection) {
			System.out.print(s.getSectionNo() + " ");
		}

		// �̫�[�W�@��Ŧ�

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

		// �إߤ@�ӷs Section (�d�N�ڭ̫����ҵ{�s�����зN�@�k) ...
		Section s = new Section(offeredAsSection.size() + 1, 
				day, time, this, room, capacity);
		
		// ... �M��⥦�O�U��!

		addSection(s);
		
		return s;
	}

	public void addSection(Section s) {
		offeredAsSection.add(s);
	}
}
