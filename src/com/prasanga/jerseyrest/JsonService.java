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

@Path("/jsonservice")
public class JsonService {
	
	@GET
	  @Produces("application/json")
	  public Response getData() throws JSONException {

		JSONObject jsonObject1 = new JSONObject();
		JSONObject jsonObject2 = new JSONObject();

		ResultSet result;
		//String ret;
		
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
			     
			  }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(sBuffer);
		String res = "@Produces(\"application/json\") Output: \n\nOutput: \n\n" + jsonObject2;
		return Response.status(200).entity(res).build();
		
	  }

	  @Path("{f}")
	  @GET
	  @Produces("application/json")
	  public Response getDatafromInput(@PathParam("f") String ret) throws JSONException {

		  JSONObject jsonObject1 = new JSONObject();
			//JSONObject jsonObject2 = new JSONObject();

			ResultSet result;
			//String ret;
			
			MysqlCon mc = new MysqlCon();
			result = mc.selectData(ret);
			
			try {
				//int i = 1;
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
				     
				     //jsonObject2.put(""+i, jsonObject1);
				     //i++;
				     
				  }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//System.out.println(sBuffer);
			String res = "@Produces(\"application/json\") Output: \n\nOutput: \n\n" + jsonObject1;
			return Response.status(200).entity(res).build();
	  }

}
