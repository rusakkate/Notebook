package by.itAcademy.training.Interface;

import java.util.Scanner;

public class UserEnter {
	Scanner sc = new Scanner (System.in);
	
	public static String inputString (String message) {
		System.out.println (message);
		String string;
		Scanner sc = new Scanner (System.in);
		string = sc.nextLine();
		return string;
	}
	
	public static int inputInt (String message, int limit) {
		System.out.println (message);
		int number;
		Scanner sc = new Scanner (System.in);
		while (!sc.hasNextInt()) {
			sc.nextLine();
			System.out.println ("Incorrect value. ");
		}
		number = sc.nextInt();
		
		while (number > limit) {
			System.out.println ("you can enter a number from 1 to " + limit);
			number = sc.nextInt();
		}
		return number;
	}

}
