// Section.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 這是個「模型」類別


import java.util.ArrayList;
import java.util.HashMap;

public class Section {
	//------
	// 屬性
	//------

	private int sectionNo;
	private char dayOfWeek;
	private String timeOfDay;
	private String room;
	private int seatingCapacity;
	private Course representedCourse;
	private ScheduleOfClasses offeredIn;
	private Professor instructor;

	// enrolledStudents 這個 HashMap 存放了 Student 物件的參考,
	//以每個 Student 的 ssn 作為 String 鍵值

	private HashMap<String, Student> enrolledStudents; 

	// assignGrades 這個 HashMap 存著 TranscriptEntry 物件參考,
	// 以 Student 的參考當成鍵值, 查詢這個學生得到的成績

	private HashMap<Student, TranscriptEntry> assignedGrades; 
	
	//--------
	// 建構子
	//--------

	public Section(int sNo, char day, String time, Course course,
		       String room, int capacity) {
		setSectionNo(sNo);
		setDayOfWeek(day);
		setTimeOfDay(time);
		setRepresentedCourse(course);
		setRoom(room);
		setSeatingCapacity(capacity);

		// 還不確定由哪位教授任教

		setInstructor(null);

		// 將輔助的群集具現化

		enrolledStudents = new HashMap<String, Student>();
		assignedGrades = new HashMap<Student, TranscriptEntry>();
	}

	//----------
	// 存取方法
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
	// 雜項方法
	//----------

	// 我們希望讓 Section 的 String 表示法看起來像這樣:
	//
	//	MATH101 - 1 - M - 8:00 AM

	public String toString() {
		return getRepresentedCourse().getCourseNo() + " - " +
		       getSectionNo() + " - " +
		       getDayOfWeek() + " - " +
		       getTimeOfDay();
	}

	// 完整的課程編號, 是將科目編號與課程編號串接, 中間加上連字號
	// 如 "ART101 - 1".

	public String getFullSectionNo() {
		return getRepresentedCourse().getCourseNo() + 
		       " - " + getSectionNo();
	}

	// 我們以 EnrollmentStatus 這個列舉型別傳回 s 這位 Student 的選修結果.
	// 這個 enum 的詳細內容請參閱 EnrollmentStatus.java 檔

	public EnrollmentStatus enroll(Student s) {
		// 首先, 確認這位 Student 還沒選到這堂課,
		// 且他之前「從未」修過這堂課
		
		Transcript transcript = s.getTranscript();

		if (s.isCurrentlyEnrolledInSimilar(this) || 
		    transcript.verifyCompletion(this.getRepresentedCourse())) {
			return EnrollmentStatus.prevEnroll;
		}

		// 如果這堂課有任何先修條件的話
		// 就檢查 Student 是否已經修過這些先修條件

		Course c = this.getRepresentedCourse();
		if (c.hasPrerequisites()) {
			for (Course pre : c.getPrerequisites()) {
				// 檢查 Student 的 Transcript 是否記載了
				// 修過先修條件的資訊

				if (!transcript.verifyCompletion(pre)) {
					return EnrollmentStatus.prereq;
				}
			}
		}
		
		// 如果這堂課已經額滿的話, 就拒絕學生選課
		
		if (!this.confirmSeatAvailability()) {
			return EnrollmentStatus.secFull;
		}
		
		// 如果執行到這邊的話, 就代表可以正式讓學生選到這堂課了

		// 請留意雙向性: 這個 Section 會透過 HashMap 握住 Student 的握柄
		// 而 Student 也會拿到這個 Section 的握柄

		enrolledStudents.put(s.getSsn(), s);
		s.addSection(this);

		return EnrollmentStatus.success;
	}
	
	// 私有「內務」方法

	private boolean confirmSeatAvailability() {
		if (enrolledStudents.size() < getSeatingCapacity()) return true;
		else return false;
	}

	public boolean drop(Student s) {
		// 我們只能退掉一個已經選修這堂課的學生

		if (!s.isEnrolledIn(this)) return false;
		else {
			// 在 HashMap 裡面找到學生, 並且把它移掉
			enrolledStudents.remove(s.getSsn());

			// 留意雙向性

			s.dropSection(this);
			return true;
		}
	}

	public int getTotalEnrollment() {
		return enrolledStudents.size();
	}	

	public void display() {
		System.out.println("課程資訊:");
		System.out.println("\t　　學期:  " + getOfferedIn().getSemester());
		System.out.println("\t科目編號:  " + 
				   getRepresentedCourse().getCourseNo());
		System.out.println("\t課程編號:  " + getSectionNo());
		System.out.println("\t上課時間:  " + getDayOfWeek() + 
				   " 的 " + getTimeOfDay());
		System.out.println("\t上課教室:  " + getRoom());
		if (getInstructor() != null) 
			System.out.println("\t授課教授:  " + 
				   getInstructor().getName());
		displayStudentRoster();
	}
	
	public void displayStudentRoster() {
		System.out.print("\t總共有 " + getTotalEnrollment() + 
				   " 位學生選修");

		// 我們顯示訊息的方式與選修人數有關.
		// (請留意上面用的是 print 而非 printf)

		if (getTotalEnrollment() == 0) System.out.println(".");
		else System.out.println(", 如下:");

		// 逐項處理 HashMap 存放的所有內容

		for (Student s : enrolledStudents.values()) {
			System.out.println("\t\t" + s.getName());
		}
	}

	// 如果學生還未拿到成績的話, 這個方法就會傳回 null

	public String getGrade(Student s) {
		String grade = null;

		// 從 assignedGrades 這個 HashMap 取回屬於這個 Student 的
		// TranscriptEntry 物件, 接著透過它取回成績

		TranscriptEntry te = assignedGrades.get(s);
		if (te != null) {
			grade = te.getGrade(); 
		}

		// 如果沒找到這位 Student 的 TranscriptEntry,
		// 就以 null 值代表這種情形

		return grade;
	}

	public boolean postGrade(Student s, String grade) {
		// 首先, 呼叫 TranscriptEntry 類別提供的輔助方法
		// 確認成績是否合理

		if (!TranscriptEntry.validateGrade(grade)) return false;

		// 查看 HashMap 是否已有這位 Student,
		// 以確保我們先前還未幫這位 Student 打過成績.
		// 如果我們發現已經打過成績的話, 就傳回 false 代表
		// 有可能蓋掉原本的成績.
		// (可以另外寫一個 eraseGrade() 方法, 讓 Professor 改變心意)

		if (assignedGrades.get(s) != null) return false;

		// 首先, 我們建立一個新的 TranscriptEntry 物件
		// 留意我們傳入「這個」Section 的參考, 因為我們希望這個
		// 身為關聯類別的 TranscriptEntry 物件同時持有 Section 與
		// Student 的握柄.
		// (我們會讓 TranscriptEntry 的建構子負責將這個 TranscriptEntry
		//  連到正確的 Transcript 物件)

		TranscriptEntry te = new TranscriptEntry(s, grade, this);

		// 接著我們「記下」這個成績,
		// 因為我們希望 TranscriptEntry 與 Section 之間是雙向連結

		assignedGrades.put(s, te);

		return true;
	}
	
	public boolean isSectionOf(Course c) {
		if (c == representedCourse) return true;
		else return false;
	}
}
