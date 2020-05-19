package connect;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerInput {
	
	private static Scanner scan = new Scanner(System.in);
	
	private static String getAction3() {
		System.out.println("Type 'insert' to insert an order, Type view to view orders");
		return scan.nextLine();
	}
	
	private static String getAction2() {
		System.out.println("Type 'insert' to create a new item, Type 'print' to print items"  );
		return scan.nextLine();
	}

	private static String getAction() {
		System.out.println("Type 'create' to create, 'print' to print, 'delete' to delete, 'update' to update or 'quit' to quit.");
		return scan.nextLine();
	}


	public void getCustomerInput() throws SQLException {
		// TODO Auto-generated method stub
			
		CustomerDB db = new CustomerDB(); {

		try {
			
			String action = "";
			action = getAction();

			do {

				switch (action) {

				case "create": // this works!!!!!
					
				
					System.out.println("Enter ID:");
					int customer_id = scan.nextInt();
					scan.nextLine();

					System.out.println("Enter first name: ");
					String firstname = scan.nextLine();

					System.out.println("Enter last name: ");
					String lastname = scan.nextLine();

					System.out.println("Enter email: ");
					String email = scan.nextLine();


					db.create(customer_id, firstname, lastname, email);
					break;

				case "print":
					db.readCustomer();
					break;

			case "delete":
					System.out.println("Enter the customer_id:");
					int customer_id1 = Integer.parseInt(scan.nextLine());
					db.deleteCustomer(customer_id1);
					break;
					
			case "update":
		
					System.out.println("Enter ID ");
					int customer_id2 = scan.nextInt();
					scan.nextLine();
					
					System.out.println("Enter Updated First Name ");
					String firstname1 = scan.nextLine();
					
					System.out.println("Enter Updated Last Name ");
					String lastname1 = scan.nextLine();
					
					System.out.println("Enter Updated Email ");
					String email1 = scan.nextLine();

					db.updateCustomer(customer_id2, firstname1, lastname1, email1);	
					System.out.println("Update Successful!");
					

//				default:
//					System.out.println("No matching case");

				}

				action = getAction();

			} while (!action.equals("quit"));
			System.out.println("bye");

		} finally {

			scan.close();
			db.close();
			
		}
		
		}	
		
	}

	void getItemInput() throws SQLException {
		// TODO Auto-generated method stub
		
		ItemsDB idb = new ItemsDB();

		try {
			
			String action2 = "";
			action2 = getAction2();

			do {

				switch (action2) {

				case "insert":
					
					System.out.println("Insert ID");
					int pid = scan.nextInt();
					scan.nextLine();
					
					System.out.println("Insert New Item");
					String name = scan.nextLine();
					
					System.out.println("Insert Price");
					int price = scan.nextInt();
						
					idb.create2(pid, name, price);
					break;
				
				case "print":
					idb.viewItem();
					break;
					
				}

				action2 = getAction2();

			} while (!action2.equals("quit"));
			System.out.println("bye");

		} finally {

			scan.close();
			idb.close(); 
			
		}
		
	}
		
		void getOrderInput() throws SQLException {
		// TODO Auto-generated method stub
		
		OrdersDB odb = new OrdersDB();

		try {
			
			String action3 = "";
			action3 = getAction3();

			do {

				switch (action3) {

				case "insert":
					
					System.out.println("Insert ID");
					int order_id = scan.nextInt();
					scan.nextLine();
						
					odb.create3(order_id);
					break;
				
				case "view":
					odb.viewItem();
					break;
					
				}

				action3 = getAction3();
				

			} while (!action3.equals("quit"));
			System.out.println("bye");

		} finally {

			scan.close();
			odb.close(); 
			
	}
		
		}
		
}
