                第 17 章 SRS 系統摘要
                =====================


第 17 章 *新增* 了這兩個類別:

	MainFrame
	PasswordPopup

同時 *修改* 了第 15 章的這兩個類別:

	Student
	SRS

以下 14 個類別與第 15 章 *相同* 未作變動:

	Course 
	CourseCatalog
	EnrollmentStatus 
	Faculty
	InvalidStudentException
	Person 
	Professor 
	ScheduleOfClasses 
	Section 
	SRSDataAccess
	SRSInitializationException
	StudentPersistenceException
	Transcript 
	TranscriptEntry

總計 18 個類別.

===

OTHER FILES IN THIS DIRECTORY ARE AS FOLLOWS:

*.dat - SRS 應用程式讀取的各式資料檔

*.dat.orig - 資料檔的原始版本，可用來「重設」檔案內容，以便反覆執行程式

reset.bat - DOS 批次檔，可將各個 *.dat 檔案的內容回復成原始狀態，以便重新
執行程式


FileNames.properties - 這是個 Java 屬性檔，將檔案用途對應到實際檔名，這樣
才不必將檔名寫死在 SRS 應用程式之內

