// Class #4:  BeanExample.java

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 這是在物件之間交換事件的驅動程式示範 ... 請一併參考 ListeningObject.java, 
// ListenedToObject.java 與 SomeObject.java.

public class BeanExample {
	public static void main(String[] args) {
		SomeObject mouth = new SomeObject();
		ListeningObject ear = new ListeningObject();
		
		// 把 "mouth" 的參考交給 "ear" !
		ear.handInListenedToObject(mouth);

		// 接著在我們變動 "mouth" 的屬性時,
		// "ear" 應該會接到通知!
		mouth.setFoobar("chocolate");
		mouth.setBarfoo("pizza");
	}
}
