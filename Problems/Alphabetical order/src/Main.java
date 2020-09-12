import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        String[] arrayCopy = Arrays.copyOf(array, array.length);
        boolean alphabeticalOrder = false;
        Arrays.sort(array);
        if (Arrays.equals(array, arrayCopy)) {
            alphabeticalOrder = true;
        }
        System.out.println(alphabeticalOrder);
    }
}