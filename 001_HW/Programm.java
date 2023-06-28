import java.util.Random;

public class Programm {
    static Random rand = new Random();

    public static void main(String[] args) {
        // task1_1();
        // task1_2();
        // task1_3("a");

        // task2(getRandArray(), getRandArray());

        // task3(getRandArray(), getRandArray());

    }

    // 1) Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
    static int task1_1() {
        int i = 1 / 0;
        return i;
    }

    static int task1_2() {
        int[] array = new int[] { 1, 3, 5, 6 };
        return array[5];
    }

    static int task1_3(String a) {
        int i = Integer.parseInt(a);
        return i;
    }

    /**
     * 2) Реализуйте метод, принимающий в качестве аргументов два целочисленных
     * массива, и возвращающий новый массив,
     * каждый элемент которого равен разности элементов двух входящих массивов в той
     * же ячейке.
     * Если длины массивов не равны, необходимо как-то оповестить пользователя.
     */

    static void task2(int[] a1, int[] a2) {
        if (a1.length != a2.length) {
            System.out.println("разные длинны массивов");
        } else {
            printArray(a1);
            printArray(a2);
            int[] a3 = new int[a1.length];
            for (int i = 0; i < a1.length; i++) {
                for (int j = 0; j < a2.length; j++) {
                    a3[i] = a1[i] - a2[j];
                }
            }
            printArray(a3);
        }
    }

    /**
     * 3) (Дополнительно) Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, 
     * и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. 
     * Если длины массивов не равны, необходимо как-то оповестить пользователя. 
     * Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.
     */
    static void task3(int[] a1, int[] a2) {
        if (a1.length != a2.length) {
            throw new RuntimeException("Разная длина массивов");
        }       
        else {
            printArray(a1);
            printArray(a2);
            for (int i = 0; i < a2.length; i++) {
                if(a2[i] == 0){
                    throw new RuntimeException("Деление на ноль запрещено");
                }
            }
            int[] a3 = new int[a1.length];
            for (int i = 0; i < a1.length; i++) {
                for (int j = 0; j < a2.length; j++) {
                    a3[i] = a1[i] / a2[j];
                }
            }
            printArray(a3);
        }
    }


    static int[] getRandArray() {
        int l = rand.nextInt(3, 5);
        int[] array = new int[l];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(0, 4);
        }
        return array;
    }

    static void printArray(int[] array) {
        System.out.print("[ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
        System.out.print("]");
        System.out.println();
    }

}