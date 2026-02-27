package com.FinTrackImplementation;
import com.connectivity.SqlOperations;
import java.util.Scanner;

public class CustomerFunctionality {
	Scanner sc = new Scanner(System.in);
	SqlOperations view_customer_details = new SqlOperations();
	
	public CustomerFunctionality() {
		System.out.println("=======================================================");
		System.out.println("Please choose what you would like to do next:");
		System.out.println("1. View Profile Details");
		System.out.println("2. Create Financial Account");
		System.out.println("3. Deposit Money");
		System.out.println("4. Withdraw Money");
		System.out.println("5. Transfer Amount");
		System.out.print("\nEnter your choice (1-5): ");
		
		int choice = sc.nextInt();
		if(choice==1) {
			view_customer_details.viewCustomerDetails();
		}
	}
}
