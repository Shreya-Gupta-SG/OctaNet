import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double Balance) {
        this.balance = Balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! Remaining balance: "+balance);
            return true;
        } else {
            System.out.println("Invalid amount!");
            return false;
            
        }
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
        balance += amount;
        System.out.println("Deposit successful! Remaining balance: "+balance);
        } else {
            System.out.println("Invalid amount!");
        }
    }

}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }
    
    //Display Screen
    public void displayMenu() {
        System.out.println("ATM INTERFACE:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Exiting the ATM. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

//Main class 
public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}


