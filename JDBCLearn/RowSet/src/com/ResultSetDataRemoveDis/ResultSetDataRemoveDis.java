package com.ResultSetDataRemoveDis;
import java.sql.*;
import java.util.Properties;
import java.io.*;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ResultSetDataRemoveDis {

	public static void main(String[] args) {
		HikariDataSource hikaridatasource = null;
		try {
			Properties properties = new Properties();
			FileInputStream fileinputstream = new FileInputStream("myconfig.properties");
			properties.load(fileinputstream);
			
			String url = (String)properties.get("mysql.url");
			String uname = (String)properties.get("mysql.username");
			String pass = (String)properties.get("mysql.password");
			
			HikariConfig hikariconfig = new HikariConfig();
			hikariconfig.setJdbcUrl(url);
			hikariconfig.setUsername(uname);
			hikariconfig.setPassword(pass);
			
			hikaridatasource = new HikariDataSource(hikariconfig);
			Connection conn = hikaridatasource.getConnection();
			System.out.println(conn);
			
			String sql = "select * from employee";
			PreparedStatement preparedstatement = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet resultset = preparedstatement.executeQuery();
			
			while(resultset.next()) {
				String cname = resultset.getString("username");
				if(cname.equals("dharmik")) {
					resultset.deleteRow();//Also Remove from databse
				}else {
					System.out.println(cname);
				}
			}
			
			preparedstatement.close();
			conn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			hikaridatasource.close();
		}
	}

}
