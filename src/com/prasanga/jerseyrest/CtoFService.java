package com.prasanga.jerseyrest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/ctofservice")
public class CtoFService {
	
	@GET
	@Produces("application/xml")
	
	public String convertCtoF(){
		
		//Person p = new Person();
		ResultSet result;
		String ret;
		
		StringBuffer sBuffer = new StringBuffer();
	       
	       //System.out.println(sBuffer);

		MysqlCon mc = new MysqlCon();
		result = mc.selectAllData();
		
		try {
			while(result.next()){
			     //Retrieve by column name
			     int id  = result.getInt("id");
			     String name = result.getString("name");
			     String address = result.getString("address");
			     String mobile = result.getString("mobile");
			     
			     //Display values
			     sBuffer.append("ID: " + id + ", Name: " + name + ", Address: " + address + ", Mobile: " + mobile);
			     //ret = "ID: " + id + ", Name: " + name + ", Address: " + address + ", Mobile: " + mobile ;
			     //System.out.print("ID: " + id);
			     //System.out.print(", Name: " + name);
			     //System.out.print(", Address: " + address);
			     //System.out.println(", Mobile: " + mobile);

			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(sBuffer);
		String out = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + sBuffer;
		return "<ctofservice>"+"<ctofoutput>" + out + "</ctofoutput>" + "</ctofservice>";
		//return out;
	}
	
	@Path("{c}")
	@GET
	@Produces("application/xml")
	public String convertCtoFfromInput(@PathParam("c")String user){
		ResultSet result;
		String ret;
		
		StringBuffer sBuffer = new StringBuffer();
	       
	       //System.out.println(sBuffer);

		MysqlCon mc = new MysqlCon();
		result = mc.selectData(user);
		
		try {
			while(result.next()){
			     //Retrieve by column name
			     int id  = result.getInt("id");
			     String name = result.getString("name");
			     String address = result.getString("address");
			     String mobile = result.getString("mobile");
			     
			     //Display values
			     sBuffer.append("ID: " + id + ", Name: " + name + ", Address: " + address + ", Mobile: " + mobile);
			     //ret = "ID: " + id + ", Name: " + name + ", Address: " + address + ", Mobile: " + mobile ;
			     //System.out.print("ID: " + id);
			     //System.out.print(", Name: " + name);
			     //System.out.print(", Address: " + address);
			     //System.out.println(", Mobile: " + mobile);

			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(sBuffer);
		String out = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + sBuffer;
		return "<ctofservice>"+"<ctofoutput>" + out + "</ctofoutput>" + "</ctofservice>";
	}

}
