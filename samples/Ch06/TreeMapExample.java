import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        // �N�@�� TreeMap ��{��
        // �H String ���d���䫬�O�B�H Student ���ȫ��O
        TreeMap<String, Student> students = new TreeMap<String, Student>();

        // ��{�ƤT�� Student; �ڭ̥H�غc�l���� Student �� idNo �P name �ݩ�
        // (�o����ݩʳ��ŧi�� String ���O)
        Student s1 = new Student("12345-12", "Fred");
        Student s2 = new Student("98765-00", "Barney");
        Student s3 = new Student("71024-91", "Wilma");

        // �N�T�Ӿǥʹ��i TreeMap, �H idNo ���d����
        students.put(s1.getIdNo(), s1);
        students.put(s2.getIdNo(), s2);
        students.put(s3.getIdNo(), s3);

        // �H�S�w�� (���T) ID ���^�@�� Student
        String id = "98765-00";
        System.out.println("���ڭ̸յ۴M�� ID = " + id + " ���ǥ�");
        Student x = students.get(id);
        if (x != null) System.out.println("���F!  Name = " + x.getName());
        else System.out.println("ID �����T:  " + id);
        System.out.println();

        // �խӤ����T�� ID
        id = "00000-00";
        System.out.println("���ڭ̸յ۴M�� ID = " + id + " ���ǥ�");
        x = students.get(id);
        if (x != null) System.out.println("���F!  Name = " + x.getName());
        else System.out.println("ID �����T:  " + id);
        System.out.println();

        System.out.println();
        System.out.println("�U���O�Ҧ��ǥ�:");
        System.out.println();

        // �v���B�z��� TreeMap �H�K�B�z�Ҧ� Student ����
        for (Student s : students.values()) {
            System.out.println("ID:  " + s.getIdNo());
            System.out.println("Name:  " + s.getName());
            System.out.println();
        }
    }
}
