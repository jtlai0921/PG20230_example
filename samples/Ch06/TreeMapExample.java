import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        // 將一個 TreeMap 具現化
        // 以 String 當成查找鍵型別、以 Student 當成值型別
        TreeMap<String, Student> students = new TreeMap<String, Student>();

        // 具現化三個 Student; 我們以建構子指派 Student 的 idNo 與 name 屬性
        // (這兩個屬性都宣告為 String 型別)
        Student s1 = new Student("12345-12", "Fred");
        Student s2 = new Student("98765-00", "Barney");
        Student s3 = new Student("71024-91", "Wilma");

        // 將三個學生插進 TreeMap, 以 idNo 當成查找鍵
        students.put(s1.getIdNo(), s1);
        students.put(s2.getIdNo(), s2);
        students.put(s3.getIdNo(), s3);

        // 以特定的 (正確) ID 取回一個 Student
        String id = "98765-00";
        System.out.println("讓我們試著尋找 ID = " + id + " 的學生");
        Student x = students.get(id);
        if (x != null) System.out.println("找到了!  Name = " + x.getName());
        else System.out.println("ID 不正確:  " + id);
        System.out.println();

        // 試個不正確的 ID
        id = "00000-00";
        System.out.println("讓我們試著尋找 ID = " + id + " 的學生");
        x = students.get(id);
        if (x != null) System.out.println("找到了!  Name = " + x.getName());
        else System.out.println("ID 不正確:  " + id);
        System.out.println();

        System.out.println();
        System.out.println("下面是所有學生:");
        System.out.println();

        // 逐項處理整個 TreeMap 以便處理所有 Student 物件
        for (Student s : students.values()) {
            System.out.println("ID:  " + s.getIdNo());
            System.out.println("Name:  " + s.getName());
            System.out.println();
        }
    }
}
