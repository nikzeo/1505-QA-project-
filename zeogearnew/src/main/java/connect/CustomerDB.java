package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDB {

	private Connection conn;
	private Statement stmt;

	public CustomerDB() throws SQLException {
		conn = DriverManager.getConnection(ClassConfig.DB_URL, ClassConfig.USER, ClassConfig.PASS);
		stmt = conn.createStatement();
	}

	public void close() throws SQLException {
		conn.close();
	}

	public void create(String firstname, String lastname, String email, String fstlnaddress, String postcode) throws SQLException {
		this.stmt = conn.createStatement();
		String sql = "INSERT INTO customers (firstname, lastname, email, fstlnaddress, postcode) VALUES (\"" + firstname
				+ "\", \"" + lastname + "\", \"" + email + "\", \"" + fstlnaddress + "\", \"" + postcode + "\")";
		System.out.println(sql);
		stmt.executeUpdate(sql);
	}

	public void readCustomer() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
		while (rs.next()) {
			String name = rs.getString("customer_id") + " " + rs.getString("firstname") + " " + rs.getString("lastname")
					+ " " + rs.getString("email");
			System.out.println(name);
		}
	}

	public void updateCustomer(int customer_id2, String firstname1, String lastname1, String email1) throws SQLException {
		String upt = "UPDATE customers SET firstname = '" + firstname1 + "', lastname = '" + lastname1 + "', email = '"
				+ email1 + "'WHERE customer_id = '" + customer_id2 + "'";
		stmt.executeUpdate(upt);

	}

	public void deleteCustomer(int customer_id) throws SQLException {
		String delete = "DELETE FROM customers WHERE customer_id = " + customer_id + "";
		stmt.executeUpdate(delete);
	}
}
