package main;

public class Starter {

	public static void main(String[] args) {

		/*
		 * This is the entry point to our application we call the
		 * Login Menu where the user must enter the correct pin to
		 * continue
		 */
		LoginMenu loginMenu = new LoginMenu();
		loginMenu.showLoginMenu();
	}

}
