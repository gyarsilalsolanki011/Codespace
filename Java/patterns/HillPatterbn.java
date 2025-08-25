package patterns;

import java.util.Scanner;

public class HillPatterbn {
    public static void main(String[] args) {
        System.out.print("Enter the number of rows for the hill pattern: ");
        Scanner scanner = new Scanner(System.in);
        int raw = scanner.nextInt();
        scanner.close();

        for (int i = 1; i <= raw; i++) {
            
            int stars = i;
            for (int star = 1; star <= stars; star++){
                System.out.print("*");
            }

            int spaces = 2 * (raw - i);
            for (int space = 1; space <= spaces; space++){
                System.out.print(" ");
            }

            for (int star = 1; star <= stars; star++){
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
