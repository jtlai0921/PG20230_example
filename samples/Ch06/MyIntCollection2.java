import java.util.ArrayList;

// �o���ڭ̤��X�R ArrayList ���O�F
public class MyIntCollection2 {
    // �ڭ̧�N ArrayList �ʸ˦b�o�����O����
    ArrayList<Integer> numbers;

    // �ڭ̦A�w�q�X�ӫʸ˪� ArrayList ���O���|���Ѫ��ݩʻP��k --
    // �P�ڭ̬� MyIntCollection ���O�ŧi�������u�ۦP�v
    private int smallestInt;
    private int largestInt;
    private int total;

    public MyIntCollection2() {
        // �N���O�� ArrayList ��{��
        numbers = new ArrayList<Integer>();

        // �N�`�Ȫ�l�� 
        total = 0;
    }

    // �]���ڭ̤��A�u�~�ӡv size() ��k�A�ҥH�ۤv�[�@�ӡI

    public int size() {
        // �e���I
        return numbers.size();
    }

    // �ڭ̬� MyIntCollection2 ��@�F MyIntCollection �֦����Ҧ���k
    // ���ڭ̰��F�Ǥp�ק�, �N�Y�ǨƱ��e�U�����O�� ArrayList �i��

    public boolean add(int i) {
        // �p�G�o�� int �O�̤j�ȩγ̤p�Ȫ��ܡA�N�⥦�O��
        // (�u�Ĥ@���v�[�i�Ʀr���ɭԡA�ھکw�q�A�o�ӭȷ|�u�P�ɡv�O�ثe�ݨ쪺
        //  �̤j�ȻP�̤p�ȡI)
        // �u�e���v�����O���s��
        if (numbers.isEmpty()) {
            smallestInt = i;
            largestInt = i;
        }
        else {
            if (i < smallestInt) smallestInt = i;
            if (i > largestInt) largestInt = i;
        }

        // ��o�ӼƦr�[���`�M����
	total = total + i;

        // �� int �[�i numbers �s��
        // �u�e���v�����O���s���B�z
        return numbers.add(i);
    }

    // �ѤU����k���P MyIntCollection �����ۦP

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
