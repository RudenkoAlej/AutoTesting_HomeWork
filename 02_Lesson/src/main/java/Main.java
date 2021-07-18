import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        /*Создайте массив из 15 случайных чисел из отрезка [0;9].
        Выведите массив на экран. Подсчитайте сколько в массиве четных
        элементов и выведете это количество на экран на отдельной строке.
        */

        int[] array = new int[15];
        int even = 0;

        Random r = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(10);
            if (array[i] % 2 == 0) {
                even++;
            }
        }
        System.out.println("Массив содержит " + even + " четных элементов");


        /*
        Создать метод, который будет сортировать указанный массив по возрастанию любым известным вам способом.
         */
        System.out.println(Arrays.toString(sortArray(array)));

        /*
        Oписать класс Phone. Реализуйте метод, который будет возвращать стоимость и производительность телефона.
        */
        Phone myPhone = new Phone(200, 5000);
        System.out.println(myPhone.phoneInfo());

        /*
        Создать класс BankAccount который будет иметь 2 поля accountNumber и balance. Реализовать в классе метод setBalance()
        который будет задавать баланс, credit() метод должен начислять средства на счет, debit() - снимать средства со счета.
        Реализовать условие что если сумма снятия меньше чем остаток на счету - вывести сообщение: "Сумма снятия больше чем
        остаток на счету!". Создать объект класса и проверить работу программы.
        */
        BankAccount account = new BankAccount();
        account.setBalance(100);
        account.credit(20);
        account.debit(80);
        account.debit(50);
    }


    private static Object[] sortArray(int[] array) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        int a = list.get(0);
        int range = list.size() - 1;
        ArrayList<Integer> resList = new ArrayList<Integer>();

        for (int m = 0; m < range; m++) {
            for (int n = 0; n < list.size() - 1; n++) {

                if (list.get(n) <= a) {
                    a = list.get(n);
                }
            }
            resList.add(a);
            list.remove(list.indexOf(a));
            a = list.get(0);
        }

        return resList.toArray();
    }


    // -----------------Types of arrays sorting -------------
    // Bubble sort:
//    private static void swap(int[] array, int ind1, int ind2) {
//        int tmp = array[ind1];
//        array[ind1] = array[ind2];
//        array[ind2] = tmp;
//    }
//
//    private static int[] sortArray(int[] array) {
//        boolean needIteration = true;
//        while (needIteration) {
//        needIteration = false;
//            for (int i = 1; i < array.length; i++) {
//                if (array[i] < array[i - 1]) {
//                    swap(array, i, i - 1);
//                    needIteration = true;
//                }
//            }
//        }
//        return array;
//    }

    //Selection sort:
//     private static void swap(int[] array, int ind1, int ind2) {
//        int tmp = array[ind1];
//        array[ind1] = array[ind2];
//        array[ind2] = tmp;
//    }
//
//    private static int[] sortArray(int[] array) {
//       for (int left = 0; left < array.length; left++) {
//            int value = array[left];
//            int i = left - 1;
//            for (; i >= 0; i--) {
//                if (value < array[i]) {
//                    swap(array, i+1, i);
//                } else {
//                   break;
//                }
//            }
//            array[i + 1] = value;
//        }
//        return array;
//    }

    //Shuttle Sort
//    private static void swap(int[] array, int ind1, int ind2) {
//            int tmp = array[ind1];
//            array[ind1] = array[ind2];
//            array[ind2] = tmp;
//        }
//
//    private static int[] sortArray(int[] array) {
//        for (int i = 1; i < array.length; i++) {
//            if (array[i] < array[i - 1]) {
//                swap(array, i, i - 1);
//                for (int z = i - 1; (z - 1) >= 0; z--) {
//                    if (array[z] < array[z - 1]) {
//                        swap(array, z, z - 1);
//                    } else {
//                        break;
//                    }
//                }
//            }
//        }
//        return array;
//    }
    
    
            System.out.println("Git check");
    



}




