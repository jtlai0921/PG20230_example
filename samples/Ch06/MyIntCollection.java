import java.util.ArrayList;

public class MyIntCollection extends ArrayList<Integer> {
    // 我們照原樣繼承了標準 ArrayList 擁有的屬性與方法，接著再定義幾個
    // 我們自己的新屬性、方法: 兩個追蹤最小值、最大值的 int，再加上一個
    // 記錄加進群集的數字總和的 int
    private int smallestInt;
    private int largestInt;
    private int total;

    // 換掉預設建構子
    public MyIntCollection() {
        // 先進行所有 ArrayList 父類別建構子所定義的工作 - 
        // 我們不必知道細節，但是我們該做！
	super();

        // 將總值初始化
        total = 0;
    }

    // 覆寫繼承自 ArrayList 的 add() 方法
    public boolean add(int i) {
        // 如果這個 int 是最大值或最小值的話，就把它記住
        // (「第一次」加進數字的時候，根據定義，這個值會「同時」是目前看到的
        //  最大值與最小值！)
        if (this.isEmpty()) {
            smallestInt = i;
            largestInt = i;
        }
        else {
            if (i < smallestInt) smallestInt = i;
            if (i > largestInt) largestInt = i;
        }

        // 把這個數字加到總和之內
	total = total + i;

        // 以 ArrayList 父類別實作的 add 方法將這個 int 插進群集之內
        // 這邊我們一樣不必知道它在內部是「如何」完成工作的 ...
        return super.add(i);
    }

    // 幾個新方法

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
