package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.Account;

public class AccountMenu {

	public void showAccountMenu(Account account) {

		@SuppressWarnings("resource")
		Scanner keyIn = new Scanner(System.in);
		int choice;
		
		try {
			do {

				System.out.println("///**** Current Account Menu ****///");
				System.out.println("1. View Balance");
				System.out.println("2. Make Withdraw");
				System.out.println("3. Make Deposit");
				System.out.println("4. Save Account Details");
				System.out.println("5. Read Account Details");
				System.out.println("Enter 0 to exit");
				choice = keyIn.nextInt();

				switch (choice) {
				case 1:
					/*
					 * This is example of runtime Polymorphism we use the
					 * Account object to call get balance, yet we don't need to specify
					 * the Account type. Java will know the correct type
					 * and return the correct balance associated with that account
					 * whether it be a CurrentAccount or a JointAccount
					 */
					System.out.printf("Balance: %.2f\n", account.getBalance());
					break;
				case 2:
					WithDrawMenu.showWithdrawMenu(account);
					break;
				case 3:
					DepositMenu.showDepositMenu(account);
					break;
				case 4:
					account.saveAccountDetails(account);
					break;
				case 5:
					account.readAccountDetails();
					break;
				default:
					if(choice == 0) {
						System.out.println("Goodbye");
						/*
						 * Where most times it would be bad practice
						 * to use System.exit(0) to end the application
						 * it is needed here if we did not use it the AccountMenu
						 * would close but the LoginMenu would be reopened as it
						 * is still on the stack
						 */
						System.exit(0);
					} else {
						System.out.println("Invlaid choice");
					}
				}
			} while (choice != 0);

		} catch (InputMismatchException ex) {

			ex.printStackTrace();
			showAccountMenu(account);
		}
	}
}
