// SRSDataAccess.java - Chapter 15, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 「資料存取層」類別


// 把所有物件存續細節封裝在這個類別內, 就可以在一路上需要修改這些部分的時候, 把對應用程式
// 的衝擊降到最低; 比如說, 這可以簡化稍後切換到關聯式資料庫技術的過程.

import java.io.*;
import java.util.*;

public class SRSDataAccess {
	// 我們宣告 String 變數, 安置我們需要存取的資料檔檔名
	// 但是實際的檔名存放在外部屬性檔內, 而非寫死在這邊
	// 稍早提過, 這個作法可讓我們未來輕易修改檔案的名稱/路徑, 不必修改程式碼

	// 課表定義在一個檔案之內:

	private static String scheduleFileName;

	// 教職員則由兩個檔案定義:

	private static String facultyFileName;
	private static String assignmentsFileName; 

	// 科目清單也由兩個檔案定義:

	private static String courseFileName;
	private static String prereqFileName;

	// 我們不需為學生資料檔宣告 static String 屬性,
	// 因為在學生登入的時候會即時推導出檔名,
	// 作法是將學生的 ID 結尾加上 ".dat" 延伸檔名

	// 從外部屬性檔讀入相關的檔名
	// "static" 程式碼區塊只會在 JVM 執行時首次載入外包類別的位元碼之後
	// 執行一次 (本例中是 SRSDataAccess 類別)

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
			// 如果找不到屬性檔的話, 就放棄執行程式

