package collection_Day3;

import java.time.LocalDateTime;
import java.util.*;


class Transaction {
    String type; // "Deposit" or "Withdraw"
    double amount;
    LocalDateTime timestamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now(); // current date & time
    }

    public String toString() {
        return timestamp + " | " + type + " | ₹" + amount;
    }
}

// Main Bank System
public class Q10_BankTransactionLog {

    Map<String, List<Transaction>> transactionMap = new HashMap<>();

    // Method to add a transaction to an account
    void addTransaction(String accountNumber, String type, double amount) {
        Transaction txn = new Transaction(type, amount);
        transactionMap.putIfAbsent(accountNumber, new ArrayList<>());
        transactionMap.get(accountNumber).add(txn);
    }

    // Generate account statement sorted by time
    void printStatement(String accountNumber) {
        List<Transaction> transactions = transactionMap.get(accountNumber);

        if (transactions == null || transactions.isEmpty()) {
            System.out.println("❌ No transactions for account: " + accountNumber);
            return;
        }

        // Sort by time
        transactions.sort(Comparator.comparing(t -> t.timestamp));

        System.out.println("📄 Statement for Account: " + accountNumber);
        for (Transaction txn : transactions) {
            System.out.println(txn);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Q10_BankTransactionLog bank = new Q10_BankTransactionLog();


        bank.addTransaction("ACC123", "Deposit", 5000);
        Thread.sleep(1000); // delay for timestamp difference
        bank.addTransaction("ACC123", "Withdraw", 1000);
        Thread.sleep(1000);
        bank.addTransaction("ACC123", "Deposit", 2000);
        bank.addTransaction("ACC999", "Deposit", 8000);

        // Generate statement
        bank.printStatement("ACC123");
    }
}
