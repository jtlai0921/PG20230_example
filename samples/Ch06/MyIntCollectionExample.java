public class MyIntCollectionExample {
  public static void main(String[] args) {
    MyIntCollection mic = new MyIntCollection();

    // �N�|���H����ƴ��J�ڭ̪��u�S��v�s��
    mic.add(3);
    mic.add(6);
    mic.add(1);
    mic.add(9);
	
    // ���αq ArrayList �~�ӦӨӪ� size ��k ...
    System.out.println("�s���]�t " + mic.size() + " �� int ��");

    // ... �M��V mic �ݤ@�ǦU�� ArrayList ���L�k���P�^�����u�S��v���D
    System.out.println("�̤p�ȬO: " + mic.getSmallestInt());
    System.out.println("�̤j�ȬO: " + mic.getLargestInt());
    System.out.println("�����ȬO: " + mic.getAverage());
  }
}
