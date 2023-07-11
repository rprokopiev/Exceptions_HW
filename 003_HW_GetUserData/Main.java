import java.util.Scanner;

import MyException.DataCheckException;
import MyException.ReceivedDataQtyException;

public class Main {
    static String prompt = "Введите ФИО и № телефона через пробел";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean flag = false;
        System.out.println(prompt);
        while (flag == false) {
            try {
                UserEntry.entryCheck(prompt, scan);
                flag = true;
            } catch (ReceivedDataQtyException e) {
                System.out.printf("%s \n Получено элементов - %d, требуется 4\n", e.getMessage(), e.getIndex());
                System.out.println(prompt);
            } catch (DataCheckException e) {
                System.out.println(e.getMessage());
                System.out.println(prompt);
            }
        }
    }
}