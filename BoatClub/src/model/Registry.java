package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.json.*;

public class Registry {
	private ArrayList<Member> memberArr;
	private File file;
	private JSONArray JSONArr = new JSONArray();

	public Registry() {
		this.memberArr = new ArrayList<Member>();
		this.file = new File(Registry.class.getResource("/data/members.json").getFile());
	}

	public ArrayList<Member> loadRegistry(){
		try {
			
			InputStream stream = this.getClass().getClassLoader().getResourceAsStream("data/members.json");
			int nextByte;
			String JSONString = "";
			while((nextByte = stream.read()) > -1) // Reads the whole file
			{
				JSONString += ((char)nextByte);
			}
			
			//creates json array from string
			if(JSONString.length() > 0) {
				JSONArr = new JSONArray(JSONString);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Parsing JSON to member.
		JSONObject jsObj;
		JSONArray jsBoats;
		for(int i = 0; i < JSONArr.length(); i++) {
			jsObj = JSONArr.getJSONObject(i);
			Member loadMember = new Member(jsObj.getString("name"), 
					jsObj.getString("persNR"),jsObj.getInt("id"));
			jsBoats = jsObj.getJSONArray("boats");
			for(int j = 0; j < jsBoats.length(); j++) {
				loadMember.addBoat(jsBoats.getJSONObject(j).getInt("length")
						, Boat.boatType.valueOf(jsBoats.getJSONObject(j).getString("boatType")));
			}
			memberArr.add(loadMember);
		}

		return memberArr;
	}
	public void addMember(Member member) {
		JSONObject JSONMember = parseToJSONObject(member);
		
		JSONArr.put(JSONMember); // Add member to the JSON Array and overwrite the file with the new array.
		FileWriter writer;
		try {
			writer = new FileWriter (file);
			writer.write(JSONArr.toString());
			writer.flush();
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void changeMember(ArrayList<Member> members) {
		JSONArr = new JSONArray(); // Clear the JSON array list and add all members.
		for(Member member : members) {
			JSONArr.put(parseToJSONObject(member));
		}
		
		//Write JSON array to file.
		FileWriter writer;
		try {
			writer = new FileWriter (file);
			writer.write(JSONArr.toString());
			writer.flush();
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private JSONObject parseToJSONObject(Member member) {
		JSONObject JSONMember = new JSONObject();
		JSONArray JSONBoats = new JSONArray();
		
		//Parsing member to JSON 
		JSONMember.put("name", member.getName());
		JSONMember.put("persNR", member.getPersonalNR());
		JSONMember.put("id", member.getId());
		ArrayList<Boat> boatArr = member.getBoats();
		for(int i = 0; i < boatArr.size(); i++) {
			JSONObject JSONBoat = new JSONObject();
			JSONBoat.put("length", boatArr.get(i).getLength());
			JSONBoat.put("boatType", boatArr.get(i).getType());
			JSONBoats.put(JSONBoat);
		}
		JSONMember.put("boats", JSONBoats);
		
		return JSONMember;
	}
}
