// SRS.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// ���O�C�� SRS ���D�X�ʵ{��


import java.util.ArrayList;

public class SRS {
	// �ڭ̥i�H�N�D���O����������s���ŧi�� public static �ݩ�
	// �o�˴N����إߤF�u����v���

	public static ArrayList<Professor> faculty; 
	public static ArrayList<Student> studentBody; 
	public static ArrayList<Course> courseCatalog; 

	// �U���o�Ӧs��F Section ����ѦҪ��s��, �ѩ�ڭ̥H UML �� SRS ��Ҫ�
	// ���G�ϵM, �ʸ˦b�@�ӯS��γ~�����O����; �Яd�N, �ڭ̨��]��H�ۦP�覡
	// �ʸˤW���o�T�Ӹs��, �ӧڭ̦b�� 15 ���]���T�|�o��.

	public static ScheduleOfClasses scheduleOfClasses = 
		      new ScheduleOfClasses("SP2005");
	
	public static void main(String[] args) {
		Professor p1, p2, p3;
		Student s1, s2, s3;
		Course c1, c2, c3, c4, c5;
		Section sec1, sec2, sec3, sec4, sec5, sec6, sec7;

		// �I�s�غc�l�إߦU�ت��� (�ڭ̳q�`�|�q��Ʈw���ɮפ�
		// Ū���o����� ...)

		// ------
		// �б¸s
		// ------

		p1 = new Professor("Jacquie Barker", "123-45-6789", 
				   "Adjunct Professor", "Information Technology");		

		p2 = new Professor("John Smith", "567-81-2345",
				   "Full Professor", "Chemistry");		

		p3 = new Professor("Snidely Whiplash", "987-65-4321",
				   "Full Professor", "Physical Education");		

		// �N���̩�i������ ArrayList ��

		faculty = new ArrayList<Professor>();
		faculty.add(p1);
		faculty.add(p2);
		faculty.add(p3);

		// ----
		// �ǥ�
		// ----
		
		s1 = new Student("Joe Blow", "111-11-1111", "Math", "M.S.");

		s2 = new Student("Fred Schnurd", "222-22-2222", 
				 "Information Technology", "Ph. D.");

		s3 = new Student("Mary Smith", "333-33-3333", "Physics", "B.S.");

		// �N���̩�i������ ArrayList ��

		studentBody = new ArrayList<Student>();
		studentBody.add(s1);
		studentBody.add(s2);
		studentBody.add(s3);

		// ----
		// ���
		// ----
		
		c1 = new Course("CMP101",
				"Beginning Computer Technology", 3.0);

		c2 = new Course("OBJ101", 
				"Object Methods for Software Development", 3.0);

		c3 = new Course("CMP283", 
				"Higher Level Languages (Java)", 3.0);

		c4 = new Course("CMP999",
				"Living Brain Computers", 3.0);

		c5 = new Course("ART101",
				"Beginning Basketweaving", 3.0);

		// �N���̩�i������ ArrayList ��

		courseCatalog = new ArrayList<Course>();
		courseCatalog.add(c1);
		courseCatalog.add(c2);
		courseCatalog.add(c3);
		courseCatalog.add(c4);
		courseCatalog.add(c5);

		// �إߤ@�ǥ��ױ��� (c1 => c2 => c3 => c4).

		c2.addPrerequisite(c1);
		c3.addPrerequisite(c2);
		c4.addPrerequisite(c3); 

		// ----
		// �ҵ{
		// ----

		// �I�s Course �� scheduleSection ��k,
		// �H�K���U�� Course �Ʃw�W�Үɶ�
		// (���|�b�����I�s Section ���غc�l)

		sec1 = c1.scheduleSection('M', "8:10 - 10:00 PM", "GOVT101", 30);

		sec2 = c1.scheduleSection('W', "6:10 - 8:00 PM", "GOVT202", 30);

		sec3 = c2.scheduleSection('R', "4:10 - 6:00 PM", "GOVT105", 25);

		sec4 = c2.scheduleSection('T', "6:10 - 8:00 PM", "SCI330", 25);

		sec5 = c3.scheduleSection('M', "6:10 - 8:00 PM", "GOVT101", 20);

		sec6 = c4.scheduleSection('R', "4:10 - 6:00 PM", "SCI241", 15);
		
		sec7 = c5.scheduleSection('M', "4:10 - 6:00 PM", "ARTS25", 40);
		
		// �N�o�ǽҵ{�[�i�Ҫ�

		scheduleOfClasses.addSection(sec1);
		scheduleOfClasses.addSection(sec2);
		scheduleOfClasses.addSection(sec3);
		scheduleOfClasses.addSection(sec4);
		scheduleOfClasses.addSection(sec5);
		scheduleOfClasses.addSection(sec6);
		scheduleOfClasses.addSection(sec7);

		// �u�αб¬��o�ǽҵ{�½�

		p3.agreeToTeach(sec1);
		p2.agreeToTeach(sec2);
		p1.agreeToTeach(sec3);
		p3.agreeToTeach(sec4);
		p1.agreeToTeach(sec5);
		p2.agreeToTeach(sec6);
		p3.agreeToTeach(sec7);

		System.out.println("====================");
		System.out.println("�ǥͶ}�l��׽ҵ{�F�I");
		System.out.println("====================");
		System.out.println();

		// �����ǥ͹��տ�צU�`�ҵ{������

		System.out.println("�ǥ� " + s1.getName() + 
				   " ���տ�� " +
				   sec1.toString());

		EnrollmentStatus status = sec1.enroll(s1);
		reportStatus(status);

		// �d�N�o��ΤF�S���u���ȡv��k reportStatus() ��Ū����ܿ�׵��G.
		// �ڭ̤]�i�H��W����浲�X���@��:
		//
		//	reportStatus(sec1.enroll(s1));
		//
		// �ӥѩ� println() �]�|�I�s�ܦh��, �]���ڭ̤]��g�@�ӧ�������u���ȡv
		// ��k, �H�K�N�W���o�T���ԭz�������X���@��:
		//
		//      attemptToEnroll(s1, sec1);
		// 
		// �ӧڭ̪��T�]�|�o��, �y��N�|�b�{���̭���γo�ӧ�²�䪺�g�k.

		// �������@�� Student �P�ɿ�סu�P�@�ӡv Course �����P Section --
		// �o���ӵL�k���\

		attemptToEnroll(s1, sec2);

		// �o�ӿ�װʧ@���ӨS���D ...

		attemptToEnroll(s2, sec2);

		// ... ���O�o�Ӿǥ��٥��������ױ���, �ҥH������ӷ|�Q�^��

		attemptToEnroll(s2, sec3);

		// �o�ǿ�װʧ@���ӨS���D

		attemptToEnroll(s2, sec7);
		attemptToEnroll(s3, sec1);

		// �ЮJ���w����, �u���\�v���Ҫ����η|�O�o��:
		//
		// sec1: s1, s3
		// sec2: s2
		// sec7: s2

		// �Ǵ������F (�z, �ٯu��!)
		// �б¬��U�Ӿǥͥ����Z

		sec1.postGrade(s1, "C+");
		sec1.postGrade(s3, "A");
		sec2.postGrade(s2, "B+");
		sec7.postGrade(s2, "A-");

		// ���ڭ̩I�s�U�� display() ��k,
		// �ݬݬO���O�@�������Q�B�@
	
		System.out.println("=====");
		System.out.println("�Ҫ�:");
		System.out.println("=====");
		System.out.println();
		scheduleOfClasses.display();

		System.out.println("=========");
		System.out.println("�б¸�T:");
		System.out.println("=========");
		System.out.println();
		p1.display();
		p2.display();
		p3.display();

		System.out.println("=========");
		System.out.println("�ǥ͸�T:");
		System.out.println("=========");
		System.out.println();
		s1.display();
		s2.display();
		s3.display();
	}

	// �d�N�o�O�Өp�������Ȥ�k ...

	private static void reportStatus(EnrollmentStatus s) {
		System.out.println("���A: " + s.value());
		System.out.println();
	}

	// ... �ӳo�]�O.

	private static void attemptToEnroll(Student s, Section sec) {
		System.out.println("�ǥ� " + s.getName() + 
				   " ���տ�� " +
				   sec.toString());

		// �b�@�Ӥ��Ȥ�k�������Υt�@�Ӥ��Ȥ�k!
		reportStatus(sec.enroll(s));
	}
}
