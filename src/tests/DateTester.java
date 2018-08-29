package tests;

import exceptions.WrongDateException;
import model.Date;

public class DateTester {

	public static void main(String[] args) {

		// Set undefined Date object
		Date dateOne = new Date();

		// Set defined Date objects with all the correct details
		Date dateTwo = new Date(5, 6, 1999);
		Date dateThree = new Date(18, 12, 2008);
		Date dateFour = new Date(29, 10, 2017);

		// Test our setters by initializing the variables
		// for our first Date object
		try {
			dateOne.setDay(40);
			dateOne.setMonth(8);
		} catch (WrongDateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dateOne.setYear(1983);

		// Test the toString method and the getter methods
		System.out.println(dateOne);
		System.out.println(dateTwo.getDay());
		System.out.println(dateThree.getMonth());
		System.out.println(dateFour.getYear());

		// Test the Equals method, first create a new Date object
		// with the same variables as one of the objects created at the start
		Date dateFive = new Date(18, 12, 2008);

		System.out.println(dateTwo);

		/*
		 * Now create an if statement where we can check if the two Dates are the same.
		 * We should always test for failure so we will pass in two Date objects we know
		 * are not the same. Then we pass two objects we know are the same.
		 */
		if (dateThree.equals(dateFive)) {
			System.out.println("These dates are the same");
		} else {
			System.out.println("These dates do not match");
		}
	}

}
