package patterns;

import java.util.Scanner;

public class SquarePattern {
    public static void main(String[] args) {
        System.out.print("Enter the number of rows for the crown pattern: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // Square pattern drawing
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n || i == 2 || i == n - 1 || j == 2 || j == n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
