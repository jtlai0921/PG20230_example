import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DateExamples {
    public static void main(String[] args) {
        //-------------------------------------------------------------------------
        // �d�� #1: ���o�ثe������P�ɶ�, �åH�w�]�榡��ܥX��

        // �H Calendar ���O���o�ثe�o�@�誺�ַ�
        Calendar thisInstant = Calendar.getInstance(); 

        // �ন Date
        Date rightNow = thisInstant.getTime(); 

        // �ন String
        String ex1 = rightNow.toString();

        System.out.print("�d�� #1: ");
        System.out.println("�ثe�ɶ��P��� (�w�]�榡): " + ex1);
        System.out.println();

        //-------------------------------------------------------------------------
        // �d�� #2: ���o�ثe������P�ɶ�, �ӫ�H SimpleDateFormat �ഫ�榡
        // ��ܥX��

        // �o�O���z�L Calendar ���O�A���o�ثe����P�ɶ����t�@�ؤ�k
        Date now = new Date(System.currentTimeMillis());

        SimpleDateFormat sdfEx2 = new SimpleDateFormat("EEEE, MMM d, yyyy hh:mm aaa");
        String ex2 = sdfEx2.format(now);

        System.out.print("�d�� #2: ");
        System.out.println("�ثe����P�ɶ� (�ۭq�榡): " + ex2);
        System.out.println();

        //-------------------------------------------------------------------------
        // �d�� #3: �ϥΧڭ̫��w�� SimpleDateFormat ���榡, (�u) �L�X������ 

        SimpleDateFormat sdfEx3 = new SimpleDateFormat("MMMM d, yyyy");

        // We'll reuse the Date instance, "now", from above.
        String ex3 = sdfEx3.format(now);

        System.out.print("�d�� #3: ");
        System.out.println("������ (�ۭq�榡): " + ex3);
        System.out.println();

        //-------------------------------------------------------------------------
        // �d�� #4: �H�t�@�خ榡 (�u) �L�X���

        SimpleDateFormat sdfEx4 = new SimpleDateFormat("MM/dd/yyyy");
        String ex4 = sdfEx4.format(now);

        System.out.print("�d�� #4: ");
        System.out.println("������ (�t�@�ئۭq�榡):  " + ex4);
        System.out.println();

        //-------------------------------------------------------------------------
        // �d�� #5: �y�X�@�ӯS�w����� Date ����

        Calendar cal = Calendar.getInstance();
        cal.set(2005, Calendar.NOVEMBER, 17);
        Date specialDate = cal.getTime();

        // �ڭ̱N���s�Q�ΤW���� SimpleDateFormat
        String ex5 = sdfEx4.format(specialDate);

        System.out.print("�d�� #5: ");
        System.out.println("�@�ӯS�O����l: " + ex5);
        System.out.println();

        //-------------------------------------------------------------------------
        // �d�� #6: ����Ӥ��
        
        // �ڭ̱N���s�Q�νd�� #5 �� Calendar ����, �إߨ�Ӥ��P�����

        cal.set(2005, Calendar.JUNE, 1);
        Date bjo2EpublicationDate = cal.getTime();

        cal.set(2005, Calendar.JULY, 1);
        Date jjbVacationDate = cal.getTime();

        System.out.print("�d�� #6: ");

        // �ڭ̱N�H before() ��k����� 
        // (���O����٦� after() �P equals() �i�H�� ...)

        if (jjbVacationDate.before(bjo2EpublicationDate)) {
            System.out.println("Jacquie �٤���h�� ..." +
                " ���٨S����!");
        }
        else {
            System.out.println("Steve and Jacquie, ���P�߱��𰲥h�a!");
        }
    }
}
