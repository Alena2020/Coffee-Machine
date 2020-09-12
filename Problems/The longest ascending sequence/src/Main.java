import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int count = 1;
        int max = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                count++;
            }
            if (array[i] < array[i - 1] || i == array.length - 1) {
                if (max < count) {
                    max = count;
                }
                count = 1;
            }
        }
        System.out.println(max);
    }
}