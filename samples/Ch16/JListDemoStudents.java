import javax.swing.*;
import java.awt.*;

public class JListDemoStudents {
	public static void main(String[] args) {
		JFrame theFrame = new JFrame("Students Enrolled in Math 101");
		Container contentPane = theFrame.getContentPane( );

		// �إ� Student ���s��
		Student[] v = new Student[3];
		v[0] = new Student("123456789", "Steve Barker");
		v[1] = new Student("987654321", "Jacquie Barker");
		v[2] = new Student("000000000", "Baby Grode");

		// �ھڳo�Ӹs���إ߲M��. �ڭ̥i�H�o�򰵪��z�ѬO Student ���O
		// �w�q�F toString() ��k, �o�|���C�� Student ����H
		// �m�W, SSN �r�ꪺ�Φ��X�{�b�M�椺.
		JList myList = new JList(v);
		contentPane.add(myList);

		theFrame.setSize(300, 100);  
		theFrame.setVisible(true);
	}
}
