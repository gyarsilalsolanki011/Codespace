class Resource {
    String name;
    Resource(String name) {
        this.name = name;
    }
}

public class DeadlockExample {
    public static void main(String[] args) {
        final Resource r1 = new Resource("Resource-1");
        final Resource r2 = new Resource("Resource-2");

        // Thread 1 locks r1 then tries r2
        Thread t1 = new Thread(() -> {
            synchronized (r1) {
                System.out.println("Thread 1 locked " + r1.name);

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }

                synchronized (r2) {
                    System.out.println("Thread 1 locked " + r2.name);
                }
            }
        });

        // Thread 2 locks r2 then tries r1
        Thread t2 = new Thread(() -> {
            synchronized (r2) {
                System.out.println("Thread 2 locked " + r2.name);

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }

                synchronized (r1) {
                    System.out.println("Thread 2 locked " + r1.name);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
// This code demonstrates a deadlock situation where two threads are waiting for each other to release locks.


