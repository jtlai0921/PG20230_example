// SRSDataAccess.java - Chapter 15, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// �u��Ʀs���h�v���O


// ��Ҧ�����s��Ӹ`�ʸ˦b�o�����O��, �N�i�H�b�@���W�ݭn�ק�o�ǳ������ɭ�, ������ε{��
// ����������̧C; ��p��, �o�i�H²�Ƶy����������p����Ʈw�޳N���L�{.

import java.io.*;
import java.util.*;

public class SRSDataAccess {
	// �ڭ̫ŧi String �ܼ�, �w�m�ڭ̻ݭn�s����������ɦW
	// ���O��ڪ��ɦW�s��b�~���ݩ��ɤ�, �ӫD�g���b�o��
	// �y�����L, �o�ӧ@�k�i���ڭ̥��ӻ����ק��ɮת��W��/���|, �����ק�{���X

	// �Ҫ�w�q�b�@���ɮפ���:

	private static String scheduleFileName;

	// ��¾���h�Ѩ���ɮשw�q:

	private static String facultyFileName;
	private static String assignmentsFileName; 

	// ��زM��]�Ѩ���ɮשw�q:

	private static String courseFileName;
	private static String prereqFileName;

	// �ڭ̤��ݬ��ǥ͸���ɫŧi static String �ݩ�,
	// �]���b�ǥ͵n�J���ɭԷ|�Y�ɱ��ɥX�ɦW,
	// �@�k�O�N�ǥͪ� ID �����[�W ".dat" �����ɦW

	// �q�~���ݩ���Ū�J�������ɦW
	// "static" �{���X�϶��u�|�b JVM ����ɭ������J�~�]���O���줸�X����
	// ����@�� (���Ҥ��O SRSDataAccess ���O)

	static {
		try {
			Properties fileNames = new Properties();
			fileNames.load(new FileInputStream("FileNames.properties"));

			facultyFileName = fileNames.getProperty("facultyFile");
			assignmentsFileName = fileNames.getProperty("assignmentsFile");
			courseFileName = fileNames.getProperty("courseFile");
			prereqFileName = fileNames.getProperty("prereqFile");
			scheduleFileName = fileNames.getProperty("scheduleFile");
		}
		catch (IOException e) {
			// �p�G�䤣���ݩ��ɪ���, �N������{��

			System.out.println("���~: �L�kŪ�� FileNames.properties �� " +
				"-- �A��!");
			System.exit(0);
		}
	}

	// ��l�� Faculty �s��
	// �Яd�N, �ڭ̥H�ۭq���ҥ~���O�q���b�H�ä[�x�s�]�ƪ���ơu���ءv�����
	// �J�쪺�U�ؿ��~����

