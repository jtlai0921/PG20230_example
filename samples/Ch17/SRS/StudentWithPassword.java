// StudentWithPassword.java - Chapter 16, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 這是個「模型」類別


public class StudentWithPassword extends Student {
	//------
	// 屬性
	//------

	private String password;

	//--------
	// 建構子
	//--------

	public StudentWithPassword(String name, String ssn, String major, 
		String degree, String password) {
		// 重新利用父類別的建構子程式碼
		super(name, ssn, major, degree);

		// ... 然後多做點事!
		this.setPassword(password);
	}
	
	// 第二種簡化的建構子

	public StudentWithPassword(String ssn) {
		// 重新利用類別的另一個建構子
		this("TBD", ssn, "TBD", "TBD", "TBD");
	}

	//----------
	// 存取方法
	//----------

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	//----------
	// 雜項方法
	//----------

	public boolean validatePassword(String pw) {
		if (pw.equals(password)) return true;
		else return false;
	}
}
