import java.io.IOException;

/**
 * Rules for overridden methods regarding access, return type, and exceptions.
 *
 * - Access specifier can be widened (protected → public).
 * - Return type can be covariant (Number → Integer).
 * - Exception list must be same or narrower (IOException → none).
 */
public class AccessReturnExceptionRules {

    static class Parent {
        protected Number test() throws IOException {
            return 1;
        }
    }

    static class Child extends Parent {
        @Override
        public Integer test() throws IOException {
            return 2;
        }
    }

    public static void main(String[] args) throws Exception {
        Parent p = new Child();
        System.out.println("Result: " + p.test());
    }
}