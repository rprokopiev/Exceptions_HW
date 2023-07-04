import java.util.Scanner;
import MyException.floatException;

/**
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа
 * (типа float),
 * и возвращает введенное значение.
 * Ввод текста вместо числа не должно приводить к падению приложения,
 * вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */

public class GetFloat {
    static String prompt = "Введите данные";
    static String a;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean flag = false;
        System.out.println(prompt);
        while (flag == false) {
            try {
                if(getFloat(getUserData(scan))){
                    flag = true;
                    System.out.println(Float.parseFloat(a));
                }
            } catch (floatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // проверка ввода, если float => возвращет true, если нет => исключение
    private static boolean getFloat(String a) throws floatException {
        try {
            Float.parseFloat(a);
            return true;
        } catch (NumberFormatException e) {
            throw new floatException(prompt);
        }
    }

    // получение ввода пользователя
    private static String getUserData(Scanner scan) {
        a = scan.nextLine();
        return a;
    }
}