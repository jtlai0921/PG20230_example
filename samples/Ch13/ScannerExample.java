import java.util.Scanner;
import java.util.InputMismatchException;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
                // ���ܨϥΪ̿�J�m��
                System.out.print("�� (�u) ��J�z���m��: ");
                String name = sc.next();
        
                System.out.print("�ХH��ƿ�J�z���~��: ");
                int age = sc.nextInt();

                System.out.print("�ХH�p�ƿ�J�z�� GPA: ");
                double gpa = sc.nextDouble();

                System.out.println();
                System.out.println(name + " ���~�֬O " + age + " ���C");
                System.out.println(name + " �� GPA �O " + gpa + "�C"); 
        }
        catch (InputMismatchException e) {
                System.out.println();
                System.out.println("�ګ�! �z�S���ӫ��ܿ�J���; " + 
                    "�Э��s��J�@���C");
        }
    }
}
