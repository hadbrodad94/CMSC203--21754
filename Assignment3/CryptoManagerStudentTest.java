import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerStudentTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIsStringInBounds() {
		//used to test whether the String is in bounds given certain scenarios
		assertTrue(CryptoManager.isStringInBounds("THIS TEST SHOULD SUCCEED"));
		assertFalse(CryptoManager.isStringInBounds("test should fail because there is a lowercase letter"));
		assertFalse(CryptoManager.isStringInBounds("TEST SHOULD FAIL BECAUSE } IS OUTSIDE THE RANGE"));
	}

	@Test
	void testCaesarEncryption() {
		//used to test whether certain examples of input work for caesar encryption
		assertEquals("IFMMP!XPSME", CryptoManager.caesarEncryption("HELLO WORLD", 1));
		assertEquals("VYR$E[E]", CryptoManager.caesarEncryption("RUN AWAY",4));
		assertEquals("[QWT\"EQQN", CryptoManager.caesarEncryption("YOUR COOL",2));
	}

	@Test
	void testBellasoEncryption() {
		//used to test whether certain examples of input work for bellaso encryption
		assertEquals("DOVGHS", CryptoManager.bellasoEncryption("ABCDEF","CMSC"));
		assertEquals("DB_WGUNMNM,UU!R!P", CryptoManager.bellasoEncryption("BASKETBALL IS FUN","BALL"));
		assertEquals("XMC&T ,[VWP%", CryptoManager.bellasoEncryption("LEBRON SUCKS","LHATER"));
	}

	@Test
	void testCaesarDecryption() {
		//used to test whether certain examples of encryped messages work for caesar decryption
		assertEquals("HELLO WORLD", CryptoManager.caesarDecryption("IFMMP!XPSME", 1));
		assertEquals("RUN AWAY", CryptoManager.caesarDecryption("VYR$E[E]", 4));
		assertEquals("YOUR COOL", CryptoManager.caesarDecryption("[QWT\"EQQN", 2));
	}

	@Test
	void testBellasoDecryption() {
		//used to test whether certain examples of decrypted messages work for bellaso decryption
		assertEquals("ABCDEF", CryptoManager.bellasoDecryption("DOVGHS","CMSC"));
		assertEquals("BASKETBALL IS FUN", CryptoManager.bellasoDecryption("DB_WGUNMNM,UU!R!P","BALL"));
		assertEquals("LEBRON SUCKS", CryptoManager.bellasoDecryption("XMC&T ,[VWP%","LHATER"));
		
	}

}
