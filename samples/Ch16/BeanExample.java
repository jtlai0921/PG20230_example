// Class #4:  BeanExample.java

// Copyright 2005 by Jacquie Barker - all rights reserved.

// �o�O�b���󤧶��洫�ƥ��X�ʵ{���ܽd ... �Ф@�ְѦ� ListeningObject.java, 
// ListenedToObject.java �P SomeObject.java.

public class BeanExample {
	public static void main(String[] args) {
		SomeObject mouth = new SomeObject();
		ListeningObject ear = new ListeningObject();
		
		// �� "mouth" ���Ѧҥ浹 "ear" !
		ear.handInListenedToObject(mouth);

		// ���ۦb�ڭ��ܰ� "mouth" ���ݩʮ�,
		// "ear" ���ӷ|����q��!
		mouth.setFoobar("chocolate");
		mouth.setBarfoo("pizza");
	}
}
