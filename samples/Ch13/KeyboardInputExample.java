// KeyboardInputExample.java

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.util.*;
import java.io.*;

// �@�ӽd�ҵ{��, ���ܨϥΪ̦b�R�O���ܦr���������H��L��J���

public class KeyboardInputExample {
    public static void main(String args[]) {
        // �d�N print �P println ���Ϊk
        System.out.print("�п�J�z���W�r: ");
        String name = KeyboardInput.readLine();
        System.out.println(name + " �z�n!");
    }
}
