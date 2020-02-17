public class MyIntCollectionExample2 {
  public static void main(String[] args) {
    MyIntCollection2 mic = new MyIntCollection2();
   
    // 不管我們用的是 MyIntCollection 還是 MyIntCollection2,
    // 客戶程式碼都「完全相同」!!! 這證明了我們設計類別的方式
    // 的確被隱藏起來了.

    mic.add(3);
    mic.add(6);
    mic.add(1);
    mic.add(9);
	
    System.out.println("群集包含 " + mic.size() + " 個 int 值");
    
    System.out.println("最小值是: " + mic.getSmallestInt());
    System.out.println("最大值是: " + mic.getLargestInt());
    System.out.println("平均值是: " + mic.getAverage());
  }
}
