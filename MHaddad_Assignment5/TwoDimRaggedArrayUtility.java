import java.util.Scanner;
import java.io.*;
/*
 * Class: CMSC203 
 * Instructor: Professor Grinberg
 * Description: Create a program  that would read and write to a file in regards to which retail store would get the bonus and which wouldn’t by accessing through ragged 2d arrays.
 * Due: 10/31/22
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Majd Haddad
*/

public class TwoDimRaggedArrayUtility {
	private double[][] data;
	private int col;
	private int row;
	
	public static double getAverage(double[][] data) {
		// returns the average of the elements in the 2d dimensional array
		double avrg = 0.0;
		int numOfElementsInRaggedArr = 0;
		for (int row = 0; row < data.length; row++) {
			for (int coln = 0; coln < data[row].length; coln++) {
				avrg += data[row][coln];
				numOfElementsInRaggedArr++;
			}
		}
		return (avrg / numOfElementsInRaggedArr);
	}

	public static double getColumnTotal(double[][] data, int col) {
		// returns the total selected column in the 2d arr index 0.
		double colnTotal = 0.0;

		for (int row = 0; row < data.length; row++) {
			// We check if the column index is within the column length of each of the rows
			// of the data, if not, it skips the whole thing
			if (col < data[row].length) {
				colnTotal += data[row][col];
			}
		}

		return colnTotal;
	}

	public static double getHighestInArray(double[][] data) {
		double highest = 0.0;
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (data[row][col] > highest) {
					highest = data[row][col];
				}
			}
		}
		return highest;
	}

	public static double getHighestInColumn(double[][] data, int col) {
		double highestInCol = 0.0;
		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length) {
				if (data[row][col] > highestInCol) {
					highestInCol = data[row][col];
				}
			}
		}
		return highestInCol;
	}

	public static int getHighestInColumnIndex(double[][] data, int col) {
		double highestInCol = 0.0;
		int indexOfRow = 0;
		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length) {
				if (data[row][col] > highestInCol) {
					indexOfRow = row;
				}
			}
		}
		// returns the index of the row
		return indexOfRow;
	}

	public static double getHighestInRow(double[][] data, int row) {
		// returns the highest number in the given row assigned in the parameter of the
		// method

		double highestInRow = 0.0;
		// 2 ways to do it
		/*
		 * int j = 0; while (j < data[row].length) { if (data[row][j] > highestInRow) {
		 * highestInRow = data[row][j]; } j++; }
		 */

		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] > highestInRow) {
				highestInRow = data[row][i];
			}
		}
		return highestInRow;
	}

	public static int getHighestInRowIndex(double[][] data, int row) {
		double totalInRow = 0.0;
		int indexOfCol = 0;
		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] > totalInRow) {
				totalInRow = data[row][i];
				indexOfCol = i;
			}
		}
		// returns the column number of the highest value in the given row.
		return indexOfCol;
	}

	public static double getLowestInArray(double[][] data) {
		double lowest = Double.MAX_VALUE;
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (data[row][col] < lowest) {
					lowest = data[row][col];
				}
			}
		}
		return lowest;
	}

	public static double getLowestInColumn(double[][] data, int col) {
		double lowest = Double.MAX_VALUE;
		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length) {
				if (data[row][col] < lowest) {
					lowest = data[row][col];
				}
			}
		}
		return lowest;
	}

	public static int getLowestInColumnIndex(double[][] data, int col) {
		int index = 0;
		double lowest = Double.MAX_VALUE;
		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length) {
				if (data[row][col] < lowest) {
					lowest = data[row][col];
					index = row;
				}
			}
		}
		// returning the lowest row index for that particular column
		return index;
	}

	public static double getLowestInRow(double[][] data, int row) {
		double lowestInRow = Double.MAX_VALUE;
		for (int col = 0; col < data[row].length; col++) {
			if (data[row][col] < lowestInRow) {
				lowestInRow = data[row][col];
			}
		}
		return lowestInRow;
	}

	public static int getLowestInRowIndex(double[][] data, int row) {
		int lowestInRowIndex = 0;
		double lowest = Double.MAX_VALUE;
		for (int col = 0; col < data[row].length; col++) {
			if (data[row][col] < lowest) {
				lowest = data[row][col];
				lowestInRowIndex = col;
			}
		}
		return lowestInRowIndex;
	}

	public static double getRowTotal(double[][] data, int row) {
		// gets total of the whole row.
		double rowTotal = 0.0;
		for (int col = 0; col < data[row].length; col++) {
			rowTotal += data[row][col];
		}
		return rowTotal;
	}

	public static double getTotal(double[][] data) {
		double total = 0.0;
		for (int row = 0; row < data.length; row++) {
			for (int coln = 0; coln < data[row].length; coln++) {
				total += data[row][coln];
			}
		}
		return total;
	}

	public static double[][] readFile(File file) throws FileNotFoundException {
		//creates the inFile object that reads data
		Scanner inFile = new Scanner(file);
		//creates a 2d array with the size of 10 for rows
		String[][] arr = new String [10][];
		//use a while loop to access each row in the arr array, gets the string from each line of the txt file,
		//and splits the spaces and stores the updated array w/out the spaces into the arr array.
		int ro = 0;
		while (inFile.hasNext() && ro < arr.length) {
			String str = inFile.nextLine();
			String [] tokens = str.split(" ");
			
			arr[ro] = tokens;
			ro++;
		}
		//creates a readFile double array with the size of the number of rows in the arr array
		double [][] readFile = new double[ro][];
		//uses a for loop to go through every row, setting 1d array st equal to each row of the arr row of the string. 
		//Next you create a double single array that would store the length of the row, because we are going to be
		//copying it and parsing it.
		for(int i =0 ; i < ro; i++) {
		 	String[] st = arr[i];
			double[] dd = new double[st.length];
			//col kkeeps track of the columns
			int col =0;
			//uses an enhanced loop in order to access thorugh each element in the array to parse it. col 
			//is used to go through each column of the single array and set it equal to the parsed double of the st array
			for(String temp : st) {	
				dd[col++] = Double.parseDouble(temp);
			}
			//used to set readfile row eaqual to dd.
			readFile[i] = dd;	
		}
		//closes file and returns the readFile double array
		inFile.close();
		return readFile;
	}

	public static void writeToFile(double[][] data, File outputFile)throws FileNotFoundException {
		PrintWriter output = new PrintWriter(outputFile);
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				output.print(data[i][j] + " ");
			}
			output.println();
		}
		output.close();
	}
}
