package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connect.ClassConfig;

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
	
	(String name, int price) throws SQLException {
		this.stmt = conn.createStatement();
		String create2 = "INSERT INTO items (name, price) VALUES (\"" + name + "\", " + price + ")";
		stmt.executeUpdate(create2);
	} 

	public void viewItem() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM items");
		while (rs.next()) {
			String item2 = rs.getString("product_id") + " " + rs.getString("name") + " " + rs.getInt("price");
			System.out.println(item2);
	}

	}
	
	public void calCost() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT \r\n" + 
				"orders_items.order_id, \r\n" + 
				"SUM(items.price) \r\n" + 
				"FROM orders_items \r\n" + 
				"JOIN items on items.product_id = orders_items.product_id \r\n" + 
				"GROUP BY orders_items.order_id");
		while (rs.next()) {
			String item5 = rs.getInt("order_id") + " " + rs.getInt("price");
			System.out.println(item5);
		}
	}
}
		
		
		

		
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
	