import java.util.Scanner;
import java.util.InputMismatchException;

public class ScannerExample2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ���ܨϥΪ̿�J�m��
        System.out.print("�� (�u) ��J�z���m��: ");
        String name = sc.next();
        
        int age = 0;
        while (age == 0) {
            System.out.print("�ХH��ƿ�J�z���~��: ");
            if (sc.hasNextInt()) age = sc.nextInt();
            else System.out.println("�ګ�!  " + sc.next() + " ���O�Ӿ�� ...");
        }

        double temperature = 0.0;
        while (temperature == 0.0) {
            System.out.print("�п�J�z�ثe��� (����, �i�Τp��): ");
            if (sc.hasNextDouble()) temperature = sc.nextDouble();
            else System.out.println("�ګ�!  " + sc.next() + " ���O�Ӥp�� ...");
        }

        System.out.println(name + " ���~�֬O " + age + " ���C");
        System.out.println(name + " ����ŬO��� " + temperature + " �סC");
    }
}
