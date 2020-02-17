// Item #2:  ListenedToObject.java

// Copyright 2005 by Jacquie Barker - all rights reserved.

// �o�O�ӧڵo�������� (��ꥼ���u���u�ݭn�v�N�O); �����w�F�n�Q�u��ť�v
// ���������ӹ�@����Ӥ�k, �� ListeningObject �i�H���U��ť�o�Ǫ���,
// �b�ݩ��ܧ󪺮ɭԦ���q��.

import java.beans.*;

public interface ListenedToObject {
	// �n���o�ӫ��O������H PropertyChangeEvents �P�䥦���󷾳q,
	// �ڭ̥�������Ĳ�o PropertyChange �ƥ�, �H�ά��o�Ǩƥ���U��ť��
	// ����k -- ���u�䥦�v����b����o�Ǩƥ󪺮ɭԯ�����X�A�����
	// (ListeningObject ����N�O��ť���Ҥl.)

	// �j�h�ƥ\�ೣ�|�ѡu��@�v�o�Ӥ��������O�ŧi PropertyChangeSupport
	// ���O�� private �ݩʶi��B�z. �o�Ӥ��O�� PCS ����|���ڭ̧���
	// �j�����u�@.  �������O, �j����@�@�ӫ��w���O�ݩʪ��覡�O�N��
	// �ŧi�� (��H) �����O, �M�����u�ڭ̡v�����O�u�X�R�v�o�����O.
	// ���ѩ� Java ���䴩�h���~��, �欰�F�~�� PCS �ݩʦ��X�R�Y�ӫ��w��
	// �����O, �N�|���o�����O�S��k���� GUI ��󪺤l���O (�� MyFrame
	// �X�R JFrame ����). �M�ӧڭ̥i�H�Τ��� (�]�N�O�u�o�ӡv����)
	// �j���@�̧@�X�U���o��Ӥ�k:
	
	public void addPropertyChangeListener(PropertyChangeListener l);

	public void removePropertyChangeListener(PropertyChangeListener l);

	// �t�@�ا@�k�O�յۥ� Java ���ت� Customizer ����, ���ݭn�T�Ӥ�k --
	// �]�t�W���o���. ���]���ڭ̥Τ���ĤT�Ӥ�k, �]���Ψ��Ӥ���
	// �N���I�u���O�v.
}
