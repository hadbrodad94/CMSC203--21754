import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
class TwoDimRaggedArrayUtilityTest {
	private double[][] dataSet1 = {{3,5,7},{8,2},{11,12,16,17}};
	File file = new File("test.txt");
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAverage() {
		assertEquals(9.0, TwoDimRaggedArrayUtility.getAverage(dataSet1));
	}

	@Test
	void testGetColumnTotal() {
		assertEquals(22.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 0));
		assertEquals(19.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 1));
		assertEquals(23.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 2));
		assertEquals(17.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 3));
	}

	@Test
	void testGetHighestInArray() {
		assertEquals(17.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet1));
	}

	@Test
	void testGetHighestInColumn() {
		
		assertEquals(11.0,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 0));
		assertEquals(12.0,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 1));
		assertEquals(16.0,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 2));
		assertEquals(17.0,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 3));
	}

	@Test
	void testGetHighestInColumnIndex() {
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 0));
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 1));
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 2));
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 3));
	}

	@Test
	void testGetHighestInRow() {
		assertEquals(7.0,TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 0));
		assertEquals(8.0,TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 1));
		assertEquals(17.0,TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 2));
	}

	@Test
	void testGetHighestInRowIndex() {
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 0));
		assertEquals(0,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 1));
		assertEquals(3,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 2));
	}

	@Test
	void testGetLowestInArray() {
		assertEquals(2.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet1));
	}

	@Test
	void testGetLowestInColumn() {
		assertEquals(3.0,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 0));
		assertEquals(2.0,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 1));
		assertEquals(7.0,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 2));
		assertEquals(17.0,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 3));
	}

	@Test
	void testGetLowestInColumnIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 0));
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 1));
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 2));
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 3));
	}

	@Test
	void testGetLowestInRow() {
		assertEquals(3.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 0));
		assertEquals(2.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 1));
		assertEquals(11.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 2));
		
	}

	@Test
	void testGetLowestInRowIndex() {
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 0));
		assertEquals(1,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 1));
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 2));
	}

	@Test
	void testGetRowTotal() {
		assertEquals(15.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 0));
		assertEquals(10.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 1));
		assertEquals(56.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 2));
	}

	@Test
	void testGetTotal() {
		assertEquals(81.0, TwoDimRaggedArrayUtility.getTotal(dataSet1));
	}

	@Test
	void testReadFile() throws FileNotFoundException {
		//double[][] ex = {{3.0,5.0,7.0},{8.0,2.0},{11.0,12.0,16.0,17.0}};
	
		//assertTrue(TwoDimRaggedArrayUtility.readFile(file).equals(ex));
		double[][] array=null;
		try {
			Scanner inFile = new Scanner(file);
			PrintWriter outFile = new PrintWriter(file);
			outFile.print("3.0 5.0 7.0\n" +
					"8.0 2.0\n" +
					"11.0 12.0 16.0 17.0");
			outFile.close();
			array = TwoDimRaggedArrayUtility.readFile(file);
			assertEquals(3.0, array[0][0],.001);
			assertEquals(5.0, array[0][1],.001);
			assertEquals(7.0, array[0][2],.001);
			assertEquals(8.0, array[1][0],.001);
			assertEquals(2.0, array[1][1],.001);
			assertEquals(11.0, array[2][0],.001);
			assertEquals(12.0, array[2][1],.001);
			assertEquals(16.0, array[2][2],.001);
			assertEquals(17.0, array[2][3],.001);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			fail("This should not have caused an FileNotFoundException");
		}
		//testing that the array is a ragged array
		try{
			assertEquals(0.0, array[1][2],.001);
			fail("This should have caused a ArrayIndexOutOfBoundsException");

		} catch (ArrayIndexOutOfBoundsException e){

			assertTrue("Correctly threw ArrayIndexOutOfBoundsException", true);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			fail("This should not have caused an Exception");
		}

		//testing that the array is a ragged array
		//this would be used if you have a negative number thats out of bounds and doesnt work.
//		try{
//			assertEquals(0.0, array[2][2],.001);
//			fail("This should have caused a ArrayIndexOutOfBoundsException");
//
//		} catch (ArrayIndexOutOfBoundsException e){
//
//			assertTrue("Correctly threw ArrayIndexOutOfBoundsException", true);
//		}
//		catch (Exception e) {
//			// TODO Auto-generated catch block
//			fail("This should not have caused an Exception");
//		}
	}
	

	@Test
	void testWriteToFile() throws FileNotFoundException{
		//TwoDimRaggedArrayUtility.writeToFile(dataSet1, file);
		double[][] array=null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSet1, file);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		array = TwoDimRaggedArrayUtility.readFile(file);
		assertEquals(3.0, array[0][0],.001);
		assertEquals(5.0, array[0][1],.001);
		assertEquals(7.0, array[0][2],.001);
		assertEquals(8.0, array[1][0],.001);
		assertEquals(2.0, array[1][1],.001);
		assertEquals(11.0, array[2][0],.001);
		assertEquals(12.0, array[2][1],.001);
		assertEquals(16.0, array[2][2],.001);
		assertEquals(17.0, array[2][3],.001);
	}

}
