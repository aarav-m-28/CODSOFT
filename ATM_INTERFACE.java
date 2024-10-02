package CODSOFT;

import java.util.Scanner;

public class ATM_INTERFACE {
double balance;	
Scanner scanner =new Scanner(System.in);

public ATM_INTERFACE(double initialBalance) {
    this.balance = initialBalance;
}

public void Menu() {
    System.out.println("Welcome to the ATM!");
    System.out.println("1. Check Balance");
    System.out.println("2. Deposit");
    System.out.println("3. Withdraw");
    System.out.println("4. Exit");
    System.out.print("Select an option: ");
}

public void Balance() {
    System.out.printf("Your current balance is: %.2f rs\n", balance);
}

public void deposit() {
	System.out.println("ENTER THE AMMOUNT YOU WANT TO DEPOSITE:");
	double amount=scanner.nextDouble();
		if(amount>0) {
			balance +=amount;
			System.out.printf("\nyou have deposited: %.2f rs\n",amount);
			Balance();
		}
}
public void Withraw() {
	System.out.println("ENTER THE AMMOUNT YOU WANT TO WITHDRAW:");
	double amount = scanner.nextDouble();
	if(amount>0 && amount<=balance) {
		balance -=amount;
		System.out.printf("you have deposited: %.2f rs",amount);
		Balance();
	}
	else {System.out.println("TRANSECTION FAILED!!!.Please try again.");
	}
}
	public static void main(String[] args) {
		ATM_INTERFACE acc = new ATM_INTERFACE(2500);
		Scanner scanner =new Scanner(System.in);
		boolean exit= false;
		while(!exit) {
		acc.Menu();
		int choice = scanner.nextInt();
		
		switch(choice) {
		
		case 1:acc.Balance();
		break;
		case 2:acc.deposit();
		break;
		case 3:acc.Withraw();
		break;
		case 4:System.out.println("THANKS FOR USING ATM.\nGOODBYE....");
		exit=true;
		break;
		default:System.out.println("INVALID OPTION. PLEASE TRY AGAIN.");
		}
		
		}
	}

}
	