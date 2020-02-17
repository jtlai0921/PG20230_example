import java.util.ArrayList;

public class VarargsExample {
    public static void main(String[] args) {
        // �I�s�w�q�F�i�ܤ޼�ñ�W����k,
        // �o�Ǥ�k�ұ������޼ƫ��O�@�p��k�W�٩ҥ�

        stringExample("foo", "bar");
        stringExample("eeny", "meeny", "miney", "mo");

        intExample(1, 3, 9, 27);
        intExample();

        Student student = new Student("Fred");
        Professor professor = new Professor("Dr. Carson");
        personExample(student, professor);

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Hello!");
        arrayList.add("How are you?");
        arrayList.add("Goodbye ...");
        objectExample(student, arrayList);

        // �Ƕi�T�Ӳ@�L����������
        objectExample2(new Pineapple(), new Bicycle(), new Cloud());
    }

    private static void stringExample(String ... args) {
        System.out.println("stringExample ���� " + args.length + " �Ӥ޼ơC");

        for (int i = 0; i < args.length; i++) {
            System.out.println("    " + args[i] + " �O�� " + args[i].getClass().getName());
        }

        System.out.println();
    }

    private static void intExample(int ... args) {
        System.out.println("intExample ���� " + args.length + " �Ӥ޼ơC");

        for (int i = 0; i < args.length; i++) {
            System.out.println("    " + args[i] + " �O�� int");
        }

        System.out.println();
    }

    private static void personExample(Person ... args) {
        System.out.println("personExample ���� " + args.length + " �Ӥ޼ơC");

        for (int i = 0; i < args.length; i++) {
            System.out.println("    " + args[i] + " �O�� " + args[i].getClass().getName());
        }

        System.out.println();
    }

    private static void objectExample(Object ... args) {
        System.out.println("objectExample ���� " + args.length + " �Ӥ޼ơC");

        for (int i = 0; i < args.length; i++) {
            System.out.println("    " + args[i] + " �O�� " + args[i].getClass().getName());
        }

        System.out.println();
    }

    private static void objectExample2(Object ... args) {
        // �o��ڭ̰��]�ǤJ�� args �}�C�N�]�t�U��
        // Pineapple, Bicycle �P Cloud ����
        for (int i = 0; i < args.length; i++) {
            // �d�N�૬�ʧ@
            if (args[i] instanceof Pineapple) {
                ((Pineapple) args[i]).eat();
            }
            else if (args[i] instanceof Bicycle) {
                ((Bicycle) args[i]).ride();
            }
            else if (args[i] instanceof Cloud) {
                ((Cloud) args[i]).paint();
            }
        }

        System.out.println();
    }
}
