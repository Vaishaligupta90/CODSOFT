// ATMSystem.java
// Vaishali Gupta - CodSoft internship
// Simple console ATM with deposit, withdraw, balance check
// Run:
// javac ATMSystem.java
// java ATMSystem

import java.util.Scanner;

class BankAccount {
    private double balance;
    public BankAccount(double initial) { this.balance = initial; }
    public double getBalance() { return balance; }
    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) return false;
        balance -= amount;
        return true;
    }
    public boolean deposit(double amount) {
        if (amount <= 0) return false;
        balance += amount;
        return true;
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(1000.0); // start with ₹1000 for demo
        System.out.println("ATM Demo - Vaishali's version (CodSoft)");

        boolean running = true;
        while (running) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose (1-4): ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.printf("Current balance: ₹%.2f\n", account.getBalance());
                    break;
                case "2":
                    System.out.print("Enter amount to deposit: ");
                    try {
                        double amt = Double.parseDouble(sc.nextLine().trim());
                        if (account.deposit(amt)) System.out.println("Deposit successful.");
                        else System.out.println("Invalid amount.");
                    } catch (Exception e) { System.out.println("Invalid entry."); }
                    break;
                case "3":
                    System.out.print("Enter amount to withdraw: ");
                    try {
                        double amt = Double.parseDouble(sc.nextLine().trim());
                        if (account.withdraw(amt)) System.out.println("Please collect cash. New balance: ₹" + account.getBalance());
                        else System.out.println("Insufficient funds or invalid amount.");
                    } catch (Exception e) { System.out.println("Invalid entry."); }
                    break;
                case "4":
                    running = false;
                    break;
                default:
                    System.out.println("Please choose 1,2,3 or 4.");
            }
        }
        System.out.println("Thank you for using Vaishali's ATM demo.");
        sc.close();
    }
}
