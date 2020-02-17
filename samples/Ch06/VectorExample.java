import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
	  // 具現化一個群集
	  Vector<Student> students = new Vector<Student>();

	  // 建立幾個 Student 物件
	  Student a = new Student("Herbie");
	  Student b = new Student("Clem");
	  Student c = new Student("Oscar");

	  // 把這三個的 Student 參考都放進群集內
	  students.add(a);
	  students.add(b);
	  students.add(c);

	  // ... 然後逐項處理群集內容, 顯示每位學生的名字
	  for (Student s : students) {
	    System.out.println(s.getName()); 
	  }
    }
}
