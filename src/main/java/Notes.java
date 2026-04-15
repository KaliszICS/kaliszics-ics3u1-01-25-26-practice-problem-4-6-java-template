/**
	* File: Lesson 4.6 - Data type checking
	* Author: Mr. Kalisz
	* Date Created: April 12, 2023
	* Date Last Modified: April 12, 2023
	*/

import java.util.Scanner;

class Notes {
	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);

		//input.hasNextInt(); -> returns true if the value given is an int, false otherwise
		//input.hasNextDouble(); -> returns true if the value given is an double, false otherwise
		//input.hasNextBoolean(); returns true if the value given is an boolean, false otherwise

		//input.hasNextLine(); -> Doesn't Exist

		//input without checking data types
		// int num;

		// System.out.print("Input an integer: ");
		// num = input.nextInt();
		// System.out.println(num + 2);

		//checking a data type

		int num;

		System.out.print("Input an integer: ");

		//use hasNextInt()
		while (!(input.hasNextInt())) { //this is our input
			input.nextLine();
			System.out.println("That was not a number!");
			System.out.print("Input an integer: ");
		}
		num = input.nextInt(); //grab the valid value from the scanner
		//clear the scanner after getting your valid input
		input.nextLine();
		System.out.println(num + 2);

		double num2;
		
		System.out.print("Input a number: ");

		//use hasNextInt()
		while (!(input.hasNextDouble())) { //this is our input
			input.nextLine();
			System.out.println("That was not a number!");
			System.out.print("Input a number: ");
		}
		num2 = input.nextDouble(); //grab the valid value from the scanner
		input.nextLine(); //clear the scanner after getting valid input
		System.out.println(num2 + 2);
		
	}
}