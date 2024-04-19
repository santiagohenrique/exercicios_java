package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the file path: ");
		String path = sc.nextLine();

		System.out.print("Enter salary: ");
		double parameterSalary = sc.nextDouble();

		File file = new File(path);

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			List<Employee> employeesList = new ArrayList<>();
			String line = br.readLine();

			while (line != null) {
				String fields[] = line.split(",");
				String name = fields[0];
				String email = fields[1];
				Double salary = Double.parseDouble(fields[2]);
				employeesList.add(new Employee(name, email, salary));
				line = br.readLine();

			}
			
			List<String> emails = employeesList.stream()
										.filter(e -> e.getSalary() > parameterSalary)
										.map(e -> e.getEmail())
										.sorted((s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase()))
										.collect(Collectors.toList());
			
			emails.forEach(System.out::println);
								

			double sumOfSalariesWithLetterM = employeesList.stream().filter(e -> e.getName().charAt(0) == 'M')
					.map(e -> e.getSalary()).reduce(0.0, (x, y) -> x + y);

			System.out.println("Sum of salary of people whose name starts with 'M': "
					+ String.format("%.2f", sumOfSalariesWithLetterM));

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();

	}

}
