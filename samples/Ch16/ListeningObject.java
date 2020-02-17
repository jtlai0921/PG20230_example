// Class #1:  ListeningObject.java

// Copyright 2005 by Jacquie Barker - all rights reserved.

// �o�O�u��ť��{���v���䤤�@�b: ����ӻ�, �o�O�@�ӥi�H���U��ť�䥦���󲣥ͪ�
// �ݩ��ܧ�ƥ� (PropertyChangeEvent) ������. �i�H�⥦�Q���@�Ӥj�u�զ��v
// �Τѽu�I
//
// �o�i�H�O�u���N�v���O������: �@��ӻ�, �o�|�O�� GUI ���� (�u�~�[�v����), 
// �ӥ��|��ť�@�ǱM�~��� (�u�ҫ��v) �����ܰ�.

import java.beans.*;

// �ڭ̹�@ PropertyChangeListener ����, ���o�����O������ા�D
// �䥦���O������ (��ť��H) �����n�ݩʵo���ܰʪ�����.

public class ListeningObject implements PropertyChangeListener {
	// �D���n: �ڷǳƴ����ť��H, ��´���Ӥw. �ڨS���ϥΥ����ݨD,
	// �u�O��¥ܽd�i�H�o�򰵦Ӥw.
	Object objectToBeListenedTo;

	// "��ť��" A �����H�Y�ؤ覡���o "��ť��H" B �����`.  �@�k�u���@��:
	// �]�N�O�N B �H��k�޼ƪ��覡�浹 A. (�t�@�ؤ覡�O�N "B" �ŧi��
	// ���ε{���� public (static) �ݩ�, �����������쪫��.)

	// (�Яd�N�U�@�Ӥ�k�� "ListenedToObject" �޼�, �o�O�ӧڵo��������;
	// �Ա��Ш� ListenedToObject.java ������.
	public void handInListenedToObject(ListenedToObject 
					   objectToBeListenedTo) {

		// �N�u�o�ӡv������U���u���ӡv���� PropertyChange �ƥ�
		// ��ť��. (�аѨ� ListenedToObject.java �P SomeObject.java 
		// ������)
		objectToBeListenedTo.addPropertyChangeListener(this);

		// �i��: �ڭn�����ť��H�����`, �S������.
		this.objectToBeListenedTo = objectToBeListenedTo;
	}

	// PropertyChangeListener �����n�D��@�U���o�Ǥ�k, �H�K�B�z���쪺
	// �ƥ�. ���޳o�Ӫ����ť�F�X�ӫ��O�U��������, ���̡u�����v���N�]��
	// �o�Ӥ�k��. �о\Ū PropertyChangeEvent �����, �̭����u����v�o��
	// ���󪺤�k.
	public void propertyChange(PropertyChangeEvent e) {
		// �ˬd�ܰʪ��O�����ݩ�
	        if (e.getPropertyName().equals("foobar")) {
			// �b�o�Ӥ�k��, �ڭ̥i�H�� e.getOldValue() ��
			// e.getNewValue(), �o��̳��|�Ǧ^ Object; �H��
			// �Ǧ^ String �� e.getPropertyName().
			System.out.println("foobar �ݩʪ�" +
				"�­ȬO " + e.getOldValue() + 
				" �s�ȫh�O " + e.getNewValue() +
				" ...");

			// �@�@�ǡu�����v���B�z�ʧ@,
			// ���O��s GUI, �P�B��Ƶ���
		}
	        else if (e.getPropertyName().equals("barfoo")) {
			System.out.println("barfoo �ݩʪ�" +
				"�­ȬO " + e.getOldValue() +
				" �s�ȫh�O " + e.getNewValue() +
				" ...");

			// �@�@�ǡu�����v���B�z�ʧ@
		}
	}
}
