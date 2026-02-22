package com.crudLogic;
import java.util.Scanner;
import com.JDBCconn.*;
import com.employee.dto.EmployeeDTO;

public class Logic {
	private final int INSERT_DATA = 1;
	private final int READ_DATA = 2;
	private final int UPDATE_DATA = 3;
	private final int DELETE_DATA = 4;
	private final int EXIT = 5;
	private final int MAX_ATTEMPTS = 3;
	private static int count = 0;
	
	public void doStart() {
		Scanner sc =new Scanner(System.in);
		CRUD crud = new CRUD();
		
		while(true){
			System.out.println("");
			System.out.println("Press-1 : Insert data");
			System.out.println("Press-2 : Read Data");
			System.out.println("Press-3 : Update Data");
			System.out.println("Press-4 : Delete Data");
			System.out.println("Press-5 : Exit\n");
			
			System.out.print("Enter your choice : ");
			System.out.print("");
			int Choice=0;
			
			try {
				Choice = sc.nextInt();
			}
			catch(Exception e) {
				count++;
				System.out.println("Invalid Input!.. please take number from 1 to 5\n");
				if(count>=MAX_ATTEMPTS) {
					System.out.println("Reached the limit.. ");
					return;
				}
				sc.nextLine();
				continue;
				
			}
			
			if(Choice<1 || Choice>5) {
				System.out.println("Invalid Input!.. please take value from 1 to 5\n");
				count++;
				if(count>=MAX_ATTEMPTS) {
					System.out.println("Reached the limit.. ");
					return;
				}
			}
			
			else {
				switch(Choice){
					case INSERT_DATA:
						System.out.print("Enter Username: ");
						String uname = sc.next();
						System.out.print("Enter Password: ");
						String password = sc.next();
						sc.nextLine();
						System.out.print("Enter Fullname: ");
						String fullname = sc.nextLine();
						System.out.print("Enter Address: ");
						String address = sc.nextLine();
						System.out.print("Enter Salary: ");
						double salary = sc.nextDouble();
						
						EmployeeDTO employeeDTO = new EmployeeDTO(uname,password,fullname,address,salary);
						
						crud.insert(employeeDTO);
						
						break;
					case READ_DATA:
						System.out.println("Enter username: ");
						String uname2 = sc.next();
						System.out.println("Enter password: ");
						String  password2 = sc.next();
						crud.read(uname2,password2);
						break;
					case UPDATE_DATA:
						System.out.println("Enter username: ");
						String uname3 = sc.next();
						System.out.println("Enter salary to update: ");
						double  salary2 = sc.nextDouble();
						crud.update(uname3,salary2);
						break;
					case DELETE_DATA:
						System.out.println("Enter username: ");
						String uname4 = sc.next();
						crud.delete(uname4);
						break;
					case EXIT:
						System.out.println("Exist..");
						return;
			}
			}
		}
	}
}
