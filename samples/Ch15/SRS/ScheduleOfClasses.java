// ScheduleOfClasses.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// �o�O�ӡu�ҫ��v���O


import java.util.ArrayList;
import java.util.HashMap;

public class ScheduleOfClasses {
	//------
	// �ݩ�
	//------

	private String semester;

	// �o�� HashMap �s��F Section ����Ѧ�,
	// ��ȬO�N��ؽs���P�ҵ{�s���걵�����G, �p "MATH101 - 1".

	private HashMap<String, Section> sectionsOffered; 

	//--------
	// �غc�l
	//--------

	public ScheduleOfClasses(String semester) {
		setSemester(semester);
		
		// �ڭ̱N���U�s����{��

		sectionsOffered = new HashMap<String, Section>();
	}

	//----------
	// �s����k
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
	// ������k
	//----------

	public void display() {
		System.out.println(getSemester() + "�Ǵ��Ҫ�:");
		System.out.println();

		// �v���B�z HashMap ���Ҧ����e

		for (Section s : sectionsOffered.values()) {
			s.display();
			System.out.println();
		}
	}

	public void addSection(Section s) {
		// �ڭ̧��ؽs���P�ҵ{�s����_��, �����[�W�s�r��, �����

		String key = s.getRepresentedCourse().getCourseNo() + 
			     " - " + s.getSectionNo();
		sectionsOffered.put(key, s);

		// �� ScheduleOfClasses ���V�s�^ Section

		s.setOfferedIn(this);
	}

	// ���㪺�ҵ{�s��, �O�N��ؽs���P�ҵ{�s���걵, �����[�W�s�r��
	// �p "ART101 - 1".

	public Section findSection(String fullSectionNo) {
		return sectionsOffered.get(fullSectionNo);
	}

	public boolean isEmpty() {
		if (sectionsOffered.size() == 0) return true;
		else return false;
	}
}
