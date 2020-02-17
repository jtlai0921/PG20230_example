// Person.java

/**
 * �@�� Person �O�@�ӤH�C�ڭ̥i�H�� Person �N��ն����Ҥ������ǥͩαб¡C
 */
public class Person {
    //------
    // �ݩ�
    //------
    
    /**
     * �@�ӤH���k�z�m�W�C
     * �q�`�H "FirstName I. LastName" ���榡�e�{�C
     */
    public String name;

    /**
     * �@�ӤH���~�֡A�H�~�����C���ޤU�@�ӥͤ�O����ɭԡA�~�֤@�w�H
     * �e�@�����ͤ���p���ǡC
     */
    private int age;

    //--------
    // �غc�l
    //--------
    /**
     * �o�ӫغc�l�|�� name �P age �o����ݩʳ]�w��ȡC
     * @param n Person ���m�W�A�H "FirstName I. LastName" ���Φ��e�{
     * @param a Person ���~��
     */
    public Person(String n, int a) { 
        name = n;    
        age = a;
    }

    public Person() {

    }

    /**
     * �o�Ӥ�k�i�ΨӱN�~�ִ��⦨�����~�֡C
     */
    public double dogYears() {
        return age/7.0;
    }
}

