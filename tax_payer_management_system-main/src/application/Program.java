package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> taxPayers = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int numberOfTaxPayers = sc.nextInt();

		for (int i = 0; i < numberOfTaxPayers; i++) {
			System.out.println("Tax payer #" + (i + 1) + " data:");
			System.out.print("Individual or company (i/c)? ");
			char taxPayerOption = sc.next().charAt(0);
			while (taxPayerOption != 'i' && taxPayerOption != 'c') {
				System.out.print("Invalid option. Try again: ");
				taxPayerOption = sc.next().charAt(0);
			}
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			if (taxPayerOption == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				taxPayers.add(new Individual(name, anualIncome, healthExpenditures));
			} else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				taxPayers.add(new Company(name, anualIncome, numberOfEmployees));
			}
		}

		System.out.println("TAXES PAID:");

		double sum = 0.0;
		for (TaxPayer taxPayer : taxPayers) {
			System.out.println(taxPayer.getName() + ": $ " + String.format("%.2f", taxPayer.tax()));
			sum += taxPayer.tax();
		}

		System.out.println();
		System.out.println("TOTAL TAXES: $ " + sum);

		sc.close();

	}

}
