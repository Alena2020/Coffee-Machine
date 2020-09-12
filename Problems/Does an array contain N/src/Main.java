import java.util.Scanner;
import java.util.Arrays;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       boolean result = false;
         int len = scanner.nextInt();
        int[]  array = new int[len];
         for (   int i = 0; i <  len; i++) {
            array[i] = scanner.nextInt();
        }
        int number = scanner.nextInt();
        for (int  i = 0; i < array.length && !result; i++)  {
            if (array[i] == number) {
                result =  true;
                 }
            }
            System.out.println(result);
    }
}