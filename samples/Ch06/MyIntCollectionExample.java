public class MyIntCollectionExample {
  public static void main(String[] args) {
    MyIntCollection mic = new MyIntCollection();

    // 將四個隨機整數插入我們的「特殊」群集
    mic.add(3);
    mic.add(6);
    mic.add(1);
    mic.add(9);
	
    // 應用從 ArrayList 繼承而來的 size 方法 ...
    System.out.println("群集包含 " + mic.size() + " 個 int 值");

    // ... 然後向 mic 問一些各種 ArrayList 都無法輕鬆回答的「特殊」問題
    System.out.println("最小值是: " + mic.getSmallestInt());
    System.out.println("最大值是: " + mic.getLargestInt());
    System.out.println("平均值是: " + mic.getAverage());
  }
}
