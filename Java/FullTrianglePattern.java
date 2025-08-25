import java.util.Scanner;

public class FullTrianglePattern {
    public static void main(String[] args) {
        System.out.print("Enter the number of rows for the full triangle pattern: ");
        Scanner scanner = new Scanner(System.in);
        int raw = scanner.nextInt();
        scanner.close();

        for (int i = 1; i <= raw; i++) {

            int spaces = raw - i;
            for (int space = 1; space <= spaces; space++) {
                System.out.print(" ");
            }

            int stars = (2 * i) - 1;
            for (int star = 1; star <= stars; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
