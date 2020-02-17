// Item #2:  ListenedToObject.java

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 這是個我發明的介面 (其實未必真的「需要」就是); 它指定了要被「監聽」
// 的物件應該實作的兩個方法, 讓 ListeningObject 可以註冊監聽這些物件,
// 在屬性變更的時候收到通知.

import java.beans.*;

public interface ListenedToObject {
	// 要讓這個型別的物件以 PropertyChangeEvents 與其它物件溝通,
	// 我們必須提供觸發 PropertyChange 事件, 以及為這些事件註冊監聽者
	// 的方法 -- 讓「其它」物件在收到這些事件的時候能夠做出適當反應
	// (ListeningObject 物件就是監聽的例子.)

	// 大多數功能都會由「實作」這個介面的類別宣告 PropertyChangeSupport
	// 型別的 private 屬性進行處理. 這個內嵌的 PCS 物件會為我們完成
	// 大部分工作.  不幸的是, 強制物件實作一個指定型別屬性的方式是將它
	// 宣告為 (抽象) 父類別, 然後讓「我們」的類別「擴充」這個類別.
	// 但由於 Java 不支援多重繼承, 單為了繼承 PCS 屬性而擴充某個指定的
	// 父類別, 就會讓這個類別沒辦法成為 GUI 原件的子類別 (像 MyFrame
	// 擴充 JFrame 那樣). 然而我們可以用介面 (也就是「這個」介面)
	// 強制實作者作出下面這兩個方法:
	
	public void addPropertyChangeListener(PropertyChangeListener l);

	public void removePropertyChangeListener(PropertyChangeListener l);

	// 另一種作法是試著用 Java 內建的 Customizer 介面, 它需要三個方法 --
	// 包含上面這兩個. 但因為我們用不到第三個方法, 因此用那個介面
	// 就有點「浪費」.
}
