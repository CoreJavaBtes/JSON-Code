package JSONPARSER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.json.simple.*;

public class WriteArrayJson {
	
	public static void main(String[] args) {
		/* Scanner sn = new Scanner(System.in);
	        System.out.println("Enter your Name :");
	        String name = sn.next();
	        System.out.println("Enter your Pass :");
	        String pass = sn.next();
	        */
		JSONObject obj = new JSONObject();
		
		JSONArray jarr = new JSONArray();
	        try{
	        	
	        
	        Connection con=null;
	        Statement stmt=null;
	        ResultSet rs=null;
	      
	       Class.forName("com.mysql.jdbc.Driver");
	      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1","root","");
	      stmt=con.createStatement();
	      rs=stmt.executeQuery("select * from  registeration ");
	      int count=0;
	      String name,pass,cont;
	      while(rs.next())
	      {
	    	   name = rs.getString(2);
	    	   pass = rs.getString(3);
	    	   cont = rs.getString(4);
	    	   JSONObject obj1 = new JSONObject(); 
	    	  obj1.put("Name", name);
	    	  obj1.put("Pass", pass);
	    	  obj1.put("Contact", cont);
	    	  jarr.add(obj1);
	    	 
	      }
	     
	      obj.put("Message", jarr); 
    	  System.out.println(obj.toJSONString());
	    //  System.out.println(obj.toJSONString());
	        }catch (Exception e) {
				// TODO: handle exception
			}
	     
	}

}
