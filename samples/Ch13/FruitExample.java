// FruitExample.java

// �o�ӨSԣ�N�q���{���O�ܽd�R�O�C�޼ƸѪR�k�Ϊ�

public class FruitExample {
    // main() ��k��ñ�W�@�w�n�ŧi�@�Ӥ޼�, ���N�O�W�� 'args' �� String �}�C.
    // (�z�i�H�ΧO���W��, �� 'args' �O���j�h�Ƶ{���]�p�̱ĥΪ��зǦW��.)
    //
    // �o�Ӱ}�C�b�{�����檺�ɭ�, �|�۰ʥH DOS �� Unix ���O�C�{���W�٫᭱ 
    // (�H�ťչj�}) ���� ('�޼�') ��l��.
    //
    // �|�Ҩӻ�, �p�G�z�b DOS ���O�C�H�U�������O����{��:
    //
    //     java FruitExample apple banana cherry
    // 
    // ���� args �}�C�N�|�۰ʪ�l�Ƭ� 3 �� String ��,
    // ���O�O "apple", "banana", "cherry",
    // ���̷|�U�ۦs��b args[0], args[1] �P args[2] �o�T'��'����.

    public static void main(String[] args) {
        System.out.println("�޼ư}�C�� " + args.length + " �Ӷ���" );

        for (int i = 0; i < args.length; i++) {
            System.out.println("�޼� #" + i + " = |" + args[i] + "|");
        }
    }
}
