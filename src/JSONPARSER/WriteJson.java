package JSONPARSER;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class WriteJson {
	
	public static void main(String[] args) {
		
	
		        JSONObject obj1 = new JSONObject();
		        
		       /*JSONObject obj = new JSONObject();
		        *  obj.put("name", "mkyong.com");
		        obj.put("age", new Integer(100));

		        JSONArray list = new JSONArray();
		        list.add("msg 1");
		        list.add("msg 2");
		        list.add("msg 3");
		         obj.put("messages", list);

		        try (FileWriter file = new FileWriter("d:\\test.json")) {

		            file.write(obj.toJSONString());
		            file.flush();

		        } catch (IOException e) {
		            e.printStackTrace();
		        }

		        System.out.print(obj);
*/
		        Scanner sn = new Scanner(System.in);
		        System.out.println("Enter your Name :");
		        String name = sn.next();
		        System.out.println("Enter your Pass :");
		        String pass = sn.next();
		        try{
		        	
		        
		        Connection con=null;
		        Statement stmt=null;
		        ResultSet rs=null;
		      
		       Class.forName("com.mysql.jdbc.Driver");
		      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1","root","");
		      stmt=con.createStatement();
		      rs=stmt.executeQuery("select * from  registeration where Uname = '"+name+"' and Password = '"+pass+"' ");
		      int count=0;
		      if(rs.next())
		      {
		    	  obj1.put("Message", "Success"); 
		      }else{
		    	  obj1.put("Message", "Fail"); 
		      }
		    
		      System.out.println("...."+obj1.toJSONString());
		        }catch (Exception e) {
					// TODO: handle exception
				}
		     
		    }

	

}
