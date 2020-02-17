// CenteredFrame.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import javax.swing.*;
import java.awt.*;

// �o�� JFrame ���S��l���O�|�۰ʧ�ۤv��ܦb������!
// ����ϥ� JFrame ���ɾ�����H�����N; �Ȥ�{���X�ݰ_�Ӥj�����o��:
/*
	CenteredFrame myFrame = new CenteredFrame("Self-Centering Frame", 200, 200);

	// �[�J�ڭ̻ݭn�Ψ쪺�䥦����, �N��ϥ� JFrame ���ɭԤ@��
	// (�]�� CenteredFrame �N�u�O�v JFrame) ... �Ӹ`��

	// �������ܥX��
	myFrame.setVisible(true);
*/

public class CenteredFrame extends JFrame {
	// �غc�l
	public CenteredFrame(String title, int width, int height) {
		super(title);
           	super.setSize(width, height);  

		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// �p��ù����ߦ�m
		int centerX = screenSize.width/2;
		int centerY = screenSize.height/2;

		// �ڭ̧Ʊ�������@�b�b���u����, �@�b�b���u�H�W
		int halfWidth = frameSize.width/2;
		int halfHeight = frameSize.height/2;
		this.setLocation(centerX - halfWidth, centerY - halfHeight);

		// �ڭ̤��|�������X�{�b�ù��W; �ڭ̱N���ϥγo�����O��
		// �Ȥ�{���X�����o���u�@
      	}

	// ���ե� main ��k
	public static void main(String[] args) {
		CenteredFrame cf = new CenteredFrame("Taa daa", 200, 200);
		cf.setVisible(true);
	}
}
