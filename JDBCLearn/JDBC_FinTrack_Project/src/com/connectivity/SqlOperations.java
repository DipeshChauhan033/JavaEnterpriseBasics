package com.connectivity;
import java.util.Scanner;
import java.math.BigDecimal;
import com.FinTrackImplementation.CustomerLogin;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlOperations {
	Scanner sc = new Scanner(System.in);
	CustomerLogin clogin = new CustomerLogin();
	public SqlOperations() {
		createTable();
	}
	
	public void createTable() {
		Connection conn = null;
		Statement statement = null;
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.createStatement();
			
			String sql = "create table if not exists customers(sn INT AUTO_INCREMENT UNIQUE KEY,"
					+ "cid int PRIMARY KEY,"
					+ "cname varchar(100)NOT NULL,"
					+ "password varchar(30)NOT NULL,"
					+ "mobile_no varchar(10)NOT NULL UNIQUE,"
					+ "address varchar(100)NOT NULL,"
					+ "CHECK (mobile_no REGEXP '^[0-9]{10}$')"
					+ ")";
			
			statement.executeUpdate(sql);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
	}
	
	public void customer_registration() {
		Connection conn = null;
		PreparedStatement preparedstatement = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			
			String sql = "insert into customers(cid,cname,password,mobile_no,address) values(?,?,?,?,?)";
			preparedstatement = conn.prepareStatement(sql);
			
			System.out.print("Enter customer id: ");
			int cid = sc.nextInt();
			preparedstatement.setInt(1,cid);
			
			System.out.print("Enter customer name: ");
			String cname = sc.next();
			preparedstatement.setString(2, cname);
			
			System.out.print("Enter psaaword: ");
			String password = sc.next();
			preparedstatement.setString(3, password);
			
			System.out.print("Enter mobile no: ");
			String mobile_no = sc.next();
			sc.nextLine();
			preparedstatement.setString(4,mobile_no);
			
			System.out.print("Enter permanent address: ");
			String address = sc.nextLine();
			preparedstatement.setString(5,address);
			System.out.println("");
			
			int check = preparedstatement.executeUpdate();
			
			if(check>0) {
				System.out.println("\nAccount Created Successfully!");
				System.out.println("Thank you for registering with us.");
				System.out.println("You can now login using your Customer ID and Password.");
				System.out.println("--------------------------------------------");
				
				clogin.customerLogin();
			}
		}
		catch(Exception e) {
			System.out.println("--- please enter valid mobile number");
		}
		finally {
			ConnectionFactory.close(preparedstatement);
			ConnectionFactory.close(conn);
		}
	}
	
	public void viewCustomerDetails() {
		Connection conn = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			
			String sql = "select * from customers where cid=? and password=?";
			preparedstatement = conn.prepareStatement(sql);
			
			int cid = clogin.cid;
			preparedstatement.setInt(1, cid);
			String pass = clogin.pass;
			preparedstatement.setString(2,pass);
			
			resultset = preparedstatement.executeQuery();
			
			if(resultset.next()) {
				int sn = resultset.getInt("sn");
				int customerid = resultset.getInt("cid");
				String cname = resultset.getString("cname");
				String password = resultset.getString("password");
				String mobile_no = resultset.getString("mobile_no");
				String address = resultset.getString("address");
				
				System.out.printf("SN: "+sn +"\nCUSTOMER ID: "+customerid+"\nCUSTOMER NAME: "+cname+"\nPASSWORD: "+password+"\nMOBILE NO: "+mobile_no+"\nADDRESS: "+address);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.close(resultset);
			ConnectionFactory.close(preparedstatement);
			ConnectionFactory.close(conn);
		}
		
	}
	
	public void saving_acc(){
		Connection conn = null;
		PreparedStatement preparedstatement = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			
			String sqlCheck = "select * from financial_account where cid=? and account_type=?";
			preparedstatement = conn.prepareStatement(sqlCheck);
			
			int cid = clogin.cid;
			String accType = "saving";
			preparedstatement.setInt(1, cid);
			preparedstatement.setString(2, accType);
			
			ResultSet resultset = preparedstatement.executeQuery();
			
			if(resultset.next()) {
				System.out.println("\nSaving Account already exists!");
				return;
			}
			
			String sql = "insert into financial_account(cid,account_type,balance)values(?,?,?)";
			preparedstatement = conn.prepareStatement(sql);
			
	
			preparedstatement.setInt(1, cid);
			preparedstatement.setString(2, accType);
			
			
			System.out.println("Minimum balance requirement will be applied.");
			System.out.print("Enter 3000 or more as Deposit Amount: ");
			BigDecimal fixedBalance = sc.nextBigDecimal();
			BigDecimal minimumbalance = new BigDecimal("3000");
			if(fixedBalance.compareTo(minimumbalance)>=0) {
				preparedstatement.setBigDecimal(3, fixedBalance);
				preparedstatement.executeUpdate();
				System.out.println("\nSaving Account Created Successfully!");
			}
			else {
				System.out.println("\nMinimum balance for Saving Account is 3000.");
				}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.close(preparedstatement);
			ConnectionFactory.close(conn);
		}
	}
	
	public void current_acc(){
		Connection conn = null;
		PreparedStatement preparedstatement = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sqlCheck = "select * from financial_account where cid=? and account_type=?";
			preparedstatement = conn.prepareStatement(sqlCheck);
			
			int cid = clogin.cid;
			String accType = "current";
			preparedstatement.setInt(1, cid);
			preparedstatement.setString(2, accType);
			
			ResultSet resultset = preparedstatement.executeQuery();
			
			if(resultset.next()) {
				System.out.println("\nCurrent Account already exists!");
				return;
			}
			String sql = "insert into financial_account(cid,account_type,balance)values(?,?,?)";
			
			preparedstatement = conn.prepareStatement(sql);
			
			preparedstatement.setInt(1, cid);
			preparedstatement.setString(2, accType);
			
			System.out.println("Minimum balance requirement will be applied.");
			System.out.print("Enter 6000 or more as Deposit Amount: ");
			BigDecimal fixedBalance = sc.nextBigDecimal();
			BigDecimal minimumbalance = new BigDecimal("6000");
			if(fixedBalance.compareTo(minimumbalance)>=0) {
				preparedstatement.setBigDecimal(3, fixedBalance);
				preparedstatement.executeUpdate();
				System.out.println("\nCurrent Account Created Successfully!");
			}
			else {
				System.out.println("\nMinimum balance for Current Account is 6000.");
				}
		}
		catch(Exception e) {
			System.out.println("Enter valid data...");
		}
		finally {
			ConnectionFactory.close(preparedstatement);
			ConnectionFactory.close(conn);
		}
	}
	
	
	public void business_acc(){
		Connection conn = null;
		PreparedStatement preparedstatement = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sqlCheck = "select * from financial_account where cid=? and account_type=?";
			preparedstatement = conn.prepareStatement(sqlCheck);
			
			int cid = clogin.cid;
			String accType = "business";
			preparedstatement.setInt(1, cid);
			preparedstatement.setString(2, accType);
			
			ResultSet resultset = preparedstatement.executeQuery();
			
			if(resultset.next()) {
				System.out.println("\nBusiness Account already exists!");
				return;
			}
			String sql = "insert into financial_account(cid,account_type,balance)values(?,?,?)";
			
			preparedstatement = conn.prepareStatement(sql);
			
			preparedstatement.setInt(1, cid);
			preparedstatement.setString(2, accType);
			
			System.out.println("Minimum balance requirement will be applied.");
			System.out.print("Enter 15000 or more as Deposit Amount: ");
			BigDecimal fixedBalance1 = sc.nextBigDecimal();
			BigDecimal minimumbalance1 = new BigDecimal("15000");
			if(fixedBalance1.compareTo(minimumbalance1)>=0) {
				preparedstatement.setBigDecimal(3, fixedBalance1);
				preparedstatement.executeUpdate();
				System.out.println("\nBusiness Account Created Successfully!");
			}
			else {
				System.out.println("\nMinimum balance for Business Account is 15000.");
				}
		}
		catch(Exception e) {
			System.out.println("Enter valid data...");
		}
		finally {
			ConnectionFactory.close(preparedstatement);
			ConnectionFactory.close(conn);
		}
	}
	
	public void deposit() {
		Connection conn = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select account_type from financial_account where cid=?";
			
			preparedstatement = conn.prepareStatement(sql);
			int cid = clogin.cid;
			preparedstatement.setInt(1, cid);
			
			resultset = preparedstatement.executeQuery();
			int count = 0;
			String[] arr = new String[3]; 
			while(resultset.next()) {
				String types = resultset.getString("account_type");
				System.out.println("");
				arr[count] = types;
				count+=1;
			}
			System.out.printf("You currently have %d active accounts,",count);
			System.out.println("");
			String toStoreType="";
			for(String tmp : arr) {
				if(tmp==null) {
					break;
				}
				System.out.println("----- "+tmp);
				toStoreType = tmp;
			}
			
			String sqlToInsert = "update financial_account set balance=balance+? where cid=? and account_type=?";
			preparedstatement = conn.prepareStatement(sqlToInsert);
			preparedstatement.setInt(2, cid);
			
			if(count==1) {
				preparedstatement.setString(3, toStoreType);
				System.out.print("Enter the amount you want to deposit into your");
				for(String tmp : arr) {
					if(tmp==null) {
						break;
					}
					System.out.print(" --- "+tmp+" ACCOUNT :");
				}
				BigDecimal amount = sc.nextBigDecimal();
				preparedstatement.setBigDecimal(1,amount);
				preparedstatement.executeUpdate();
				System.out.printf("Deposit successful! The amount has been credited to your %s ACCOUNT.",toStoreType);
				
			}
			
			else if(count>1) {
				System.out.print("\n----Enter :\n");
				int choosemenu = 1;
				for(String tmp : arr) {
					if(tmp==null) {
						break;
					}
					System.out.printf("%d to deposit amount into your "+tmp+" ACCOUNT\n",choosemenu);
					choosemenu+=1;
				}
				System.out.print(": ");
				int choice = sc.nextInt();
				try {
					if(choice==1) {
						String index1 = arr[0];
						preparedstatement.setString(3, index1);
						System.out.printf("Enter the amount you want to deposit into your %s ACCOUNT: ",index1);
						BigDecimal amount = sc.nextBigDecimal();
						preparedstatement.setBigDecimal(1,amount);
						preparedstatement.executeUpdate();
						System.out.printf("Deposit successful! The amount has been credited to your %s ACCOUNT.",index1);
					}
					else if(choice==2) {
						String index2 = arr[1];
						preparedstatement.setString(3, index2);
						System.out.printf("Enter the amount you want to deposit into your %s ACCOUNT: ",index2);
						BigDecimal amount2 = sc.nextBigDecimal();
						preparedstatement.setBigDecimal(1,amount2);
						preparedstatement.executeUpdate();
						System.out.printf("Deposit successful! The amount has been credited to your %s ACCOUNT.",index2);
					}
					else if(choice==3) {
						if(count==3) {
							String index3 = arr[2];
							preparedstatement.setString(3, index3);
							System.out.printf("Enter the amount you want to deposit into your %s ACCOUNT: ",index3);
							BigDecimal amount3 = sc.nextBigDecimal();
							preparedstatement.setBigDecimal(1,amount3);
							preparedstatement.executeUpdate();
							System.out.printf("Deposit successful! The amount has been credited to your %s ACCOUNT.",index3);
						}
						else {
							System.out.println("Please Choose Valid Account Type..");
						}
					}
					else {
						System.out.println("Please Choose Valid Account Type..");
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			else {
				System.out.println("No account is associated with the provided details. Please create an account first.");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.close(resultset);
			ConnectionFactory.close(preparedstatement);
			ConnectionFactory.close(conn);
		}
		
		
	}
	
	public void withdraw() {
		Connection conn = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select account_type from financial_account where cid=?";
			
			preparedstatement = conn.prepareStatement(sql);
			int cid = clogin.cid;
			preparedstatement.setInt(1, cid);
			resultset = preparedstatement.executeQuery();
			
			int count = 0;
			String[] arr = new String[3];
			while(resultset.next()) {
				String types = resultset.getString("account_type");
				System.out.println("");
				arr[count] = types;
				count+=1;
			}
			
			System.out.printf("You currently have %d active accounts,",count);
			System.out.println("");
			String toStoreType="";
			for(String tmp : arr) {
				if(tmp==null) {
					break;
				}
				System.out.println("----- "+tmp);
				toStoreType = tmp;
			}
			
			String sqlToWithdraw = "update financial_account set balance=balance-? where cid=? and account_type=?";
			preparedstatement = conn.prepareStatement(sqlToWithdraw);
			preparedstatement.setInt(2, cid);
			
			if(count==1) {
				preparedstatement.setString(3, toStoreType);
				System.out.print("Enter the amount you want to withdraw from your");
				for(String tmp : arr) {
					if(tmp==null) {
						break;
					}
					System.out.print(" --- "+tmp+" ACCOUNT :");
				}
				BigDecimal amount = sc.nextBigDecimal();
				preparedstatement.setBigDecimal(1,amount);
				preparedstatement.executeUpdate();
				System.out.printf("Withdraw successful! The amount has been deducted from your %s ACCOUNT.",toStoreType);
			}
			else if(count>1) {
				System.out.print("\n----Enter :\n");
				int choosemenu = 1;
				for(String tmp : arr) {
					if(tmp==null) {
						break;
					}
					System.out.printf("%d to withdraw amount from your "+tmp+" ACCOUNT\n",choosemenu);
					choosemenu+=1;
				}
				System.out.print(": ");
				int choice = sc.nextInt();
				try {
					if(choice==1) {
						String index1 = arr[0];
						preparedstatement.setString(3, index1);
						System.out.printf("Enter the amount you want to deposit into your %s ACCOUNT: ",index1);
						BigDecimal amount = sc.nextBigDecimal();
						preparedstatement.setBigDecimal(1, amount);
						preparedstatement.executeUpdate();
						System.out.printf("Withdraw successful! The amount has been deducted from your %s ACCOUNT.",index1);
					}
					else if(choice==2) {
						String index2 = arr[1];
						preparedstatement.setString(3, index2);
						System.out.printf("Enter the amount you want to deposit into your %s ACCOUNT: ",index2);
						BigDecimal amount = sc.nextBigDecimal();
						preparedstatement.setBigDecimal(1, amount);
						preparedstatement.executeUpdate();
						System.out.printf("Withdraw successful! The amount has been deducted from your %s ACCOUNT.",index2);
					}
					else if(choice==3) {
						if(count==3) {
							String index3 = arr[2];
							preparedstatement.setString(3, index3);
							System.out.printf("Enter the amount you want to deposit into your %s ACCOUNT: ",index3);
							BigDecimal amount = sc.nextBigDecimal();
							preparedstatement.setBigDecimal(1, amount);
							preparedstatement.executeUpdate();
							System.out.printf("Withdraw successful! The amount has been deducted from your %s ACCOUNT.",index3);
						}
					}
					else {
						System.out.println("Please Choose Valid Account Type..");
					}
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			else {
				System.out.println("No account is associated with the provided details. Please create an account first.");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(resultset);
			ConnectionFactory.close(preparedstatement);
			ConnectionFactory.close(conn);
		}
	}
	
	
	
	public void transfer() {
		Connection conn = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select account_type from financial_account where cid=?";
			
			preparedstatement = conn.prepareStatement(sql);
			int cid = clogin.cid;
			preparedstatement.setInt(1, cid);
			resultset = preparedstatement.executeQuery();
			
			String[] arr = new String[3];
			int count = 0;
			while(resultset.next()) {
				String types = resultset.getString("account_type");
				arr[count] = types;
				count+=1;
			}
			
			String AmountTransfering = "update financial_account set balance=balance-? where cid=? and account_type=?";
			preparedstatement = conn.prepareStatement(AmountTransfering);
			preparedstatement.setInt(2,cid);
			
			String AmountReceiving = "update financial_account set balance=balance+? where cid=? and account_type=?";
			
	
			if(count==1) {
				String index1 = arr[0];
				preparedstatement.setString(3, index1);
				receiveraccounts obj = new receiveraccounts();
				if(cid==obj.cid) {
					System.out.println("-----Enter valid Customer id-----");
				}
				else if(obj.count==1) {
					System.out.print("Enter the amount you want to transfer from your");
					for(String tmp : arr) {
						if(tmp==null) {
							break;
						}
						System.out.print(" --- "+tmp+" ACCOUNT :");	
					}
					BigDecimal amount = sc.nextBigDecimal();
					preparedstatement.setBigDecimal(1,amount);
					preparedstatement.executeUpdate();
					
					preparedstatement = conn.prepareStatement(AmountReceiving);
					preparedstatement.setBigDecimal(1, amount);
					preparedstatement.setInt(2, obj.cid);
					preparedstatement.setString(3, obj.arr[0]);
					preparedstatement.executeUpdate();
					System.out.printf("Transaction successful! ₹%s has been transferred successfully.",amount);
				}
				else if(obj.count>1) {
					System.out.printf("Receiver have %d active accounts,",obj.count);
					System.out.println("");
					for(String tmp: obj.arr) {
						if(tmp==null) {
							break;
						}
						System.out.println("-----"+tmp);
					}
					System.out.print("\n----Enter :\n");
					int choosemenu = 1;
					for(String tmp : obj.arr) {
						if(tmp==null) {
							break;
						}
						System.out.printf("%d to transfer amount into "+tmp+" ACCOUNT\n",choosemenu);
						choosemenu+=1;
					}
					System.out.print(": ");
					int choice = sc.nextInt();
					if(choice==1) {
						String indexofreceiver = obj.arr[0];
						System.out.printf("Enter the amount you want to transfer from your %s: ","---"+index1+" ACCOUNT");
						BigDecimal amount = sc.nextBigDecimal();
						preparedstatement.setBigDecimal(1,amount);
						preparedstatement.executeUpdate();
						preparedstatement = conn.prepareStatement(AmountReceiving);
						preparedstatement.setBigDecimal(1, amount);
						preparedstatement.setInt(2, obj.cid);
						preparedstatement.setString(3, indexofreceiver);
						preparedstatement.executeUpdate();
						System.out.printf("Transaction successful! ₹%s has been transferred successfully.",amount);
						
					}
					else if(choice==2) {
						String indexofreceiver = obj.arr[1];
						System.out.printf("Enter the amount you want to transfer from your %s: ","---"+index1+" ACCOUNT");
						BigDecimal amount = sc.nextBigDecimal();
						preparedstatement.setBigDecimal(1,amount);
						preparedstatement.executeUpdate();
						preparedstatement = conn.prepareStatement(AmountReceiving);
						preparedstatement.setBigDecimal(1, amount);
						preparedstatement.setInt(2, obj.cid);
						preparedstatement.setString(3, indexofreceiver);
						preparedstatement.executeUpdate();
						System.out.printf("Transaction successful! ₹%s has been transferred successfully.",amount);
						
					}
					else if(choice==3) {
						if(obj.count==3) {
							String indexofreceiver = obj.arr[2];
							System.out.printf("Enter the amount you want to transfer from your %s: ","---"+index1+" ACCOUNT");
							BigDecimal amount = sc.nextBigDecimal();
							preparedstatement.setBigDecimal(1,amount);
							preparedstatement.executeUpdate();
							preparedstatement = conn.prepareStatement(AmountReceiving);
							preparedstatement.setBigDecimal(1, amount);
							preparedstatement.setInt(2, obj.cid);
							preparedstatement.setString(3, indexofreceiver);
							preparedstatement.executeUpdate();
							System.out.printf("Transaction successful! ₹%s has been transferred successfully.",amount);
						}
					}
					else {
						System.out.println("Please Choose Valid Account Type..");
					}
				}
				else {
					System.out.println("Please Choose Valid Account Type..");
				}
			}
			
			else if(count>1) {
				System.out.printf("You currently have %d active accounts,",count);
				System.out.println("");
				for(String tmp : arr) {
					if(tmp==null) {
						break;
					}
					System.out.println("----- "+tmp);
				}
				
				System.out.print("\n----Enter :\n");
				int choosemenu = 1;
				for(String tmp : arr) {
					if(tmp==null) {
						break;
					}
					System.out.printf("%d to transfer amount from your "+tmp+" ACCOUNT\n",choosemenu);
					choosemenu+=1;
				}
				System.out.print(": ");
				int choice = sc.nextInt();
				if(choice==1) {
					String index1 = arr[0];
					preparedstatement.setString(3,index1);
					receiveraccounts obj = new receiveraccounts();
					System.out.printf("Receiver have %d active accounts,",obj.count);
					System.out.println("");
					for(String tmp: obj.arr) {
						if(tmp==null) {
							break;
						}
						System.out.println("-----"+tmp);
					}
					System.out.print("\n----Enter :\n");
					int choosemenu2 = 1;
					for(String tmp : obj.arr) {
						if(tmp==null) {
							break;
						}
						System.out.printf("%d to transfer amount into "+tmp+" ACCOUNT\n",choosemenu2);
						choosemenu2+=1;
					}
					System.out.print(": ");
					int choice2 = sc.nextInt();
					if(choice2==1) {
						String indexofreceiver = obj.arr[0];
						System.out.printf("Enter the amount you want to transfer from your %s: ","---"+index1+" ACCOUNT");
						BigDecimal amount = sc.nextBigDecimal();
						preparedstatement.setBigDecimal(1,amount);
						preparedstatement.executeUpdate();
						preparedstatement = conn.prepareStatement(AmountReceiving);
						preparedstatement.setBigDecimal(1, amount);
						preparedstatement.setInt(2, obj.cid);
						preparedstatement.setString(3, indexofreceiver);
						preparedstatement.executeUpdate();
						System.out.printf("Transaction successful! ₹%s has been transferred successfully.",amount);
						
					}
					else if(choice2==2) {
						String indexofreceiver = obj.arr[1];
						System.out.printf("Enter the amount you want to transfer from your %s: ","---"+index1+" ACCOUNT");
						BigDecimal amount = sc.nextBigDecimal();
						preparedstatement.setBigDecimal(1,amount);
						preparedstatement.executeUpdate();
						preparedstatement = conn.prepareStatement(AmountReceiving);
						preparedstatement.setBigDecimal(1, amount);
						preparedstatement.setInt(2, obj.cid);
						preparedstatement.setString(3, indexofreceiver);
						preparedstatement.executeUpdate();
						System.out.printf("Transaction successful! ₹%s has been transferred successfully.",amount);
						
					}
					else if(choice2==3) {
						if(obj.count==3) {
							String indexofreceiver = obj.arr[2];
							System.out.printf("Enter the amount you want to transfer from your %s: ","---"+index1+" ACCOUNT");
							BigDecimal amount = sc.nextBigDecimal();
							preparedstatement.setBigDecimal(1,amount);
							preparedstatement.executeUpdate();
							preparedstatement = conn.prepareStatement(AmountReceiving);
							preparedstatement.setBigDecimal(1, amount);
							preparedstatement.setInt(2, obj.cid);
							preparedstatement.setString(3, indexofreceiver);
							preparedstatement.executeUpdate();
							System.out.printf("Transaction successful! ₹%s has been transferred successfully.",amount);
						}
					}
					else {
						System.out.println("Please Choose Valid Account Type..");
					}
				}
				else if(choice==2) {
					String index1 = arr[1];
					preparedstatement.setString(3,index1);
					receiveraccounts obj = new receiveraccounts();
					System.out.printf("Receiver have %d active accounts,",obj.count);
					System.out.println("");
					for(String tmp: obj.arr) {
						if(tmp==null) {
							break;
						}
						System.out.println("-----"+tmp);
					}
					System.out.print("\n----Enter :\n");
					int choosemenu2 = 1;
					for(String tmp : obj.arr) {
						if(tmp==null) {
							break;
						}
						System.out.printf("%d to transfer amount into "+tmp+" ACCOUNT\n",choosemenu2);
						choosemenu2+=1;
					}
					System.out.print(": ");
					int choice2 = sc.nextInt();
					if(choice2==1) {
						String indexofreceiver = obj.arr[0];
						System.out.printf("Enter the amount you want to transfer from your %s: ","---"+index1+" ACCOUNT");
						BigDecimal amount = sc.nextBigDecimal();
						preparedstatement.setBigDecimal(1,amount);
						preparedstatement.executeUpdate();
						preparedstatement = conn.prepareStatement(AmountReceiving);
						preparedstatement.setBigDecimal(1, amount);
						preparedstatement.setInt(2, obj.cid);
						preparedstatement.setString(3, indexofreceiver);
						preparedstatement.executeUpdate();
						System.out.printf("Transaction successful! ₹%s has been transferred successfully.",amount);
						
					}
					else if(choice2==2) {
						String indexofreceiver = obj.arr[1];
						System.out.printf("Enter the amount you want to transfer from your %s: ","---"+index1+" ACCOUNT");
						BigDecimal amount = sc.nextBigDecimal();
						preparedstatement.setBigDecimal(1,amount);
						preparedstatement.executeUpdate();
						preparedstatement = conn.prepareStatement(AmountReceiving);
						preparedstatement.setBigDecimal(1, amount);
						preparedstatement.setInt(2, obj.cid);
						preparedstatement.setString(3, indexofreceiver);
						preparedstatement.executeUpdate();
						System.out.printf("Transaction successful! ₹%s has been transferred successfully.",amount);
						
					}
					else if(choice2==3) {
						if(obj.count==3) {
							String indexofreceiver = obj.arr[2];
							System.out.printf("Enter the amount you want to transfer from your %s: ","---"+index1+" ACCOUNT");
							BigDecimal amount = sc.nextBigDecimal();
							preparedstatement.setBigDecimal(1,amount);
							preparedstatement.executeUpdate();
							preparedstatement = conn.prepareStatement(AmountReceiving);
							preparedstatement.setBigDecimal(1, amount);
							preparedstatement.setInt(2, obj.cid);
							preparedstatement.setString(3, indexofreceiver);
							preparedstatement.executeUpdate();
							System.out.printf("Transaction successful! ₹%s has been transferred successfully.",amount);
						}
					}
					else {
						System.out.println("Please Choose Valid Account Type..");
					}
				}
				else if(choice==3) {
					String index1 = arr[2];
					preparedstatement.setString(3,index1);
					receiveraccounts obj = new receiveraccounts();
					System.out.printf("Receiver have %d active accounts,",obj.count);
					System.out.println("");
					for(String tmp: obj.arr) {
						if(tmp==null) {
							break;
						}
						System.out.println("-----"+tmp);
					}
					System.out.print("\n----Enter :\n");
					int choosemenu2 = 1;
					for(String tmp : obj.arr) {
						if(tmp==null) {
							break;
						}
						System.out.printf("%d to transfer amount into "+tmp+" ACCOUNT\n",choosemenu2);
						choosemenu2+=1;
					}
					System.out.print(": ");
					int choice2 = sc.nextInt();
					if(choice2==1) {
						String indexofreceiver = obj.arr[0];
						System.out.printf("Enter the amount you want to transfer from your %s: ","---"+index1+" ACCOUNT");
						BigDecimal amount = sc.nextBigDecimal();
						preparedstatement.setBigDecimal(1,amount);
						preparedstatement.executeUpdate();
						preparedstatement = conn.prepareStatement(AmountReceiving);
						preparedstatement.setBigDecimal(1, amount);
						preparedstatement.setInt(2, obj.cid);
						preparedstatement.setString(3, indexofreceiver);
						preparedstatement.executeUpdate();
						System.out.printf("Transaction successful! ₹%s has been transferred successfully.",amount);
						
					}
					else if(choice2==2) {
						String indexofreceiver = obj.arr[1];
						System.out.printf("Enter the amount you want to transfer from your %s: ","---"+index1+" ACCOUNT");
						BigDecimal amount = sc.nextBigDecimal();
						preparedstatement.setBigDecimal(1,amount);
						preparedstatement.executeUpdate();
						preparedstatement = conn.prepareStatement(AmountReceiving);
						preparedstatement.setBigDecimal(1, amount);
						preparedstatement.setInt(2, obj.cid);
						preparedstatement.setString(3, indexofreceiver);
						preparedstatement.executeUpdate();
						System.out.printf("Transaction successful! ₹%s has been transferred successfully.",amount);
						
					}
					else if(choice2==3) {
						if(obj.count==3) {
							String indexofreceiver = obj.arr[2];
							System.out.printf("Enter the amount you want to transfer from your %s: ","---"+index1+" ACCOUNT");
							BigDecimal amount = sc.nextBigDecimal();
							preparedstatement.setBigDecimal(1,amount);
							preparedstatement.executeUpdate();
							preparedstatement = conn.prepareStatement(AmountReceiving);
							preparedstatement.setBigDecimal(1, amount);
							preparedstatement.setInt(2, obj.cid);
							preparedstatement.setString(3, indexofreceiver);
							preparedstatement.executeUpdate();
							System.out.printf("Transaction successful! ₹%s has been transferred successfully.",amount);
						}
					}
					else {
						System.out.println("Please Choose Valid Account Type..");
					}
				}
				else {
					System.out.println("Please Choose Valid Account Type..");
				}
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.close(resultset);
			ConnectionFactory.close(preparedstatement);
			ConnectionFactory.close(conn);
		}
	}
	public void viewAllCustomers() {
		Connection conn = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		int cid,count = 1;
		String cname,mobile_no,address;
		
		try {
			conn = ConnectionFactory.getConnection();
			
			String sql = "select cid,cname,mobile_no,address from customers";
			preparedstatement = conn.prepareStatement(sql);
			
			resultset = preparedstatement.executeQuery();
			while(resultset.next()) {
				cid = resultset.getInt("cid");
				cname = resultset.getString("cname");
				mobile_no = resultset.getString("mobile_no");
				address = resultset.getString("address");
				
				System.out.printf("%d:",count);
				System.out.println("	Customer Id: "+cid);
				System.out.println("	Customer Name: "+cname);
				System.out.println("	Mobile No of Customer: "+mobile_no);
				System.out.println("	Address of Customer: "+address);
				System.out.println("");
				count+=1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.close(resultset);
			ConnectionFactory.close(preparedstatement);
			ConnectionFactory.close(conn);
		}
	}
	
}

class receiveraccounts{
	public int count = 0;
	public int cid;
	public String[] arr;
	public receiveraccounts() {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select account_type from financial_account where cid=?";
			
			System.out.println("Enter receiver customer id: ");
			cid = sc.nextInt();
			
			preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setInt(1, cid);
			resultset = preparedstatement.executeQuery();
			
			arr = new String[3];
			while(resultset.next()) {
				String types = resultset.getString("account_type");
				arr[count] = types;
				count+=1;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.close(resultset);
			ConnectionFactory.close(preparedstatement);
			ConnectionFactory.close(conn);
		}
	}
	
	
}
