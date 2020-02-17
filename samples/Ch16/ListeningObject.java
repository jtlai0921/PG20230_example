// Class #1:  ListeningObject.java

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 這是「監聽方程式」的其中一半: 具體來說, 這是一個可以註冊監聽其它物件產生的
// 屬性變更事件 (PropertyChangeEvent) 的物件. 可以把它想成一個大「耳朵」
// 或天線！
//
// 這可以是「任意」型別的物件: 一般來說, 這會是個 GUI 元件 (「外觀」物件), 
// 而它會監聽一些專業領域 (「模型」) 物件的變動.

import java.beans.*;

// 我們實作 PropertyChangeListener 介面, 讓這個類別的實體能知道
// 其它類別的實體 (監聽對象) 有重要屬性發生變動的情形.

public class ListeningObject implements PropertyChangeListener {
	// 非必要: 我準備握住監聽對象, 單純握住而已. 我沒有使用它的需求,
	// 只是單純示範可以這麼做而已.
	Object objectToBeListenedTo;

	// "監聽者" A 必須以某種方式取得 "監聽對象" B 的握柄.  作法只有一種:
	// 也就是將 B 以方法引數的方式交給 A. (另一種方式是將 "B" 宣告為
	// 應用程式的 public (static) 屬性, 讓它成為全域物件.)

	// (請留意下一個方法的 "ListenedToObject" 引數, 這是個我發明的介面;
	// 詳情請見 ListenedToObject.java 的註解.
	public void handInListenedToObject(ListenedToObject 
					   objectToBeListenedTo) {

		// 將「這個」物件註冊為「那個」物件的 PropertyChange 事件
		// 監聽者. (請參見 ListenedToObject.java 與 SomeObject.java 
		// 的註解)
		objectToBeListenedTo.addPropertyChangeListener(this);

		// 可略: 我要握住監聽對象的握柄, 沒為什麼.
		this.objectToBeListenedTo = objectToBeListenedTo;
	}

	// PropertyChangeListener 介面要求實作下面這些方法, 以便處理收到的
	// 事件. 不管這個物件監聽了幾個型別各異的物件, 它們「全部」都將跑到
	// 這個方法內. 請閱讀 PropertyChangeEvent 的文件, 裡面有「分辨」這些
	// 物件的方法.
	public void propertyChange(PropertyChangeEvent e) {
		// 檢查變動的是哪個屬性
	        if (e.getPropertyName().equals("foobar")) {
			// 在這個方法內, 我們可以用 e.getOldValue() 或
			// e.getNewValue(), 這兩者都會傳回 Object; 以及
			// 傳回 String 的 e.getPropertyName().
			System.out.println("foobar 屬性的" +
				"舊值是 " + e.getOldValue() + 
				" 新值則是 " + e.getNewValue() +
				" ...");

			// 作一些「正式」的處理動作,
			// 像是更新 GUI, 同步資料等等
		}
	        else if (e.getPropertyName().equals("barfoo")) {
			System.out.println("barfoo 屬性的" +
				"舊值是 " + e.getOldValue() +
				" 新值則是 " + e.getNewValue() +
				" ...");

			// 作一些「正式」的處理動作
		}
	}
}
