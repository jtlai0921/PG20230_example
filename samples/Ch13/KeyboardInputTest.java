// KeyboardInputTest.java

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.util.*;
import java.io.*;

/** ���ܨϥΪ̥H��L��J��ƪ��d�ҵ{�� */

public class KeyboardInputTest {
    public static void main(String args[]) {
        // ��ܻ���
        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println("�z�i�b�C�� ==> ���ܤ����J�����ơA");
        System.out.println("�M����U Enter ��C");
        System.out.println("����J�����ƪ����� Enter �N�i���}�{���C");
        System.out.println("------------------------------------------------------");
        System.out.println();

        // �L���j��? �~��; �`�N�U���� break �ԭz.
        while (true) {
                // ���ܨϥΪ� (�d�N print() �P println() ���f�t)
                System.out.print("==> ");

                // ���Χڭ̪����U���O!
                String line = KeyboardInput.readLine();

                // �ˬd���}����
                if (line.equals("")) break;

                // ��ܿ�J����ƥH�@����
                System.out.println("�z��J�F: |" + line + "|");
                System.out.println();
        }
    }
}
