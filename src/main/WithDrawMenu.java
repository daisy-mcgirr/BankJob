package main;

import java.util.Scanner;

import model.Account;
import model.CurrentAccount;
import model.JointAccount;

public class WithDrawMenu {

	public static void showWithdrawMenu(Account account) {
		
		@SuppressWarnings("resource")
		Scanner keyIn = new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner stringKeyIn = new Scanner(System.in);
		double amount;

		try {

			System.out.println("//** Withdraw Menu **//");

			System.out.println("Please enter amount you wish to withdraw: ");
			amount = keyIn.nextDouble();

			if (account instanceof CurrentAccount) {

				CurrentAccount currAcc = (CurrentAccount) account;
				currAcc.withdraw(amount);
			} else if (account instanceof JointAccount) {

				JointAccount jointAcc = (JointAccount) account;
				
				/*
				 * To withdraw money from a joint account both account
				 * holders must be in agreement so we need to do a small
				 * check first
				 */
				System.out.println("First account holder agree: y/n");
				char holderOne = stringKeyIn.nextLine().charAt(0);
				
				System.out.println("Second account holder agree: y/n");
				char holderTwo = stringKeyIn.nextLine().charAt(0);
				
				// Both holders agree
				if (holderOne == 'y' && holderTwo == 'y') {
					
					jointAcc.withdraw(amount);
				} else {
					// Someone did not agree
					System.out.println("Sorry both holders must authorize the transaction");
				}
			}

		} catch (Exception ex) {

		}
	}
}






