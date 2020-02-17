// TranscriptEntry.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// �o�O�ӡu�ҫ��v���O


public class TranscriptEntry {
	//------
	// �ݩ�
	//------

	private String grade;
	private Student student;
	private Section section;
	private Transcript transcript;

	//--------
	// �غc�l
	//--------

	public TranscriptEntry(Student s, String grade, Section se) {
		this.setStudent(s);
		this.setSection(se);
		this.setGrade(grade);

		// ���o�ǥͪ����Z�� ...

		Transcript t = s.getTranscript();

		// ... �M�� Transcript �P TranscriptEntry ���V�s���_��

		this.setTranscript(t);
		t.addTranscriptEntry(this);
	}

	//----------
	// �s����k
	//----------

	public void setStudent(Student s) {
		student = s;
	}

	public Student getStudent() {
		return student;
	}

	public void setSection(Section s) {
		section = s;
	}

	public Section getSection() {
		return section;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGrade() {
		return grade;
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
	
	// �U���o��Ӥ�k�ŧi���R�A��k, �]���i�����U��k�ϥ�

	public static boolean validateGrade(String grade) {
		boolean outcome = false;

		if (grade.equals("F") ||
		    grade.equals("I")) {
			outcome = true;
		}

		if (grade.startsWith("A") ||
		    grade.startsWith("B") ||
		    grade.startsWith("C") ||
		    grade.startsWith("D")) {
			if (grade.length() == 1) outcome = true;
			else if (grade.length() == 2) {
				if (grade.endsWith("+") ||
				    grade.endsWith("-")) {
					outcome = true;
				}
			}
		}

		return outcome;
	}

	public static boolean passingGrade(String grade) {
		boolean outcome = false;

		// ����, �T�{���Z�X�z

		if (validateGrade(grade)) {
			// ���ۧP�_���Z�O�_�� D ��

			if (grade.startsWith("A") ||
			    grade.startsWith("B") ||
			    grade.startsWith("C") ||
			    grade.startsWith("D")) {
				outcome = true;
			}
		}

		return outcome;
	}
}
