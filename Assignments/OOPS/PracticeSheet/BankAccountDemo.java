package PracticeSheet;

public class BankAccountDemo {

    static class BankAccount {
        private String name;
        private double balance;
        private String type;

        // Constructor using 'this' to resolve shadowing
        public BankAccount(String name, double balance, String type) {
            this.name = name;       // 'this.name' refers to the instance variable
            this.balance = balance; // Shadowing: 'balance' parameter shadows the field
            this.type = type;       // Resolves the conflict using 'this'
        }

        // Method to update balance
        public void updateBalance(double balance) {
            System.out.println("Updating balance...");
            System.out.println("Old balance: " + this.balance);

            this.balance = balance; // Resolves shadowing again
            System.out.println("New balance: " + this.balance);
        }

        // Method to display account details
        public void displayDetails() {
            System.out.println("\n--- Account Info ---");
            System.out.println("Name: " + name);
            System.out.println("Account Type: " + type);
            System.out.println("Balance: $" + balance);
        }
    }

    // Main method
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Sanjana", 1000.0, "Savings");
        account.displayDetails();

        // Update balance
        account.updateBalance(1500.0);
        account.displayDetails();
    }
}