	public static Faculty initializeFaculty() throws SRSInitializationException {
		Faculty faculty = new Faculty();
		String line = null;
		BufferedReader bIn = null;

		try {
			// �}�ҲĤ@���ɮ�
			bIn = new BufferedReader(new FileReader(facultyFileName));

			line = bIn.readLine();
			while (line != null) {
				// �ڭ̱N�� TAB �Ϲj��쪺�O�������|���ݩ� --
				// name, ssn, title, �P dept
				// �M��I�s Professor �غc�l�y�X�s���б�

				StringTokenizer st = new StringTokenizer(line, "\t");

				// �p�G���ƥؤ��諸��, �N�^�����~

				if (st.countTokens() != 4) {
					throw new SRSInitializationException(
						"�ɮ׮榡���~ -- �b " + 
						facultyFileName +
						" �ɮפ����O�� -- |" + 
						line + "| -- ���Ӧ� 4 ����� ");
				}
				else {
					String name = st.nextToken();
					String ssn = st.nextToken();
					String title = st.nextToken();
					String dept = st.nextToken();

					// �إߤ@�� Professor ����æs�J�s��

					Professor p = new Professor(name, ssn, title, dept);
					faculty.addProfessor(p);
				}
				
					line = bIn.readLine();
			}

			bIn.close();
		}
		catch (IOException i) { 
			throw new SRSInitializationException("�s�� " + 
				facultyFileName + " �ɮ׮ɵo�Ϳ��~");
		}

		// �B�z�ĤG���ɮ�, �]�N�O�t�d���ª����

		try {
			// ���}�ɮ�
			bIn = new BufferedReader(
				new FileReader(assignmentsFileName));

			line = bIn.readLine();
			while (line != null) {
				// �ڭ̱N�� TAB �Ϲj��쪺�O�����ӭ�,
				// ���O�O�бª����|�O�I���X, �H�έt�d���ª��ҵ{�s��

				StringTokenizer st = new StringTokenizer(
					line, "\t");

				// �p�G���ƥؤ��諸��, �N�^�����~

				if (st.countTokens() != 2) {
					throw new SRSInitializationException(
						"�ɮ׮榡���~ -- �b " + 
						assignmentsFileName +
						" �ɮפ����O�� -- |" + 
						line + "| -- ���Ӧ� 2 ����� ");
				}
				else {
					String ssn = st.nextToken();

					// ����ҵ{�s���O��ؽs���P�ҵ{�s��
					// �γs�r�����b�@�_, ���O "ART101 - 1"

					String fullSectionNo = st.nextToken();

					// �q�A���s���d�߳o��Ӫ���.
					// �Яd�N, �ѩ�� scheduleOfClasses
					// �ŧi�� public static �ݩʪ��t�G,
					// �]���o��u�@�ä�������!

					Professor p = faculty.findProfessor(ssn); 
					Section s = SRS.scheduleOfClasses.
						findSection(fullSectionNo); 

					// �u�n�ڭ̧�� Professor �P Section,
					// �N�S���D�F

					if (p != null && s != null) p.agreeToTeach(s);
				}

				line = bIn.readLine();
			}

			bIn.close();
		}
		catch (IOException i) { 
			throw new SRSInitializationException("�s�� " + 
				assignmentsFileName + " �ɮ׮ɵo�Ϳ��~");
		}

		// �p�G�ڭ̧����S�� Faculty �إߥ��󶵥ت���,
		// �N�|�q���o�Ӱ��D

		if (faculty.isEmpty()) {
			throw new SRSInitializationException("�إ߱�¾����Ʈ�" + 
				"�o�Ϳ��~");
		}

		// �p�G�ڭ̰���ܦ��S����X����ҥ~����, �N�N��
		// �ڭ̤w�g��n�F�u�X�ʡvSRS �һݪ� Faculty ����

		return faculty;
	}

	// �� CourseCatalog �]�w���. �Яd�N, �ڭ̱N�H�ۭq���ҥ~���O�^������
	// ��l�ƹL�{���J�쪺���~ (�P Faculty ���@�k�@��)

