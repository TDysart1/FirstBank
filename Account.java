package FirstBank;

import java.util.Scanner;

public class Account {
	
	private String accountName; 
	private int accountId;
	private double balance;
	private double previousTransaction; 
	public Account(String name, int id) {
		this.accountName = name;
		this.accountId = id; 
			
		}
	void withdrawl(double amount) {
		if(amount != 0) {
			balance = balance - amount;
			previousTransaction = amount; 
			}
		}
	void deposit(double amount) {
		if(amount != 0) {
			balance = balance + amount;
			previousTransaction = amount; 
			}
		}
	void checkBalance() {
		System.out.println( "Balance : $" + balance); 
	}
	void history() {
		if(previousTransaction > 0) {System.out.println("History : Deposited $" + previousTransaction + 0); }
		else if(previousTransaction < 0 ){System.out.println("History : Withdrew $" + previousTransaction + 0); }
		else {System.out.println("No history recorded");}
		
	}
	void interest(int years) {
		double interestRate = .0185;
		double newBalance = (balance * interestRate * years) + balance; 
		System.out.println("The current interest rate is " + (100 * interestRate));
		System.out.println("After " + years + " years, your balance will be $" + newBalance );
	}
	public String toString() {
		return "This account belongs to " + accountName + " and the id is " + accountId;
		}
	void dash() {
		System.out.println("-----------");
	}
		
	public void showMenu() {
		int option;
		System.out.println("Welcome to the First Bank Program!");
		dash();
		System.out.println("Account Name " + accountName);
		System.out.println("Account Id: " + accountId);
		dash();
		System.out.println("Press the following number for action you wish to do: " );
		dash();
		System.out.println("1 - check balance");
		System.out.println("2 - Deposit Money into account");
		System.out.println("3 - Withdrawl Money");
		System.out.println("4 - View Previous Transaction");
		System.out.println("5 - calculate interest ");
		System.out.println("0 - exit the system");
		Scanner userInput = new Scanner(System.in);
		do{
			dash();
			System.out.println("What would you like to do?");
			option = userInput.nextInt();
			
			switch(option) {
			case 1:
				checkBalance();
				break;
			case 2:
				System.out.println("How much would you like to deposit?");
				double amount = userInput.nextDouble();
				deposit(amount);
				break;
			case 3:
				System.out.println("How much would you like to withdrawl?");
				double amount2 = userInput.nextDouble();
				withdrawl(amount2);
				break;
			case 4:
				history();
				break;
			case 5:
				System.out.println("How many years are we calculating?");
				int total = userInput.nextInt();
				interest(total);
				break;
			case 0:
				dash();
				break;
			default:
				System.out.println("Not a valid input");
			}
		} while (option != 0); {System.out.println("Thank for coming!");}
		
	}
}
