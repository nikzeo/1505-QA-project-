package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connect.ClassConfig;

public class OrdersDB {

	private Connection conn;
	private Statement stmt;

	public OrdersDB() throws SQLException {
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

	public void createOrder(int customer_id, int product_id, int quantity) throws SQLException {
		this.stmt = conn.createStatement();
		String createorder = "INSERT INTO orders (customer_id, product_id, quantity) VALUES (" + customer_id + ", "
				+ product_id + "," + quantity + ")";
		stmt.executeUpdate(createorder);
	}

	public void viewOrder() throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM orders");
		while (rs.next()) {
			String vieworder = "Order ID:   " + rs.getString ("order_id") + "\nCustomer ID:   " + rs.getString("customer_id") + "\nProduct ID:   " + rs.getString("product_id") + "\nQuantity Ordered:  " + rs.getString("quantity");
			System.out.println(vieworder); }

	}
	
	public void deleteOrder (int order_id) throws SQLException {
		String deleteorder = "DELETE FROM orders WHERE order_id = " + order_id +"";
		stmt.executeUpdate(deleteorder);
	
	}
	
	public void updateOrder(int order_id, int product_id, int quantity) throws SQLException {
		String updateorder = "UPDATE orders SET order_id = '" + order_id + "', product_id = '" + product_id + "', quantity = '"
				+ quantity + "'WHERE order_id = '" + order_id + "'";
		stmt.executeUpdate(updateorder);
	}

	public void calculateOrder(int order_id) throws SQLException {

		ResultSet rs = stmt.executeQuery("select (items.price * orders.quantity) AS order_total FROM items, orders "
				+ "WHERE items.product_id = orders.product_id AND order_id = " + order_id);
		while (rs.next()) {
			String test = "£" + rs.getFloat("order_total");
			System.out.println(test);

		}

	}
}

//
//	