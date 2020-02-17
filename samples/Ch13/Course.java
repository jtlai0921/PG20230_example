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
		// 委任
		return gradeBook.getGrade(s);
	}

	// 我們的內部類別. 就編譯器來說, "GradeBook" 這個符號
	// 只在 Course 類別的範圍內有效; 我們不能在其它地方
	// 參考 GradeBook 這個型別
	class GradeBook {
		// 為每個學生儲存成績, 用的是 String 格式, 如: "B+"
		private HashMap<Student, String> grades;

		// 建構子
		public GradeBook() {
			grades = new HashMap<Student, String>();
			// 略
		}

		// 其它方法

		public void assignGrade(Student s, String grade) {
			grades.put(s, grade);
		}

		public String getGrade(Student s) {
			return grades.get(s);
		}
	}
}
