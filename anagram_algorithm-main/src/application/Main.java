package application;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String s1 = sc.nextLine();
		String s2 = sc.nextLine();

		System.out.println(s1);
		System.out.println(s2);

		boolean result = isAnagram(s1, s2);

		if(result) {
			System.out.println("ANAGRAMS!");
		} else {
			System.out.println("NOT ANAGRAMS!");
		}
		
		sc.close();
	}

	private static boolean isAnagram(String s1, String s2) {

		int countOcurrencesInA = 0;
		int countOcurrencesInB = 0;

		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();

		if (s1.length() == s2.length()) {

			for (int i = 0; i < s1.length(); i++) {

				for (int j = 0; j < s1.length(); j++) {
					if (s1.charAt(i) == s2.charAt(j)) { 
						countOcurrencesInB++;
					}
				}
				
				if(countOcurrencesInB == 0) {
					return false;
				}

				for (int k = 0; k < s1.length(); k++) {
					if (s1.charAt(i) == s1.charAt(k)) {
						countOcurrencesInA++;
					}
				}

				if (countOcurrencesInA != countOcurrencesInB) {
					return false;
				}

			}
			return true;
		}
		return false;

	}
}
