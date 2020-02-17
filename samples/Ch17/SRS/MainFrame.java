// MainFrame.java - Chapter 16, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// �o�O�� GUI ���O


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class MainFrame extends JFrame {
	// �N�Ҧ�����b���w�q�����O���ݩ�
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

	// ����n�J�� Student �����`
	// (�o�O null ���ܴN�N��S�H�n�J)
	private Student currentUser;

	// �غc�l
	public MainFrame() {
		// ���ݩʫ��w���
		currentUser = null;

		// �d�N�o���ꤣ���[�W "this." -- ����W�۩I�s����k
		// (�e���S�[�W�I�g�k) ���|�۰ʷ��� "�o��" ���󪺩I�s�ʧ@
		this.setTitle("Student Registration System");
		this.setSize(500, 300);
		Container contentPane = this.getContentPane( );

		// �b�ù��W�m����ܵ���
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width)/2, 
		                 (screenSize.height - frameSize.height)/2);

		// �إߴX�����O

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

		// �ڭ̱N���D�������G���~��u�ιw�]�� BorderLayout.

		// �Яd�N, �ڭ̦b�[�J���Ҫ��ɭԨS���d�U���`! �o�O�]��
		// �b�N���̱��W GUI ����, �ڭ̴N���|�H�{���X��o�Ǫ���
		// ���q���t�G; �]���ڭ̤��ШϥΦP�@�ӰѦ��ܼ� "l".

		JLabel l = new JLabel("SSN:  ");
		l.setForeground(Color.black);
 		labelPanel.add(l);

		l = new JLabel("�m�W:  ");
		l.setForeground(Color.black);
 		labelPanel.add(l);

		l = new JLabel("��׬���`��:  ");
		l.setForeground(Color.black);
		labelPanel.add(l);

		// �Τ@�ӨS���e�����Ҷ��/�d��
		l = new JLabel("");
 		labelPanel.add(l);

		// �ڭ� "���T" �|����i�H�ק諸����, �o�˵y��ڭ̤~��H�W��
		// �^�YŪ�g���̪����e.  �d�N�ڭ̨�N�����̿�F�y�z�ʪ��W��.
 		ssnField = new JTextField(10);

 		nameLabel = new JLabel();
		nameLabel.setForeground(Color.black);

		totalCoursesLabel = new JLabel(); 
		totalCoursesLabel.setForeground(Color.black);

		fieldPanel.add(ssnField);
		fieldPanel.add(nameLabel);
		fieldPanel.add(totalCoursesLabel);
		
		// �Τ@�ӨS���e�����Ҷ��/�d��
		l = new JLabel("");
 		fieldPanel.add(l);

		// �إ߫��s, �ñN���̩�W���O; �o��P�˥ΤF�y�z�ʪ��W��.
		dropButton = new JButton("�h��");
		addButton = new JButton("�[��");
		logoffButton = new JButton("�n�X");

		// �إߨ�Ʀh����Ҫ����s
		saveScheduleButton = new JButton();
		saveScheduleButton.setLayout(new GridLayout(2, 1));
		l1 = new JLabel("�x�s�ڪ�", JLabel.CENTER);
		l1.setForeground(Color.black);
		l2 = new JLabel("�ҵ{�M��", JLabel.CENTER);
		l2.setForeground(Color.black);
		saveScheduleButton.add(l1);
		saveScheduleButton.add(l2);

		buttonPanel.add(dropButton);
		buttonPanel.add(saveScheduleButton);
		buttonPanel.add(new JLabel("")); // �d�ն��
		buttonPanel.add(addButton);
		buttonPanel.add(logoffButton);

		studentCourseList = new JList();
		studentCourseList.setFixedCellWidth(200);
		bottomLeftPanel.add(studentCourseList, BorderLayout.CENTER);

		l = new JLabel("�w���:");
		l.setForeground(Color.black);
		bottomLeftPanel.add(l, BorderLayout.NORTH);

		l = new JLabel("--- �Ǵ��Ҫ� ---", JLabel.CENTER);
		l.setForeground(Color.black);
		rightPanel.add(l, BorderLayout.NORTH);

		// �q ScheduleOfClasses ���^ Section �� Collection,
		// �M��H�p�����u���ȡv��k sortSections �N���ƧǦn, �A��ܥX��
		scheduleOfClassesList = new JList(sortSections(SRS.scheduleOfClasses.
			getSectionsOffered()));

		scheduleOfClassesList.setFixedCellWidth(250);
		rightPanel.add(scheduleOfClassesList, BorderLayout.EAST);

		// �N���s�]�����T���}��/�������A
		resetButtons();

		// �̫�, �N�Ҧ����O�|�_��, ���������Y
		// �̷ӦC, �滼�W���Ǧw��
		topLeftPanel.add(labelPanel);
		topLeftPanel.add(fieldPanel);
		leftPanel.add(topLeftPanel);
		leftPanel.add(bottomLeftPanel);
		contentPane.add(leftPanel, BorderLayout.WEST);
		contentPane.add(rightPanel, BorderLayout.CENTER);
		contentPane.add(buttonPanel, BorderLayout.SOUTH);

		// ------------
		// �[�J�Ҧ��欰
		// ------------

		// ���P���������󥲶��ϥΤ��P��������ť��:
		//
		// o	��r���|�b���U Enter ���ɭ�
		//	�^�� ActionListener
		//
		// o	���s�|�b���U���ɭԦ^�� ActionListener
		//
		// o	JLists �|�b������ت��ɭ�
		//	�^�� ListSelectionListener

		ActionListener aListener;
		ListSelectionListener lListener;
		WindowListener wListener;

		// ssnField

		aListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ����, �M����ܵۤW�@��ǥ͸�T�����
				clearFields();
		
				// �ڭ̱N�յۥH GUI Ū�J�� SSN �إ� Student
				String id = ssnField.getText();
				Student theStudent = null;

				try {
					theStudent = SRSDataAccess.initializeStudent(id);
				}
				catch (InvalidStudentException e2) {
					// �p��! ID ����
					currentUser = null;
	
					// ���ϥΪ̪��D�n�J����
					JOptionPane.showMessageDialog(null, 
					"�ǥ� ID ����; �ЦA�դ@���C",
					"�ǥ� ID ����",
					JOptionPane.WARNING_MESSAGE);

				    return;
				}
				
				// �p�G�ڭ̰����o�䪺��, �N�N��ǥ͸�ƬO�諸
				// ���ۧڭ̻ݭn�߰�, ���ұK�X.
				// �ڭ̱N�H MainFrame �����U��k�i��᭱�o��
				// �u�@.
				PasswordPopup pp = new PasswordPopup(
					MainFrame.this);
				String pw = pp.getPassword();
				pp.dispose();

				if (validatePassword(theStudent, pw)) {
					currentUser = theStudent;
					setFields(theStudent);

					// ���ϥΪ̪��D�n�J���\
					JOptionPane.showMessageDialog(null, 
						"�ǥ� " +
						theStudent.getName() +
						" �n�J���\�C",
						"�n�J���\",
						JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					// �K�X���ҥ���; �q���ϥΪ�
					JOptionPane.showMessageDialog(null, 
						"�K�X���~; �ЦA�դ@���C",
						"�K�X���~",
						JOptionPane.WARNING_MESSAGE);
				}

				MainFrame.this.repaint();

				// �N���s�]�����T���}��/�������A
				resetButtons();
			}
		};
		ssnField.addActionListener(aListener);

		// addButton

		aListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �P�_�ثe������ҵ{ 
				// (�Яd�N�ڭ̥����૬, �]���Ǧ^���O Object �Ѧ�)
				Section selected = (Section)
					scheduleOfClassesList.getSelectedValue();

				// �ˬd�ǥͬO�_��F�P�@�ӡu��ءv���䥦�u�ҵ{�v
				// �p�G������, �N����ĵ�i�T��
				if (currentUser.isCurrentlyEnrolledInSimilar(selected)) {
					// �إߤ@�Ӥ��t�u���v�T����r�� String �}�C
					// �o�˹�ܲ��~���|�Ӽe
					String[] message = 
					{"�z�w�g��F�o�Ӭ�ت��䥦�ҵ{, ",
					 "�Ϊ̬O���e�w�g�׹L�F�C",
					 " " };

					// ���ۥi�H�� String �}�C�����浹 showMessageDialog() ��k
					JOptionPane.showMessageDialog(null, 
						message,
						"�ڵ����",
						JOptionPane.WARNING_MESSAGE);
				}
				else {
					// �������ǥͿ�׽ҵ{, �æ^���B�z���G
					EnrollmentStatus outcome =
						selected.enroll(currentUser);

					// �V�ϥΪ̦^���B�z���G
					if (outcome != EnrollmentStatus.success) {
					    JOptionPane.showMessageDialog(
						null, 
						outcome.value(),
						"�ڵ����",
						JOptionPane.WARNING_MESSAGE);
					}
					else { // ���\!
						// ��ܽT�{�T��
						JOptionPane.showMessageDialog(
							null, 
							"�w��� " + selected.
							getRepresentedCourse().
							getCourseNo() + ".",
							"��Ҧ��\",
							JOptionPane.INFORMATION_MESSAGE);

						// ��s�ǥͥثe����ҲM��
						// (�d�N JList �Ʊ�o��@�Ӱ}�C,
						// �ҥH�ڭ̩I�s getEnrolledSectionx ��k
						// �Ǧ^���s���� toArray ��k.)

						studentCourseList.setListData(
							currentUser.
								getEnrolledSections().toArray(new Section[1]));

						// ��s��ܾǥͽҵ{�`�ƪ�����
						int total = 
							currentUser.getEnrolledSections().size();
						totalCoursesLabel.setText("" + total);

						// �����Ǵ��Ҫ��������
						scheduleOfClassesList.clearSelection();
					}
				}

				// �N���s�]�����T���}��/�������A
				resetButtons();
			}
		};
		addButton.addActionListener(aListener);

		// dropButton

		aListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �P�_�ثe��w���ҵ{
				// (�d�N�ڭ̥����૬, �]���Ǧ^���O Object �Ѧ�)
				Section selected = (Section)
					studentCourseList.getSelectedValue();

				// �h���ҵ{
				selected.drop(currentUser);

				// ��ܽT�{�T��
				JOptionPane.showMessageDialog(null, 
					"�w�h�� " + selected.
					    getRepresentedCourse().
					    getCourseNo() + " �ҵ{�C",
					"�h�令�\",
					JOptionPane.INFORMATION_MESSAGE);

				// ��s�ǥͥثe����Ҫ�
				// (�d�N JList �ݭn���O�}�C, �ҥH�ڭ̩I�s
				//  getEnrolledSections ��k�Ǧ^���s���� toArray ��k)
				studentCourseList.setListData(
					currentUser.
						getEnrolledSections().toArray(new Section[1]));

				// ��s��ܾǥͽҵ{�`�ƪ����
				int total = currentUser.getEnrolledSections().size();
				totalCoursesLabel.setText("" + total);

				// �N���s�]�����T���}��/�������A
				resetButtons();
			}
		};
		dropButton.addActionListener(aListener);

		// saveScheduleButton

		aListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SRSDataAccess.persistStudent(currentUser);

					// �p�G�S����X�ҥ~����,
					// �N�q���ϥΪ̷s�Ҫ�w�g�x�s����
					JOptionPane.showMessageDialog(null, 
						"�Ҫ�w�x�s�����C", 
						"�Ҫ��x�s����",
						JOptionPane.INFORMATION_MESSAGE);
				}
				catch (StudentPersistenceException e2) {
					// ���ϥΪ̪��D�x�s�L�{�X�F���D
					JOptionPane.showMessageDialog(null, 
						"�x�s�Ҫ�ɵo�Ͱ��D; " +
						"�дM�� SRS ���@�H�����o��U�C",
						"�Ҫ��x�s����",
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

				// �����Ҫ����������
				scheduleOfClassesList.clearSelection();

				// �ˬd�U���s�����A
				resetButtons();
			}
		};
		logoffButton.addActionListener(aListener);

		// studentCourseList

		lListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// ����F�u�o�ӡv�M�檺���ؤ���,
				// �N�|�����u�t�@�ӡv�M�椧�����������
				if (!(studentCourseList.isSelectionEmpty())) 
					scheduleOfClassesList.clearSelection();

				// �N���s�]�����T���}��/�������A
				resetButtons();
			}
		};
		studentCourseList.addListSelectionListener(lListener);

		// scheduleOfClassesList

		lListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// ����F�u�o�ӡv�M�檺���ؤ���,
				// �N�|�����u�t�@�ӡv�M�椧�����������
				if (!(scheduleOfClassesList.isSelectionEmpty())) 
					studentCourseList.clearSelection();

				// �N���s�]�����T���}��/�������A
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
        // ���Ȥ�k.
        //-----------

	private void resetButtons() {
		// �C�ӫ��s�����A���ѥ|�ӱ���@�_����:
		//	
		// o	�O�_���ϥΪ̵n�J

		boolean isLoggedOn;
		if (currentUser != null) isLoggedOn = true;
		else isLoggedOn = false;
		
		// o	�ϥΪ̬O�_��F�ܤ֤@��ҵ{

		boolean atLeastOne;
		if (currentUser != null && currentUser.getEnrolledSections().size() > 0)
			atLeastOne = true;
		else atLeastOne = false;

		// o	�O�_����F�Y�ӿ�쪺�ҵ{

		boolean courseSelected;
		if (studentCourseList.isSelectionEmpty()) 
			courseSelected = false;
		else courseSelected = true;
		
		// o    �O�_����F�Ǵ��Ҫ������ҵ{

		boolean catalogSelected;
		if (scheduleOfClassesList.isSelectionEmpty()) 
			catalogSelected = false;
		else catalogSelected = true;

		// �{�b, ���U�ӫ��s���O�ˬd�o�Ǳ���

		// �h����s:

		if (isLoggedOn && atLeastOne && courseSelected)
			dropButton.setEnabled(true);
		else dropButton.setEnabled(false);

		// �[����s:

		if (isLoggedOn && catalogSelected)
			addButton.setEnabled(true);
		else addButton.setEnabled(false);

		// �x�s�ڪ��ҵ{�M����s:

		if (isLoggedOn) {
			saveScheduleButton.setEnabled(true);

			// �ѩ�ڭ̫إ߫��ӫ��s���覡�ϵM,
			// �ڭ̥����h���@�I�Ʊ��~����������{���}/�������~�[
			l1.setEnabled(true); 
			l2.setEnabled(true); 
		}
		else {
			saveScheduleButton.setEnabled(false);
			l1.setEnabled(false); 
			l2.setEnabled(false); 
		}

		// �n�X���s:

		if (isLoggedOn) logoffButton.setEnabled(true);  
		else logoffButton.setEnabled(false);  
	}

	// �b�ϥΪ̵n�X���ɭԩI�s

	private void clearFields() {
		nameLabel.setText("");
		totalCoursesLabel.setText("");

		// �Яd�N JList �ݭn�@�Ӱ}�C,
		// �ҥH�ڭ̰��@�� Object �}�C�u�Ŵߡv�Ƕi�h
		studentCourseList.setListData(new Object[1]);
	}

	// �]�w�U�����, �M�浥�����e, �ϬM�Y��ǥͪ���� (�n�J�ɩI�s)

	private void setFields(Student theStudent) {
		nameLabel.setText(theStudent.getName());
		int total = theStudent.getEnrolledSections().size();
		totalCoursesLabel.setText("" + total);
	
		// �p�G�ǥͤw�g��ץ���ҵ{����, �N�N������ܥX��
		if (total > 0) {
			// �ѩ�ڭ̤w�g���Ӹs���s��۾ǥͿ�ת��ҵ{,
			// �ӳo�Ǫ���S������ toString() ��k,
			// �]���ڭ̥i�H������o�Ӹs�Υ浹 JList
			// (�d�N JList �ݭn���O�}�C, �]���ڭ̩I�s
			//  getEnrolledSections ��k�^�Ǫ��s���� toArray ��k)
			studentCourseList.setListData(theStudent.
				getEnrolledSections().toArray(new Section[1]));
		}
	}

	// �N HashMap �����e�ন Section �}�C, 
	// �æb�L�{���̷Ӧr�����ǱƧǪ����U��k

	private Section[] sortSections(HashMap<String, Section> sections) {
		// �ڭ̱N�� HashMap �����e��� TreeMap ����,
		// ���|�۰ʱN���ب̷ӻ��W��ȶ��ǱƧ�
		TreeMap<String, Section> sortedMap = 
			new TreeMap<String, Section>(sections);
		
		return sortedMap.values().toArray(new Section[1]);
	}

	// ���ǥͱK�X�P ID �Y�T�ӼƦr, ���Ҿǥͨ��������U��k

	private boolean validatePassword(Student s, String pw) {
		if (pw == null) return false;
		else if (s.getSsn().startsWith(pw)) return true;
		else return false;
	}
 }
