// SRS.java - Chapter 16, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// ���O�C�� SRS ���D�X�ʵ{��, �w�[�W����s��\��H�ιϧΤ���


import java.util.*;

public class SRS {
	// �ڭ̥i�H�N�D���O����������s���ŧi�� public static �ݩ�
	// �o�˴N����إߤF�u����v���; �i�b SRS ���ε{�����䥦�a��
	// �H SRS.collectionName �� SRS.faculty ���g�k�����s��.

	public static Faculty faculty; 
	public static CourseCatalog courseCatalog; 
	public static ScheduleOfClasses scheduleOfClasses;

	// �ڭ̤��إ� Student ���󪺸s��, �]���ڭ̤@���u�B�z�@��ǥ� --
	// �]�N�O�ثe�n�J���ǥ�.

	public static void main(String[] args) {
		// ��l�ƩҦ�����.  �ڭ� (�b�o��V��r��) �s����ƪ��ʧ@
		// �]������ SRSDataAccess ��Ƽh���U���O���t�G,
		// �����ε{���ӻ��O�����z����.

		// �ڭ̨ϥΦۭq�ҥ~ ...

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

		// �إߨ���� GUI �D����

		new MainFrame();
	}
}
