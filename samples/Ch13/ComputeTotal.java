// ComputeTotal.java

public class ComputeTotal {
    // main() ��k��ñ�W�@�w�n�ŧi�@�Ӥ޼�, ���N�O�W�� 'args' �� String �}�C.
    // (�z�i�H�ΧO���W��, �� 'args' �O���j�h�Ƶ{���]�p�̱ĥΪ��зǦW��.)
    //
    // �o�Ӱ}�C�b�{�����檺�ɭ�, �|�۰ʥH DOS �� Unix ���O�C�{���W�٫᭱ 
    // (�H�ťչj�}) ���� ('�޼�') ��l��.
    //
    // �|�Ҩӻ�, �p�G�z�b DOS ���O�C�H�U�������O����{��:
    //
    //     java ComputeTotal 123 456 789
    // 
    // ���� args �}�C�N�|�۰ʪ�l�Ƭ� 3 �� String ��,
    // ���O�O "123", "456", "789",
    // ���̷|�U�ۦs��b args[0], args[1] �P args[2] �o�T'��'����.

    public static void main(String[] args) {
        // ���ڭ̤@�}�l�����I���~�ˬd
	// �p�G�ϥΪ̧ѰO��J����Ʀr����, �N�^�����~
        if (args.length == 0) {
            System.out.println("�Ϊk: java ComputeTotal list_of_numbers_to_add");
            System.out.println("  ��: java ComputeTotal 123 456 789");
            System.exit(0);
        }
        
	// ���۸յۧ�Ҧ���J�� String �ন�Ʀr, ���K�p���`�M
	// �p�G���Ʀr�ഫ���Ѫ���, �N�^�����~
        double sum = 0.0;
        for (int i = 0; i < args.length; i++) {
          // �ڭ̧� try-catch �϶���b�j�餺 ...
          try {
            sum = sum + Double.parseDouble(args[i]);
          }
          catch (NumberFormatException e) {
            System.out.println("�ګ�! \"" + args[i] + "\" ���O�ӼƦr�C");
          }
        }        

        System.out.println("�`�M�O:  " + sum);
    }
}
