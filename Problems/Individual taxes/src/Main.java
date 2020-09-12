import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int companies = scanner.nextInt();
        double[] incomes = new double[companies];
        double[] percent = new double[companies];
        double taxes = 0;
        int number = 1;
        double max = 0;
        for (int i = 0; i < companies; i++) {
            incomes[i] = scanner.nextDouble();
        }
        for (int i = 0; i < companies; i++) {
            percent[i] = scanner.nextDouble();
        }
        for (int i = 0; i < companies; i++) {
            taxes = percent[i] * incomes[i] / 100;
            if (max < taxes) {
                max = taxes;
                number = i + 1;
            }
        }
        System.out.println(number);
    }
}

