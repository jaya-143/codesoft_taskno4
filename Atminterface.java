package codeSoft_numbergame;
import java.util.Scanner;

//4.Create a class to represent the user's bank account, which stores the account balance.
class BankAccount {
	 private double balance;
	
	 public BankAccount(double initialBalance) {
	     this.balance = initialBalance;
	 }
	
	 public boolean deposit(double amount) {
	     if (amount > 0) {
	         balance += amount;
	         return true;
	     }
	     return false;
	 }
	
	 public boolean withdraw(double amount) {
	     if (amount > 0 && amount <= balance) {
	         balance -= amount;
	         return true;
	     }
	     return false;
	 }
	
	 public double getBalance() {
	     return balance;
	 }
}


// 1.Create a class to represent the ATM machine.
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    
// 2.Design the user interface for the ATM, including options such as withdrawing, depositing, and checking the balance.    
    public void display_Menu() {
    	System.out.println("ATM INTERFACE");
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
    

// 3.Implement methods for each option, such as withdraw(amount), deposit (amount), and checkBalance()
    public void perform_Transaction() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            display_Menu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                	
// 7.Display appropriate messages to the user based on their chosen options and the success or failure of their transactions
                    System.out.println("Current Balance: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: $");
                    double deposit_Amount = scanner.nextDouble();
                    
// 6.Validate user input to ensure it is within acceptable limits (eg. sufficient balance for withdrawals)
                    if (account.deposit(deposit_Amount)) {
                        System.out.println("Deposit of $" + deposit_Amount + " was successful. Your available new balance is $" + account.getBalance());
                    } else {
                        System.out.println("Invalid deposit amount. Please enter a positive value.");
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: $ ");
                    double withdraw_Amount = scanner.nextDouble();
                    
// 6.Validate user input to ensure it is within acceptable limits (eg. sufficient balance for withdrawals)
                    if (account.withdraw(withdraw_Amount)) {
                        System.out.println("Withdrawal of $" + withdraw_Amount + " was successful. Your new available balance is $" + account.getBalance());
                    } else {
                        System.out.println("Insufficient funds or invalid amount. Unable to withdraw the requested amount.");
                    }
                    break;
                case 4:
                    quit = true;
                    System.out.println("Thank you for using the ATM. Good day..!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;
            }
        }
        scanner.close();
    }
}


// 5.Connect the ATM class with the user's bank account class to access and modify the account balance.
public class Atminterface {
	 public static void main(String[] args) {
	        BankAccount account = new BankAccount(1000.0);
	        ATM atm = new ATM(account);
	        atm.perform_Transaction();
	    }
}


