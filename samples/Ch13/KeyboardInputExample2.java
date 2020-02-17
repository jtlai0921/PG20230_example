// KeyboardInputExample2.java

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.util.Scanner;

// 以 Java 5.0 提供的 Scanner 類別提示使用者以鍵盤輸入資料的範例

public class KeyboardInputExample2 {
    public static void main(String args[]) {
        // 留意 print 與 println 的用法
        System.out.print("請輸入您的名字: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println(name + " 您好!");
    }
}
