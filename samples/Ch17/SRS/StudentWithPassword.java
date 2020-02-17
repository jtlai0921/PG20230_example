// StudentWithPassword.java - Chapter 16, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// �o�O�ӡu�ҫ��v���O


public class StudentWithPassword extends Student {
	//------
	// �ݩ�
	//------

	private String password;

	//--------
	// �غc�l
	//--------

	public StudentWithPassword(String name, String ssn, String major, 
		String degree, String password) {
		// ���s�Q�Τ����O���غc�l�{���X
		super(name, ssn, major, degree);

		// ... �M��h���I��!
		this.setPassword(password);
	}
	
	// �ĤG��²�ƪ��غc�l

	public StudentWithPassword(String ssn) {
		// ���s�Q�����O���t�@�ӫغc�l
		this("TBD", ssn, "TBD", "TBD", "TBD");
	}

	//----------
	// �s����k
	//----------

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	//----------
	// ������k
	//----------

	public boolean validatePassword(String pw) {
		if (pw.equals(password)) return true;
		else return false;
	}
}
