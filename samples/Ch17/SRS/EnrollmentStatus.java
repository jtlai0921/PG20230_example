// EnrollmentStatus.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 「輔助用」列舉型別


// Section 類別會以此代表學生嘗試選修的各種處理結果

public enum EnrollmentStatus {
	// 列舉這個 enum 可以使用的值
	success("選修成功!  :o)"), 
	secFull("選修失敗; 課程人數已滿.  :op"), 
	prereq("選修失敗; 尚未修完先修課程.  :op"), 
	prevEnroll("選修失敗; 已經選修過了.  :op");

	// 這代表 enum 實體的值
	private final String value;

	// 建構子 (上面用到)
	EnrollmentStatus(String value) {
		this.value = value;
	}

	// enum 實體值的存取方法
	public String value() {
		return value;
	}
}
