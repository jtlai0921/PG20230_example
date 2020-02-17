// Class #3:  SomeObject.java

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 這是個要被 "監聽" 的物件; 它可以是任意型別!

// 這其實是個 Java Bean! 理由如註解所示.

import java.beans.*;

public class SomeObject implements ListenedToObject {
	// 下面這兩個是 "繫結屬性" (bound property)
	private String foobar;
	private String barfoo;

	// 繫結屬性是個 JavaBeans 的 "術語", 指的是會在內容變動時通知監聽者的屬性.
	// Bean (這個類別) 實作繫結屬性的方式有兩種:
	//
	//	1.	在程式碼改變屬性內容的時候, 要引發 PropertyChange 事件,
	//		通常這在屬性的 Set 方法內進行 (請參閱上面這兩個屬性
	//		位在下面的 Set 方法).
	//
	//	2.	Bean 也必須提供讓監聽者註冊的機制. 這可以透過
	//		建立 PropertyChangeSupport 物件當成 Bean 類別的屬性 (如下),
	//		而後提供幾個 ListenedToObject 介面定義的方法完成
	//
	// 當然, "監聽者" 也必須做點事情! 方程式的另一半請參照 ListeningObject.java.

	// 要讓這個物件透過 PropertyChangeEvent 與其它物件溝通, 我們必須
	// 為 "這個" 類別賦予向註冊的監聽者發出 PropertyChange 事件的能力 --
	// 我們會以 private 屬性的方式建立 PropertyChangeSupport (PCS) 物件, 
	// 然後將所有工作 "委任" 給它, 以便達成這個目的!

	private PropertyChangeSupport pcs = 
				new PropertyChangeSupport(this);

	// Get/Set 方法
	public void setFoobar(String newValue) {
		String oldValue = this.foobar;
		this.foobar = newValue;

		// 請見稍早討論 "繫結" 屬性的內容.  當 "繫結" 屬性的內容
		// 改變時, 我們將引發事件, 使它傳給所有註冊的監聽者
		pcs.firePropertyChange("foobar", oldValue, newValue);
	}

	public void setBarfoo(String newValue) {
		String oldValue = this.barfoo;
		this.barfoo = newValue;

		// 請見稍早討論 "繫結" 屬性的內容.  當 "繫結" 屬性的內容
		// 改變時, 我們將引發事件, 使它傳給所有註冊的監聽者
		pcs.firePropertyChange("barfoo", oldValue, newValue);
	}

	// 下面這個方法會加入 PropertyChange 支援

	public void addPropertyChangeListener(
					PropertyChangeListener l) {
		// 我們將新增監聽者的工作委任給 PCS 物件進行.

		// 為了安全起見, 先移除它, 確保它不會已經在清單內
		pcs.removePropertyChangeListener(l);

		pcs.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(
					PropertyChangeListener l) {
		// 我們同樣也將移除監聽者的工作委任給 PCS 進行.

		pcs.removePropertyChangeListener(l);
	}
}
