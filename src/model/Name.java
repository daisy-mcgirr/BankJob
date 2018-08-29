package model;

import java.io.Serializable;

public class Name implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String title;
	private String firstName;
	private String lastName;
	
	/**
	 * Declare a default constructor as we also have a loaded
	 * one
	 */
	public Name() {
		super();
	}

	/**
	 * Loaded constructor that sets all variables on creation
	 * @param title
	 * @param firstName
	 * @param lastName
	 */
	public Name(String title, String firstName, String lastName) {
		super();
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nTitle: " + title + "\nFirst Name: " + firstName + "\nLast Name: " + lastName;
	}
	
	@Override
	public boolean equals(Object temp) {
		
		/*
		 * Check to ensure the object we are comparing
		 * is not a null object or else we will end up
		 * with a NullPointerException
		 */
		if(temp == null) {
			return false;
		}
		
		/*
		 * In this if statement we use the keyword 'instanceof' to
		 * check if the object we have passed in is an instance of
		 * Name class. This is so we don't run into a ParseException in
		 * our next section of code
		 */
		if(temp instanceof Name) {
			
			/*
			 * In this section we do what is called casting,
			 * casting allows us to set or Object class to the correct class
			 * we want to work with such as the Name class.
			 * 
			 * As has been mentioned many times Java works on a
			 * hierarchical class. As all classes derive from the
			 * Object class we can pass in and check against this object
			 * and also cast it back to a Name object.
			 */
			Name name = (Name) temp;
			
			/*
			 * In this if statement we do or check by test to see
			 * if the variables with our class match that of the Object
			 * passed into the method
			 */
			if(this.title.equalsIgnoreCase(name.title)
					&& this.firstName.equalsIgnoreCase(name.firstName)
					&& this.lastName.equalsIgnoreCase(name.lastName)) {
				
				// If all variables match we return to say that the two
				// objects are the same
				return true;
			} else {
				
				// return false if one of the variables does not match
				return false;
			}
		}
		
		// return false as default as it means that the check was
		// completed
		return false;
	}
	
	public boolean isFemale(Name name) {
		
		/*
		 * In this method we check the title of the name
		 * if the title contains any of the three below.
		 * As we are using the OR operator only one of the
		 * statements will need to return true
		 */
		return name.getTitle().equalsIgnoreCase("Miss") 
				|| name.getTitle().equalsIgnoreCase("Mrs")
				|| name.getTitle().equalsIgnoreCase("Ms");
	}
}
