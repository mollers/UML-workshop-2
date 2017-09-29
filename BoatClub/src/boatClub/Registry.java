package boatClub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.*;

public class Registry {
	private ArrayList<Member> memberArr;
	private File file;
	private JSONArray JSONArr = new JSONArray();

	public Registry() {
		this.memberArr = new ArrayList<Member>();
		this.file = new File("src/boatClub/registry/members.json");
	}

	public ArrayList<Member> loadRegistry(){
		BufferedReader bf;
		try {
			bf = new BufferedReader(new FileReader(file.getPath()));
			JSONArr = new JSONArray(bf.readLine());
			bf.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(JSONArr.toString());
		JSONObject jsObj;
		JSONArray jsBoats;
		for(int i = 0; i < JSONArr.length(); i++) {
			jsObj = JSONArr.getJSONObject(i);
			Member temp = new Member(jsObj.getString("name"), 
					jsObj.getString("persNR"),jsObj.getInt("id"));
			jsBoats = jsObj.getJSONArray("boats");
			for(int j = 0; j < jsBoats.length(); j++) {
				temp.addBoat(jsBoats.getJSONObject(j).getInt("length")
						, Boat.boatType.valueOf(jsBoats.getJSONObject(j).getString("boatType")));
			}
			memberArr.add(temp);
		}
		
		return memberArr;
	}
	public void addMember(Member member) {
		long start = System.currentTimeMillis();
		JSONObject JSONMember = new JSONObject();
		JSONArray JSONBoats = new JSONArray();
		

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
		JSONArr.put(JSONMember);
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
		long end = System.currentTimeMillis();
		System.out.println("Adding member took: " + (end - start) + " ms");

	}
	public void changeMember(ArrayList<Member> members) {
		JSONArr = new JSONArray();
		for(Member m : members) {
			addMember(m);
		}
	}
}
