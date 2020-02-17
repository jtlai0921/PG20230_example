// TranscriptEntry.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 這是個「模型」類別


public class TranscriptEntry {
	//------
	// 屬性
	//------

	private String grade;
	private Student student;
	private Section section;
	private Transcript transcript;

	//--------
	// 建構子
	//--------

	public TranscriptEntry(Student s, String grade, Section se) {
		this.setStudent(s);
		this.setSection(se);
		this.setGrade(grade);

		// 取得學生的成績單 ...

		Transcript t = s.getTranscript();

		// ... 然後 Transcript 與 TranscriptEntry 雙向連結起來

		this.setTranscript(t);
		t.addTranscriptEntry(this);
	}

	//----------
	// 存取方法
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
	// 雜項方法
	//----------
	
	// 下面這兩個方法宣告為靜態方法, 因此可當成輔助方法使用

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

		// 首先, 確認成績合理

		if (validateGrade(grade)) {
			// 接著判斷成績是否比 D 高

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
