package main;

import java.util.Scanner;

import model.Account;
import model.CurrentAccount;
import model.JointAccount;

public class DepositMenu {

	public static void showDepositMenu(Account account) {
		
		@SuppressWarnings("resource")
		Scanner keyIn = new Scanner(System.in);
		double amount;

		try {

			System.out.println("//** Deposit Menu **//");

			System.out.println("Please enter deposit amount: ");
			amount = keyIn.nextDouble();

			if (account instanceof CurrentAccount) {

				CurrentAccount currAcc = (CurrentAccount) account;
				currAcc.deposit(amount);
			} else if (account instanceof JointAccount) {

				JointAccount jointAcc = (JointAccount) account;
				jointAcc.deposit(amount);
			}

		} catch (Exception ex) {

		}
	}
}
