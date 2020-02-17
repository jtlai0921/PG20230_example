// SRS.java - Chapter 15, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// ���O�C�� SRS ���D�X�ʵ{��, �w�[�W����s��\��

import java.util.*;

public class SRS {
	// �ڭ̥i�H�N�D���O����������s���ŧi�� public static �ݩ�
	// �o�˴N����إߤF�u����v���; �i�b SRS ���ε{�����䥦�a��
	// �H SRS.collectionName �� SRS.faculty ���g�k�����s��.

	// �ڭ̱N�� 14 ���ŧi�� ArrayList ���X�Ӹs���ʸ˦� Faculty �P 
	// CourseCatalog ���M�θs��, �����̧��H�@�I.
	//
	//	public static ArrayList<Professor> faculty; 
	//	public static ArrayList<Course> courseCatalog; 
	//
	// (ScheduleOfClasses �h�O�@�}�l�N�o�򰵤F)

	public static Faculty faculty; 
	public static CourseCatalog courseCatalog; 
	public static ScheduleOfClasses scheduleOfClasses;

	// �ڭ̤��إ� Student ���󪺸s��, �]���ڭ̤@���u�B�z�@��ǥ� --
	// �]�N�O�ثe�n�J���ǥ�.

	public static void main(String[] args) {
		// ��l�ƩҦ�����. �ѩ�ɤJ SRSDataAccess �o�Ӹ�Ƽh���U���O���t�G, 
		// �ҥH�ڭ� (�q ASCII ��r��) �s����ƪ��覡��o�����ε{���ӻ��O
		// �����u�z���v��.

		// �ڭ̥H�ۭq���ҥ~���O�q���b�H�ä[�x�s�]�ƪ���ƭ��ت����
		// �J�쪺�U�ذ��D.

		try {
			// �إ߳o�Ǫ��󪺶��ǫܭ��n:
			// �إ� ScheduleOfClasses ���ɭԻݭn�Ψ�{���� CourseCatalog,
			// �إ� Faculty ���ɭԻݭn�Ψ�{���� ScheduleOfClasses.

			courseCatalog = SRSDataAccess.initializeCourseCatalog();
			scheduleOfClasses = 
				SRSDataAccess.initializeScheduleOfClasses("SP2005");
			faculty = SRSDataAccess.initializeFaculty();
		}
		catch (SRSInitializationException e) {
			System.out.println("���~:  " + e.getMessage() + "-- �A��!");
			System.exit(0);	
		}

        // ���ڭ̩I�s�U�� display ��k, �ݬݬO���O�Ҧ��F�賣�ئn�F

		System.out.println("====================");
		System.out.println("��زM��:");
		System.out.println("====================");
		System.out.println();
		courseCatalog.display();

		System.out.println("====================");
		System.out.println("�Ҫ�:");
		System.out.println("====================");
		System.out.println();
		scheduleOfClasses.display();

		System.out.println("====================");
		System.out.println("��¾����T:");
		System.out.println("====================");
		System.out.println();
		faculty.display();

        // �����@��ǥ͵n�J. �d�N�o��ǥͦb ssn.dat �ɮפ��w�g��פF
		// �X�Ӥ��P���ҵ{ (�Ա��аѾ\ 111-11-1111.dat �ɮ�)

		Student student = null;

		// �ڭ̥H�ۭq���ҥ~���O�q���b�H�ä[�x�s�]�ƪ���ƭ��ت����
		// �J�쪺�U�ذ��D.

		try {
			student = SRSDataAccess.initializeStudent("111-11-1111");
		}
		catch (InvalidStudentException e) {
			System.out.println("���~:  " + e.getMessage() + "-- �A��!");
			System.exit(0);	
		}

		// �^�U�ǥͪ��{����T

		System.out.println("===========================");
		System.out.println("��סu���e�v���ǥ͸�T:");
		System.out.println("===========================");
		System.out.println();
		student.display();

		// �����ǥͿ�ץt�@��ҵ{

		Section sec = scheduleOfClasses.findSection("ART101 - 1");
		sec.enroll(student);

		// �^�U�ǥͧ�s�᪺��T

		System.out.println("==========================");
		System.out.println("��סu����v���ǥ͸�T:");
		System.out.println("==========================");
		System.out.println();
		student.display();

		// �����ǥ͵n�X, �H�K�N�ǥ��ܰʹL���ҷ~�t���s�^�ɮ�
		// (�z�i�˵� 111-11-1111.dat �ɮת����e, �ݬݦ��S���Q�ק�L)

		try {
			SRSDataAccess.persistStudent(student);  
		}
		catch (StudentPersistenceException e) {
			System.out.println("���~:  " + e.getMessage() + "-- �A��!");
			System.exit(0);	
		}

		// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
		// * �b����o�ӵ{�����e, �аO�o�H reset.bat �N 111-11-1111.dat �����
		// * �����e��_�쪬.
		// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	}
}
