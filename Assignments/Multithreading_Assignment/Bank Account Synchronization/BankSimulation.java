package Multithreading_Assignment;

public class BankSimulation {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Starting with ₹1000


        Thread depositThread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(200, "User-A");
                sleep(500);
            }
        });

        Thread depositThread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(100, "User-B");
                sleep(300);
            }
        });


        Thread withdrawThread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.withdraw(150, "User-C");
                sleep(400);
            }
        });

        Thread withdrawThread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.withdraw(100, "User-D");
                sleep(200);
            }
        });


        depositThread1.start();
        depositThread2.start();
        withdrawThread1.start();
        withdrawThread2.start();


        try {
            depositThread1.join();
            depositThread2.join();
            withdrawThread1.join();
            withdrawThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("\nFinal Balance: ₹" + account.getBalance());
    }

    // Helper method to sleep thread
    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
