/**
 * Demonstrates try-catch-finally with return statements.
 *
 * - Finally block executes even if try/catch return earlier.
 * - If finally also has return, it overrides try/catch returns.
 * - Catching Throwable is discouraged (catches Errors too).
 */
public class TryCatchFinally {

    public static int tricky() {
        try {
            return 3;
        } catch (Throwable e) {
            return 5;
        } finally {
            return 7; // This return overrides previous returns
        }
    }

    public static void main(String[] args) {
        System.out.println("Result: " + tricky()); // Always 7
    }
}
