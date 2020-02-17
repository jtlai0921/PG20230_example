import java.util.Scanner;
import java.util.InputMismatchException;

public class ScannerExample2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 提示使用者輸入姓氏
        System.out.print("請 (只) 輸入您的姓氏: ");
        String name = sc.next();
        
        int age = 0;
        while (age == 0) {
            System.out.print("請以整數輸入您的年齡: ");
            if (sc.hasNextInt()) age = sc.nextInt();
            else System.out.println("啊咧!  " + sc.next() + " 不是個整數 ...");
        }

        double temperature = 0.0;
        while (temperature == 0.0) {
            System.out.print("請輸入您目前體溫 (攝氏度, 可用小數): ");
            if (sc.hasNextDouble()) temperature = sc.nextDouble();
            else System.out.println("啊咧!  " + sc.next() + " 不是個小數 ...");
        }

        System.out.println(name + " 的年齡是 " + age + " 歲。");
        System.out.println(name + " 的體溫是攝氏 " + temperature + " 度。");
    }
}
