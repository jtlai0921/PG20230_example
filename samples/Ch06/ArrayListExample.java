import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
	  // 具現化一個群集
	  ArrayList<Student> students = new ArrayList<Student>();

	  // 建立幾個 Student 物件
	  Student a = new Student("Herbie");
	  Student b = new Student("Clem");
	  Student c = new Student("Oscar");

	  // 將這三個 Student 的參考存進群集
	  students.add(a);
	  students.add(b);
	  students.add(c);

	  // ... 接著逐項處理每個項目，印出每位學生的姓名
	  for (Student s : students) {
	    System.out.println(s.getName()); 
	  }
    }
}
