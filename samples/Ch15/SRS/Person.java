// Person.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 這是個「模型」類別


// 我們將它宣告為抽象類別, 因為不希望它被具現化

public abstract class Person {
	//------
	// 屬性
	//------

	private String name;
	private String ssn;
	
	//--------
	// 建構子
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
	// 存取方法
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
	// 雜項方法
	//----------

	// 我們將讓每個子類別決定自己的 String 表示法

	public abstract String toString(); 

	public void display() {
		System.out.println("Person 資訊:");
		System.out.println("\t姓名: " + this.getName());
		System.out.println("\t社會保險編號: " + this.getSsn());
	}
}	
