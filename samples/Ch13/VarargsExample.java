import java.util.ArrayList;

public class VarargsExample {
    public static void main(String[] args) {
        // 呼叫定義了可變引數簽名的方法,
        // 這些方法所接受的引數型別一如方法名稱所示

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

        // 傳進三個毫無相關的物件
        objectExample2(new Pineapple(), new Bicycle(), new Cloud());
    }

    private static void stringExample(String ... args) {
        System.out.println("stringExample 收到 " + args.length + " 個引數。");

        for (int i = 0; i < args.length; i++) {
            System.out.println("    " + args[i] + " 是個 " + args[i].getClass().getName());
        }

        System.out.println();
    }

    private static void intExample(int ... args) {
        System.out.println("intExample 收到 " + args.length + " 個引數。");

        for (int i = 0; i < args.length; i++) {
            System.out.println("    " + args[i] + " 是個 int");
        }

        System.out.println();
    }

    private static void personExample(Person ... args) {
        System.out.println("personExample 收到 " + args.length + " 個引數。");

        for (int i = 0; i < args.length; i++) {
            System.out.println("    " + args[i] + " 是個 " + args[i].getClass().getName());
        }

        System.out.println();
    }

    private static void objectExample(Object ... args) {
        System.out.println("objectExample 收到 " + args.length + " 個引數。");

        for (int i = 0; i < args.length; i++) {
            System.out.println("    " + args[i] + " 是個 " + args[i].getClass().getName());
        }

        System.out.println();
    }

    private static void objectExample2(Object ... args) {
        // 這邊我們假設傳入的 args 陣列將包含各類
        // Pineapple, Bicycle 與 Cloud 物件
        for (int i = 0; i < args.length; i++) {
            // 留意轉型動作
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
