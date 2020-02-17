// SimpleCalc.java

// Copyright 2005 by Jacquie Barker - all rights reserved.

public class SimpleCalc {
    public static void main(String args[]) {
        // �ڭ̱N�n�D�ϥΪ̿�J��ӭn�B�⪺�ƭ�
        // ���O���̷|�H String ���Φ��ǤJ�{��
        double first = 0.0;
        double second = 0.0;

        for (int i = 1; i <= 2; i++) {
            System.out.print("�п�J�@�ӼƦr:  ");
            String sNumber = KeyboardInput.readLine();

            // �յ۱N��J���r���ন�ƭ�
            double number = 0.0; 

            try {
                number = Double.parseDouble(sNumber);
            }
            catch (NumberFormatException e) {
                System.out.println("���O�Ʀr: " + sNumber);
                System.out.println("�ЦA�դ@��!");
                System.exit(0);
            }

            // Remember the number;
            if (i == 1) first = number;
            else second = number;
        }

        System.out.print("�п�ܭn�����B�� (+, -, *, /): ");
        String operation = KeyboardInput.readLine();

        // Let's try to compute an answer.

        double answer = 0.0;

        if (operation.equals("+"))  answer = first + second;
        else if (operation.equals("-")) answer = first - second;
        else if (operation.equals("*")) answer = first * second;
        else if (operation.equals("/")) answer = first / second;
        else {
            System.out.println("�B�⤣��: " + operation);
            System.out.println("�ЦA�դ@��!");
            System.exit(0);
        }

        System.out.println(first + " " + operation + " " + second + " = " + answer);
    }
}
