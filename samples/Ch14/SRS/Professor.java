// Professor.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// �o�O�ӡu�ҫ��v���O


import java.util.ArrayList;

public class Professor extends Person {
	//------
	// �ݩ�
	//------

	private String title;
	private String department;
	private ArrayList<Section> teaches; 

	//--------
	// �غc�l
	//--------

	public Professor(String name, String ssn, String title, String dept) {
		// ���s�Q�Τ����O�����޼ƫغc�l

		super(name, ssn);

		setTitle(title);
		setDepartment(dept);

		// �N���U�s����{��

		teaches = new ArrayList<Section>();
	}
	
	//----------
	// �s����k
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
	// ������k
	//----------

	public void display() {
		// ������� Person ���@���T

		super.display();
		
		// �M����� Professor ���M�ݸ�T

		System.out.println("Professor �M�ݸ�T:");
		System.out.println("\t¾��: " + getTitle());
		System.out.println("\t��¾�t��: " + getDepartment());
		displayTeachingAssignments();

		// �̫�[�W�Ŧ�

		System.out.println();
	}
	
	// �ѩ�����O (Person) �N���w�q����H��k, �]���ڭ̥����]�p�X
	// �o�Ӥ�k; �p�G���o�򰵪���, Professor �]�|�ܦ���H���O.
	//
	// �ڭ̧Ʊ� Professor �Ǧ^�U�C�榡���r��:
	//
	// 	Josephine Blow (Associate Professor, Math)

	public String toString() {
		return getName() + " (" + getTitle() + ", " +
		       getDepartment() + ")";
	}

	public void displayTeachingAssignments() {
		System.out.println(getName() + " ���Ъ��ҵ{:");
		
		// �ڭ̱N�v���B�z teaches �o�� ArrayList �����e,
		// �@���B�z�@�� Section ����

		if (teaches.size() == 0) {
			System.out.println("\t(�L)");
		}

		else for (Section s : teaches) {
			// �d�N�ڭ̩I�s Section ���󬰧ڭ̳B�z���֤u�@!

			System.out.println("\t��ؽs��: " +
				s.getRepresentedCourse().getCourseNo());
			System.out.println("\t�ҵ{�s��: " + 
				s.getSectionNo());
			System.out.println("\t��ئW��: " +
				s.getRepresentedCourse().getCourseName());
			System.out.println("\t�W�Үɶ�: " +
				s.getDayOfWeek() + " - " + 
				s.getTimeOfDay());
			System.out.println("\t-----");
		}
	}
	
	public void agreeToTeach(Section s) {
		teaches.add(s);

		// �ڭ̧Ʊ����V�s���o�Ǫ���

		s.setInstructor(this);
	}
}
