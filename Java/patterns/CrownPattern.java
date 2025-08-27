package patterns;

import java.util.Scanner;

public class CrownPattern {
    public static void main(String[] args) {
        System.out.print("Enter the number of rows for the crown pattern: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {

            // Left stars
            int stars = i;
            for (int s = 1; s <= stars; s++) {
                System.out.print("*");
            }

            // First space
            int spaces = 2 * (n - i);
            for (int sp = 1; sp <= spaces; sp++) {
                System.out.print(" ");
            }

            // Middle stars
            stars = 2 * i - 1;
            for (int s = 1; s <= stars; s++) {
                System.out.print("*");
            }

            // Second space (same as first space)
            spaces = 2 * (n - i);
            for (int sp = 1; sp <= spaces; sp++) {
                System.out.print(" ");
            }

            // Right stars (same as left)
            stars = i;
            for (int s = 1; s <= stars; s++) {
                System.out.print("*");
            }

            System.out.println(); // Move to next line
        }
        scanner.close(); // Close the scanner to avoid resource leak
    }
}
