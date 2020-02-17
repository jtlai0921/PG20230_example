// KeyboardInput.java

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.io.*;

// 這是個輔助類別, 提供一個靜態方法, 讓您從命令提示字元視窗讀取鍵盤輸入
// (透過 System.in 為之).
//
// 每次呼叫 KeyboardInput.readLine() 這個靜態方法都會傳回一個 String,
// 代表一行輸入資料 (直到使用者按下 Enter 為止)

public class KeyboardInput {
    public static String readLine() {
        // 我們將以 StringBuffer 逐一收集各個字元資料
        StringBuffer input = new StringBuffer("");

        try {
            // 讀入第一個整數, 然後將它轉成字元
            char in = (char) System.in.read();

            // 繼續執行, 直到偵測到換行字元 (\n)
            // 這代表使用者按了鍵盤上的 Enter 鍵
            while (in != '\n') {   
                input.append(in);

                // 讀下一個字元
                in = (char) System.in.read();
            }
        }
        catch (IOException e) {
            // 我們不打算對這類例外情況進行任何處置
        }

        // 拔掉頭尾的空白字元
        return input.toString().trim();
    }
}
