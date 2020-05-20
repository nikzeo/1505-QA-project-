package connect;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerInput {
	
	private static Scanner scan = new Scanner(System.in);
	public CustomerDB cdb;
	public ItemsDB idb;
	public OrdersDB odb;
	
	public CustomerInput() throws SQLException {
		cdb = new CustomerDB();
		idb = new ItemsDB();
		odb = new OrdersDB();
	}
	
	public void showStartingSelection() throws SQLException {
		System.out.println("Hello, Welcome to ZEOGEAR "
				+ "\n\n -----\n     /\n   /\n /\n ----- \n\n------------------------------------------\n"
				+ "Press 1 for Customer Related Queries \nPress 2 for Product/Item Related Queries \nPress 3 for Order Related Queries"
				+ "\n------------------------------------------");
		String selection = scan.nextLine();
		
		switch(selection) {
			case "1":
				showCustomerQueries();
				break;
			case "2":
				getItemInput();
				break;
			case "3":
				getOrderInput();
				break;
			default: 
				System.out.println("Try again!");
				showStartingSelection();
		}
	}
	
	
	public void showCustomerQueries() throws SQLException {
		System.out.println("Type 1 to Create a New Customer\nType 2 to View Customers\nType 3 to Delete Customers\nType 4 to Update a Customer\nType 5 to to Exit");
		String selection = scan.nextLine();

		switch (selection) {
			case "1": 
				createCustomer();
				break;
			case "2":
				viewCustomers();
				break;
			case "3":
				deleteCustomer();
				break;
			case "4":
				updateCustomer();
				break;
			default:
				System.out.println("Try again!");
				showCustomerQueries();
			}
	}
	
	public void createCustomer() throws SQLException {
		System.out.println("Enter first name: ");
		String firstname = scan.nextLine();

		System.out.println("Enter last name: ");
		String lastname = scan.nextLine();

		System.out.println("Enter email: ");
		String email = scan.nextLine();
			
		System.out.println("Enter the First Line of the Address");
		String fstlnaddress = scan.nextLine();
			
		System.out.println("Enter the postcode");
		String postcode = scan.nextLine();
			
		cdb.create(firstname, lastname, email, fstlnaddress, postcode);
		System.out.println("Customer successfully created");
		showStartingSelection();
	}
	
	public void viewCustomers() throws SQLException {
		cdb.readCustomer();
		System.out.println("Type Y when you would like to go back to the starting selection");
		
		while(true) {
			String result = scan.nextLine();
			if (result.equals("Y") || result.equals("y")) {
				showStartingSelection();
				break;
			}
		}
	}
	
	public void deleteCustomer() throws SQLException {
		System.out.println("Enter the customer_id:");
		int customer_id1 = Integer.parseInt(scan.nextLine());
		cdb.deleteCustomer(customer_id1);
		System.out.println("Customer successfully deleted");
		showStartingSelection();
	}
	
	public void updateCustomer() throws SQLException {
		System.out.println("Enter ID ");
		int customer_id2 = scan.nextInt();
		scan.nextLine();
			
		System.out.println("Enter Updated First Name ");
		String firstname1 = scan.nextLine();
			
		System.out.println("Enter Updated Last Name ");
		String lastname1 = scan.nextLine();
			
		System.out.println("Enter Updated Email ");
		String email1 = scan.nextLine();

		cdb.updateCustomer(customer_id2, firstname1, lastname1, email1);	

		System.out.println("Update Successful!");
		showStartingSelection();
	}

		
	public static void getItemInput() throws SQLException {
		// TODO Auto-generated method stub
		ItemsDB idb = new ItemsDB();

		try {
			
			System.out.println("Type 'insert' to create a new item, Type 'print' to print items"  );
			String selection = scan.nextLine();

			do {

				switch (selection) {

				case "insert":
					
					System.out.println("Insert New Item");
					String name = scan.nextLine();
					
					System.out.println("Insert Price");
					int price = scan.nextInt();
						
					idb.create2(name, price);
					break;
				
				case "print":
					idb.viewItem();
					break;
					
				}

				selection = getAction2();

			} while (!selection.equals("quit"));
			System.out.println("bye");
		} finally {
//			scan.close();
//			idb.close(); 
		}
	}
		
		void getOrderInput() throws SQLException {
		// TODO Auto-generated method stub
		
			OrdersDB odb = new OrdersDB();
		
			System.out.println("Type 'insert' to insert an order, Type view to view orders, type calculate to calculate the value of an order");
			String selection = scan.nextLine();

			switch (selection) {
				case "insert":		
					System.out.println("Customer_ID");
					int customer_id4 = scan.nextInt();
					scan.nextLine();
					
					System.out.println("Enter Product ID");
					int product_id5 = scan.nextInt();
					
					System.out.println("Insert Quantity ordered");
					int quantity = scan.nextInt();
					scan.nextLine();
					
					odb.create3(customer_id4, product_id5, quantity);
					break;
				
				case "view":
					odb.viewItem();
					break;
					
				case "calculate":
					System.out.println("Which Order do you want to calculate the value for? (Enter ID)");
					int order_id = scan.nextInt();
					scan.hasNextLine();
					odb.checkOrderValue(order_id);	
			}
		}
		
}
