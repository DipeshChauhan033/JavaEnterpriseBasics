package com.FinTrackImplementation;
import com.connectivity.SqlOperations;
import java.util.Scanner;

public class CustomerFunctionality {
	Scanner sc = new Scanner(System.in);
	SqlOperations customerLogic = new SqlOperations();
	
	public CustomerFunctionality() {
		System.out.println("=======================================================");
		System.out.println("Please choose what you would like to do next:");
		System.out.println("1. View Profile Details");
		System.out.println("2. Create Financial Account");
		System.out.println("3. Deposit Money");
		System.out.println("4. Withdraw Money");
		System.out.println("5. Transfer Amount");
		System.out.print("\nEnter your choice (1-5): ");
		
		int choice1 = sc.nextInt();
		if(choice1==1) {
			customerLogic.viewCustomerDetails();
		}
		else if(choice1==2) {
			System.out.println("\n====================================");
			System.out.println("Create New Financial Account");
			System.out.println("====================================");

			System.out.println("Please select the type of account you want to create:");
			System.out.println("1. Saving Account");
			System.out.println("2. Current Account");
			System.out.println("3. Business Account");
			System.out.print("\nEnter your choice (1-3): ");
			int choice2 = sc.nextInt();
			
			if(choice2==1) {
				customerLogic.saving_acc();
			}
			else if(choice2==2) {
				customerLogic.current_acc();
			}
			else if(choice2==3) {
				customerLogic.business_acc();
			}
			else{
				System.out.println("Kindly choose a valid option (1-3) from the menu.");
			}
		}
		else if(choice1==3) {
			customerLogic.deposit();
		}
		else if(choice1==4) {
			customerLogic.withdraw();
		}
		else if(choice1==5) {
			customerLogic.transfer();
		}
		else {
			System.out.println("Kindly choose a valid option (1-5) from the menu.");
		}
	}
}
