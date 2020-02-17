// Section.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// �o�O�ӡu�ҫ��v���O


import java.util.ArrayList;
import java.util.HashMap;

public class Section {
	//------
	// �ݩ�
	//------

	private int sectionNo;
	private char dayOfWeek;
	private String timeOfDay;
	private String room;
	private int seatingCapacity;
	private Course representedCourse;
	private ScheduleOfClasses offeredIn;
	private Professor instructor;

	// enrolledStudents �o�� HashMap �s��F Student ���󪺰Ѧ�,
	//�H�C�� Student �� ssn �@�� String ���

	private HashMap<String, Student> enrolledStudents; 

	// assignGrades �o�� HashMap �s�� TranscriptEntry ����Ѧ�,
	// �H Student ���Ѧҷ����, �d�߳o�Ӿǥͱo�쪺���Z

	private HashMap<Student, TranscriptEntry> assignedGrades; 
	
	//--------
	// �غc�l
	//--------

	public Section(int sNo, char day, String time, Course course,
		       String room, int capacity) {
		setSectionNo(sNo);
		setDayOfWeek(day);
		setTimeOfDay(time);
		setRepresentedCourse(course);
		setRoom(room);
		setSeatingCapacity(capacity);

		// �٤��T�w�ѭ���б¥���

		setInstructor(null);

		// �N���U���s����{��

		enrolledStudents = new HashMap<String, Student>();
		assignedGrades = new HashMap<Student, TranscriptEntry>();
	}

	//----------
	// �s����k
	//----------

	public void setSectionNo(int no) {
		sectionNo = no;
	}
	
	public int getSectionNo() {
		return sectionNo;
	}
	
	public void setDayOfWeek(char day) {
		dayOfWeek = day;
	}
	
	public char getDayOfWeek() {
		return dayOfWeek;
	}
		
	public void setTimeOfDay(String time) {
		timeOfDay = time;
	}
	
	public String getTimeOfDay() {
		return timeOfDay;
	}

	public void setInstructor(Professor prof) {
		instructor = prof;
	}
	
	public Professor getInstructor() {
		return instructor;
	}
	
	public void setRepresentedCourse(Course c) {
		representedCourse = c;
	}
	
	public Course getRepresentedCourse() {
		return representedCourse;
	}		

	public void setRoom(String r) {
		room = r;
	}

	public String getRoom() {
		return room;
	}

