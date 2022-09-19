/*
 * Class: CMSC203 CRN 21754
 * Instructor: Professor Grinberg
 * Description: RNG class is used as a way to assist us with coding in the main class  which is 
 * RandomNumberGuesser. RNG class is provided with methods. RandomNumberGuesser is the class where the code 
 * actually happens. Its a game that allows the user to guess a number from 1 to 100 within the 
 * constraint of 7 attempts.
 * Due: 9/25/22
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Majd Haddad
*/

import java.util.Scanner;
public class RandomNumberGuesser extends RNG{
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		// declaring the new class so that I can use the methods inside that class.
		RNG methodHelper = new RNG();
		int maximumNumber = 100, minimumNumber = 0, maximumAttempts = 7, randomGeneratedNum, numberGuessed = 0, count = 0;
		System.out.println("This application generates a random integer between " + minimumNumber + " and " + maximumNumber + " and asks the user to guess repeatedly until they guess correctly.");
		String userRepeat = "yes";
		System.out.println();
		do {
			minimumNumber = 0;
			maximumNumber = 100;
			count = 0;
			//uses rand() method from RNG to generate a random number and store that number in randomGeneratedNum.
			randomGeneratedNum = methodHelper.rand();
			//Used to test cases
			//System.out.println("Random number is " + randomGeneratedNum);
			System.out.println("Enter your first guess: ");
			numberGuessed = input.nextInt();
			count++;
			//while loop used to make sure user enters initial guess from 0 to 100. 
			while(numberGuessed < 0 || numberGuessed > 100) {
				System.out.println("Error! Enter your number between 0 and 100.");
				numberGuessed = input.nextInt();
			}
			
			while(numberGuessed != randomGeneratedNum) {
				if(count == 7) {
					System.out.println("You have exceeded the maximum number of guesses, " + maximumAttempts + ". Try again.");
					break;
				}
				
				if(numberGuessed < randomGeneratedNum) {
					minimumNumber = numberGuessed;
					System.out.println("Your guess is too low");
				}
				if(numberGuessed > randomGeneratedNum) {
					maximumNumber = numberGuessed;
					System.out.println("Your guess is too high");
				}
				System.out.println("Number of guesses is: " + count);
				//asks user to enter their number. again
				System.out.println("Enter your next guess between " + minimumNumber + " and " + maximumNumber);
				numberGuessed = input.nextInt();
				while(numberGuessed <= minimumNumber || numberGuessed >= maximumNumber) {
					methodHelper.inputValidation(numberGuessed, minimumNumber, maximumNumber);
					numberGuessed = input.nextInt();
				}
				count++;
			}
			//prints positive message when user guesses the right number
			if(numberGuessed == randomGeneratedNum) {
				System.out.println("Congratulations, you guessed correctly");
			}
			//asks user if they want to continue and repeats the game when the user says yes.
			input.nextLine();
			System.out.println("Try again? (yes or no)");
			userRepeat = input.nextLine();
		}while(userRepeat.equalsIgnoreCase("yes"));
		System.out.println("Programmer: Majd Haddad");
		input.close();
}
}
