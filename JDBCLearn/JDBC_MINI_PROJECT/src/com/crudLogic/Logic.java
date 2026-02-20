package com.crudLogic;
import java.util.Scanner;
import com.JDBCconn.*;
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
			System.out.println("Press-1 : Insert data");
			System.out.println("Press-2 : Read Data");
			System.out.println("Press-3 : Update Data");
			System.out.println("Press-4 : Delete Data");
			System.out.println("Press-5 : Exit\n");
			
			System.out.print("Enter your choice..-");
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
						crud.insert();
						break;
					case READ_DATA:
						break;
					case UPDATE_DATA:
						break;
					case DELETE_DATA:
						break;
					case EXIT:
						System.out.println("Exist..");
						return;
			}
			}
		}
	}
}
