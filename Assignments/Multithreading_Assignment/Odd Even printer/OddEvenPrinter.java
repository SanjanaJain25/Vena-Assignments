package Multithreading_Assignment;

class OddEvenPrinter {
    private int number = 1;  // Starts from 1

    // Method to print odd numbers
    public synchronized void printOdd() {
        while (number <= 100) {
            if (number % 2 != 0) {  // If it's an odd number
                System.out.print(number + " ");
                number++;  // Increment the number for the next round
                notify();  // Notify the other thread to print even number
                try {
                    if (number <= 100) {
                        wait();  // Wait for the other thread to print
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Method to print even numbers
    public synchronized void printEven() {
        while (number <= 100) {
            if (number % 2 == 0) {  // If it's an even number
                System.out.print(number + " ");
                number++;  // Increment the number for the next round
                notify();  // Notify the other thread to print odd number
                try {
                    if (number <= 100) {
                        wait();  // Wait for the other thread to print
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

