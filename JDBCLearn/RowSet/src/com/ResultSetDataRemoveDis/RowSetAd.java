package com.ResultSetDataRemoveDis;
import java.sql.*;
import java.util.Properties;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import java.io.*;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class RowSetAd {

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
			
			CachedRowSet cachedrowset  = RowSetProvider.newFactory().createCachedRowSet();
			cachedrowset.populate(resultset);
			
			while(cachedrowset.next()) {
				String cname = cachedrowset.getString("username");
				if(cname.equals("niraj")) {
					cachedrowset.deleteRow();
				}
			}
			test(cachedrowset);
			
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
	
	private static void test(CachedRowSet cachedrowset) {
		try {
			cachedrowset.beforeFirst();
			while(cachedrowset.next()) {
				System.out.println("Name: "+cachedrowset.getString("username"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
