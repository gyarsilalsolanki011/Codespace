/**
 * Constructor chaining demonstration.
 *
 * - Compiler inserts super() if no explicit constructor call is present.
 * - Parent must be initialized before child.
 */
public class ConstructorChaining {

    static class Parent {
        Parent() {
            System.out.println("Parent()");
        }
    }

    static class Child extends Parent {
        Child() {
            // Compiler automatically inserts super() here
            System.out.println("Child()");
        }
    }

    static class Parent2 {
        Parent2(String msg) {
            System.out.println("Parent2: " + msg);
        }
    }

    static class Child2Fixed extends Parent2 {
        Child2Fixed() {
            super("from Child2Fixed"); // Must call explicit constructor
            System.out.println("Child2Fixed()");
        }
    }

    public static void main(String[] args) {
        new Child();
        new Child2Fixed();
    }
}
