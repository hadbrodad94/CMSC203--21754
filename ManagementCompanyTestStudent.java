/*
 * Class: CMSC203 
 * Instructor:Grinberg
 * Description: Designs a Property Management that collects the plot, property and combines it together in an organized fashion.
 * Due: 10/24/22
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Majd Haddad
   
*/
/**
 * @author Majd Haddad
 */
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent {
	ManagementCompany mg1;
	Property prop1,prop2,prop3,prop4, prop5;
	@BeforeEach
	void setUp() throws Exception {
		//the management company
		mg1 = new ManagementCompany("Majd","7777777", 7);
		
		
		//adding the properties w/ the plots to the company
		prop1 = new Property("House", "Silver Spring", 2900.00,"James Justre",1,1,1,1);
		prop2 = new Property("Hotel","Rockville",400.0,"Ahmed Rahman",2,2,1,1);
		prop3 = new Property("Apartment","GaithersBerg", 2360, "Henry Jones", 4,2,1,1);
		prop4 = new Property("Building1", "Georgetown", 3000.0, "Jimmy",3,3,3,3);
		prop5 = new Property ("RainyStation", "Becky", 1500.0, "Billy Boh",6,4,1,1);


		mg1.addProperty(prop1);
		mg1.addProperty(prop2);
		mg1.addProperty(prop3);
		mg1.addProperty(prop4);
		mg1.addProperty(prop5);
	}

	@AfterEach
	void tearDown() throws Exception {
		mg1 = null;
		prop1 = prop2 = prop3= prop4 = prop5 = null;
	}

	@Test
	void testAddProperty() {
//		prop4 = new Property("Building1", "Georgetown", 3000.0, "Jimmy");
		assertEquals(prop1,mg1.getProperties()[0]);
//		assertEquals(-4,mg1.addProperty(prop2));
//		assertEquals(-4,mg1.addProperty(prop3));
//		assertEquals(-4,mg1.addProperty(prop4));
//		assertEquals(-4,mg1.addProperty(prop5));
	}



	@Test
	void testGetHighestRentPropperty() {
		assertEquals(prop4, mg1.getHighestRentPropperty());
	}

	@Test
	void testGetMgmFeePer() {
		assertEquals(7,mg1.getMgmFeePer(), 0);
	}

	@Test
	void testGetName() {
		assertEquals("Majd",mg1.getName());
	}

	@Test
	void testGetPlot() {
		

		assertEquals(mg1.getProperties()[0].getPlot().toString(), "1,1,1,1");
		assertEquals(mg1.getProperties()[1].getPlot().toString(), "2,2,1,1");
		assertEquals(mg1.getProperties()[2].getPlot().toString(), "4,2,1,1");
		assertEquals(mg1.getProperties()[3].getPlot().toString(), "3,3,3,3");
		assertEquals(mg1.getProperties()[4].getPlot().toString(), "6,4,1,1");
		
	}

	@Test
	void testGetProperties() {
		//propertyName + "," + city + "," + owner + "," + rentAmount;
		assertEquals(mg1.getProperties()[0],prop1);
		assertEquals(mg1.getProperties()[1],prop2);
		assertEquals(mg1.getProperties()[2],prop3);
		assertEquals(mg1.getProperties()[3],prop4);
		assertEquals(mg1.getProperties()[4],prop5);
	}

	@Test
	void testGetPropertiesCount() {
		assertEquals(5,mg1.getPropertiesCount());
	}

	@Test
	void testGetTaxID() {
		assertEquals("7777777", mg1.getTaxID());
	}

	@Test
	void testGetTotalRent() {
		assertEquals(10160.0,mg1.getTotalRent(),0);
	}

	@Test
	void testIsManagementFeeValid() {
		assertTrue(mg1.isManagementFeeValid());
	}

	@Test
	void testIsPropertiesFull() {
		assertFalse(mg1.isPropertiesFull());
	}

	@Test
	void testRemoveLastProperty() {
		mg1.removeLastProperty();
		assertEquals(mg1.getProperties()[4], null);
	}

	@Test
	void testToString() {
		String value = "List of the properties for Majd, taxID: 7777777" + "\n" 
				+ "______________________________________________________\n"
				+ "House,Silver Spring,James Justre,2900.0\n"
				+ "Hotel,Rockville,Ahmed Rahman,400.0\n"
				+ "Apartment,GaithersBerg,Henry Jones,2360.0\n"
				+ "Building1,Georgetown,Jimmy,3000.0\n"
				+ "RainyStation,Becky,Billy Boh,1500.0\n"
				+ "______________________________________________________\n\n"
				+ "total management Fee: 711.2";
		assertEquals(value, mg1.toString());
	
	}

}
