// InvalidStudentException.java - Chapter 15, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 這是個「實作」類別


// 在從永久儲存設備復原 Student 狀態的過程中, 如果發生問題的話,
// 就會丟出這個例外型別進行通報

public class InvalidStudentException extends SRSInitializationException {
	public InvalidStudentException(String message) {
		super(message);
	}
}