	public static CourseCatalog initializeCourseCatalog() 
		throws SRSInitializationException {
		CourseCatalog catalog = new CourseCatalog();
		String line = null;
		BufferedReader bIn = null;

		try {
			// �}���ɮ�
			bIn = new BufferedReader(new FileReader(courseFileName));

			line = bIn.readLine();
			while (line != null) {
				// �ڭ̱N�� TAB �Ϲj��쪺�O����T���ݩ� --
				// courseNo, courseName, �P credits
				// �M��I�s Course �غc�l�إ߷s����ت���

				StringTokenizer st = new StringTokenizer(line, "\t");

				// �p�G���ƥؤ��諸��, �N�^�����~

				if (st.countTokens() != 3) {
					throw new SRSInitializationException(
						"�ɮ׮榡���~ -- �b " + 
						courseFileName +
						" �ɮפ����O�� -- |" + 
						line + "| -- ���Ӧ� 3 ����� ");
				}
				else {
					String courseNo = st.nextToken();
					String courseName = st.nextToken();
					String creditValue = st.nextToken();

					// �ڭ̥����N�̫�@�ӭ��ন�Ʀr,
					// ���ɥH Double ���O���R�A��k�i���ഫ

					double credits = -1.0;
					try {
						credits = Double.parseDouble(creditValue);
					}
					catch (NumberFormatException nfe) {
						throw new SRSInitializationException(
							"�ɮ׮榡���~ -- �b " +
							courseFileName + 
							" �ɮפ����O�� -- |" + 
							line + "| -- �t�����X�k���Ǥ���");
					}

					// �̫�, �I�s Course �غc�l�إ߹����� Course ����,
					// �ç⥦�s��s������

					Course c = new Course(courseNo, courseName, credits);
					catalog.addCourse(c);
				}
				
				line = bIn.readLine();
			}

			bIn.close();
		}
		catch (IOException i) { 
			throw new SRSInitializationException("�s�� " + 
				courseFileName + " �ɮ׮ɵo�Ϳ��~");
		}

		// �B�z�ĤG���ɮ�, �o���ɮשw�q�F��ؤ������������Y

		try {
			// �}���ɮ�
			bIn = new BufferedReader(
				new FileReader(prereqFileName));

			line = bIn.readLine();
			while (line != null) {
				// �ڭ̱N�� TAB �Ϲj��쪺�O�����ӭ�,
				// ���O�O "A" ��ت��s���P "B" ��ت��s��
				// �o�N�� A �O B �����׬�ؤ��@

				StringTokenizer st = new StringTokenizer(line, "\t");

				// �p�G���ƥؤ��諸��, �N�^�����~

				if (st.countTokens() != 2) {
					throw new SRSInitializationException(
						"�ɮ׮榡���~ -- �b " + 
						prereqFileName +
						" �ɮפ����O�� -- |" + 
						line + "| -- ���Ӧ� 2 ����� ");
				}
				else {
					String courseNoA = st.nextToken();
					String courseNoB = st.nextToken();

					// �b CourseCatalog �����j�M�o��Ӭ��

					Course a = catalog.findCourse(courseNoA); 
					Course b = catalog.findCourse(courseNoB); 

					// �p�G����̪���, �N�N a �]�� b �����׬��

					if (a != null && b != null) {
						b.addPrerequisite(a);
					}
				}

				line = bIn.readLine();
			}

			bIn.close();
		}
		catch (IOException i) { 
			throw new SRSInitializationException("�s�� " + 
				prereqFileName + " �ɮ׮ɵo�Ϳ��~");
		}

		// �p�G�ڭ̨S���إߥ���Ҫ��ت���, �N�N���^�������~����

		if (catalog.isEmpty()) {
			throw new SRSInitializationException("��l�Ƭ�ظ�T��" + 
				"�o�Ϳ��~");
		}

		// �p�G�ڭ̰���즹, �S����X����ҥ~����, �N�N��ڭ̦��\�إߤF
		// �u�X�ʡvSRS �һݪ� CourseCatalog ����

		return catalog;
	}

	// ��l�� ScheduleOfClasses. �Яd�N�ڭ̥ΤF�ۭq�ҥ~���O
	// �q���U�ت�l�ƹL�{�������~ (�P Faculty �@��)

