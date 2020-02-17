// SimpleCalc.java

// Copyright 2005 by Jacquie Barker - all rights reserved.

public class SimpleCalc {
    public static void main(String args[]) {
        // 我們將要求使用者輸入兩個要運算的數值
        // 但是它們會以 String 的形式傳入程式
        double first = 0.0;
        double second = 0.0;

        for (int i = 1; i <= 2; i++) {
            System.out.print("請輸入一個數字:  ");
            String sNumber = KeyboardInput.readLine();

            // 試著將輸入的字串轉成數值
            double number = 0.0; 

            try {
                number = Double.parseDouble(sNumber);
            }
            catch (NumberFormatException e) {
                System.out.println("不是數字: " + sNumber);
                System.out.println("請再試一次!");
                System.exit(0);
            }

            // Remember the number;
            if (i == 1) first = number;
            else second = number;
        }

        System.out.print("請選擇要做的運算 (+, -, *, /): ");
        String operation = KeyboardInput.readLine();

        // Let's try to compute an answer.

        double answer = 0.0;

        if (operation.equals("+"))  answer = first + second;
        else if (operation.equals("-")) answer = first - second;
        else if (operation.equals("*")) answer = first * second;
        else if (operation.equals("/")) answer = first / second;
        else {
            System.out.println("運算不對: " + operation);
            System.out.println("請再試一次!");
            System.exit(0);
        }

        System.out.println(first + " " + operation + " " + second + " = " + answer);
    }
}
