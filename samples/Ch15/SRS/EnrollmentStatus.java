// EnrollmentStatus.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// �u���U�Ρv�C�|���O


// Section ���O�|�H���N��ǥ͹��տ�ת��U�سB�z���G

public enum EnrollmentStatus {
	// �C�|�o�� enum �i�H�ϥΪ���
	success("��צ��\!  :o)"), 
	secFull("��ץ���; �ҵ{�H�Ƥw��.  :op"), 
	prereq("��ץ���; �|���ק����׽ҵ{.  :op"), 
	prevEnroll("��ץ���; �w�g��׹L�F.  :op");

	// �o�N�� enum ���骺��
	private final String value;

	// �غc�l (�W���Ψ�)
	EnrollmentStatus(String value) {
		this.value = value;
	}

	// enum ����Ȫ��s����k
	public String value() {
		return value;
	}
}
