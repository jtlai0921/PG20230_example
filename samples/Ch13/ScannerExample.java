import java.util.Scanner;
import java.util.InputMismatchException;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
                // 提示使用者輸入姓氏
                System.out.print("請 (只) 輸入您的姓氏: ");
                String name = sc.next();
        
                System.out.print("請以整數輸入您的年齡: ");
                int age = sc.nextInt();

                System.out.print("請以小數輸入您的 GPA: ");
                double gpa = sc.nextDouble();

                System.out.println();
                System.out.println(name + " 的年齡是 " + age + " 歲。");
                System.out.println(name + " 的 GPA 是 " + gpa + "。"); 
        }
        catch (InputMismatchException e) {
                System.out.println();
                System.out.println("啊咧! 您沒有照指示輸入資料; " + 
                    "請重新輸入一次。");
        }
    }
}
