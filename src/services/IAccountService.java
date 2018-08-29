package services;

import model.Name;

public interface IAccountService {

	boolean changeName(Name name);
	
	boolean changeAddress(String address);
	
	void deposit(double amount);
	
	double withdraw(double amount);
}
