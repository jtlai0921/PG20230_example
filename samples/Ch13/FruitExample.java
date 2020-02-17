// FruitExample.java

// 這個沒啥意義的程式是示範命令列引數解析法用的

public class FruitExample {
    // main() 方法的簽名一定要宣告一個引數, 那就是名為 'args' 的 String 陣列.
    // (您可以用別的名稱, 但 'args' 是絕大多數程式設計者採用的標準名稱.)
    //
    // 這個陣列在程式執行的時候, 會自動以 DOS 或 Unix 指令列程式名稱後面 
    // (以空白隔開) 的值 ('引數') 初始化.
    //
    // 舉例來說, 如果您在 DOS 指令列以下面的指令執行程式:
    //
    //     java FruitExample apple banana cherry
    // 
    // 那麼 args 陣列就會自動初始化為 3 個 String 值,
    // 分別是 "apple", "banana", "cherry",
    // 它們會各自存放在 args[0], args[1] 與 args[2] 這三'格'之內.

    public static void main(String[] args) {
        System.out.println("引數陣列有 " + args.length + " 個項目" );

        for (int i = 0; i < args.length; i++) {
            System.out.println("引數 #" + i + " = |" + args[i] + "|");
        }
    }
}
