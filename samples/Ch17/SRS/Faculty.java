// Faculty.java - Chapter 15, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// �o�O�ӡu��@�v���O


// �� 14 �����g���L�A�ڭ̥���N Professor ���s���ʸ˦b Faculty ���O���A
// �N���ڭ̦b�� 14 ���� Section ���s���ʸ˨� ScheduleOfClasses ���O�@�ˡC
// �o�˥i�H�����ε{���h�@�h��H�ʡC

import java.util.*;
import java.io.*;

public class Faculty {
	//------
	// �ݩ�
	//------

	// �o�� HashMap �s��F Professor ����Ѧ�
	// �åH Professor �����|�O�I�s�� (String) �����

	private HashMap<String, Professor> professors;

	//--------
	// �غc�l
	//--------

	public Faculty() {
		// �ڭ̱N���U���Ÿs����{��

		professors = new HashMap<String, Professor>();
	}

	//----------
	// �s����k
	//----------

	// �S��!

	//----------
	// ������k
	//----------

	public void display() {
		// �v���B�z HashMap ����ܨC�Ӷ���

		for (Professor p : professors.values()) {
			p.display();
			System.out.println();
		}
	}

	public void addProfessor(Professor p) {
		professors.put(p.getSsn(), p);
	}

	public Professor findProfessor(String ssn) {
		return (Professor) professors.get(ssn);
	}

	public boolean isEmpty() {
		if (professors.size() == 0) return true;
		else return false;
	}
}
