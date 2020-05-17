package main;

import java.sql.SQLException;
import java.util.Scanner;

public class App {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		
		CustomerDB db = new CustomerDB();
//			DB db2 = new DB();

		try {
			String action = "";
			action = getAction();

			do {

				switch (action) {

				case "create": // this works!!!!!

					System.out.println("Enter CID:");
					int customer_id = scan.nextInt();
					scan.nextLine();

					System.out.println("Enter first name: ");
					String firstname = scan.nextLine();

					System.out.println("Enter last name: ");
					String lastname = scan.nextLine();

					System.out.println("Enter email: ");
					String email = scan.nextLine();


					db.create(customer_id, firstname, lastname, email);;
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
					System.out.println("Update Succesful!");
					

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

	private static String getAction() {
		System.out.println("Type 'create' to create, 'print' to print, 'delete' to delete, 'update' to update or 'quit' to quit.");
		return scan.nextLine().toLowerCase();
	}

}
