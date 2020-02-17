// Person.java

/**
 * 一個 Person 是一個人。我們可以用 Person 代表校園環境之內的學生或教授。
 */
public class Person {
    //------
    // 屬性
    //------
    
    /**
     * 一個人的法理姓名。
     * 通常以 "FirstName I. LastName" 的格式呈現。
     */
    public String name;

    /**
     * 一個人的年齡，以年為單位。不管下一個生日是什麼時候，年齡一定以
     * 前一次的生日當成計算基準。
     */
    private int age;

    //--------
    // 建構子
    //--------
    /**
     * 這個建構子會為 name 與 age 這兩個屬性設定初值。
     * @param n Person 的姓名，以 "FirstName I. LastName" 的形式呈現
     * @param a Person 的年齡
     */
    public Person(String n, int a) { 
        name = n;    
        age = a;
    }

    public Person() {

    }

    /**
     * 這個方法可用來將年齡換算成狗的年齡。
     */
    public double dogYears() {
        return age/7.0;
    }
}

