package PracticeSheet;

public class BankAccount {
    // Private fields (Encapsulation)
    private String accountHolder;
    private double balance;
    private String accountNumber;

    // Constructor to initialize all fields
    public BankAccount(String accountHolder, double balance, String accountNumber) {
        this.accountHolder = accountHolder;
        setBalance(balance); // Use setter to apply validation
        this.accountNumber = accountNumber;
    }

    // Getter for accountHolder
    public String getAccountHolder() {
        return accountHolder;
    }

    // Setter for accountHolder
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Setter for balance with validation
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Error: Balance cannot be negative.");
        }
    }

    // Getter for accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }

    // Setter for accountNumber
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Method to print account details
    public void printAccountDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }

    // Main method to test
    public static void main(String[] args) {
        // Create a bank account with valid balance
        BankAccount acc = new BankAccount("Sanjana", 500.0, "ACC12345");
        acc.printAccountDetails();

        // Try to set a negative balance (should be prevented)
        acc.setBalance(-100.0);

        // Check current balance (should still be 500)
        System.out.println("\nAfter invalid update:");
        acc.printAccountDetails();
    }
}

