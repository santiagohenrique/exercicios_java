package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("-- Enter account data --");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		sc.nextLine();
		System.out.print("Holder: ");
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		Double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		Double withdrawLimit = sc.nextDouble();
		Account acc = new Account(number, holder, balance, withdrawLimit);

		try {
			System.out.print("Enter amount for withdraw: ");
			acc.withdraw(sc.nextDouble());
		} catch (InputMismatchException e) {
			System.out.printf("%nInvalid data");
		} catch (BusinessException e) {
			System.out.printf("%nWithdraw error: " + e.getMessage());
		}

	}

}
