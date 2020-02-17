// AnalyzeWords.java

import java.util.TreeSet;

public class AnalyzeWords {
    public static void main(String[] args) {
        // 讓我們先從一點錯誤檢查開始
        // 如果使用者忘記輸入資料的話, 就將之回報為錯誤
        if (args.length == 0) {
            System.out.println("用法: java AnalyzeWords [-sort] list_of_words");
            System.out.println("  例: java AnalyzeWords -sort ZEBRA ELEPHANT RAT MONKEY");
            System.exit(0);
        }

        // 初始化幾個變數
        boolean sort = false;
        String shortest = null;
        String longest = null;
        TreeSet<String> sortedWords = new TreeSet<String>();

        for (int i = 0; i < args.length; i++) {
            // 注意 -sort 選項是否有出現
            if (args[i].equals("-sort")) {
                sort = true;
                continue;
            }
        
            // 如果我們還沒遇到最短或最長的單字, 那麼根據定義, 
            // 這就是第一個單字, 同時也是最短與最長的單字!
            if (shortest == null) {
                shortest = args[i];
                longest = args[i];
            }
            // 否則就將這個單字與最短, 最長的單字進行比對
            else {     
                if (args[i].length() > longest.length()) longest = args[i]; 
                if (args[i].length() < shortest.length()) shortest = args[i]; 
            }

            // 將這個單字加入 TreeSet 以便自動排序,
            // 不管使用者是否有要求進行排序;
            // 如果使用者沒有要求排序的話, 我們不將它顯示出來就好
            sortedWords.add(args[i]);
        }

        if (sort) {
            System.out.println("排好的單字:");
            for (String s : sortedWords) {
                System.out.println("\t" + s);
            }
        }

        System.out.println("最短的單字有 " + shortest.length() + " 個字元。");
        System.out.println("最長的單字有 " + longest.length() + " 個字元。");
    }
}
