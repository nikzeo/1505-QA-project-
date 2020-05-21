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
		stmt.executeUpdate(sql);
	}

	public void readCustomer() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
		while (rs.next()) {
			String name = rs.getString("customer_id") + "  " + rs.getString("firstname") + "  " + rs.getString("lastname")
					+ " " + rs.getString("email") + "  " + rs.getString("fstlnaddress") + "  " + rs.getString("postcode");
			System.out.println(name);
		}
	}

	public void updateCustomer(int customer_id, String firstname, String lastname, String email, String fstlnaddress, String postcode) throws SQLException {
		String upt = "UPDATE customers SET firstname = '" + firstname + "', lastname = '" + lastname + "', email = '"
				+ email + "', fstlnaddress = '" + fstlnaddress + "', postcode = '" + postcode + "'WHERE customer_id = '" + customer_id + "'";
		stmt.executeUpdate(upt);

	}

	public void deleteCustomer(int customer_id) throws SQLException {
		String delete = "DELETE FROM customers WHERE customer_id = " + customer_id + "";
		stmt.executeUpdate(delete);
	}
}
