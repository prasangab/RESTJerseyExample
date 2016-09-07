package com.prasanga.jerseyrest;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/ftocservice")
public class FtoCService {
	
	@GET
	  @Produces("application/json")
	  public Response convertFtoC() throws JSONException {

		JSONObject jsonObject1 = new JSONObject();
		JSONObject jsonObject2 = new JSONObject();

		ResultSet result;
		String ret;
		
		StringBuffer sBuffer = new StringBuffer();
	       
	       //System.out.println(sBuffer);

		MysqlCon mc = new MysqlCon();
		result = mc.selectAllData();
		
		try {
			int i = 1;
			while(result.next()){
			     //Retrieve by column name
			     int id  = result.getInt("id");
			     String name = result.getString("name");
			     String address = result.getString("address");
			     String mobile = result.getString("mobile");
			     
			     jsonObject1.put("ID", id); 
			     jsonObject1.put("Name", name);
			     jsonObject1.put("Address", address); 
			     jsonObject1.put("Mobile", mobile);
			     
			     jsonObject2.put(""+i, jsonObject1);
			     i++;
			     //jsonObject.put(key, value)
			     //Display values
			     //sBuffer.append("ID: " + id + ", Name: " + name + ", Address: " + address + ", Mobile: " + mobile);
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
		
		//System.out.println(sBuffer);
		String res = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject2;
		return Response.status(200).entity(res).build();
		
	  }

	  @Path("{f}")
	  @GET
	  @Produces("application/json")
	  public Response convertFtoCfromInput(@PathParam("f") float f) throws JSONException {

		JSONObject jsonObject = new JSONObject();
		float celsius;
		celsius =  (f - 32)*5/9; 
		jsonObject.put("F Value", f); 
		jsonObject.put("C Value", celsius);

		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	  }

}
