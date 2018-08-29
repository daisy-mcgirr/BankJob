package model;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	/*
	 * The Account class is our super class from
	 * this class we will produce subclasses of different
	 * types of Accounts
	 */
	private static int nextAccountNumber = 100345;
	private Name name;
	private String address;
	private Date opened;
	private double balance;
	private int accountNumber;
	private static String fileBin = "account_details.bin";
	private String fileText = "account_details.txt";
	
	// Extra variables needed
	private int pin;
	private static ArrayList<Account> accounts = new ArrayList<>();
	
	/**
	 * Default constructor that will set the id for any new
	 * Accounts created
	 */
	public Account() {
		accountNumber = nextAccountNumber++;
	}

	/**
	 * @param name
	 * @param address
	 * @param opened
	 * @param balance
	 * @param accountNumber
	 */
	public Account(Name name, String address, Date opened, double balance, int pin) {
		this.name = name;
		this.address = address;
		this.opened = opened;
		this.balance = balance;
		this.pin = pin;
		this.accountNumber = nextAccountNumber++;
	}

	/**
	 * @return the name
	 */
	public Name getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(Name name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the opened
	 */
	public Date getOpened() {
		return opened;
	}

	/**
	 * @param opened the opened to set
	 */
	public void setOpened(Date opened) {
		this.opened = opened;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @return the pin
	 */
	public int getPin() {
		return pin;
	}

	/**
	 * @param pin the pin to set
	 */
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	/**
	 * 
	 * @param account
	 */
	public static void saveAccount(Account account) {
		accounts.add(account);
	}
	
	/**
	 * Method to serialize an account details out to a
	 * binary file and also to a human readable text file
	 * @param account
	 */
	public void saveAccountDetails(Account account) {
		
		// This writes data to a binary file
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileBin))) {
			oos.writeObject(account);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// This writes data to a text file
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileText))) {
			//bw.write(account.toString());
			//bw.newLine();
			
			for(Account tempAccount : accounts) {
				bw.write(tempAccount.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to read from a binary file and display the details
	 * to the console. 
	 */
	public void readAccountDetails() {
		
		// Read from the chosen file
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileBin))) {
			
			// Print to the console the details of the file
			System.out.println(ois.readObject());
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the accounts
	 */
	public static ArrayList<Account> getAccounts() {
		
		/*
		 * Create some fake data that we can use to test the
		 * application and these accounts to the ArrayList and
		 * return the List
		 */
		CurrentAccount currAccOne = new CurrentAccount(
				new Name("Ms", "Carol", "Danvers"),
				"Main Street",
				new Date(2, 6, 1998),
				870.50,
				1234,
				300);
		
		CurrentAccount currAccTwo = new CurrentAccount(
				new Name("Mr", "Tony", "Stark"),
				"Avengers Tower",
				new Date(2, 6, 1975),
				10000000000.00,
				9876,
				5000);
		
		JointAccount jointAccOne = new JointAccount(
				new Name("Miss", "Jean", "Grey"),
				"Main Street",
				new Date(2, 6, 1998),
				870.50,
				4321,
				new Name("Mr", "Scott", "Summers"));
		
		accounts.add(currAccOne);
		accounts.add(currAccTwo);
		accounts.add(jointAccOne);
		
		return accounts;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account Details:\nAccount Number: " + accountNumber
				+ name + "\nAddress: " + address + "\nBalance: " + balance
				+ "\nDate Opened: " + opened;
	}
	
	
}
