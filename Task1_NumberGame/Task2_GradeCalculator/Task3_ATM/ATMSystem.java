// ATMSystem.java
// Vaishali Gupta - CodSoft internship
// Simple console ATM with deposit, withdraw, balance check
// Run:
// javac ATMSystem.java
// java ATMSystem
import java.util.Scanner;

// Helper class renamed to "UserAccount"
class UserAccount {
    private double balance;

    // Constructor
    public UserAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Deposit money
    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid deposit amount!");
            return false;
        }
        balance += amount;
        System.out.println("✅ Deposit successful! New Balance: ₹" + balance);
        return true;
    }

    // Withdraw money
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount!");
            return false;
        } else if (amount > balance) {
            System.out.println("❌ Insufficient funds!");
            return false;
        } else {
            balance -= amount;
            System.out.println("✅ Withdrawal successful! Remaining Balance: ₹" + balance);
            return true;
        }
    }

    // Check balance
    public double getBalance() {
        return balance;
    }
}

// Main class (must match file name in compiler)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserAccount account = new UserAccount(1000.0); // starting balance ₹1000
        int choice;

        System.out.println("💳 Welcome to CodSoft ATM 💳");

        do {
            System.out.println("\n------ ATM MENU ------");
            System.out.println("1️⃣  Check Balance");
            System.out.println("2️⃣  Deposit Money");
            System.out.println("3️⃣  Withdraw Money");
            System.out.println("4️⃣  Exit");
            System.out.print("👉 Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("💰 Current Balance: ₹" + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double deposit = sc.nextDouble();
                    account.deposit(deposit);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdraw = sc.nextDouble();
                    account.withdraw(withdraw);
                    break;

                case 4:
                    System.out.println("🙏 Thank you for using CodSoft ATM!");
                    break;

                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}

