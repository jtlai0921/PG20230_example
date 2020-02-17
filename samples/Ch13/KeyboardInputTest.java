// KeyboardInputTest.java

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.util.*;
import java.io.*;

/** 提示使用者以鍵盤輸入資料的範例程式 */

public class KeyboardInputTest {
    public static void main(String args[]) {
        // 顯示說明
        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println("您可在每個 ==> 提示之後輸入任何資料，");
        System.out.println("然後按下 Enter 鍵。");
        System.out.println("不輸入任何資料直接按 Enter 就可離開程式。");
        System.out.println("------------------------------------------------------");
        System.out.println();

        // 無限迴圈? 才怪; 注意下面的 break 敘述.
        while (true) {
                // 提示使用者 (留意 print() 與 println() 的搭配)
                System.out.print("==> ");

                // 應用我們的輔助類別!
                String line = KeyboardInput.readLine();

                // 檢查離開條件
                if (line.equals("")) break;

                // 顯示輸入的資料以作測試
                System.out.println("您輸入了: |" + line + "|");
                System.out.println();
        }
    }
}
