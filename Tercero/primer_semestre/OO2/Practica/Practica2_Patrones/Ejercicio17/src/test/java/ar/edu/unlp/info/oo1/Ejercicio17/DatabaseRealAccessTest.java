package ar.edu.unlp.info.oo1.Ejercicio17;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DatabaseRealAccessTest {

	private DatabaseProxy database;
	
	@BeforeEach
	void setUp() throws Exception {
		database = new DatabaseProxy("Password");
	}

	@Test
	void testLogin() {
		assertFalse(database.getLogged());
		database.login("Password");
		assertTrue(database.getLogged());
	}

	@Test
	void testGetSearchResults() {
		assertEquals(database.getSearchResults("select * from comics where id=1"), null);
		database.login("Password");
		assertEquals(database.getSearchResults("select * from comics where id=1"), Arrays.asList("Spiderman", "Marvel"));
	}
	
	@Test
	void testInsertNewRow() {
		assertEquals(database.insertNewRow(Arrays.asList("Patoruzú", "La flor")), -1);
		database.login("Password");
		assertEquals(database.insertNewRow(Arrays.asList("Patoruzú", "La flor")), 3);
	}
}
