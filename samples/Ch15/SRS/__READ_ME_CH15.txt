                第 15 章 SRS 系統摘要
                =====================


第 15 章 *新增* 了 6 個新類別:

	CourseCatalog
	Faculty
	InvalidStudentException
	SRSDataAccess
	SRSInitializationException
	StudentPersistenceException

同時 *修改* 了一個類別:

	SRS

以下 9 個類別與第 14 章相同 *未經變動*:

	Course 
	EnrollmentStatus 
	Person 
	Professor 
	ScheduleOfClasses 
	Section 
	Student 
	Transcript 
	TranscriptEntry

總共有 16 個類別.

===

目錄內其它檔案的用途:

*.dat - SRS 應用程式讀取的各式資料檔

*.dat.orig - 資料檔的原始版本，可用來「重設」檔案內容，以便反覆執行程式

reset.bat - DOS 批次檔，可將各個 *.dat 檔案的內容回復成原始狀態，以便重新
執行程式

FileNames.properties - 這是個 Java 屬性檔，將檔案用途對應到實際檔名，這樣
才不必將檔名寫死在 SRS 應用程式之內

