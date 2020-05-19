package connect;

import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.xdevapi.DbDoc;

public class Main {
		
	public static void main(String[] args) throws SQLException { 
		// TODO Auto-generated method stub
	
	
	CustomerInput cdb = new CustomerInput();
		
	Scanner scan2 = new Scanner (System.in);
	System.out.println("Press 1 for Customer stuff - Press 2 for Item stuff - Press 3 for Order stuff ");
	String selection = scan2.nextLine();
	
	switch (selection) {
	
	case "1":
		
		cdb.getCustomerInput();
		break;
		
	case "2":
		
		cdb.getItemInput();
	
	case "3":
	
		cdb.getOrderInput();
		
	default: 
		
		System.out.println("Try again!");
		
	}

}
		
}		
	
	
		
	
		
		
		
		
	
			