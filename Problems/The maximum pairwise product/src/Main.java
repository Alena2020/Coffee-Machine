import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt();
        }
        int maxProduct = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            int product = array[i] * array[i + 1];
            if (maxProduct < product)
                maxProduct = product;
        }
        System.out.println(maxProduct);
    }
}