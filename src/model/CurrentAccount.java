package model;

import services.IAccountService;

public class CurrentAccount extends Account implements IAccountService {

	private static final long serialVersionUID = 1L;
	/*
	 * CurrentAccount is a subclass of Account this can be see in our declaration we
	 * use the the keyword 'extends' followed by the class you wish to extend.
	 */

	private double overDraft;
	/*
	 * To aid us in ensuring we are updating our Account correctly we need a second
	 * variable this is the Overdraft limit it is set in the constructor and the
	 * setter method and is the same value as the Overdraft
	 */
	private double overDraftLimit;

	/*
	 * When we extend from a class we must specify in the constructors a call to the
	 * class we extend from we do this by using the super() method call.
	 */
	public CurrentAccount() {
		super();
	}

	/*
	 * If the super class has an overloaded constructor we pass them up through the
	 * super method.
	 */
	public CurrentAccount(Name name, String address, Date opened, double balance, int pin, double overDraft) {
		super(name, address, opened, balance, pin);
		this.overDraft = overDraft;
		this.overDraftLimit = overDraft;
	}

	/**
	 * @return the overDraft
	 */
	public double getOverDraft() {
		return overDraft;
	}

	/**
	 * @param overDraft
	 *            the overDraft to set
	 */
	public void setOverDraft(double overDraft) {
		this.overDraft = overDraft;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "\nOver Draft Limit: " + overDraft + "\n";
	}

	/**
	 * Method to change the account holders name
	 * 
	 * @param name
	 *            the new name of the account holder
	 */
	@Override
	public boolean changeName(Name name) {

		if (name != null) {
			this.setName(name);
			return true;
		}
		return false;
	}

	/**
	 * Method to change the address of the account holder
	 * 
	 * @param address
	 *            the new address of the account holder
	 */
	@Override
	public boolean changeAddress(String address) {

		if (address != null) {
			this.setAddress(address);
		}
		return false;
	}

	/**
	 * Method to deposit money into the account before updating the balance a check
	 * must be done to see if the overdraft needs to be replenished first.
	 * 
	 * @param amount
	 *            the amount of money to be deposited
	 * 
	 */
	@Override
	public void deposit(double amount) {

		/*
		 * First check to see if the overdraft is below the overdraft limit, if it is
		 * the overdraft must be balanced first.
		 */
		if (getOverDraft() < this.overDraftLimit) {

			// Find the difference between the overdraft and the
			// overdraft limit
			double overDraftDifference = this.overDraftLimit - getOverDraft();

			// Check if the amount deposited is greater than the
			// overdraft difference
			if (amount > overDraftDifference) {

				/*
				 * If the amount is greater we balance the overdraft first, then subtract the
				 * overdraft difference from the amount we then set the balance with the
				 * remainder
				 */
				setOverDraft(overDraft + overDraftDifference);
				amount = amount - overDraftDifference;
				setBalance(getBalance() + amount);
			} else {
				// If the amount is less than the difference
				setOverDraft(overDraft + amount);
			}
		} else {

			// If there is no difference between the overdraft and
			// the overdraft limit we just set the balance
			setBalance(getBalance() + amount);
		}
	}

	/**
	 * Method to withdraw money from the account. A check on the balance must be
	 * performed to ensure there is enough in the account, if not a check on the
	 * overdraft is performed to see if there is enough in both.
	 * 
	 * @param amount
	 *            the amount of money to withdraw
	 */
	@Override
	public double withdraw(double amount) {

		/*
		 * To with draw money we must ensure that the user has enough money to cover the
		 * withdraw. The first check is simple if the users balance is greater than the
		 * withdraw amount we withdraw the cash and set the new balance
		 */
		if (getBalance() > amount) {

			setBalance(getBalance() - amount);
			return amount;

			// Debug
		} else if (getBalance() < amount && (getOverDraft() + getBalance()) > amount) {

			/*
			 * If the balance cannot cover the withdraw we check to see the user has a
			 * overdraft and if there is enough between the balance and the overdraft to
			 * cover the withdraw
			 */
			if (getBalance() > 0) {

				// if there is money in the balance use that first
				double subTotal = amount - getBalance();
				setBalance(0);

				// remove the remainder from the overdraft
				setOverDraft(getOverDraft() - subTotal);
				return amount;

			} else {

				// If no money in balance remove directly from overdraft
				setOverDraft(getOverDraft() - amount);
				return amount;
			}

		} else if (getBalance() < amount && (getOverDraft() + getBalance()) < (amount - getBalance())) {
			/*
			 * If balance and overdraft together still can't cover the withdraw amount
			 * return a message to the user
			 */
			System.out.println("Sorry Insufficient funds");

		}

		// Return 0 withdraw if an issues arises
		return 0;
	}
}
