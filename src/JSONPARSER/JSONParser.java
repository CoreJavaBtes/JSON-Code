package JSONPARSER;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {

	public static void main(String[] args) throws JSONException {
		
		String name,code1,code2;
		
		String url = "http://services.groupkt.com/country/get/all";
		Post obj  = new Post(url);
		StringBuilder response = obj.Connect();
		String response1 = response.toString();
		JSONParser parser = new JSONParser();
		JSONObject jobj = new JSONObject(response1);
		JSONObject jobj1 = jobj.getJSONObject("RestResponse");
		
		JSONArray jarr = jobj1.getJSONArray("result");
		for(int i = 0; i< jarr.length(); i++)
		{
			JSONObject jobj2 = jarr.getJSONObject(i);
			 name = jobj2.getString("name");
			 code1 = jobj2.getString("alpha2_code");
			 code2 = jobj2.getString("alpha3_code");
			 System.out.println("............"+name);
		}
		
		//System.out.println("........."+response1);
 				
	}
}
