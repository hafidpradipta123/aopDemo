package com.apit.aopdemo;

import com.apit.aopdemo.dao.AccountDAO;
import com.apit.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO){
		return runner ->{
			//demoTheBeforeAdvice(theAccountDAO, theMembershipDAO); // spring will automatically inject dependency? what dependency?  (autowired this class to what class?)
			//demoTheAfterReturningAdvice(theAccountDAO);
			
			demoTheAfterThrowingAdvice(theAccountDAO);
		};
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts =null;

		try{
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch(Exception exc) {
			System.out.println("\n\n Main Program: ... caught exepction : " + exc);
		}
			System.out.println("\n\n Main Program: demoTheAfterThrowingAdvice");
			System.out.println("-----");
			System.out.println(theAccounts);
			System.out.println("\n");

	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = theAccountDAO.findAccounts();

		System.out.println("\n\n Main Program: demoTheAfterReturningAdvice");
		System.out.println("-----");

		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		Account myAccount = new Account();
		myAccount.setName("Barampam");
		myAccount.setLevel("PLatinum");

		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		theAccountDAO.setName("bekantan");

		theAccountDAO.setServiceCode("setnyamanya apa");
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// call the membership business method
		theMembershipDAO.addCabe();

	}

}
