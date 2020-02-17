// ComputeTotal.java

public class ComputeTotal {
    // main() 方法的簽名一定要宣告一個引數, 那就是名為 'args' 的 String 陣列.
    // (您可以用別的名稱, 但 'args' 是絕大多數程式設計者採用的標準名稱.)
    //
    // 這個陣列在程式執行的時候, 會自動以 DOS 或 Unix 指令列程式名稱後面 
    // (以空白隔開) 的值 ('引數') 初始化.
    //
    // 舉例來說, 如果您在 DOS 指令列以下面的指令執行程式:
    //
    //     java ComputeTotal 123 456 789
    // 
    // 那麼 args 陣列就會自動初始化為 3 個 String 值,
    // 分別是 "123", "456", "789",
    // 它們會各自存放在 args[0], args[1] 與 args[2] 這三'格'之內.

    public static void main(String[] args) {
        // 讓我們一開始先做點錯誤檢查
	// 如果使用者忘記輸入任何數字的話, 就回報錯誤
        if (args.length == 0) {
            System.out.println("用法: java ComputeTotal list_of_numbers_to_add");
            System.out.println("  例: java ComputeTotal 123 456 789");
            System.exit(0);
        }
        
	// 接著試著把所有輸入的 String 轉成數字, 順便計算總和
	// 如果有數字轉換失敗的話, 就回報錯誤
        double sum = 0.0;
        for (int i = 0; i < args.length; i++) {
          // 我們把 try-catch 區塊放在迴圈內 ...
          try {
            sum = sum + Double.parseDouble(args[i]);
          }
          catch (NumberFormatException e) {
            System.out.println("啊咧! \"" + args[i] + "\" 不是個數字。");
          }
        }        

        System.out.println("總和是:  " + sum);
    }
}
