import java.util.*;

public class Course {
	private String name;
	private ArrayList<Student> enrolledStudents;
	private GradeBook gradeBook;

	public Course(String name) {
		this.name = name;
		enrolledStudents = new ArrayList<Student>();
		gradeBook = new GradeBook();
	}

	public String getGrade(Student s) {
		// �e��
		return gradeBook.getGrade(s);
	}

	// �ڭ̪��������O. �N�sĶ���ӻ�, "GradeBook" �o�ӲŸ�
	// �u�b Course ���O���d�򤺦���; �ڭ̤���b�䥦�a��
	// �Ѧ� GradeBook �o�ӫ��O
	class GradeBook {
		// ���C�Ӿǥ��x�s���Z, �Ϊ��O String �榡, �p: "B+"
		private HashMap<Student, String> grades;

		// �غc�l
		public GradeBook() {
			grades = new HashMap<Student, String>();
			// ��
		}

		// �䥦��k

		public void assignGrade(Student s, String grade) {
			grades.put(s, grade);
		}

		public String getGrade(Student s) {
			return grades.get(s);
		}
	}
}
