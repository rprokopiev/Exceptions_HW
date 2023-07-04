import java.util.Scanner;
import MyException.floatException;
/**
 * Разработайте программу, которая выбросит Exception, 
 * когда пользователь вводит пустую строку. 
 * Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */
public class EmptyEntryFix {
    static String prompt = "Введите данные";
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try{
            checkData(getUserData(prompt, scan));
        }
        catch(floatException e){
            System.out.println(e.getMessage());
        }
        finally{
            scan.close();
        }
    }

    private static void checkData(String a) throws floatException{
        if(a.isEmpty()){
            throw new floatException("Пустые строки вводить нельзя");
        }
        System.out.println(a);
    }

    private static String getUserData(String prompt, Scanner scan){
        System.out.println(prompt);
        String a = scan.nextLine();
        return a;
    }
}