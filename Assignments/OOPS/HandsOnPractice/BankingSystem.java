package HandsOnPractice;

import java.util.Scanner;

public class BankingSystem {

    // Represents one bank customer
    static class Account {
        private String name;
        private String accountNumber;
        private double balance;

        // Constructor: what happens when we create an account
        public Account(String name, String accountNumber, double initialBalance) {
            this.name = name;
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
        }

        // Deposit money into the account
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited $" + amount + " into " + accountNumber);
            } else {
                System.out.println("Invalid amount to deposit.");
            }
        }

        // Withdraw money from the account
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrew $" + amount + " from " + accountNumber);
            } else {
                System.out.println("Invalid amount or not enough balance.");
            }
        }

        // Transfer money to another account
        public void transfer(Account target, double amount) {
            if (amount > 0 && amount <= balance) {
                this.balance -= amount;
                target.balance += amount;
                System.out.println("Transferred $" + amount + " to " + target.accountNumber);
            } else {
                System.out.println("Transfer failed. Check balance or amount.");
            }
        }

        // Show account information
        public void showInfo() {
            System.out.println("Name: " + name + ", Account: " + accountNumber + ", Balance: $" + balance);
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public double getBalance() {
            return balance;
        }
    }

    // A simple bank that holds multiple accounts
    static class Bank {
        private Account[] accounts = new Account[10]; // Max 10 accounts for now
        private int count = 0;

        // Add a new account to the bank
        public void addAccount(String name, String accountNumber, double initialBalance) {
            if (count < accounts.length) {
                accounts[count] = new Account(name, accountNumber, initialBalance);
                System.out.println("Account created for " + name);
                count++;
            } else {
                System.out.println("Bank is full, can't add more accounts.");
            }
        }

        // Find an account by account number
        public Account findAccount(String accNumber) {
            for (int i = 0; i < count; i++) {
                if (accounts[i].getAccountNumber().equals(accNumber)) {
                    return accounts[i];
                }
            }
            return null;
        }

        // Show all account details
        public void showAllAccounts() {
            for (int i = 0; i < count; i++) {
                accounts[i].showInfo();
            }
        }
    }

    // Entry point of our mini banking app
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank myBank = new Bank();

        while (true) {
            System.out.println("\n--- Welcome to Simple Bank ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Show All Accounts");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();  // Clear the buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter account number: ");
                    String accNo = sc.nextLine();
                    System.out.print("Enter initial deposit: ");
                    double initBal = sc.nextDouble();
                    myBank.addAccount(name, accNo, initBal);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    accNo = sc.nextLine();
                    Account acc = myBank.findAccount(accNo);
                    if (acc != null) {
                        System.out.print("Enter amount to deposit: ");
                        double dep = sc.nextDouble();
                        acc.deposit(dep);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    accNo = sc.nextLine();
                    acc = myBank.findAccount(accNo);
                    if (acc != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double wd = sc.nextDouble();
                        acc.withdraw(wd);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("From account: ");
                    String from = sc.nextLine();
                    System.out.print("To account: ");
                    String to = sc.nextLine();
                    System.out.print("Amount to transfer: ");
                    double amt = sc.nextDouble();
                    Account sender = myBank.findAccount(from);
                    Account receiver = myBank.findAccount(to);
                    if (sender != null && receiver != null) {
                        sender.transfer(receiver, amt);
                    } else {
                        System.out.println("One or both accounts not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    accNo = sc.nextLine();
                    acc = myBank.findAccount(accNo);
                    if (acc != null) {
                        System.out.println("Current balance: $" + acc.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 6:
                    myBank.showAllAccounts();
                    break;

                case 7:
                    System.out.println("Thank you for using Simple Bank!");
                    sc.close();
                    return;

                default:
                    System.out.println("Please choose a valid option.");
            }
        }
    }
}
