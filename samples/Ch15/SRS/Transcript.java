// Transcript.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// �o�O�ӡu�ҫ��v���O


import java.util.ArrayList;

public class Transcript {
	//------
	// �ݩ�
	//------

	private ArrayList<TranscriptEntry> transcriptEntries; 
	private Student studentOwner;

	//--------
	// �غc�l
	//--------

	public Transcript(Student s) {
		setStudentOwner(s);

		// �ڭ̱N���U�Ϊ��s����{��

		transcriptEntries = new ArrayList<TranscriptEntry>();
	}

	//----------
	// �s����k
	//----------

	public void setStudentOwner(Student s) {
		studentOwner = s;
	}

	public Student getStudentOwner() {
		return studentOwner;
	}

	//----------
	// ������k
	//----------

	public boolean verifyCompletion(Course c) {
		boolean outcome = false;

		// �v���B�z�Ҧ��� TranscriptEntries,
		// �M���ݩ���w Course �� Section ����

		for (TranscriptEntry te : transcriptEntries) {
			Section s = te.getSection();

			if (s.isSectionOf(c)) {
				// �T�{���Z�ή�

				if (TranscriptEntry.passingGrade(te.getGrade())) {
					outcome = true;

					// �ڭ̧��F, �ҥH�i�H�פ�j��

					break;
				}
			}
		}

		return outcome;
	}

	public void addTranscriptEntry(TranscriptEntry te) {
		transcriptEntries.add(te);
	}

	public void display() {
		System.out.println(getStudentOwner().toString() + " �����Z��:");

		if (transcriptEntries.size() == 0) {
			System.out.println("\t(�L���)");
		}
		else for (TranscriptEntry te : transcriptEntries) {
			Section sec = te.getSection();

			Course c = sec.getRepresentedCourse();

			ScheduleOfClasses soc = sec.getOfferedIn();

			System.out.println("\t�@�@�Ǵ�: " +
					   soc.getSemester());
			System.out.println("\t��ؽs��: " +
					   c.getCourseNo());
			System.out.println("\t�@�Ǥ���: " +
					   c.getCredits());
			System.out.println("\t�@�@���Z: " +
					   te.getGrade());
			System.out.println("\t-----");
		}
	}
}
