package connect;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;



public class CustomerDBTest {
	
	@Mock
	Statement mockstatement;
	
	@Mock
	Connection connection;
	
	@InjectMocks
	CustomerDB customerdb;
	 
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCreate() throws SQLException {
		when(connection.createStatement()).thenReturn(mockstatement);
		
		String firstname = "John";
		String lastname = "Doe";
		String email = "test@test.com";
		String fstlnaddress = "15 Highbury Way";
		String postcode = "BN2 9AF";
		
		customerdb.create(firstname, lastname, email, fstlnaddress, postcode);
		
		String expectedSql = "INSERT INTO customers (firstname, lastname, email, fstlnaddress, postcode) VALUES (\"" + firstname
		+ "\", \"" + lastname + "\", \"" + email + "\", \"" + fstlnaddress + "\", \"" + postcode + "\")";
		
		verify(mockstatement).executeUpdate(expectedSql);
	}

	/*
	 * @Test public void testReadCustomer() throws SQLException {
	 * when(connection.createStatement()).thenReturn(mockstatement);
	 * 
	 * customerdb.readCustomer();
	 * 
	 * verify(mockstatement).executeQuery("SELECT * FROM customers"); }
	 */

	@Test
	public void testUpdateCustomer() throws SQLException {
		when(connection.createStatement()).thenReturn(mockstatement);
		
		int id = 1;
		String firstname = "John";
		String lastname = "Doe";
		String email = "test@test.com";
		String fstlnaddress = "15 Highbury Way";
		String postcode = "BN2 9AF";
		
		customerdb.updateCustomer(id, firstname, lastname, email, fstlnaddress, postcode);
		
		String expectedSql = "UPDATE customers SET firstname = '" + firstname + "', lastname = '" + lastname + "', email = '"
				+ email + "', fstlnaddress = '" + fstlnaddress + "', postcode = '" + postcode + "'WHERE customer_id = '" + id + "'";
		
		verify(mockstatement).executeUpdate(expectedSql);
	}

	@Test
	public void testDeleteCustomer() throws SQLException {
		when(connection.createStatement()).thenReturn(mockstatement);
		
		int id = 1;
		
		customerdb.deleteCustomer(id);
		
		String expectedSql = "DELETE FROM customers WHERE customer_id = " + id + "";
		
		verify(mockstatement).executeUpdate(expectedSql);
	}

}
