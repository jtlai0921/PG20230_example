// Student.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// �o�O�ӡu�ҫ��v���O


import java.util.ArrayList;
import java.util.Collection;

public class Student extends Person {
	//------
	// �ݩ�
	//------

	private String major;
	private String degree;
	private Transcript transcript;
	private ArrayList<Section> attends; 
	
	//--------
	// �غc�l
	//--------

	public Student(String name, String ssn, String major, String degree) {
		// ���s�Q�Τ����O���غc�l�{���X

		super(name, ssn);

		this.setMajor(major);
		this.setDegree(degree);

		// �إߥ��s�� Transcript �� Student �����Z��

		this.setTranscript(new Transcript(this));

		// �Яd�N, �ڭ̦b���N�䴩�Ϊ��Ÿs����{��

		attends = new ArrayList<Section>();
	}
	
	// �ĤG�ؤ��²�檺�غc�l

	public Student(String ssn) {
		// ���s�Q�βĤ@�� Student �غc�l���{���X

		this("TBD", ssn, "TBD", "TBD");
	}

	//----------
	// �s����k
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
	// ������k
	//----------

	public void display() {
		// ����, ��ܤ@�몺 Person ��T

		super.display();
		
		// ���ۦA��� Student �M������T

		System.out.println("Student �M�ݸ�T:");
		System.out.println("\t�D��: " + this.getMajor());
		System.out.println("\t�Ǧ�: " + this.getDegree());
		this.displayCourseSchedule();
		this.printTranscript();

		// �̫�A�[�W�@��Ŧ�
		System.out.println();
	}	
	
	// �ڭ̳Q���]�p�o�Ӥ�k, �]���ڭ̪������O (Person) �N���w�q����H��k;
	// �p�G�S���o�򰵪���, �N�|�� Student �]������H���O
	//
	// �� Student �ӻ�, �ڭ̧Ʊ�Ǧ^�榡�p�U���r��:
	//
	// Joe Blow (123-45-6789) [Master of Science - Math]

	public String toString() {
		return this.getName() + " (" + this.getSsn() + ") [" + this.getDegree() +
		       " - " + this.getMajor() + "]";
	}

	public void displayCourseSchedule() {
		// ����ܼ��D

		System.out.println(this.getName() + " ���Ҫ�:");
		
		// �v���B�z ArrayList �̭��s�� Section ����

		for (Section s : attends) {
			// �ѩ� attends �o�� ArrayList �]�t�F Student �L�h�P�ثe
			// ��L���Ҧ� Section, �]���ڭ̥u�Q��ܨ����٨S�����L���Z
			// ���ҵ{

			if (s.getGrade(this) == null) {
				System.out.println("\t��ؽs��: " + 
					s.getRepresentedCourse().getCourseNo());
				System.out.println("\t�ҵ{�s��: " + 
					s.getSectionNo());
				System.out.println("\t��ئW��: " + 
					s.getRepresentedCourse().getCourseName());
				System.out.println("\t�W�Үɶ�: "  +
					s.getDayOfWeek() + " - " +
					s.getTimeOfDay());
				System.out.println("\t�W�ұЫ�: "  +
					s.getRoom());
				System.out.println("\t�б©m�W: " +
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
	
	// �P�_ Student �O�_�w�g��F�u�o��vSection

	public boolean isEnrolledIn(Section s) {
		if (attends.contains(s)) return true;
		else return false;
	}
		
	// �P�_ Student �O�_��L�u�P�@�ӡv��ت��u����v�ҵ{

	public boolean isCurrentlyEnrolledInSimilar(Section s1) {
		boolean foundMatch = false;

		Course c1 = s1.getRepresentedCourse();

		for (Section s2 : attends) {
			Course c2 = s2.getRepresentedCourse();
			if (c1 == c2) {
				// �b ArrayList attends �̭�, ���T���ӦP�@����ت���L�ҵ{
				// �ˬd�ǥͬO�_�ثe�u���b��סv (�]�N�O�ˬd�L�O�_�����즨�Z)
				// �p�G�٨S�����Z����, �N��ثe���b���;
				// �p�G�����Z����, �N��ǥͤw�b�L�h�ק��o���ҤF
				if (s2.getGrade(this) == null) {
					// �٨S�����Z! �o�N��ǥͥثe���b��צP�@�Ӭ�ت��t�@����
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
