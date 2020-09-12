import  java.util.Scanner;
import  java.util.Arrays;
class Main {
    public static void main(String[] args) {
        int counter = 0;
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        for (int num : array) {
            if (num == n) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}