	public static ScheduleOfClasses initializeScheduleOfClasses(String semester) 
		throws SRSInitializationException {
		ScheduleOfClasses soc = new ScheduleOfClasses(semester);
		String line = null;
		BufferedReader bIn = null;

		try {
			// �}���ɮ�
			bIn = new BufferedReader(new FileReader(scheduleFileName));

			line = bIn.readLine();
			while (line != null) {
				// �ڭ̭n�N TAB �Ϲj��쪺�O��������ݩ� --
				// courseNo, sectionNo, dayOfWeek, timeOfDay, room, 
				// �H�� capacity.  �ڭ̱N�H courseNo �d�߹����� Course ����,
				// �M��I�s scheduleSection() ��k�y�X�s�� Section ����.

				StringTokenizer st = new StringTokenizer(line, "\t");

				// �p�G���Ƥ����󤻪���, �N�q�����~

				if (st.countTokens() != 6) {
					throw new SRSInitializationException(
						"�ɮ׮榡���~ -- �b " + 
						scheduleFileName +
						" �ɮפ����O�� -- |" + 
						line + "| -- ���Ӧ� 6 ����� ");
				}
				else {
					String courseNo = st.nextToken();

					// �ڭ̥����N�U�@�ӭȱq String �ন int
					//
					String sectionNumber = st.nextToken();
					int sectionNo = -1;
					try {
						sectionNo = Integer.parseInt(sectionNumber);
					}
					catch (NumberFormatException nfe) {
						throw new SRSInitializationException(
							"�ɮ׮榡���~ -- �b " +
							scheduleFileName + 
							" �ɮפ����O�� -- |" + 
							line + "| -- �t�����X�k���ҵ{�s��");
					}

					String dayOfWeek = st.nextToken();
					String timeOfDay = st.nextToken();
					String room = st.nextToken();
					
					// �ڭ̥����N�U�@�ӭȱq String �ন int

					String capacityValue = st.nextToken();
					int capacity = -1;
					try {
						capacity = Integer.parseInt(capacityValue);
					}
					catch (NumberFormatException nfe) {
						throw new SRSInitializationException(
							"�ɮ׮榡���~ -- �b " +
							scheduleFileName + 
							" �ɮפ����O�� -- |" + 
							line + "| -- �t�����X�k���y��e�q");
					}

					// �b��زM�椺�d�߹����� Course ����
					// (�� courseCatalog ���� SRS ���O�� public static �ܼ�
					//  �b�o�ɴN�ܤ�K�F!)

					Course c = SRS.courseCatalog.findCourse(courseNo);

					// �إ� Section ���� ...

					Section s = new Section(
						sectionNo, dayOfWeek.charAt(0), 
						timeOfDay, c, room, capacity);

					// ... �N�����Ҫ� ...

					String key = courseNo + " - " + s.getSectionNo();
					soc.addSection(s);

					// ... �M��N���s�W Course
					c.addSection(s);
				}
				
				line = bIn.readLine();
			}

			bIn.close();
		}
		catch (IOException i) { 
			throw new SRSInitializationException("�s�� " + 
				scheduleFileName + " �ɮ׮ɵo�Ϳ��~");
		}

		// �p�G�ڭ̳̫�å��إߥ��� Section ���ت���, �N�^���o�Ӱ��D

		if (soc.isEmpty()) {
			throw new SRSInitializationException("��l��" + 
				"�Ҫ��T�ɵo�Ϳ��~");
		}

		// �p�G�ڭ̰����o��, �S����X����ҥ~����,
		// �N�N��ڭ̶�n�u�X�ʡv SRS �һݪ� ScheduleOfClasses ����F

		return soc;
	}

	// ��l�Ƥ@�� Student.  �o��ڭ̤@�˥Φۭq���ҥ~���O -- InvalidStudentException
	// �q���U�رq�ä[�x�s�]�ƨ��^�ǥ͸�ƮɹJ�쪺���D; 
	// ���O SRSInitializationException ���l�ͫ��O���@.

