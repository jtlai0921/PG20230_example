// Person.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// �o�O�ӡu�ҫ��v���O


// �ڭ̱N���ŧi����H���O, �]�����Ʊ楦�Q��{��

public abstract class Person {
	//------
	// �ݩ�
	//------

	private String name;
	private String ssn;
	
	//--------
	// �غc�l
	//--------

	public Person(String name, String ssn) {
		this.setName(name);
		this.setSsn(ssn);
	}

        public Person() {
		this.setName("?");
		this.setSsn("???-??-????");
        }
	
	//----------
	// �s����k
	//----------

	public void setName(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSsn(String s) {
		ssn = s;
	}
	
	public String getSsn() {
		return ssn;
	}

	//----------
	// ������k
	//----------

	// �ڭ̱N���C�Ӥl���O�M�w�ۤv�� String ��ܪk

	public abstract String toString(); 

	public void display() {
		System.out.println("Person ��T:");
		System.out.println("\t�m�W: " + this.getName());
		System.out.println("\t���|�O�I�s��: " + this.getSsn());
	}
}	
