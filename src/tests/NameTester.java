package tests;

import java.util.*;

import model.Name;

public class NameTester {

	public static void main(String[] args) {

		// Set undefined Name object
		Name nameOne = new Name();
		
		// Set defined Name object with all the correct details
		Name nameTwo = new Name("Ms", "Susan", "Doherty");
		Name nameThree = new Name("Mr", "Daniel", "Hegerty");
		Name nameFour = new Name("Mrs", "Hilary", "Cassidy");
		Name nameFive = new Name("Mr", "James", "Patton");
		
		// Test our setters by initializing the variables
		// for our first Name object
		nameOne.setTitle("Mr");
		nameOne.setFirstName("Stephen");
		nameOne.setLastName("Doherty");
		
		// Test the toString method and the getter methods 
		System.out.println(nameOne);
		System.out.println(nameTwo.getTitle());
		System.out.println(nameThree.getFirstName());
		System.out.println(nameFour.getLastName());
		System.out.println(nameFive + "\n");
		
		// Create an ArrayList that stores Name objects
		ArrayList<Name> names = new ArrayList<>();
		
		// Add our newly created Names objects to the ArrayList
		names.add(nameTwo);
		names.add(nameThree);
		names.add(nameFour);
		
		// Test the Equals method, first create a new Name object
		// with the same variables as one of the objects created at the start
		Name nameSix = new Name("Mrs", "Hilary", "Cassidy");
		
		/*
		 * Now create an if statement where we can check if
		 * the two Names are the same. We should always test for
		 * failure so we will pass in two Name objects we know are
		 * not the same. Then we pass two objects we know are the same.
		 */
		if(nameFour.equals(nameSix)) {
			System.out.println("These names are the same\n");
		} else {
			System.out.println("These names are different\n");
		}
		
		/*
		 * Test the nameSearch method, again test for failure
		 * first by passing in a Name object that is not in the list.
		 * Next pass in one that is in the list
		 */
		if(nameSearch(nameFive, names)) {
			System.out.println("Name contained in list");
		} else {
			System.out.println("Name could not be found");
		}
	}
	
	public static boolean nameSearch(Name name, ArrayList<Name> names) {
		
		/*
		 * There is two ways we can now check if the ArrayList
		 * contains the name object, one we iterate over the
		 * ArrayList and then use our equals method to test are the
		 * two objects the same and return true if it is found.
		 */
		for (Name temp : names) {
			
			if(temp.equals(name)) {
				return true;
			}
		}
		
		/*
		 * As we are working with an ArrayList the ArrayList class comes
		 * with some handy methods of its own. One of these is the
		 * contains method which will check to see if an object is stored
		 * within it.
		 */
		/*if (names.contains(name)) {
			return true;
		}*/
		return false;
	}

}