	public void setSeatingCapacity(int c) {
		seatingCapacity = c;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setOfferedIn(ScheduleOfClasses soc) {
		offeredIn = soc;
	}

	public ScheduleOfClasses getOfferedIn() {
		return offeredIn;
	}	

	//----------
	// ������k
	//----------

	// �ڭ̧Ʊ��� Section �� String ��ܪk�ݰ_�ӹ��o��:
	//
	//	MATH101 - 1 - M - 8:00 AM

	public String toString() {
		return getRepresentedCourse().getCourseNo() + " - " +
		       getSectionNo() + " - " +
		       getDayOfWeek() + " - " +
		       getTimeOfDay();
	}

	// ���㪺�ҵ{�s��, �O�N��ؽs���P�ҵ{�s���걵, �����[�W�s�r��
	// �p "ART101 - 1".

	public String getFullSectionNo() {
		return getRepresentedCourse().getCourseNo() + 
		       " - " + getSectionNo();
	}

	// �ڭ̥H EnrollmentStatus �o�ӦC�|���O�Ǧ^ s �o�� Student ����׵��G.
	// �o�� enum ���ԲӤ��e�аѾ\ EnrollmentStatus.java ��

	public EnrollmentStatus enroll(Student s) {
		// ����, �T�{�o�� Student �٨S���o���,
		// �B�L���e�u�q���v�׹L�o���
		
		Transcript transcript = s.getTranscript();

		if (s.isCurrentlyEnrolledInSimilar(this) || 
		    transcript.verifyCompletion(this.getRepresentedCourse())) {
			return EnrollmentStatus.prevEnroll;
		}

		// �p�G�o��Ҧ�������ױ��󪺸�
		// �N�ˬd Student �O�_�w�g�׹L�o�ǥ��ױ���

		Course c = this.getRepresentedCourse();
		if (c.hasPrerequisites()) {
			for (Course pre : c.getPrerequisites()) {
				// �ˬd Student �� Transcript �O�_�O���F
				// �׹L���ױ��󪺸�T

				if (!transcript.verifyCompletion(pre)) {
					return EnrollmentStatus.prereq;
				}
			}
		}
		
		// �p�G�o��Ҥw�g�B������, �N�ڵ��ǥͿ��
		
		if (!this.confirmSeatAvailability()) {
			return EnrollmentStatus.secFull;
		}
		
		// �p�G�����o�䪺��, �N�N��i�H�������ǥͿ��o��ҤF

		// �Яd�N���V��: �o�� Section �|�z�L HashMap ���� Student �����`
		// �� Student �]�|����o�� Section �����`

		enrolledStudents.put(s.getSsn(), s);
		s.addSection(this);

		return EnrollmentStatus.success;
	}
	
	// �p���u���ȡv��k

	private boolean confirmSeatAvailability() {
		if (enrolledStudents.size() < getSeatingCapacity()) return true;
		else return false;
	}

	public boolean drop(Student s) {
		// �ڭ̥u��h���@�Ӥw�g��׳o��Ҫ��ǥ�

		if (!s.isEnrolledIn(this)) return false;
		else {
			// �b HashMap �̭����ǥ�, �åB�⥦����
			enrolledStudents.remove(s.getSsn());

			// �d�N���V��

			s.dropSection(this);
			return true;
		}
	}

	public int getTotalEnrollment() {
		return enrolledStudents.size();
	}	

	public void display() {
		System.out.println("�ҵ{��T:");
		System.out.println("\t�@�@�Ǵ�:  " + getOfferedIn().getSemester());
		System.out.println("\t��ؽs��:  " + 
				   getRepresentedCourse().getCourseNo());
		System.out.println("\t�ҵ{�s��:  " + getSectionNo());
		System.out.println("\t�W�Үɶ�:  " + getDayOfWeek() + 
				   " �� " + getTimeOfDay());
		System.out.println("\t�W�ұЫ�:  " + getRoom());
		if (getInstructor() != null) 
			System.out.println("\t�½ұб�:  " + 
				   getInstructor().getName());
		displayStudentRoster();
	}
	
	public void displayStudentRoster() {
		System.out.print("\t�`�@�� " + getTotalEnrollment() + 
				   " ��ǥͿ��");

		// �ڭ���ܰT�����覡�P��פH�Ʀ���.
		// (�Яd�N�W���Ϊ��O print �ӫD printf)

		if (getTotalEnrollment() == 0) System.out.println(".");
		else System.out.println(", �p�U:");

		// �v���B�z HashMap �s�񪺩Ҧ����e

		for (Student s : enrolledStudents.values()) {
			System.out.println("\t\t" + s.getName());
		}
	}

	// �p�G�ǥ��٥����즨�Z����, �o�Ӥ�k�N�|�Ǧ^ null

	public String getGrade(Student s) {
		String grade = null;

		// �q assignedGrades �o�� HashMap ���^�ݩ�o�� Student ��
		// TranscriptEntry ����, ���۳z�L�����^���Z

		TranscriptEntry te = assignedGrades.get(s);
		if (te != null) {
			grade = te.getGrade(); 
		}

		// �p�G�S���o�� Student �� TranscriptEntry,
		// �N�H null �ȥN��o�ر���

		return grade;
	}

	public boolean postGrade(Student s, String grade) {
		// ����, �I�s TranscriptEntry ���O���Ѫ����U��k
		// �T�{���Z�O�_�X�z

		if (!TranscriptEntry.validateGrade(grade)) return false;

		// �d�� HashMap �O�_�w���o�� Student,
		// �H�T�O�ڭ̥��e�٥����o�� Student ���L���Z.
		// �p�G�ڭ̵o�{�w�g���L���Z����, �N�Ǧ^ false �N��
		// ���i��\���쥻�����Z.
		// (�i�H�t�~�g�@�� eraseGrade() ��k, �� Professor ���ܤ߷N)

		if (assignedGrades.get(s) != null) return false;

		// ����, �ڭ̫إߤ@�ӷs�� TranscriptEntry ����
		// �d�N�ڭ̶ǤJ�u�o�ӡvSection ���Ѧ�, �]���ڭ̧Ʊ�o��
		// �������p���O�� TranscriptEntry ����P�ɫ��� Section �P
		// Student �����`.
		// (�ڭ̷|�� TranscriptEntry ���غc�l�t�d�N�o�� TranscriptEntry
		//  �s�쥿�T�� Transcript ����)

		TranscriptEntry te = new TranscriptEntry(s, grade, this);

		// ���ۧڭ̡u�O�U�v�o�Ӧ��Z,
		// �]���ڭ̧Ʊ� TranscriptEntry �P Section �����O���V�s��

		assignedGrades.put(s, te);

		return true;
	}
	
	public boolean isSectionOf(Course c) {
		if (c == representedCourse) return true;
		else return false;
	}
}
