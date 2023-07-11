import java.util.Scanner;

import MyException.DataCheckException;
import MyException.ReceivedDataQtyException;

public class UserEntry {

    // Метод получает строку от пользователя и возвращает значение String, если:
    // разбиения строки по пробелам даёт 4 подстроки
    // и последняя строка состоит только из цифр.
    public static void entryCheck(String prompt, Scanner scan) throws ReceivedDataQtyException, DataCheckException {
        String a = getUserData(scan);
        try {
            if (dataQtyCheck(a) && dataQualityCheck(a)) {
                WriteToFile.addToFile(a.split(" "));
            }
        } catch (ReceivedDataQtyException e) {
            throw new ReceivedDataQtyException(e.getMessage(), e.getIndex());
        } catch (DataCheckException e) {
            throw new DataCheckException(e.getMessage());
        }
    }

    // получение строки от пользователя
    private static String getUserData(Scanner scan) {
        String a = scan.nextLine();
        return a;
    }

    // Метод разбивает строку на подстроки по знаку пробела, считает кол-во
    // полученных строк,
    // Если кол-во = 4 - true, если нет - exception.
    private static boolean dataQtyCheck(String a) throws ReceivedDataQtyException {
        int index = 0;
        for (int i = 0; i < a.split(" ").length; i++) {
            index++;
        }
        if (index == 4) {
            return true;
        } else {
            throw new ReceivedDataQtyException("Не совпадает количество введённых данных", index);
        }
    }

    // Проверка, если в телефонном номере цифры, 
    // если цифры - true, если нет - exception.
    private static boolean dataQualityCheck(String a) throws DataCheckException {
        String check = a.split(" ")[3];
        try {
            Double.parseDouble(check);
            return true;
        } catch (NumberFormatException e) {
            throw new DataCheckException("Ошибочный формат номера телефона");
        }
    }
}
