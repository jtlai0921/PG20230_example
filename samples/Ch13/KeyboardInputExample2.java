// KeyboardInputExample2.java

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.util.Scanner;

// �H Java 5.0 ���Ѫ� Scanner ���O���ܨϥΪ̥H��L��J��ƪ��d��

public class KeyboardInputExample2 {
    public static void main(String args[]) {
        // �d�N print �P println ���Ϊk
        System.out.print("�п�J�z���W�r: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println(name + " �z�n!");
    }
}
