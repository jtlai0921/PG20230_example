import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
	  // ��{�Ƥ@�Ӹs��
	  ArrayList<Student> students = new ArrayList<Student>();

	  // �إߴX�� Student ����
	  Student a = new Student("Herbie");
	  Student b = new Student("Clem");
	  Student c = new Student("Oscar");

	  // �N�o�T�� Student ���ѦҦs�i�s��
	  students.add(a);
	  students.add(b);
	  students.add(c);

	  // ... ���۳v���B�z�C�Ӷ��ءA�L�X�C��ǥͪ��m�W
	  for (Student s : students) {
	    System.out.println(s.getName()); 
	  }
    }
}
