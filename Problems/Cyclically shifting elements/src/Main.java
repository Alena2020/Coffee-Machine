import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] a = new int[len];
        for (int i = 0;  i < len;  i++) {
            a[i] = scanner.nextInt();
        }
        System.out.print(a[a.length - 1] + " ");
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + " ");
        }
//        int [] aCopy = Arrays.copyOf(a, a.length-1);
//
//
//        System.out.print( aCopy);
    }
}