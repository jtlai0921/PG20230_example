public class MyIntCollectionExample2 {
  public static void main(String[] args) {
    MyIntCollection2 mic = new MyIntCollection2();
   
    // ���ާڭ̥Ϊ��O MyIntCollection �٬O MyIntCollection2,
    // �Ȥ�{���X���u�����ۦP�v!!! �o�ҩ��F�ڭ̳]�p���O���覡
    // ���T�Q���ð_�ӤF.

    mic.add(3);
    mic.add(6);
    mic.add(1);
    mic.add(9);
	
    System.out.println("�s���]�t " + mic.size() + " �� int ��");
    
    System.out.println("�̤p�ȬO: " + mic.getSmallestInt());
    System.out.println("�̤j�ȬO: " + mic.getLargestInt());
    System.out.println("�����ȬO: " + mic.getAverage());
  }
}
