/**
 * Static methods cannot be overridden, only hidden.
 *
 * - Method resolution is based on reference type, not object type.
 */
public class StaticOverride {

    static class Parent {
        static void display() { System.out.println("Parent static method"); }
    }

    static class Child extends Parent {
        static void display() { System.out.println("Child static method"); }
    }

    public static void main(String[] args) {
        Parent p = new Child();
        p.display();   // Prints Parent's method (reference type rule)
        Child.display(); // Explicitly call Child's method
    }
}