			System.out.println("錯誤: 無法讀取 FileNames.properties 檔 " +
				"-- 再見!");
			System.exit(0);
		}
	}

	// 初始化 Faculty 群集
	// 請留意, 我們以自訂的例外型別通報在以永久儲存設備的資料「重建」物件時
	// 遇到的各種錯誤情形

	public static Faculty initializeFaculty() throws SRSInitializationException {
		Faculty faculty = new Faculty();
		String line = null;
		BufferedReader bIn = null;

		try {
			// 開啟第一個檔案
			bIn = new BufferedReader(new FileReader(facultyFileName));

			line = bIn.readLine();
			while (line != null) {
				// 我們將把 TAB 區隔欄位的記錄分成四個屬性 --
				// name, ssn, title, 與 dept
				// 然後呼叫 Professor 建構子造出新的教授

				StringTokenizer st = new StringTokenizer(line, "\t");

				// 如果欄位數目不對的話, 就回報錯誤

				if (st.countTokens() != 4) {
					throw new SRSInitializationException(
						"檔案格式錯誤 -- 在 " + 
						facultyFileName +
						" 檔案內的記錄 -- |" + 
						line + "| -- 應該有 4 個欄位 ");
				}
				else {
					String name = st.nextToken();
					String ssn = st.nextToken();
					String title = st.nextToken();
					String dept = st.nextToken();

					// 建立一個 Professor 實體並存入群集

					Professor p = new Professor(name, ssn, title, dept);
					faculty.addProfessor(p);
				}
				
					line = bIn.readLine();
			}

			bIn.close();
		}
		catch (IOException i) { 
			throw new SRSInitializationException("存取 " + 
				facultyFileName + " 檔案時發生錯誤");
		}

		// 處理第二個檔案, 也就是負責講授的科目

		try {
			// 打開檔案
			bIn = new BufferedReader(
				new FileReader(assignmentsFileName));

			line = bIn.readLine();
			while (line != null) {
				// 我們將把 TAB 區隔欄位的記錄拆成兩個值,
				// 分別是教授的社會保險號碼, 以及負責講授的課程編號

				StringTokenizer st = new StringTokenizer(
					line, "\t");

				// 如果欄位數目不對的話, 就回報錯誤

				if (st.countTokens() != 2) {
					throw new SRSInitializationException(
						"檔案格式錯誤 -- 在 " + 
						assignmentsFileName +
						" 檔案內的記錄 -- |" + 
						line + "| -- 應該有 2 個欄位 ");
				}
				else {
					String ssn = st.nextToken();

					// 完整課程編號是科目編號與課程編號
					// 用連字號接在一起, 像是 "ART101 - 1"

					String fullSectionNo = st.nextToken();

					// 從適當的群集查詢這兩個物件.
					// 請留意, 由於把 scheduleOfClasses
					// 宣告成 public static 屬性的緣故,
					// 因此這件工作並不難完成!

					Professor p = faculty.findProfessor(ssn); 
					Section s = SRS.scheduleOfClasses.
						findSection(fullSectionNo); 

					// 只要我們找到 Professor 與 Section,
					// 就沒問題了

					if (p != null && s != null) p.agreeToTeach(s);
				}

				line = bIn.readLine();
			}

			bIn.close();
		}
		catch (IOException i) { 
			throw new SRSInitializationException("存取 " + 
				assignmentsFileName + " 檔案時發生錯誤");
		}

		// 如果我們完全沒為 Faculty 建立任何項目的話,
		// 就會通報這個問題

		if (faculty.isEmpty()) {
			throw new SRSInitializationException("建立教職員資料時" + 
				"發生錯誤");
		}

		// 如果我們執行至此沒有丟出任何例外的話, 就代表
		// 我們已經填好了「驅動」SRS 所需的 Faculty 實體

		return faculty;
	}

	// 為 CourseCatalog 設定初值. 請留意, 我們將以自訂的例外型別回報任何
	// 初始化過程中遇到的錯誤 (與 Faculty 的作法一樣)

	public static CourseCatalog initializeCourseCatalog() 
		throws SRSInitializationException {
		CourseCatalog catalog = new CourseCatalog();
		String line = null;
		BufferedReader bIn = null;

		try {
			// 開啟檔案
			bIn = new BufferedReader(new FileReader(courseFileName));

			line = bIn.readLine();
			while (line != null) {
				// 我們將把 TAB 區隔欄位的記錄拆成三個屬性 --
				// courseNo, courseName, 與 credits
				// 然後呼叫 Course 建構子建立新的科目物件

				StringTokenizer st = new StringTokenizer(line, "\t");

				// 如果欄位數目不對的話, 就回報錯誤

				if (st.countTokens() != 3) {
					throw new SRSInitializationException(
						"檔案格式錯誤 -- 在 " + 
						courseFileName +
						" 檔案內的記錄 -- |" + 
						line + "| -- 應該有 3 個欄位 ");
				}
				else {
					String courseNo = st.nextToken();
					String courseName = st.nextToken();
					String creditValue = st.nextToken();

					// 我們必須將最後一個值轉成數字,
					// 此時以 Double 類別的靜態方法進行轉換

					double credits = -1.0;
					try {
						credits = Double.parseDouble(creditValue);
					}
					catch (NumberFormatException nfe) {
						throw new SRSInitializationException(
							"檔案格式錯誤 -- 在 " +
							courseFileName + 
							" 檔案內的記錄 -- |" + 
							line + "| -- 含有不合法的學分數");
					}

					// 最後, 呼叫 Course 建構子建立對應的 Course 物件,
					// 並把它存到群集之內

					Course c = new Course(courseNo, courseName, credits);
					catalog.addCourse(c);
				}
				
				line = bIn.readLine();
			}

			bIn.close();
		}
		catch (IOException i) { 
			throw new SRSInitializationException("存取 " + 
				courseFileName + " 檔案時發生錯誤");
		}

		// 處理第二個檔案, 這個檔案定義了科目之間的先修關係

		try {
			// 開啟檔案
			bIn = new BufferedReader(
				new FileReader(prereqFileName));

			line = bIn.readLine();
			while (line != null) {
				// 我們將把 TAB 區隔欄位的記錄拆成兩個值,
				// 分別是 "A" 科目的編號與 "B" 科目的編號
				// 這代表 A 是 B 的先修科目之一

				StringTokenizer st = new StringTokenizer(line, "\t");

				// 如果欄位數目不對的話, 就回報錯誤

				if (st.countTokens() != 2) {
					throw new SRSInitializationException(
						"檔案格式錯誤 -- 在 " + 
						prereqFileName +
						" 檔案內的記錄 -- |" + 
						line + "| -- 應該有 2 個欄位 ");
				}
				else {
					String courseNoA = st.nextToken();
					String courseNoB = st.nextToken();

					// 在 CourseCatalog 之中搜尋這兩個科目

					Course a = catalog.findCourse(courseNoA); 
					Course b = catalog.findCourse(courseNoB); 

					// 如果找到兩者的話, 就將 a 設為 b 的先修科目

					if (a != null && b != null) {
						b.addPrerequisite(a);
					}
				}

				line = bIn.readLine();
			}

			bIn.close();
		}
		catch (IOException i) { 
			throw new SRSInitializationException("存取 " + 
				prereqFileName + " 檔案時發生錯誤");
		}

		// 如果我們沒有建立任何課表項目的話, 就將之回報為錯誤情形

		if (catalog.isEmpty()) {
			throw new SRSInitializationException("初始化科目資訊時" + 
				"發生錯誤");
		}

		// 如果我們執行到此, 沒有丟出任何例外的話, 就代表我們成功建立了
		// 「驅動」SRS 所需的 CourseCatalog 實體

		return catalog;
	}

	// 初始化 ScheduleOfClasses. 請留意我們用了自訂例外型別
	// 通報各種初始化過程中的錯誤 (與 Faculty 一樣)

	public static ScheduleOfClasses initializeScheduleOfClasses(String semester) 
		throws SRSInitializationException {
		ScheduleOfClasses soc = new ScheduleOfClasses(semester);
		String line = null;
		BufferedReader bIn = null;

		try {
			// 開啟檔案
			bIn = new BufferedReader(new FileReader(scheduleFileName));

			line = bIn.readLine();
			while (line != null) {
				// 我們要將 TAB 區隔欄位的記錄拆成六個屬性 --
				// courseNo, sectionNo, dayOfWeek, timeOfDay, room, 
				// 以及 capacity.  我們將以 courseNo 查詢對應的 Course 物件,
				// 然後呼叫 scheduleSection() 方法造出新的 Section 物件.

				StringTokenizer st = new StringTokenizer(line, "\t");

				// 如果欄位數不等於六的話, 就通報錯誤

				if (st.countTokens() != 6) {
					throw new SRSInitializationException(
						"檔案格式錯誤 -- 在 " + 
						scheduleFileName +
						" 檔案內的記錄 -- |" + 
						line + "| -- 應該有 6 個欄位 ");
				}
				else {
					String courseNo = st.nextToken();

					// 我們必須將下一個值從 String 轉成 int
					//
					String sectionNumber = st.nextToken();
					int sectionNo = -1;
					try {
						sectionNo = Integer.parseInt(sectionNumber);
					}
					catch (NumberFormatException nfe) {
						throw new SRSInitializationException(
							"檔案格式錯誤 -- 在 " +
							scheduleFileName + 
							" 檔案內的記錄 -- |" + 
							line + "| -- 含有不合法的課程編號");
					}

					String dayOfWeek = st.nextToken();
					String timeOfDay = st.nextToken();
					String room = st.nextToken();
					
					// 我們必須將下一個值從 String 轉成 int

					String capacityValue = st.nextToken();
					int capacity = -1;
					try {
						capacity = Integer.parseInt(capacityValue);
					}
					catch (NumberFormatException nfe) {
						throw new SRSInitializationException(
							"檔案格式錯誤 -- 在 " +
							scheduleFileName + 
							" 檔案內的記錄 -- |" + 
							line + "| -- 含有不合法的座位容量");
					}

					// 在科目清單內查詢對應的 Course 物件
					// (把 courseCatalog 做成 SRS 類別的 public static 變數
					//  在這時就很方便了!)

					Course c = SRS.courseCatalog.findCourse(courseNo);

					// 建立 Section 物件 ...

					Section s = new Section(
						sectionNo, dayOfWeek.charAt(0), 
						timeOfDay, c, room, capacity);

					// ... 將它放到課表內 ...

					String key = courseNo + " - " + s.getSectionNo();
					soc.addSection(s);

					// ... 然後將它連上 Course
					c.addSection(s);
				}
				
				line = bIn.readLine();
			}

			bIn.close();
		}
		catch (IOException i) { 
			throw new SRSInitializationException("存取 " + 
				scheduleFileName + " 檔案時發生錯誤");
		}

		// 如果我們最後並未建立任何 Section 項目的話, 就回報這個問題

		if (soc.isEmpty()) {
			throw new SRSInitializationException("初始化" + 
				"課表資訊時發生錯誤");
		}

		// 如果我們執行到這邊, 沒有丟出任何例外的話,
		// 就代表我們填好「驅動」 SRS 所需的 ScheduleOfClasses 實體了

		return soc;
	}

	// 初始化一個 Student.  這邊我們一樣用自訂的例外型別 -- InvalidStudentException
	// 通報各種從永久儲存設備取回學生資料時遇到的問題; 
	// 它是 SRSInitializationException 的衍生型別之一.

	public static Student initializeStudent(String sId) throws InvalidStudentException {
		// 首先建立一個「空殼」 Student 物件, 然後試著從對應的檔案 (如 111-11-1111.dat)
		// 讀出 Student 的資料.

		Student s = new Student("?");

		String line = null;
		BufferedReader bIn = null;

		// 產生檔名

		String pathToFile = sId + ".dat";

		try {
			// 開啟檔案

			bIn = new BufferedReader(new FileReader(pathToFile));

            // 這個檔案的開頭是存放學生基本資料 (社會保險號碼, 姓名等等),
            // 接著是 0 或多筆代表這位學生目前選修課程的記錄

			line = bIn.readLine();

			if (line == null) {
				// 透過自訂例外型別回報錯誤

				throw new InvalidStudentException("檔案格式不正確: " +
					pathToFile);
			}

			// 我們將把主記錄解析成四個屬性 -- ssn, name, major 與 degree

			StringTokenizer st = new StringTokenizer(line, "\t");

			// 如果欄位數目不對的話, 就將之回報錯誤

			if (st.countTokens() != 4) {
				// 透過自訂例外型別回報這個錯誤

				throw new InvalidStudentException("在 " + pathToFile + 
					"檔案內的記錄 |" + line + "| 格式不正確");
			}

			// 為這個剛建立的 Student 物件填入從檔案讀到的資料

			s.setSsn(st.nextToken());
			s.setName(st.nextToken());
			s.setMajor(st.nextToken());
			s.setDegree(st.nextToken());

			// 檔案的剩餘內容 (如果有的話) 代表學生先前登入 SRS 系統時
			// 選修的所有課程.

			// 如果檔案內沒有次記錄的話,
			// "while" 迴圈就完全不會執行

			line = bIn.readLine();
			while (line != null) {
				// 完整課程編號是由科目編號與課程編號連結而成,
				// 中間加上連字號, 如 "ART101 - 1";

				// 拔掉前後的空白字元, 然後以課程編號從 SRS 的課表取回
				// 對應的 Section 物件; SRS 的課表是 SRS 類別
				// 宣告為 public static 的屬性.

				String fullSectionNo = line.trim();
				Section sec = SRS.scheduleOfClasses.findSection(
					fullSectionNo);

				// 留意我們以 Section 類別的 enroll 方法,
				// 確保 Student 與 Section 之間建立雙向連結

				if (sec != null) sec.enroll(s);

				line = bIn.readLine();
			}

			bIn.close();
		}
		catch (IOException i) {
			// 以自訂例外型別回報問題

			throw new InvalidStudentException("存取 " + 
				pathToFile + " 檔案時發生錯誤");
		}

		// 如果我們執行到這邊, 沒有丟出任何例外的話, 就代表我們成功地
		// 建立一個代表登入 SRS 的學生的 Student 物件了

		return s;
	}

	// 存續 Student 的狀態. 這個方法會在學生登出系統的時候, 將這位學生的
	// 資訊全部寫回對應的 ssn.dat 檔案內.
	// 我們同樣在此以自訂的例外型別 -- StudentPersistenceException 回報問題

	public static void persistStudent(Student s) throws StudentPersistenceException {
		FileOutputStream fos = null;
		PrintWriter pw = null;
		
		// 推導出我們要寫入的檔名
		String pathToFile = s.getSsn() + ".dat";

		try {
			// 嘗試建立 ssn.dat 檔. 請留意, 如果已經有同名檔案的話,
			// 現有的檔案就會被「覆蓋」掉, 這正是我們希望的作法

			fos = new FileOutputStream(pathToFile);
			pw = new PrintWriter(fos);

			// 首先, 以 TAB 區隔欄位的形式輸出主記錄/標頭

			pw.println(s.getSsn() + "\t" + s.getName() + "\t" +
				   s.getMajor() + "\t" + s.getDegree());

			// 接著為這位 Student 選修的所有 Section
			// 分別輸出一筆次記錄

			Collection<Section> sections = s.getEnrolledSections();
			for (Section sec : sections) {
				pw.println(sec.getFullSectionNo());
			}

			pw.close();
		}
		catch (IOException e) {
			// 回報遇到錯誤
			
			throw new StudentPersistenceException("在將學生資訊存到 " +
				pathToFile + " 檔案時發生錯誤");
		}
	}
}
