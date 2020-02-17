// CourseCatalog.java - Chapter 15, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// �o�O�ӡu��@�v���O


// �� 14 �����g���L�A�ڭ̥���N Course ���s���ʸ˦b CourseCatalog ���O���A
// �N���ڭ̦b�� 14 ���� Section ���s���ʸ˨� ScheduleOfClasses ���O�@�ˡC
// �o�˥i�H�����ε{���h�@�h��H�ʡC

import java.util.*;
import java.io.*;

public class CourseCatalog {
	//------
	// �ݩ�
	//------

	// �o�� HashMap �s�F Course ����Ѧ�
	// �åH Course ����ؽs�� (String) �����

	private HashMap<String, Course> courses;

	//--------
	// �غc�l
	//--------

	public CourseCatalog() {
		// �ڭ̱N���U���Ÿs����{��
		courses = new HashMap<String, Course>();
	}

	//----------
	// �s����k
	//----------

	// �S��!

	//----------
	// ������k
	//----------

	public void display() {
		// �v���B�z HashMap ����ܨC�Ӷ���

		for (Course c : courses.values()) {
			c.display();
			System.out.println();
		}
	}

	public void addCourse(Course c) {
		// �ڭ̥H��ؽs�������

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
