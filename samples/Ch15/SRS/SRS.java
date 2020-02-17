// SRS.java - Chapter 15, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 指令列版 SRS 的主驅動程式, 已加上物件存續功能

import java.util.*;

public class SRS {
	// 我們可以將主類別之內的物件群集宣告為 public static 屬性
	// 這樣就等於建立了「全域」資料; 可在 SRS 應用程式的其它地方
	// 以 SRS.collectionName 或 SRS.faculty 等寫法直接存取.

	// 我們將第 14 章宣告成 ArrayList 的幾個群集封裝成 Faculty 與 
	// CourseCatalog 等專用群集, 讓它們更抽象一點.
	//
	//	public static ArrayList<Professor> faculty; 
	//	public static ArrayList<Course> courseCatalog; 
	//
	// (ScheduleOfClasses 則是一開始就這麼做了)

	public static Faculty faculty; 
	public static CourseCatalog courseCatalog; 
	public static ScheduleOfClasses scheduleOfClasses;

	// 我們不建立 Student 物件的群集, 因為我們一次只處理一位學生 --
	// 也就是目前登入的學生.

	public static void main(String[] args) {
		// 初始化所有物件. 由於導入 SRSDataAccess 這個資料層輔助類別的緣故, 
		// 所以我們 (從 ASCII 文字檔) 存取資料的方式對這個應用程式來說是
		// 完全「透明」的.

		// 我們以自訂的例外類別通報在以永久儲存設備的資料重建物件時
		// 遇到的各種問題.

		try {
			// 建立這些物件的順序很重要:
			// 建立 ScheduleOfClasses 的時候需要用到現有的 CourseCatalog,
			// 建立 Faculty 的時候需要用到現有的 ScheduleOfClasses.

			courseCatalog = SRSDataAccess.initializeCourseCatalog();
			scheduleOfClasses = 
				SRSDataAccess.initializeScheduleOfClasses("SP2005");
			faculty = SRSDataAccess.initializeFaculty();
		}
		catch (SRSInitializationException e) {
			System.out.println("錯誤:  " + e.getMessage() + "-- 再見!");
			System.exit(0);	
		}

        // 讓我們呼叫各個 display 方法, 看看是不是所有東西都建好了

		System.out.println("====================");
		System.out.println("科目清單:");
		System.out.println("====================");
		System.out.println();
		courseCatalog.display();

		System.out.println("====================");
		System.out.println("課表:");
		System.out.println("====================");
		System.out.println();
		scheduleOfClasses.display();

		System.out.println("====================");
		System.out.println("教職員資訊:");
		System.out.println("====================");
		System.out.println();
		faculty.display();

        // 模擬一位學生登入. 留意這位學生在 ssn.dat 檔案內已經選修了
		// 幾個不同的課程 (詳情請參閱 111-11-1111.dat 檔案)

		Student student = null;

		// 我們以自訂的例外類別通報在以永久儲存設備的資料重建物件時
		// 遇到的各種問題.

		try {
			student = SRSDataAccess.initializeStudent("111-11-1111");
		}
		catch (InvalidStudentException e) {
			System.out.println("錯誤:  " + e.getMessage() + "-- 再見!");
			System.exit(0);	
		}

		// 回顧學生的現有資訊

		System.out.println("===========================");
		System.out.println("選修「之前」的學生資訊:");
		System.out.println("===========================");
		System.out.println();
		student.display();

		// 模擬學生選修另一堂課程

		Section sec = scheduleOfClasses.findSection("ART101 - 1");
		sec.enroll(student);

		// 回顧學生更新後的資訊

		System.out.println("==========================");
		System.out.println("選修「之後」的學生資訊:");
		System.out.println("==========================");
		System.out.println();
		student.display();

		// 模擬學生登出, 以便將學生變動過的課業負荷存回檔案
		// (您可檢視 111-11-1111.dat 檔案的內容, 看看有沒有被修改過)

		try {
			SRSDataAccess.persistStudent(student);  
		}
		catch (StudentPersistenceException e) {
			System.out.println("錯誤:  " + e.getMessage() + "-- 再見!");
			System.exit(0);	
		}

		// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
		// * 在執行這個程式之前, 請記得以 reset.bat 將 111-11-1111.dat 資料檔
		// * 的內容恢復原狀.
		// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	}
}
