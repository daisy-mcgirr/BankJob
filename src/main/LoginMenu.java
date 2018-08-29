package main;

import java.util.ArrayList;
import java.util.Scanner;

import model.Account;

public class LoginMenu {

	// The user has a max of three attempts to enter
	// the correct pin MAX_ATTEMPT is a constant and cannot be changed
	private final int MAX_ATTEMPT = 3;
	
	public void showLoginMenu() {
		
		@SuppressWarnings("resource")
		Scanner keyIn = new Scanner(System.in);
		int pin;
		int count = 3;
		AccountMenu accountMenu = new AccountMenu();
		ArrayList<Account> accounts = Account.getAccounts();
		
		try {
			
			System.out.println("///**** LOGIN MENU ****///");
			
			for(int i = 1; i <= MAX_ATTEMPT; i++) {
				
				System.out.println("Please enter pin number");
				pin = keyIn.nextInt();
				
				for (Account account : accounts) {
					
					if(pin == account.getPin()) {
						accountMenu.showAccountMenu(account);
					}
				}
				
				System.out.println("Sorry incorrect pin, please try again");
				System.out.printf("%d attempts left\n", --count);
			}
			
		} catch(Exception ex) {
			
			ex.printStackTrace();
			showLoginMenu();
		}
	}
}
