import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
	  // ��{�Ƥ@�Ӹs��
	  Vector<Student> students = new Vector<Student>();

	  // �إߴX�� Student ����
	  Student a = new Student("Herbie");
	  Student b = new Student("Clem");
	  Student c = new Student("Oscar");

	  // ��o�T�Ӫ� Student �Ѧҳ���i�s����
	  students.add(a);
	  students.add(b);
	  students.add(c);

	  // ... �M��v���B�z�s�����e, ��ܨC��ǥͪ��W�r
	  for (Student s : students) {
	    System.out.println(s.getName()); 
	  }
    }
}
