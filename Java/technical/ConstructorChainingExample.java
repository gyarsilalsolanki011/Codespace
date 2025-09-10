//********************************************************
//
// Constructor chaining & why the compiler inserts super()
//
//********************************************************


// Example 1 — parent has no-arg constructor
class Parent {
    Parent() {
        System.out.println("Parent()");
    }
}

class Child extends Parent {
    Child() {
        // compiler inserts super() here automatically
        System.out.println("Child()");
    }
}



//Example 2 — parent has only parameterized constructor (shows compile error unless you call super(...))
class Parent2 {
    Parent2(String msg) {
        System.out.println("Parent2: " + msg);
    }
}

// class Child2 extends Parent2 {
//     Child2() {
//         // compiler would try to insert super(); but Parent2 has no no-arg -> COMPILER ERROR
//         System.out.println("Child2()");
//     }
// }

// To fix, explicitly call super("hello") in Child2's constructor:
class Child2Fixed extends Parent2 {
    Child2Fixed() {
        super("from Child2Fixed"); // must call a matching parent ctor
        System.out.println("Child2Fixed()");
    }
}


public class ConstructorChainingExample {
    public static void main(String[] args) {
        // Create an instance of the subclass
        new Child();
        new Child2Fixed();
    }
}
