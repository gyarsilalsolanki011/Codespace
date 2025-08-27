package patterns;

import java.util.Scanner;

public class HalfTrianglePattern {
    public static void main(String[] args) {
        System.out.print("Enter the number of rows for the half triangle pattern: ");
        Scanner scanner = new Scanner(System.in);
        int raw = scanner.nextInt();
        scanner.close();

        for (int i = 1; i <= raw; i++) {

            int stars = i;
            for (int star = 1; star <= stars; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
