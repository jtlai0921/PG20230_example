// AnalyzeWords.java

import java.util.TreeSet;

public class AnalyzeWords {
    public static void main(String[] args) {
        // ���ڭ̥��q�@�I���~�ˬd�}�l
        // �p�G�ϥΪ̧ѰO��J��ƪ���, �N�N���^�������~
        if (args.length == 0) {
            System.out.println("�Ϊk: java AnalyzeWords [-sort] list_of_words");
            System.out.println("  ��: java AnalyzeWords -sort ZEBRA ELEPHANT RAT MONKEY");
            System.exit(0);
        }

        // ��l�ƴX���ܼ�
        boolean sort = false;
        String shortest = null;
        String longest = null;
        TreeSet<String> sortedWords = new TreeSet<String>();

        for (int i = 0; i < args.length; i++) {
            // �`�N -sort �ﶵ�O�_���X�{
            if (args[i].equals("-sort")) {
                sort = true;
                continue;
            }
        
            // �p�G�ڭ��٨S�J��̵u�γ̪�����r, ����ھکw�q, 
            // �o�N�O�Ĥ@�ӳ�r, �P�ɤ]�O�̵u�P�̪�����r!
            if (shortest == null) {
                shortest = args[i];
                longest = args[i];
            }
            // �_�h�N�N�o�ӳ�r�P�̵u, �̪�����r�i����
            else {     
                if (args[i].length() > longest.length()) longest = args[i]; 
                if (args[i].length() < shortest.length()) shortest = args[i]; 
            }

            // �N�o�ӳ�r�[�J TreeSet �H�K�۰ʱƧ�,
            // ���ިϥΪ̬O�_���n�D�i��Ƨ�;
            // �p�G�ϥΪ̨S���n�D�ƧǪ���, �ڭ̤��N����ܥX�ӴN�n
            sortedWords.add(args[i]);
        }

        if (sort) {
            System.out.println("�Ʀn����r:");
            for (String s : sortedWords) {
                System.out.println("\t" + s);
            }
        }

        System.out.println("�̵u����r�� " + shortest.length() + " �Ӧr���C");
        System.out.println("�̪�����r�� " + longest.length() + " �Ӧr���C");
    }
}
