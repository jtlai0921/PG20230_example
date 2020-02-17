import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DateExamples {
    public static void main(String[] args) {
        //-------------------------------------------------------------------------
        // 範例 #1: 取得目前的日期與時間, 並以預設格式顯示出來

        // 以 Calendar 類別取得目前這一刻的快照
        Calendar thisInstant = Calendar.getInstance(); 

        // 轉成 Date
        Date rightNow = thisInstant.getTime(); 

        // 轉成 String
        String ex1 = rightNow.toString();

        System.out.print("範例 #1: ");
        System.out.println("目前時間與日期 (預設格式): " + ex1);
        System.out.println();

        //-------------------------------------------------------------------------
        // 範例 #2: 取得目前的日期與時間, 而後以 SimpleDateFormat 轉換格式
        // 顯示出來

        // 這是不透過 Calendar 類別，取得目前日期與時間的另一種方法
        Date now = new Date(System.currentTimeMillis());

        SimpleDateFormat sdfEx2 = new SimpleDateFormat("EEEE, MMM d, yyyy hh:mm aaa");
        String ex2 = sdfEx2.format(now);

        System.out.print("範例 #2: ");
        System.out.println("目前日期與時間 (自訂格式): " + ex2);
        System.out.println();

        //-------------------------------------------------------------------------
        // 範例 #3: 使用我們指定給 SimpleDateFormat 的格式, (只) 印出今日日期 

        SimpleDateFormat sdfEx3 = new SimpleDateFormat("MMMM d, yyyy");

        // We'll reuse the Date instance, "now", from above.
        String ex3 = sdfEx3.format(now);

        System.out.print("範例 #3: ");
        System.out.println("今日日期 (自訂格式): " + ex3);
        System.out.println();

        //-------------------------------------------------------------------------
        // 範例 #4: 以另一種格式 (只) 印出日期

        SimpleDateFormat sdfEx4 = new SimpleDateFormat("MM/dd/yyyy");
        String ex4 = sdfEx4.format(now);

        System.out.print("範例 #4: ");
        System.out.println("今日日期 (另一種自訂格式):  " + ex4);
        System.out.println();

        //-------------------------------------------------------------------------
        // 範例 #5: 造出一個特定日期的 Date 物件

        Calendar cal = Calendar.getInstance();
        cal.set(2005, Calendar.NOVEMBER, 17);
        Date specialDate = cal.getTime();

        // 我們將重新利用上面的 SimpleDateFormat
        String ex5 = sdfEx4.format(specialDate);

        System.out.print("範例 #5: ");
        System.out.println("一個特別的日子: " + ex5);
        System.out.println();

        //-------------------------------------------------------------------------
        // 範例 #6: 比對兩個日期
        
        // 我們將重新利用範例 #5 的 Calendar 實體, 建立兩個不同的日期

        cal.set(2005, Calendar.JUNE, 1);
        Date bjo2EpublicationDate = cal.getTime();

        cal.set(2005, Calendar.JULY, 1);
        Date jjbVacationDate = cal.getTime();

        System.out.print("範例 #6: ");

        // 我們將以 before() 方法比對日期 
        // (但是其實還有 after() 與 equals() 可以用 ...)

        if (jjbVacationDate.before(bjo2EpublicationDate)) {
            System.out.println("Jacquie 還不能去休假 ..." +
                " 書還沒完成!");
        }
        else {
            System.out.println("Steve and Jacquie, 放鬆心情休假去吧!");
        }
    }
}
