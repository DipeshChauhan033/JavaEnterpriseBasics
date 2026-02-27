package com.FinTrackImplementation;
import java.util.Scanner;
import com.connectivity.SqlOperations;

public class FinTrackDone{
		Scanner sc = new Scanner(System.in);
		SqlOperations sqloperations = new SqlOperations();
		CustomerLogin clogin = new CustomerLogin();
		
		public void exe(){
			System.out.printf("Kindly choose your account type to proceed (Admin or Customer).\nEnter 1 for ADMIN, 2 for CUSTOMER: ");
			int choice1 = sc.nextInt();
			System.out.println();
			if(choice1==1) {
				//Admin..
			}
			else if(choice1==2) {
				System.out.println("Welcome to the Customer Panel..\n");
				System.out.print("Please select an option to continue:\n"
						+ "1. New Customer (Register)\n"
						+ "2. Existing Customer (Login)\n"
						+ "Enter your choice (1 or 2): ");
				System.out.println();
				
				int choice2 = sc.nextInt();
				if(choice2==1) {
					System.out.println("\nYou have selected: New Customer Registration.");
					System.out.println("Kindly enter the required details to proceed with account creation.\n");
					
					sqloperations.customer_registration();
				}
				else if(choice2==2) {
					clogin.customerLogin();
				}
				else {
					System.out.println("Invalid input. Please enter 1 for Register or 2 for Login.");
				}
			}
			else {
				System.out.println("Invalid input. Please enter 1 for Admin or 2 for Customer.");
			}
		}
		
}
