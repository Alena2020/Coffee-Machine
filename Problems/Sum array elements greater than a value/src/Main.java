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
        int n = scanner.nextInt();
        for (int num : arrays) {
            if (num > n) {
                sum += num;
            }
        }
        System.out.println(sum);
    }
}