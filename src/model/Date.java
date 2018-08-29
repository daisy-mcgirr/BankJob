package model;

import java.io.Serializable;

import exceptions.WrongDateException;

public class Date implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int day;
	private int month;
	private int year;

	/**
	 * 
	 */
	public Date() {
	}

	/**
	 * @param day
	 * @param month
	 * @param year
	 */
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day
	 *            the day to set
	 */
	public void setDay(int day) throws WrongDateException {

		// This shows a good example where we can use our
		// own Exception class to catch an error if the
		// user enters the wrong date.
		if (day > 0 && day < 32) {
			this.day = day;
		} else {
			throw new WrongDateException("Invalid day");
		}
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(int month) throws WrongDateException {

		// This shows a god example where we can use our
		// own Exception class to catch an error if the
		// user enters the wrong date.
		if (month > 0 && month < 13) {
			this.month = month;
		} else {
			throw new WrongDateException("Invalid Month");
		}
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return day + "/" + month + "/" + year;
	}

	@Override
	public boolean equals(Object temp) {

		/*
		 * Check to ensure the object we are comparing is not a null object or else we
		 * will end up with a NullPointerException
		 */
		if (temp == null) {
			return false;
		}

		/*
		 * In this if statement we use the keyword 'instanceof' to check if the object
		 * we have passed in is an instance of Name class. This is so we don't run into
		 * a ParseException in our next section of code
		 */
		if (temp instanceof Date) {

			/*
			 * In this section we do what is called casting, casting allows us to set or
			 * Object class to the correct class we want to work with such as the Name
			 * class.
			 * 
			 * As has been mentioned many times Java works on a hierarchical class. As all
			 * classes derive from the Object class we can pass in and check against this
			 * object and also cast it back to a Name object.
			 */
			Date date = (Date) temp;

			/*
			 * In this if statement we do or check by test to see if the variables with our
			 * class match that of the Object passed into the method
			 */
			if (this.day == date.day && this.month == date.month && this.year == date.year) {

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
}
