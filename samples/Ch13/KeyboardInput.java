// KeyboardInput.java

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.io.*;

// �o�O�ӻ��U���O, ���Ѥ@���R�A��k, ���z�q�R�O���ܦr������Ū����L��J
// (�z�L System.in ����).
//
// �C���I�s KeyboardInput.readLine() �o���R�A��k���|�Ǧ^�@�� String,
// �N��@���J��� (����ϥΪ̫��U Enter ����)

public class KeyboardInput {
    public static String readLine() {
        // �ڭ̱N�H StringBuffer �v�@�����U�Ӧr�����
        StringBuffer input = new StringBuffer("");

        try {
            // Ū�J�Ĥ@�Ӿ��, �M��N���ন�r��
            char in = (char) System.in.read();

            // �~�����, ���찻���촫��r�� (\n)
            // �o�N��ϥΪ̫��F��L�W�� Enter ��
            while (in != '\n') {   
                input.append(in);

                // Ū�U�@�Ӧr��
                in = (char) System.in.read();
            }
        }
        catch (IOException e) {
            // �ڭ̤������o���ҥ~���p�i�����B�m
        }

        // �ޱ��Y�����ťզr��
        return input.toString().trim();
    }
}
