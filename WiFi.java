/*
 * Class: CMSC203 
 * Instructor: Professor Grinberg
 * Description: Develop a program that would help a user with his wifi connection problems.
 * Due: 9/12
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Majd Haddad
*/

import java.util.Scanner;
public class WiFi {
	public static void main(String [] args) {
		//Declaring Scanner object for input
		Scanner userin = new Scanner(System.in);
		//Declaring constants and variables
		final String repeat1 = "Reboot the computer and try to connect";
		final String repeat2 = "Did that fix the problem?";
		final String repeat3 = "Invalid answer; try again.";
		
		System.out.println("If you have a problem with internet connectivity this WiFi Diagnosis might work.");
		System.out.println();
		System.out.println(repeat1);
		System.out.println(repeat2);
		//Getting user input
		String input = userin.nextLine();
		
		if(input.equalsIgnoreCase("YES")) {
			System.out.println();
			System.out.println("Done");
		}else if(input.equalsIgnoreCase("NO")) {
			System.out.println(repeat1);
			System.out.println(repeat2);
			input = userin.nextLine();
			if(input.equalsIgnoreCase("YES")) {
				System.out.println();
				System.out.println("Done");
			}else if(input.equalsIgnoreCase("NO")) {
				System.out.println("Make sure the cables connecting the router are firmly plugged in and power is getting to the router");
				System.out.println(repeat2);
				input = userin.nextLine();
				if(input.equalsIgnoreCase("YES")) {
					System.out.println();
					System.out.println("Done");
				}else if(input.equalsIgnoreCase("NO")) {
					System.out.println("Move the computer closer to the router and try to connect");
					System.out.println(repeat2);
					input = userin.nextLine();
					if(input.equalsIgnoreCase("YES")) {
						System.out.println();
						System.out.println("Done");
					} else if (input.equalsIgnoreCase("NO")) {
						System.out.println("Contact your ISP");
					}else {
						System.out.println();
						System.out.println(repeat3);
					}
				}else {
					System.out.println();
					System.out.println(repeat3);
				}
			}else {
				System.out.println();
				System.out.println(repeat3);
			}
		} else {
			System.out.println();
			System.out.println(repeat3);
		}
		System.out.println("Programmer: Majd Haddad");
		//closes scanner
		userin.close();
	
}
}
