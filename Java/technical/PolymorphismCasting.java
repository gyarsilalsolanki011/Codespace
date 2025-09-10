/**
 * Polymorphism and casting demonstration.
 *
 * - Upcasting: Child object → Parent reference (safe).
 * - Downcasting: Parent reference → Child reference (needs instanceof check).
 * - Direct Parent → Child assignment is not allowed.
 * - Forced cast can cause ClassCastException.
 */
public class PolymorphismCasting {

    static class A {
        void m() { System.out.println("A#m"); }
    }

    static class B extends A {
        @Override
        void m() { System.out.println("B#m"); }
        void bOnly() { System.out.println("B#bOnly"); }
    }

    public static void main(String[] args) {
        A a1 = new B();   // ✅ Upcasting
        a1.m();           // B#m (runtime polymorphism)

        // B a2 = new A(); // ❌ Compile-time error

        try {
            B b2 = (B) new A(); // Compiles, but fails at runtime
            b2.bOnly();
        } catch (ClassCastException ex) {
            System.out.println("ClassCastException: " + ex.getMessage());
        }

        A a3 = new B();
        if (a3 instanceof B) {
            B b3 = (B) a3; // Safe downcasting
            b3.bOnly();
        }
    }
}
