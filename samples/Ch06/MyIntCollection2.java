import java.util.ArrayList;

// 這次我們不擴充 ArrayList 類別了
public class MyIntCollection2 {
    // 我們改將 ArrayList 封裝在這個類別之內
    ArrayList<Integer> numbers;

    // 我們再定義幾個封裝的 ArrayList 類別不會提供的屬性與方法 --
    // 與我們為 MyIntCollection 類別宣告的完全「相同」
    private int smallestInt;
    private int largestInt;
    private int total;

    public MyIntCollection2() {
        // 將內嵌的 ArrayList 具現化
        numbers = new ArrayList<Integer>();

        // 將總值初始化 
        total = 0;
    }

    // 因為我們不再「繼承」 size() 方法，所以自己加一個！

    public int size() {
        // 委任！
        return numbers.size();
    }

    // 我們為 MyIntCollection2 實作了 MyIntCollection 擁有的所有方法
    // 但我們做了些小修改, 將某些事情委託給內嵌的 ArrayList 進行

    public boolean add(int i) {
        // 如果這個 int 是最大值或最小值的話，就把它記住
        // (「第一次」加進數字的時候，根據定義，這個值會「同時」是目前看到的
        //  最大值與最小值！)
        // 「委任」給內嵌的群集
        if (numbers.isEmpty()) {
            smallestInt = i;
            largestInt = i;
        }
        else {
            if (i < smallestInt) smallestInt = i;
            if (i > largestInt) largestInt = i;
        }

        // 把這個數字加到總和之內
	total = total + i;

        // 把 int 加進 numbers 群集
        // 「委任」給內嵌的群集處理
        return numbers.add(i);
    }

    // 剩下的方法都與 MyIntCollection 完全相同

    public int getSmallestInt() {
	return smallestInt;
    }

    public int getLargestInt() {
	return largestInt;
    }

    public double getAverage() {
        return ((double) total)/((double) this.size());
    }
}
