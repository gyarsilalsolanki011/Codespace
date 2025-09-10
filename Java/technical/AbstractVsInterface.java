/**
 * Abstract Class vs Interface demonstration.
 *
 * - Abstract class can have constructors and state.
 * - Interface cannot have constructors (only static/default methods).
 * - Abstract class is good for shared implementation.
 * - Interface is good for defining contracts/capabilities.
 */
public class AbstractVsInterface {

    /** Abstract class with a constructor and an abstract method. */
    abstract static class Animal {
        String name;

        Animal(String name) {
            this.name = name;
            System.out.println("Animal constructor called with: " + name);
        }

        abstract void sound();
    }

    /** Subclass Dog provides implementation of abstract method. */
    static class Dog extends Animal {
        Dog(String name) {
            super(name);
            System.out.println("Dog constructor called");
        }

        @Override
        void sound() {
            System.out.println("Woof from " + name);
        }
    }

    /** Interface with default and static methods. */
    interface Movable {
        default void start() {
            System.out.println("Movable: default start");
        }

        static void info() {
            System.out.println("Movable: static info");
        }
    }

    /** Class implementing interface. */
    static class Car implements Movable {}

    public static void main(String[] args) {
        Animal a = new Dog("Rex");
        a.sound();          // Abstract method implementation

        Movable.info();     // Static method on interface
        new Car().start();  // Default method from interface
    }
}