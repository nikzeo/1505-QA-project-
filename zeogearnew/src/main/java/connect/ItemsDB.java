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

	public void createitem
	
	(String name, double price) throws SQLException {
		this.stmt = conn.createStatement();
		String createitem = "INSERT INTO items (name, price) VALUES (\"" + name + "\", " + price + ")";
		stmt.executeUpdate(createitem);
	} 

	public void viewItem() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM items");
		while (rs.next()) {
			String viewitem = rs.getString("product_id") + " " + rs.getString("name") + "\n£" + rs.getDouble("price");
			System.out.println(viewitem); }
	}

	public void updateItem (int product_id, String name, float price) throws SQLException {
			String updateitem  = "UPDATE items SET name = '" + name + "', " + price + " WHERE product_id = '" + product_id + "'";
			stmt.executeUpdate(updateitem);
	}
	
	public void deleteItem (int product_id) throws SQLException {
		String deleteitem = "DELETE FROM items WHERE product_id = " + product_id +"";
		stmt.executeUpdate(deleteitem);
		
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
	