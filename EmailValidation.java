package practiceProj_EmaiValid;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

class EmailValidation {
	public static boolean isValid(String email) {
		String emailRegex = "^(.+)@(.+)$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public static void main(String[] args) {
		ArrayList<String> address = new ArrayList<>();

		address.add("Alok.choudhary@hotmail.com");
		address.add(".com@alok");

		for (String i : address) {
			if (isValid(i))
				System.out.println(i + " - Yes");
			else
				System.out.println(i + " - No");

			System.out.println("Enter any email address to check");
		}
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println("The Email address " + input + " is " + (isValid(input) ? "valid" : "invalid"));
		sc.close();
	}
}
