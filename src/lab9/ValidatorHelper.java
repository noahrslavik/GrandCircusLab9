package lab9;

import java.util.Scanner;

public class ValidatorHelper {

	public static int getInt(Scanner kbd, String prompt) {
		System.out.print(prompt);
		boolean isValid = kbd.hasNextInt();
		while(!isValid) {
			kbd.nextLine();
			System.out.println("Oops. That isn't a valid number. Please enter a number without decimals");
			System.out.print(prompt);
			isValid = kbd.hasNextInt();
		}
		return kbd.nextInt();
	}
	
	public static int getIntAtOrAbove(Scanner kbd, String prompt, int minValue) {
		int input = getInt(kbd, prompt);
		if(input < minValue) {
			//invalid input
			System.out.println("Nope ya fucked it, number must be at least " + minValue);
			return getIntAtOrAbove(kbd,prompt,minValue);
		}else {
			//valid input
			return input;
		}	
	}

	public static double getDouble(Scanner kbd, String prompt) {
		System.out.print(prompt);
		boolean isValid = kbd.hasNextDouble();
		while(!isValid) {
			kbd.nextLine();
			System.out.println("Oops. That isn't a valid number. Please enter a double. ");
			System.out.print(prompt);
			isValid = kbd.hasNextDouble();
		}
		
		return kbd.nextDouble();
	}
		
	public static String getString(Scanner kbd, String prompt){
		System.out.print(prompt);
		return kbd.nextLine();	}	

	public static boolean getYesNo(Scanner kbd, String prompt) {
		kbd.nextLine();
		System.out.println(prompt);
		return kbd.nextLine().startsWith("y");
	}
}



