import java.util.ArrayList;

public class MyIntCollection extends ArrayList<Integer> {
    // �ڭ̷ӭ���~�ӤF�з� ArrayList �֦����ݩʻP��k�A���ۦA�w�q�X��
    // �ڭ̦ۤv���s�ݩʡB��k: ��Ӱl�̤ܳp�ȡB�̤j�Ȫ� int�A�A�[�W�@��
    // �O���[�i�s�����Ʀr�`�M�� int
    private int smallestInt;
    private int largestInt;
    private int total;

    // �����w�]�غc�l
    public MyIntCollection() {
        // ���i��Ҧ� ArrayList �����O�غc�l�ҩw�q���u�@ - 
        // �ڭ̤������D�Ӹ`�A���O�ڭ̸Ӱ��I
	super();

        // �N�`�Ȫ�l��
        total = 0;
    }

    // �мg�~�Ӧ� ArrayList �� add() ��k
    public boolean add(int i) {
        // �p�G�o�� int �O�̤j�ȩγ̤p�Ȫ��ܡA�N�⥦�O��
        // (�u�Ĥ@���v�[�i�Ʀr���ɭԡA�ھکw�q�A�o�ӭȷ|�u�P�ɡv�O�ثe�ݨ쪺
        //  �̤j�ȻP�̤p�ȡI)
        if (this.isEmpty()) {
            smallestInt = i;
            largestInt = i;
        }
        else {
            if (i < smallestInt) smallestInt = i;
            if (i > largestInt) largestInt = i;
        }

        // ��o�ӼƦr�[���`�M����
	total = total + i;

        // �H ArrayList �����O��@�� add ��k�N�o�� int ���i�s������
        // �o��ڭ̤@�ˤ������D���b�����O�u�p��v�����u�@�� ...
        return super.add(i);
    }

    // �X�ӷs��k

    public int getSmallestInt() {
	return smallestInt;
    }

    public int getLargestInt() {
	return largestInt;
    }

    public double getAverage() {
        return ((double) total)/((double) this.size());
    }
}
