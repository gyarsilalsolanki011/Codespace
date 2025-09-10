/**
 * Difference between Overloading and Overriding.
 *
 * Overloading: same method name, different parameter list (compile-time).
 * Overriding: same method signature in parent/child, different implementation (runtime).
 */
public class OverloadingVsOverriding {

    /** Demonstrates method overloading (compile-time polymorphism). */
    static class Calculator {
        int add(int a, int b) { return a + b; }
        double add(double a, double b) { return a + b; }
    }

    /** Parent class with a method. */
    static class Parent {
        void show() { System.out.println("Parent show()"); }
    }

    /** Child overrides the parent's method (runtime polymorphism). */
    static class Child extends Parent {
        @Override
        void show() { System.out.println("Child show()"); }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Overloading (int): " + calc.add(2, 3));
        System.out.println("Overloading (double): " + calc.add(2.5, 3.5));

        Parent p = new Child();
        p.show(); // Calls Child's version at runtime
    }
}