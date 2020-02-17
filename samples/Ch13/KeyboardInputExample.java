// KeyboardInputExample.java

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.util.*;
import java.io.*;

// 一個範例程式, 提示使用者在命令提示字元視窗內以鍵盤輸入資料

public class KeyboardInputExample {
    public static void main(String args[]) {
        // 留意 print 與 println 的用法
        System.out.print("請輸入您的名字: ");
        String name = KeyboardInput.readLine();
        System.out.println(name + " 您好!");
    }
}
