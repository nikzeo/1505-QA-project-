package main;

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

//	public void createCustomer(String fName, String lName) throws SQLException {
//		stmt.executeUpdate(
//				"INSERT INTO customer (`first_name`, `last_name`)" + " VALUES ('" + fName + "', '" + lName + "')");
//	}

	public void create
	
	(int customer_id, String firstname, String lastname, String email) throws SQLException {
		this.stmt = conn.createStatement();
		String sql = "INSERT INTO customers (customer_id, firstname, lastname, email) VALUES ("+ customer_id + ", \"" + firstname + "\", \"" + lastname + "\", \""+ email + "\")";
		stmt.executeUpdate(sql);
	}

	public void readCustomer() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
		while (rs.next()) {
			String name = rs.getString("firstname") + " " + rs.getString("lastname") + " " + rs.getString("email");
			System.out.println(name);
		}
	}

	public void updateCustomer(String fName, String lName, int cid) throws SQLException {
		stmt.executeUpdate(
				"UPDATE customer SET first_name = '" + fName + "', last_name = '" + lName + "' WHERE cid = " + cid +"");
	}

	public void deleteCustomer(int customer_id) throws SQLException {
		String delete = "DELETE FROM customers WHERE customer_id = " + customer_id + ";";
		stmt.executeUpdate(delete);
	}}

	
	
