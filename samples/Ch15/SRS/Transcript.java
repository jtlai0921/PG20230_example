// Transcript.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 這是個「模型」類別


import java.util.ArrayList;

public class Transcript {
	//------
	// 屬性
	//------

	private ArrayList<TranscriptEntry> transcriptEntries; 
	private Student studentOwner;

	//--------
	// 建構子
	//--------

	public Transcript(Student s) {
		setStudentOwner(s);

		// 我們將輔助用的群集具現化

		transcriptEntries = new ArrayList<TranscriptEntry>();
	}

	//----------
	// 存取方法
	//----------

	public void setStudentOwner(Student s) {
		studentOwner = s;
	}

	public Student getStudentOwner() {
		return studentOwner;
	}

	//----------
	// 雜項方法
	//----------

	public boolean verifyCompletion(Course c) {
		boolean outcome = false;

		// 逐項處理所有的 TranscriptEntries,
		// 尋找屬於指定 Course 的 Section 物件

		for (TranscriptEntry te : transcriptEntries) {
			Section s = te.getSection();

			if (s.isSectionOf(c)) {
				// 確認成績及格

				if (TranscriptEntry.passingGrade(te.getGrade())) {
					outcome = true;

					// 我們找到了, 所以可以終止迴圈

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
		System.out.println(getStudentOwner().toString() + " 的成績單:");

		if (transcriptEntries.size() == 0) {
			System.out.println("\t(無資料)");
		}
		else for (TranscriptEntry te : transcriptEntries) {
			Section sec = te.getSection();

			Course c = sec.getRepresentedCourse();

			ScheduleOfClasses soc = sec.getOfferedIn();

			System.out.println("\t　　學期: " +
					   soc.getSemester());
			System.out.println("\t科目編號: " +
					   c.getCourseNo());
			System.out.println("\t　學分數: " +
					   c.getCredits());
			System.out.println("\t　　成績: " +
					   te.getGrade());
			System.out.println("\t-----");
		}
	}
}
