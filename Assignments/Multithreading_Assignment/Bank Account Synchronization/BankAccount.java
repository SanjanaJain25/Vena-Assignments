package Multithreading_Assignment;

public class BankAccount {
    private double balance;

    public BankAccount(double initialbalance){
        this.balance= initialbalance;
    }

    public synchronized void deposit(double amount, String user) {
        balance += amount;
        System.out.println(user + " deposited ₹" + amount + " | New Balance: ₹" + balance);
    }
    public synchronized void withdraw(double amount, String user) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(user + " withdrew ₹" + amount + " | New Balance: ₹" + balance);
        } else {
            System.out.println(user + " tried to withdraw ₹" + amount + " | Failed: Insufficient Balance ₹" + balance);
        }
    }
    public synchronized double getBalance() {
        return balance;
    }
}

