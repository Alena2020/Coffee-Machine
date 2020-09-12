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
        boolean sorted = true;
        for (int i = 0; i < arrays.length-1 && sorted  ; i++) {
            if (arrays[i] >= arrays[i +1]) {
                sorted = false;
            }
        }
        System.out.println(sorted);
    }
}