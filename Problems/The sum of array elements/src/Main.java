import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arrays = new int[len];
        for (int i = 0; i < len; i++) {
            arrays[i] = scanner.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < arrays.length; i++) {
            sum = sum + arrays[i];
        }
        System.out.println(sum);
    }
}