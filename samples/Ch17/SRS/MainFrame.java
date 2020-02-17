// MainFrame.java - Chapter 16, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// 這是個 GUI 類別


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class MainFrame extends JFrame {
	// 將所有元件在此定義為類別的屬性
	private JPanel leftPanel;
	private JPanel topLeftPanel;
	private JPanel labelPanel;
	private JPanel fieldPanel;
	private JPanel bottomLeftPanel;
	private JPanel rightPanel;
	private JPanel buttonPanel;
	private JTextField ssnField;
	private JLabel nameLabel;
	private JLabel totalCoursesLabel;
	private JButton dropButton;
	private JButton addButton;
	private JButton logoffButton;
	private JButton saveScheduleButton; 
	private JLabel l1;
	private JLabel l2;
	private JList studentCourseList;
	private JList scheduleOfClassesList;

	// 握住登入的 Student 的握柄
	// (這是 null 的話就代表沒人登入)
	private Student currentUser;

	// 建構子
	public MainFrame() {
		// 為屬性指定初值
		currentUser = null;

		// 留意這邊其實不必加上 "this." -- 任何獨自呼叫的方法
		// (前面沒加上點寫法) 都會自動當成對 "這個" 物件的呼叫動作
		this.setTitle("Student Registration System");
		this.setSize(500, 300);
		Container contentPane = this.getContentPane( );

		// 在螢幕上置中顯示視窗
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width)/2, 
		                 (screenSize.height - frameSize.height)/2);

		// 建立幾塊面板

		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(2, 1));  

		topLeftPanel = new JPanel();
		topLeftPanel.setLayout(new GridLayout(1, 2));  

		labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(4, 1));

		fieldPanel = new JPanel();
		fieldPanel.setLayout(new GridLayout(4, 1));

		bottomLeftPanel = new JPanel();
		bottomLeftPanel.setLayout(new BorderLayout());
		
		rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 4)); 

		// 我們將讓主視窗的佈局繼續沿用預設的 BorderLayout.

		// 請留意, 我們在加入標籤的時候沒有留下握柄! 這是因為
		// 在將它們掛上 GUI 之後, 我們就不會以程式碼跟這些物件
		// 溝通的緣故; 因此我們反覆使用同一個參考變數 "l".

		JLabel l = new JLabel("SSN:  ");
		l.setForeground(Color.black);
 		labelPanel.add(l);

		l = new JLabel("姓名:  ");
		l.setForeground(Color.black);
 		labelPanel.add(l);

		l = new JLabel("選修科目總數:  ");
		l.setForeground(Color.black);
		labelPanel.add(l);

		// 用一個沒內容的標籤填空/留白
		l = new JLabel("");
 		labelPanel.add(l);

		// 我們 "的確" 會握住可以修改的元件, 這樣稍後我們才能以名稱
		// 回頭讀寫它們的內容.  留意我們刻意為它們選了描述性的名稱.
 		ssnField = new JTextField(10);

 		nameLabel = new JLabel();
		nameLabel.setForeground(Color.black);

		totalCoursesLabel = new JLabel(); 
		totalCoursesLabel.setForeground(Color.black);

		fieldPanel.add(ssnField);
		fieldPanel.add(nameLabel);
		fieldPanel.add(totalCoursesLabel);
		
		// 用一個沒內容的標籤填空/留白
		l = new JLabel("");
 		fieldPanel.add(l);

		// 建立按鈕, 並將它們放上面板; 這邊同樣用了描述性的名稱.
		dropButton = new JButton("退選");
		addButton = new JButton("加選");
		logoffButton = new JButton("登出");

		// 建立具備多行標籤的按鈕
		saveScheduleButton = new JButton();
		saveScheduleButton.setLayout(new GridLayout(2, 1));
		l1 = new JLabel("儲存我的", JLabel.CENTER);
		l1.setForeground(Color.black);
		l2 = new JLabel("課程清單", JLabel.CENTER);
		l2.setForeground(Color.black);
		saveScheduleButton.add(l1);
		saveScheduleButton.add(l2);

		buttonPanel.add(dropButton);
		buttonPanel.add(saveScheduleButton);
		buttonPanel.add(new JLabel("")); // 留白填空
		buttonPanel.add(addButton);
		buttonPanel.add(logoffButton);

		studentCourseList = new JList();
		studentCourseList.setFixedCellWidth(200);
		bottomLeftPanel.add(studentCourseList, BorderLayout.CENTER);

		l = new JLabel("已選修:");
		l.setForeground(Color.black);
		bottomLeftPanel.add(l, BorderLayout.NORTH);

		l = new JLabel("--- 學期課表 ---", JLabel.CENTER);
		l.setForeground(Color.black);
		rightPanel.add(l, BorderLayout.NORTH);

		// 從 ScheduleOfClasses 取回 Section 的 Collection,
		// 然後以私有的「內務」方法 sortSections 將它排序好, 再顯示出來
		scheduleOfClassesList = new JList(sortSections(SRS.scheduleOfClasses.
			getSectionsOffered()));

		scheduleOfClassesList.setFixedCellWidth(250);
		rightPanel.add(scheduleOfClassesList, BorderLayout.EAST);

		// 將按鈕設為正確的開啟/關閉狀態
		resetButtons();

		// 最後, 將所有面板疊起來, 放到視窗裡頭
		// 依照列, 欄遞增順序安放
		topLeftPanel.add(labelPanel);
		topLeftPanel.add(fieldPanel);
		leftPanel.add(topLeftPanel);
		leftPanel.add(bottomLeftPanel);
		contentPane.add(leftPanel, BorderLayout.WEST);
		contentPane.add(rightPanel, BorderLayout.CENTER);
		contentPane.add(buttonPanel, BorderLayout.SOUTH);

		// ------------
		// 加入所有行為
		// ------------

		// 不同類型的元件必須使用不同類型的監聽者:
		//
		// o	文字欄位會在按下 Enter 的時候
		//	回應 ActionListener
		//
		// o	按鈕會在按下的時候回應 ActionListener
		//
		// o	JLists 會在選取項目的時候
		//	回應 ListSelectionListener

		ActionListener aListener;
		ListSelectionListener lListener;
		WindowListener wListener;

		// ssnField

		aListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 首先, 清除顯示著上一位學生資訊的欄位
				clearFields();
		
				// 我們將試著以 GUI 讀入的 SSN 建立 Student
				String id = ssnField.getText();
				Student theStudent = null;

				try {
					theStudent = SRSDataAccess.initializeStudent(id);
				}
				catch (InvalidStudentException e2) {
					// 喵的! ID 不對
					currentUser = null;
	
					// 讓使用者知道登入失敗
					JOptionPane.showMessageDialog(null, 
					"學生 ID 不對; 請再試一次。",
					"學生 ID 不對",
					JOptionPane.WARNING_MESSAGE);

				    return;
				}
				
				// 如果我們執行到這邊的話, 就代表學生資料是對的
				// 接著我們需要詢問, 驗證密碼.
				// 我們將以 MainFrame 的輔助方法進行後面這項
				// 工作.
				PasswordPopup pp = new PasswordPopup(
					MainFrame.this);
				String pw = pp.getPassword();
				pp.dispose();

				if (validatePassword(theStudent, pw)) {
					currentUser = theStudent;
					setFields(theStudent);

					// 讓使用者知道登入成功
					JOptionPane.showMessageDialog(null, 
						"學生 " +
						theStudent.getName() +
						" 登入成功。",
						"登入成功",
						JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					// 密碼驗證失敗; 通知使用者
					JOptionPane.showMessageDialog(null, 
						"密碼錯誤; 請再試一次。",
						"密碼錯誤",
						JOptionPane.WARNING_MESSAGE);
				}

				MainFrame.this.repaint();

				// 將按鈕設為正確的開啟/關閉狀態
				resetButtons();
			}
		};
		ssnField.addActionListener(aListener);

		// addButton

		aListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 判斷目前選到哪堂課程 
				// (請留意我們必須轉型, 因為傳回的是 Object 參考)
				Section selected = (Section)
					scheduleOfClassesList.getSelectedValue();

				// 檢查學生是否選了同一個「科目」的其它「課程」
				// 如果有的話, 就產生警告訊息
				if (currentUser.isCurrentlyEnrolledInSimilar(selected)) {
					// 建立一個內含「兩行」訊息文字的 String 陣列
					// 這樣對話盒才不會太寬
					String[] message = 
					{"您已經選了這個科目的其它課程, ",
					 "或者是先前已經修過了。",
					 " " };

					// 接著可以把 String 陣列直接交給 showMessageDialog() 方法
					JOptionPane.showMessageDialog(null, 
						message,
						"拒絕選課",
						JOptionPane.WARNING_MESSAGE);
				}
				else {
					// 嘗試讓學生選修課程, 並回報處理結果
					EnrollmentStatus outcome =
						selected.enroll(currentUser);

					// 向使用者回報處理結果
					if (outcome != EnrollmentStatus.success) {
					    JOptionPane.showMessageDialog(
						null, 
						outcome.value(),
						"拒絕選課",
						JOptionPane.WARNING_MESSAGE);
					}
					else { // 成功!
						// 顯示確認訊息
						JOptionPane.showMessageDialog(
							null, 
							"已選到 " + selected.
							getRepresentedCourse().
							getCourseNo() + ".",
							"選課成功",
							JOptionPane.INFORMATION_MESSAGE);

						// 更新學生目前的選課清單
						// (留意 JList 希望得到一個陣列,
						// 所以我們呼叫 getEnrolledSectionx 方法
						// 傳回的群集的 toArray 方法.)

						studentCourseList.setListData(
							currentUser.
								getEnrolledSections().toArray(new Section[1]));

						// 更新顯示學生課程總數的標籤
						int total = 
							currentUser.getEnrolledSections().size();
						totalCoursesLabel.setText("" + total);

						// 取消學期課表的選取項目
						scheduleOfClassesList.clearSelection();
					}
				}

				// 將按鈕設為正確的開啟/關閉狀態
				resetButtons();
			}
		};
		addButton.addActionListener(aListener);

		// dropButton

		aListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 判斷目前選定的課程
				// (留意我們必須轉型, 因為傳回的是 Object 參考)
				Section selected = (Section)
					studentCourseList.getSelectedValue();

				// 退掉課程
				selected.drop(currentUser);

				// 顯示確認訊息
				JOptionPane.showMessageDialog(null, 
					"已退掉 " + selected.
					    getRepresentedCourse().
					    getCourseNo() + " 課程。",
					"退選成功",
					JOptionPane.INFORMATION_MESSAGE);

				// 更新學生目前的選課表
				// (留意 JList 需要的是陣列, 所以我們呼叫
				//  getEnrolledSections 方法傳回的群集的 toArray 方法)
				studentCourseList.setListData(
					currentUser.
						getEnrolledSections().toArray(new Section[1]));

				// 更新顯示學生課程總數的欄位
				int total = currentUser.getEnrolledSections().size();
				totalCoursesLabel.setText("" + total);

				// 將按鈕設為正確的開啟/關閉狀態
				resetButtons();
			}
		};
		dropButton.addActionListener(aListener);

		// saveScheduleButton

		aListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SRSDataAccess.persistStudent(currentUser);

					// 如果沒有丟出例外的話,
					// 就通知使用者新課表已經儲存完成
					JOptionPane.showMessageDialog(null, 
						"課表已儲存完成。", 
						"課表儲存完成",
						JOptionPane.INFORMATION_MESSAGE);
				}
				catch (StudentPersistenceException e2) {
					// 讓使用者知道儲存過程出了問題
					JOptionPane.showMessageDialog(null, 
						"儲存課表時發生問題; " +
						"請尋找 SRS 維護人員取得協助。",
						"課表儲存失敗",
						JOptionPane.WARNING_MESSAGE);
				}
			}
		};
		saveScheduleButton.addActionListener(aListener);

		// logoffButton

		aListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFields();
				ssnField.setText("");
				currentUser = null;

				// 取消課表內選取的項目
				scheduleOfClassesList.clearSelection();

				// 檢查各按鈕的狀態
				resetButtons();
			}
		};
		logoffButton.addActionListener(aListener);

		// studentCourseList

		lListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// 選取了「這個」清單的項目之後,
				// 就會取消「另一個」清單之內選取的項目
				if (!(studentCourseList.isSelectionEmpty())) 
					scheduleOfClassesList.clearSelection();

				// 將按鈕設為正確的開啟/關閉狀態
				resetButtons();
			}
		};
		studentCourseList.addListSelectionListener(lListener);

		// scheduleOfClassesList

		lListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// 選取了「這個」清單的項目之後,
				// 就會取消「另一個」清單之內選取的項目
				if (!(scheduleOfClassesList.isSelectionEmpty())) 
					studentCourseList.clearSelection();

				// 將按鈕設為正確的開啟/關閉狀態
				resetButtons();
			}
		};
		scheduleOfClassesList.addListSelectionListener(lListener);

		wListener = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		this.addWindowListener(wListener);

              	this.setVisible(true);
         }

        //-----------
        // 內務方法.
        //-----------

	private void resetButtons() {
		// 每個按鈕的狀態都由四個條件一起控制:
		//	
		// o	是否有使用者登入

		boolean isLoggedOn;
		if (currentUser != null) isLoggedOn = true;
		else isLoggedOn = false;
		
		// o	使用者是否選了至少一堂課程

		boolean atLeastOne;
		if (currentUser != null && currentUser.getEnrolledSections().size() > 0)
			atLeastOne = true;
		else atLeastOne = false;

		// o	是否選取了某個選到的課程

		boolean courseSelected;
		if (studentCourseList.isSelectionEmpty()) 
			courseSelected = false;
		else courseSelected = true;
		
		// o    是否選取了學期課表之內的課程

		boolean catalogSelected;
		if (scheduleOfClassesList.isSelectionEmpty()) 
			catalogSelected = false;
		else catalogSelected = true;

		// 現在, 為各個按鈕分別檢查這些條件

		// 退選按鈕:

		if (isLoggedOn && atLeastOne && courseSelected)
			dropButton.setEnabled(true);
		else dropButton.setEnabled(false);

		// 加選按鈕:

		if (isLoggedOn && catalogSelected)
			addButton.setEnabled(true);
		else addButton.setEnabled(false);

		// 儲存我的課程清單按鈕:

		if (isLoggedOn) {
			saveScheduleButton.setEnabled(true);

			// 由於我們建立後兩個按鈕的方式使然,
			// 我們必須多做一點事情才能讓它們顯現打開/關閉的外觀
			l1.setEnabled(true); 
			l2.setEnabled(true); 
		}
		else {
			saveScheduleButton.setEnabled(false);
			l1.setEnabled(false); 
			l2.setEnabled(false); 
		}

		// 登出按鈕:

		if (isLoggedOn) logoffButton.setEnabled(true);  
		else logoffButton.setEnabled(false);  
	}

	// 在使用者登出的時候呼叫

	private void clearFields() {
		nameLabel.setText("");
		totalCoursesLabel.setText("");

		// 請留意 JList 需要一個陣列,
		// 所以我們做一個 Object 陣列「空殼」傳進去
		studentCourseList.setListData(new Object[1]);
	}

	// 設定各個欄位, 清單等的內容, 反映某位學生的資料 (登入時呼叫)

	private void setFields(Student theStudent) {
		nameLabel.setText(theStudent.getName());
		int total = theStudent.getEnrolledSections().size();
		totalCoursesLabel.setText("" + total);
	
		// 如果學生已經選修任何課程的話, 就將它們顯示出來
		if (total > 0) {
			// 由於我們已經有個群集存放著學生選修的課程,
			// 而這些物件又都提供 toString() 方法,
			// 因此我們可以直接把這個群及交給 JList
			// (留意 JList 需要的是陣列, 因此我們呼叫
			//  getEnrolledSections 方法回傳的群集的 toArray 方法)
			studentCourseList.setListData(theStudent.
				getEnrolledSections().toArray(new Section[1]));
		}
	}

	// 將 HashMap 的內容轉成 Section 陣列, 
	// 並在過程中依照字母順序排序的輔助方法

	private Section[] sortSections(HashMap<String, Section> sections) {
		// 我們將把 HashMap 的內容轉到 TreeMap 之內,
		// 它會自動將項目依照遞增鍵值順序排序
		TreeMap<String, Section> sortedMap = 
			new TreeMap<String, Section>(sections);
		
		return sortedMap.values().toArray(new Section[1]);
	}

	// 比對學生密碼與 ID 頭三個數字, 驗證學生身分的輔助方法

	private boolean validatePassword(Student s, String pw) {
		if (pw == null) return false;
		else if (s.getSsn().startsWith(pw)) return true;
		else return false;
	}
 }
