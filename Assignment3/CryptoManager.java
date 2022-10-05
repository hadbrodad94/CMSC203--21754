/*
 * Class: CMSC203 
 * Instructor: Professor Grinberg
 * Description: Purpose of CryptoManager class is to encrypt and decrypt anthing the user inputs into Caesar Cipher and Bellaso.
 * The purpose of CryptoManagerGFATest is to guarantee and assure everything works fine from the class CryptoManager using JUnit. 
 * The Purpose of FXMAINPANE and FXDriver is to display everything for the output design of the GUI and make sure it works using JavaFX. 
 * The purpose of CryptoManagerTestPublic is to assure that the GUI works for CryptoManager by testing examples.
 * Due: 10/9/22
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Majd Haddad
*/


/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		boolean isBounded = true;
		//uses for loop to check whether each letter in the plainText is within the upper and lower range and returns the boolean in regards to that condition
		for(int i = 0; i < plainText.length(); i++) {
			if(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE) {
				isBounded = true;
			}else {
				isBounded = false;
				break;
			}
		}
		return isBounded;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		String combination = ""; 
		char letter;
		//used to concatenate the encrypted string after shifting the plainText by x amount of times by the user. 
		//Uses a for loop with a while loop that checks the bounds if the letter is greater than the Upper_range
		if(key > UPPER_RANGE) {
			key %= RANGE;
		}else if ( key < LOWER_RANGE){
			key%= RANGE + key;
		}
		
		if(isStringInBounds(plainText) == true) {
			for(int i = 0; i < plainText.length(); i++) {
				letter = (char)(key + plainText.charAt(i));
				while(letter > UPPER_RANGE) {
					letter -= RANGE;
				}
				combination += letter;
			}
		}
		return combination;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		String bellasoEncrypted = "";
		int indexOfAddedLetter;
		char letter;
		//uses if statement to check if the plainText message is in bounded
		if(isStringInBounds(plainText) == true) {
			//Everytime the key(bellasoStr) is past the length of the plainText, that index is the modulus of he plainText.length which is them 
			//resetted from the beginning everytime you go up 1
			for(int i = 0; i < plainText.length(); i++) {
				//over here is where the action takes place of the bellasoStr index going back to the original.
				indexOfAddedLetter = i % bellasoStr.length();
				letter = (char)(bellasoStr.charAt(indexOfAddedLetter) + plainText.charAt(i));
				while( letter > UPPER_RANGE) {
					letter -= RANGE;
				}
				bellasoEncrypted += letter;
			}
			}else {
				System.out.println("The selected string is not in bounds, Try again");
			}
	return bellasoEncrypted;
	}
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		String reDecrypt = "";
		char letter;
		//uses inbounds to check whether the encryptedText is within it.
		//uses modulus to make sure I am deshifting properly
		//uses for loop and while loop inside to check if the letter which is the .atChar(i) of encryptedText - key is less than 
		//the LOWER_RANGE AND keeps on adding letter to RANGE until its greater than or equal to it.
		if(isStringInBounds(encryptedText) == true) {
			if(key > UPPER_RANGE) {
				key %= RANGE;
			}else if ( key < LOWER_RANGE){
				key%= RANGE + key;
			}
		
			for(int i = 0; i < encryptedText.length(); i++) {
				letter = (char)(encryptedText.charAt(i) - key);
				while(letter < LOWER_RANGE) {
					letter+=RANGE;
				}
				reDecrypt += letter;
			}
		
			}
		return reDecrypt;
		}
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		String bellasoDecrypted = "";
		int numOfChar;
		int letterNum;
		//had to change to make the number of the letter and then cast at the end b/c it was producing logical errors.
		//different formatting because I was getting logical error where some 7s and 8s were being displayed rather than letters
		//uses for loop that for every i, the numOfChar is stored as i % bellasoStr.length() to add on to the bellasoStr because in order for bellaso to work, you need the key and the 
		//encrypted text to have the same length. So the subscript of the bellasoStr is repeated until it matches the length of the encryptedText.
		//while loop checks for range and undoes the process of the encryption by adding letterNum to RANGE if the letterNum is less than LOWER_RANGE
		for(int i = 0; i < encryptedText.length(); i++) {
			numOfChar = i % bellasoStr.length();
			letterNum = (encryptedText.charAt(i) - bellasoStr.charAt(numOfChar));
			while(letterNum < LOWER_RANGE) {
				letterNum += RANGE;
			}
			bellasoDecrypted += (char)letterNum;
		}
		System.out.println("Programmer: Majd Haddad");
		return bellasoDecrypted;
		
	}
	//Problem seeing for caesssar encryption for in bounds. However, it is not my fault that this error is displaying.
	public static boolean hasSmall(String text) {
		int x;
		
		for(int i = 0; i < text.length(); i++) {
			x = text.charAt(i);
			if( x >= 97 && x <= 122) {
				return true;
			}
		}
		return false;
	}
}

