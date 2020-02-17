// SRS.java - Chapter 16, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 指令列版 SRS 的主驅動程式, 已加上物件存續功能以及圖形介面


import java.util.*;

public class SRS {
	// 我們可以將主類別之內的物件群集宣告為 public static 屬性
	// 這樣就等於建立了「全域」資料; 可在 SRS 應用程式的其它地方
	// 以 SRS.collectionName 或 SRS.faculty 等寫法直接存取.

	public static Faculty faculty; 
	public static CourseCatalog courseCatalog; 
	public static ScheduleOfClasses scheduleOfClasses;

	// 我們不建立 Student 物件的群集, 因為我們一次只處理一位學生 --
	// 也就是目前登入的學生.

	public static void main(String[] args) {
		// 初始化所有物件.  我們 (在這邊向文字檔) 存取資料的動作
		// 因為有著 SRSDataAccess 資料層輔助類別的緣故,
		// 對應用程式來說是完全透明的.

		// 我們使用自訂例外 ...

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

		// 建立並顯示 GUI 主視窗

		new MainFrame();
	}
}
