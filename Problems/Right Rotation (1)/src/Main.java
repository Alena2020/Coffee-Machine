import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] entrance = in.nextLine().split(" ");
        int number = in.nextInt();
        number = number % entrance.length;

        String[] rotatedArray = new String[entrance.length];
        for (int i = 0; i < entrance.length; i++) {
            rotatedArray[i] = entrance[(entrance.length - number + i) % entrance.length];
        }
        for (String s : rotatedArray) {
            System.out.print(s + " ");
        }
    }
}

