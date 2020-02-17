// SRS.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 指令列版 SRS 的主驅動程式


import java.util.ArrayList;

public class SRS {
	// 我們可以將主類別之內的物件群集宣告為 public static 屬性
	// 這樣就等於建立了「全域」資料

	public static ArrayList<Professor> faculty; 
	public static ArrayList<Student> studentBody; 
	public static ArrayList<Course> courseCatalog; 

	// 下面這個存放了 Section 物件參考的群集, 由於我們以 UML 為 SRS 塑模的
	// 結果使然, 封裝在一個特殊用途的類別之內; 請留意, 我們其實也能以相同方式
	// 封裝上面這三個群集, 而我們在第 15 章也的確會這麼做.

	public static ScheduleOfClasses scheduleOfClasses = 
		      new ScheduleOfClasses("SP2005");
	
	public static void main(String[] args) {
		Professor p1, p2, p3;
		Student s1, s2, s3;
		Course c1, c2, c3, c4, c5;
		Section sec1, sec2, sec3, sec4, sec5, sec6, sec7;

		// 呼叫建構子建立各種物件 (我們通常會從資料庫或檔案內
		// 讀取這類資料 ...)

		// ------
		// 教授群
		// ------

		p1 = new Professor("Jacquie Barker", "123-45-6789", 
				   "Adjunct Professor", "Information Technology");		

		p2 = new Professor("John Smith", "567-81-2345",
				   "Full Professor", "Chemistry");		

		p3 = new Professor("Snidely Whiplash", "987-65-4321",
				   "Full Professor", "Physical Education");		

		// 將它們放進對應的 ArrayList 內

		faculty = new ArrayList<Professor>();
		faculty.add(p1);
		faculty.add(p2);
		faculty.add(p3);

		// ----
		// 學生
		// ----
		
		s1 = new Student("Joe Blow", "111-11-1111", "Math", "M.S.");

		s2 = new Student("Fred Schnurd", "222-22-2222", 
				 "Information Technology", "Ph. D.");

		s3 = new Student("Mary Smith", "333-33-3333", "Physics", "B.S.");

		// 將它們放進對應的 ArrayList 內

		studentBody = new ArrayList<Student>();
		studentBody.add(s1);
		studentBody.add(s2);
		studentBody.add(s3);

		// ----
		// 科目
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

		// 將它們放進對應的 ArrayList 內

		courseCatalog = new ArrayList<Course>();
		courseCatalog.add(c1);
		courseCatalog.add(c2);
		courseCatalog.add(c3);
		courseCatalog.add(c4);
		courseCatalog.add(c5);

		// 建立一些先修條件 (c1 => c2 => c3 => c4).

		c2.addPrerequisite(c1);
		c3.addPrerequisite(c2);
		c4.addPrerequisite(c3); 

		// ----
		// 課程
		// ----

		// 呼叫 Course 的 scheduleSection 方法,
		// 以便為各個 Course 排定上課時間
		// (它會在內部呼叫 Section 的建構子)

		sec1 = c1.scheduleSection('M', "8:10 - 10:00 PM", "GOVT101", 30);

		sec2 = c1.scheduleSection('W', "6:10 - 8:00 PM", "GOVT202", 30);

		sec3 = c2.scheduleSection('R', "4:10 - 6:00 PM", "GOVT105", 25);

		sec4 = c2.scheduleSection('T', "6:10 - 8:00 PM", "SCI330", 25);

		sec5 = c3.scheduleSection('M', "6:10 - 8:00 PM", "GOVT101", 20);

		sec6 = c4.scheduleSection('R', "4:10 - 6:00 PM", "SCI241", 15);
		
		sec7 = c5.scheduleSection('M', "4:10 - 6:00 PM", "ARTS25", 40);
		
		// 將這些課程加進課表

		scheduleOfClasses.addSection(sec1);
		scheduleOfClasses.addSection(sec2);
		scheduleOfClasses.addSection(sec3);
		scheduleOfClasses.addSection(sec4);
		scheduleOfClasses.addSection(sec5);
		scheduleOfClasses.addSection(sec6);
		scheduleOfClasses.addSection(sec7);

		// 聘用教授為這些課程授課

		p3.agreeToTeach(sec1);
		p2.agreeToTeach(sec2);
		p1.agreeToTeach(sec3);
		p3.agreeToTeach(sec4);
		p1.agreeToTeach(sec5);
		p2.agreeToTeach(sec6);
		p3.agreeToTeach(sec7);

		System.out.println("====================");
		System.out.println("學生開始選修課程了！");
		System.out.println("====================");
		System.out.println();

		// 模擬學生嘗試選修各節課程的情形

		System.out.println("學生 " + s1.getName() + 
				   " 嘗試選修 " +
				   sec1.toString());

		EnrollmentStatus status = sec1.enroll(s1);
		reportStatus(status);

		// 留意這邊用了特殊的「內務」方法 reportStatus() 解讀並顯示選修結果.
		// 我們也可以把上面兩行結合成一行:
		//
		//	reportStatus(sec1.enroll(s1));
		//
		// 而由於 println() 也會呼叫很多次, 因此我們也能寫一個更複雜的「內務」
		// 方法, 以便將上面這三條敘述全部結合成一行:
		//
		//      attemptToEnroll(s1, sec1);
		// 
		// 而我們的確也會這麼做, 稍後就會在程式裡面改用這個更簡潔的寫法.

		// 嘗試讓一位 Student 同時選修「同一個」 Course 的不同 Section --
		// 這應該無法成功

		attemptToEnroll(s1, sec2);

		// 這個選修動作應該沒問題 ...

		attemptToEnroll(s2, sec2);

		// ... 但是這個學生還未滿足先修條件, 所以選修應該會被回絕

		attemptToEnroll(s2, sec3);

		// 這些選修動作應該沒問題

		attemptToEnroll(s2, sec7);
		attemptToEnroll(s3, sec1);

		// 塵埃落定之後, 「成功」選到課的情形會是這樣:
		//
		// sec1: s1, s3
		// sec2: s2
		// sec7: s2

		// 學期結束了 (哇, 還真快!)
		// 教授為各個學生打成績

		sec1.postGrade(s1, "C+");
		sec1.postGrade(s3, "A");
		sec2.postGrade(s2, "B+");
		sec7.postGrade(s2, "A-");

		// 讓我們呼叫各個 display() 方法,
		// 看看是不是一切都順利運作
	
		System.out.println("=====");
		System.out.println("課表:");
		System.out.println("=====");
		System.out.println();
		scheduleOfClasses.display();

		System.out.println("=========");
		System.out.println("教授資訊:");
		System.out.println("=========");
		System.out.println();
		p1.display();
		p2.display();
		p3.display();

		System.out.println("=========");
		System.out.println("學生資訊:");
		System.out.println("=========");
		System.out.println();
		s1.display();
		s2.display();
		s3.display();
	}

	// 留意這是個私有的內務方法 ...

	private static void reportStatus(EnrollmentStatus s) {
		System.out.println("狀態: " + s.value());
		System.out.println();
	}

	// ... 而這也是.

	private static void attemptToEnroll(Student s, Section sec) {
		System.out.println("學生 " + s.getName() + 
				   " 嘗試選修 " +
				   sec.toString());

		// 在一個內務方法之內應用另一個內務方法!
		reportStatus(sec.enroll(s));
	}
}
