// Class #3:  SomeObject.java

// Copyright 2005 by Jacquie Barker - all rights reserved.

// �o�O�ӭn�Q "��ť" ������; ���i�H�O���N���O!

// �o���O�� Java Bean! �z�Ѧp���ѩҥ�.

import java.beans.*;

public class SomeObject implements ListenedToObject {
	// �U���o��ӬO "ô���ݩ�" (bound property)
	private String foobar;
	private String barfoo;

	// ô���ݩʬO�� JavaBeans �� "�N�y", �����O�|�b���e�ܰʮɳq����ť�̪��ݩ�.
	// Bean (�o�����O) ��@ô���ݩʪ��覡�����:
	//
	//	1.	�b�{���X�����ݩʤ��e���ɭ�, �n�޵o PropertyChange �ƥ�,
	//		�q�`�o�b�ݩʪ� Set ��k���i�� (�аѾ\�W���o����ݩ�
	//		��b�U���� Set ��k).
	//
	//	2.	Bean �]������������ť�̵��U������. �o�i�H�z�L
	//		�إ� PropertyChangeSupport ����� Bean ���O���ݩ� (�p�U),
	//		�ӫᴣ�ѴX�� ListenedToObject �����w�q����k����
	//
	// ��M, "��ť��" �]�������I�Ʊ�! ��{�����t�@�b�аѷ� ListeningObject.java.

	// �n���o�Ӫ���z�L PropertyChangeEvent �P�䥦���󷾳q, �ڭ̥���
	// �� "�o��" ���O�ᤩ�V���U����ť�̵o�X PropertyChange �ƥ󪺯�O --
	// �ڭ̷|�H private �ݩʪ��覡�إ� PropertyChangeSupport (PCS) ����, 
	// �M��N�Ҧ��u�@ "�e��" ����, �H�K�F���o�ӥت�!

	private PropertyChangeSupport pcs = 
				new PropertyChangeSupport(this);

	// Get/Set ��k
	public void setFoobar(String newValue) {
		String oldValue = this.foobar;
		this.foobar = newValue;

		// �Ш��y���Q�� "ô��" �ݩʪ����e.  �� "ô��" �ݩʪ����e
		// ���ܮ�, �ڭ̱N�޵o�ƥ�, �ϥ��ǵ��Ҧ����U����ť��
		pcs.firePropertyChange("foobar", oldValue, newValue);
	}

	public void setBarfoo(String newValue) {
		String oldValue = this.barfoo;
		this.barfoo = newValue;

		// �Ш��y���Q�� "ô��" �ݩʪ����e.  �� "ô��" �ݩʪ����e
		// ���ܮ�, �ڭ̱N�޵o�ƥ�, �ϥ��ǵ��Ҧ����U����ť��
		pcs.firePropertyChange("barfoo", oldValue, newValue);
	}

	// �U���o�Ӥ�k�|�[�J PropertyChange �䴩

	public void addPropertyChangeListener(
					PropertyChangeListener l) {
		// �ڭ̱N�s�W��ť�̪��u�@�e���� PCS ����i��.

		// ���F�w���_��, ��������, �T�O�����|�w�g�b�M�椺
		pcs.removePropertyChangeListener(l);

		pcs.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(
					PropertyChangeListener l) {
		// �ڭ̦P�ˤ]�N������ť�̪��u�@�e���� PCS �i��.

		pcs.removePropertyChangeListener(l);
	}
}
