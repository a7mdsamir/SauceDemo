package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Random;


public class JsonDataReader 
{
	public String firstname, lastname , address, city,state, zipCode, phoneNumber, ssn, username, password, confirmPassword ,accountname ;

	public void JsonReader() throws IOException, ParseException 
	{
		String filePath = System.getProperty("user.dir")+"/src/test/java/data/UserData.json";

		File srcFile = new File(filePath); 

		JSONParser parser = new JSONParser(); 
		JSONArray jarray = (JSONArray)parser.parse(new FileReader(srcFile)); 

		for(Object jsonObj : jarray) 
		{
			JSONObject person = (JSONObject) jsonObj ; 
			firstname  = (String) person.get("firstname"); 
//			System.out.println(firstname);

			lastname = (String) person.get("lastname"); 
//			System.out.println(lastname);

			address  = (String) person.get("address");
//			System.out.println(address);

			city = (String) person.get("city");
//			System.out.println(city);

			state = (String) person.get("state");
//			System.out.println(state);

			zipCode  = (String) person.get("zipCode");
//			System.out.println(zipCode);

			phoneNumber = (String) person.get("phoneNumber");
//			System.out.println(phoneNumber);

			ssn  = (String) person.get("ssn");
//			System.out.println(ssn);

			username = (String) person.get("username");
			System.out.println("username from JSON :  " + username);

			password = (String) person.get("password");
//			System.out.println(password);

			confirmPassword = (String) person.get("confirmPassword");
//			System.out.println(confirmPassword);

			accountname = (String) person.get("accountname");


		}

	}

	public void updateJsonFile() throws IOException, ParseException {
		String filePath = System.getProperty("user.dir") + "/src/test/java/data/UserData.json";
		File srcFile = new File(filePath);

		JSONParser parser = new JSONParser();
		JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcFile));

		// Generate random phone number and update it in the JSON object
		Random random = new Random();
		String random3Number = String.format("%03d", random.nextInt(100));
		String newUsername = "ahmed" + random3Number;
		for (Object jsonObj : jarray) {
			JSONObject person = (JSONObject) jsonObj;


			person.put("username", newUsername);

			// Update the JSON file
			try (FileWriter file = new FileWriter(filePath)) {
				file.write(jarray.toJSONString());
				file.flush();
			}
		}

		System.out.println("JSON file updated with new random username." + newUsername);
	}

}
