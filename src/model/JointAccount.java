package model;

import services.IAccountService;

public class JointAccount extends Account implements IAccountService {

	private static final long serialVersionUID = 1L;

	private Name secondAccountHolder;

	/**
	 * Default constructor that calls the super class Account to set the account
	 * Number
	 */
	public JointAccount() {
	}

	/**
	 * User defined constructor with parameters
	 * 
	 * @param accountHolder
	 *            the name associated with the Account set in the superclass Account
	 * @param address
	 *            a String value representing the address set in the superclass
	 *            Account
	 * @param dateOpened
	 *            the date the Account was opened set in the superclass Account
	 * @param balance
	 *            the balance of the Account set in the superclass Account
	 * @param pin
	 *            the pin number of the Account set in the superclass Account
	 * @param accountHolderTwo
	 *            the name of the second account holder
	 */
	public JointAccount(Name name, String address, Date opened, double balance, int pin, Name secondAccountHolder) {
		super(name, address, opened, balance, pin);
		this.secondAccountHolder = secondAccountHolder;
	}

	/**
	 * @return the Name of second account holder
	 */
	public Name getSecondAccountHolder() {
		return secondAccountHolder;
	}

	/**
	 * @param secondAccountHolder
	 *            the Name of the second account holder to set
	 */
	public void setSecondAccountHolder(Name secondAccountHolder) {
		this.secondAccountHolder = secondAccountHolder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "\nSecond Account Holder: " + secondAccountHolder + "\n";
	}

	@Override
	public boolean changeName(Name name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeAddress(String address) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Method to deposit money to the account
	 * 
	 * @param amount
	 *            the amount of money to be deposited
	 */
	@Override
	public void deposit(double amount) {

		// Adding money to the joint account is straight forward
		// We just need to add the amount to the balance
		setBalance(getBalance() + amount);
	}

	/**
	 * Method to withdraw money from account requires second account holders
	 * authorization
	 * 
	 * @param amount
	 *            the amount of money to withdraw from the account
	 */
	@Override
	public double withdraw(double amount) {

		/*
		 * The withdraw method is straight forward as long as both account holders
		 * agree. We check if the balance is greater than the required amount.
		 */
		if (getBalance() > amount) {

			// Set balance by removing amount
			setBalance(getBalance() - amount);
			return amount;
		} else {

			// If there is not enough in the account show
			// an appropriate message
			System.out.println("Sorry Insufficient funds");
		}
		return 0;
	}
}
