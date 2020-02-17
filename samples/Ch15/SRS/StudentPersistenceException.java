// StudentPersistenceException.java - Chapter 15, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 這是個「實作」類別


// 在我們將 Student 的狀態寫到永久儲存設備時, 如果發生問題的話, 
// 就會丟出這個例外型別進行通報

public class StudentPersistenceException extends SRSInitializationException {
	public StudentPersistenceException(String message) {
		super(message);
	}
}
