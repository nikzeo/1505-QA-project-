package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemsDB {

	private Connection conn;
	private Statement stmt;

	public ItemsDB() throws SQLException {
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

	public void create2
	
	(int product_id, String name, int price) throws SQLException {
		this.stmt = conn.createStatement();
		String create2 = "INSERT INTO items (product_id, name, price) VALUES (" + product_id + ", \"" + name + "\", " + price + ")";
		stmt.executeUpdate(create2);
	} 

	public void viewItem() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM items");
		while (rs.next()) {
			String item2 = rs.getString("name") + " " + rs.getInt("price");
			System.out.println(item2);
	}
		
		
	}}
		
//	}
//
//	public void updateCustomer(int customer_id2, String firstname1, String lastname1, String email1) throws SQLException {
//		
//		String upt = "UPDATE customers SET firstname = '" + firstname1 + "', lastname = '" + lastname1 + "', email = '" + email1 + "'WHERE customer_id = '" + customer_id2 + "'";    
//		stmt.executeUpdate(upt); 
//
//	}
//			
//	public void deleteCustomer(int customer_id) throws SQLException {
//		String delete = "DELETE FROM customers WHERE customer_id = " + customer_id + "";
//		stmt.executeUpdate(delete);
//	}}
//
//	
	