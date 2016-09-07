package com.prasanga.jerseyrest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MysqlCon {
	
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/testdata";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	
	public ResultSet selectAllData(){
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT * FROM details";
		      rs = stmt.executeQuery(sql);
		      
		      //Person p = new Person();
		      //List<Person> data = null;
		      //ArrayList al = new ArrayList();
		    //STEP 5: Extract data from result set
		      /*while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		         String name = rs.getString("name");
		         String address = rs.getString("address");
		         String mobile = rs.getString("mobile");

		         p.setId(id);
		         p.setName(name);
		         p.setAddress(address);
		         p.setMobile(mobile);
		         
		         
		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", Name: " + name);
		         System.out.print(", Address: " + address);
		         System.out.println(", Mobile: " + mobile);
		         
		         data.add(p);
		      } */
		      
		      
		      //System.out.println(data);
		      //data.add(data);
		      //STEP 6: Clean-up environment
		      //rs.close();
		      //stmt.close();
		      //conn.close();
		      
		      //return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
public ResultSet selectData(String name){
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      //sql = "SELECT * FROM Users WHERE Name ='" + uName + "' AND Pass ='" + uPass + "'"
		      String sql = "SELECT * FROM details WHERE name ='" + name + "'";
		      rs = stmt.executeQuery(sql);
		      
		      //Person p = new Person();
		      //List<Person> data = null;
		      //ArrayList al = new ArrayList();
		    //STEP 5: Extract data from result set
		      /*while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		         String name = rs.getString("name");
		         String address = rs.getString("address");
		         String mobile = rs.getString("mobile");

		         p.setId(id);
		         p.setName(name);
		         p.setAddress(address);
		         p.setMobile(mobile);
		         
		         
		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", Name: " + name);
		         System.out.print(", Address: " + address);
		         System.out.println(", Mobile: " + mobile);
		         
		         data.add(p);
		      } */
		      
		      
		      //System.out.println(data);
		      //data.add(data);
		      //STEP 6: Clean-up environment
		      //rs.close();
		      //stmt.close();
		      //conn.close();
		      
		      //return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
