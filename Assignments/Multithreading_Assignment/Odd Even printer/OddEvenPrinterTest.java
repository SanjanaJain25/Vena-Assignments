package Multithreading_Assignment;

public class OddEvenPrinterTest {
    public static void main(String[] args) {
        OddEvenPrinter printer = new OddEvenPrinter();

        // Thread A (prints odd numbers)
        Thread oddThread = new Thread(() -> {
            printer.printOdd();


        });

        // Thread B (prints even numbers)
        Thread evenThread = new Thread(() -> {
            printer.printEven();
        });



        // Start both threads
        oddThread.start();
        evenThread.start();

        // Wait for both threads to finish
        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
