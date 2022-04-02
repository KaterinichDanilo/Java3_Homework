package Homework4;

public class homework4 {
    private static final Object monitor = new Object();
    private static final int NUM = 5;
    private static volatile int currentThread = 0;

    public static void main(String[] args) {
        Thread printA = new Thread(() -> {
            for (int i = 0; i < NUM; i++) {
                synchronized (monitor) {
                    while (currentThread != 0) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("A");
                    currentThread = 1;
                    monitor.notifyAll();

                }
            }
        });

        Thread printB = new Thread(() -> {
            for (int i = 0; i < NUM; i++) {
                synchronized (monitor) {
                    while (currentThread != 1) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("B");
                    currentThread = 2;
                    monitor.notifyAll();

                }
            }
        });

        Thread printC = new Thread(() -> {
            for (int i = 0; i < NUM; i++) {
                synchronized (monitor) {
                    while (currentThread != 2) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                     System.out.print("C");
                     currentThread = 0;
                     monitor.notifyAll();
                }
            }
        });

        printA.start();
        printB.start();
        printC.start();
    }
}