	public static Student initializeStudent(String sId) throws InvalidStudentException {
		// �����إߤ@�ӡu�Ŵߡv Student ����, �M��յ۱q�������ɮ� (�p 111-11-1111.dat)
		// Ū�X Student �����.

		Student s = new Student("?");

		String line = null;
		BufferedReader bIn = null;

		// �����ɦW

		String pathToFile = sId + ".dat";

		try {
			// �}���ɮ�

			bIn = new BufferedReader(new FileReader(pathToFile));

            // �o���ɮת��}�Y�O�s��ǥͰ򥻸�� (���|�O�I���X, �m�W����),
            // ���۬O 0 �Φh���N��o��ǥͥثe��׽ҵ{���O��

			line = bIn.readLine();

			if (line == null) {
				// �z�L�ۭq�ҥ~���O�^�����~

				throw new InvalidStudentException("�ɮ׮榡�����T: " +
					pathToFile);
			}

			// �ڭ̱N��D�O���ѪR���|���ݩ� -- ssn, name, major �P degree

			StringTokenizer st = new StringTokenizer(line, "\t");

			// �p�G���ƥؤ��諸��, �N�N���^�����~

			if (st.countTokens() != 4) {
				// �z�L�ۭq�ҥ~���O�^���o�ӿ��~

				throw new InvalidStudentException("�b " + pathToFile + 
					"�ɮפ����O�� |" + line + "| �榡�����T");
			}

			// ���o�ӭ�إߪ� Student �����J�q�ɮ�Ū�쪺���

			s.setSsn(st.nextToken());
			s.setName(st.nextToken());
			s.setMajor(st.nextToken());
			s.setDegree(st.nextToken());

			// �ɮת��Ѿl���e (�p�G������) �N��ǥͥ��e�n�J SRS �t�ή�
			// ��ת��Ҧ��ҵ{.

			// �p�G�ɮפ��S�����O������,
			// "while" �j��N�������|����

			line = bIn.readLine();
			while (line != null) {
				// ����ҵ{�s���O�Ѭ�ؽs���P�ҵ{�s���s���Ӧ�,
				// �����[�W�s�r��, �p "ART101 - 1";

				// �ޱ��e�᪺�ťզr��, �M��H�ҵ{�s���q SRS ���Ҫ���^
				// ������ Section ����; SRS ���Ҫ�O SRS ���O
				// �ŧi�� public static ���ݩ�.

				String fullSectionNo = line.trim();
				Section sec = SRS.scheduleOfClasses.findSection(
					fullSectionNo);

				// �d�N�ڭ̥H Section ���O�� enroll ��k,
				// �T�O Student �P Section �����إ����V�s��

				if (sec != null) sec.enroll(s);

				line = bIn.readLine();
			}

			bIn.close();
		}
		catch (IOException i) {
			// �H�ۭq�ҥ~���O�^�����D

			throw new InvalidStudentException("�s�� " + 
				pathToFile + " �ɮ׮ɵo�Ϳ��~");
		}

		// �p�G�ڭ̰����o��, �S����X����ҥ~����, �N�N��ڭ̦��\�a
		// �إߤ@�ӥN��n�J SRS ���ǥͪ� Student ����F

		return s;
	}

	// �s�� Student �����A. �o�Ӥ�k�|�b�ǥ͵n�X�t�Ϊ��ɭ�, �N�o��ǥͪ�
	// ��T�����g�^������ ssn.dat �ɮפ�.
	// �ڭ̦P�˦b���H�ۭq���ҥ~���O -- StudentPersistenceException �^�����D

	public static void persistStudent(Student s) throws StudentPersistenceException {
		FileOutputStream fos = null;
		PrintWriter pw = null;
		
		// ���ɥX�ڭ̭n�g�J���ɦW
		String pathToFile = s.getSsn() + ".dat";

		try {
			// ���իإ� ssn.dat ��. �Яd�N, �p�G�w�g���P�W�ɮת���,
			// �{�����ɮ״N�|�Q�u�л\�v��, �o���O�ڭ̧Ʊ檺�@�k

			fos = new FileOutputStream(pathToFile);
			pw = new PrintWriter(fos);

			// ����, �H TAB �Ϲj��쪺�Φ���X�D�O��/���Y

			pw.println(s.getSsn() + "\t" + s.getName() + "\t" +
				   s.getMajor() + "\t" + s.getDegree());

			// ���۬��o�� Student ��ת��Ҧ� Section
			// ���O��X�@�����O��

			Collection<Section> sections = s.getEnrolledSections();
			for (Section sec : sections) {
				pw.println(sec.getFullSectionNo());
			}

			pw.close();
		}
		catch (IOException e) {
			// �^���J����~
			
			throw new StudentPersistenceException("�b�N�ǥ͸�T�s�� " +
				pathToFile + " �ɮ׮ɵo�Ϳ��~");
		}
	}
}
