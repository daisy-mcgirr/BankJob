/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.CurrentAccount;
import model.Date;
import model.Name;

/**
 * @author Denis Bourne
 *
 */
class CurrentAccountTest {

	CurrentAccount currAcc = new CurrentAccount(new Name("Ms", "Susan", "Doherty"),
			"Main Street",
			new Date(2, 6, 1998), 870.50, 5678, 300);
	@Test
	void testWithdraw() {
		System.out.println("Balance: " + currAcc.getBalance());
		System.out.println("Overdraft: " + currAcc.getOverDraft());
		assertEquals(2000, currAcc.withdraw(2000), "Balance should be: " + currAcc.getBalance());
		System.out.println("Balance: " + currAcc.getBalance());
		System.out.println("Overdraft: " + currAcc.getOverDraft());
	}

}








