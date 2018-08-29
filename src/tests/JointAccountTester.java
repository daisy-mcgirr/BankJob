package tests;

import model.Date;
import model.JointAccount;
import model.Name;

public class JointAccountTester {

	public static void main(String[] args) {

		JointAccount jaOne = new JointAccount();

		JointAccount jaTwo = new JointAccount(new Name("Mrs", "Peggy", "Brown"), "MainStreet", new Date(22, 8, 1978),
				6740.80, 4477, new Name("Mr", "Joe", "Brown"));

		Name nameOfAccountHolder = new Name("Mr", "James", "Doherty");
		Name nameofSecondAccountHolder = new Name("Miss", "Jane", "Hegerty");
		Date accountOpened = new Date(17, 4, 2018);

		jaOne.setName(nameOfAccountHolder);
		jaOne.setSecondAccountHolder(nameofSecondAccountHolder);
		jaOne.setOpened(accountOpened);
		jaOne.setBalance(4567);
		jaOne.setPin(9735);
		jaOne.setAddress("Lower Main Street");

		System.out.println(jaTwo);
	}

}
