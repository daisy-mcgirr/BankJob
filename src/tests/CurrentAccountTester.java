package tests;

import model.Account;
import model.CurrentAccount;
import model.Date;
import model.Name;

public class CurrentAccountTester {

	public static void main(String[] args) {

		// Set undefined CurrentAccount object
		CurrentAccount currAccOne = new CurrentAccount();
		
		// Set defined Date objects with all the correct details
		CurrentAccount currAccTwo = new CurrentAccount(
				new Name("Ms", "Carol", "Danvers"),
				"Main Street",
				new Date(2, 6, 1998),
				870.50,
				1234,
				0.0);
		
		CurrentAccount currAccThree = new CurrentAccount(
				new Name("Miss", "Jean", "Grey"),
				"Lower Street",
				new Date(2, 6, 1998),
				870.50,
				5678,
				300);
		
		CurrentAccount currAccFour = new CurrentAccount(
				new Name("Mr", "Tony", "Stark"),
				"Avengers Tower",
				new Date(2, 6, 1975),
				10000000000.00,
				9876,
				5000);
		
		// Test our setters by initializing the variables
		// And setting currAccOne
		Name name = new Name("Mr", "Bruce", "Banner");
		Date date = new Date(22, 10, 2005);
		
		currAccOne.setName(name);
		currAccOne.setAddress("Upper Street");
		currAccOne.setOpened(date);
		currAccOne.setBalance(2005.00);
		currAccOne.setPin(9987);
		currAccOne.setOverDraft(500);
		
		// Test the toString method and the getter methods
		System.out.println(currAccOne + "\n");
		System.out.println(currAccTwo.getName());
		System.out.println(currAccThree.getAccountNumber());
		System.out.println(currAccFour.getOverDraft());
		
		/*
		 * This is example of Polymorphism we declare an Account object
		 * but we then instantiate it using the CurrentAccount. With this
		 * we can call all methods associated with the Account class but we
		 * still can't call any methods that is associated with the CurrentAccount
		 * so we cannot call to getOverDraft or setOverDraft will fail.
		 */
		Account accOne = new CurrentAccount(new Name("Mr", "Phil", "Coulsen"),
				"Hill Top",
				new Date(14, 5, 2002),
				340,
				4567,
				200);
		
		System.out.println("\n" + accOne.getBalance());
		
		// We can print all details of the Account though including the
		// overdraft variable
		System.out.println("\n" + accOne);
	}

}
