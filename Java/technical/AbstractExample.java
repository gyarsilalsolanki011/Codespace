//********************************************************
//
// Abstract class vs Interface (constructors + quick differences)
//
//********************************************************

// File: AbstractExample.java
abstract class Animal {

    String name;

    // abstract class can have a constructor
    Animal(String name) {
        this.name = name;
        System.out.println("Animal ctor: " + name);
    }

    abstract void sound();
}

// Subclass for Abstract class
class Dog extends Animal {
    Dog(String name) {
        super(name); // must call parent constructor
        System.out.println("Dog ctor");
    }

    @Override
    void sound() {
        System.out.println("Woof from " + name);
    }
}

// Parent Class for interface
interface Movable {

    int MAX_SPEED = 120; // public static final

    default void start() { // default method (implementation allowed)
        System.out.println("Movable default start");
    }

    static void info() { // static method in interface
        System.out.println("Movable info");
    }
    // Note: you cannot write a constructor in an interface.
    // interface I { I() { } } // <-- compile error
}

// Subclass for interface
class Car implements Movable {
    // inherits default start(); can override if needed
}

// Main class
public class AbstractExample {
    public static void main(String[] args) {
        Animal a = new Dog("Rex");
        a.sound();

        Movable.info(); // call static method on interface
        Car c = new Car();
        c.start(); // uses default method from interface
    }
}
