package boatClub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Registry {
	private ArrayList<Member> memberArr;
	private File file;
	
	public Registry() {
		this.memberArr = new ArrayList<Member>();
		this.file = new File("src/boatClub/registry/members.json");
	}
	
	public ArrayList<Member> loadRegistry(){
		Member temp;
		
		
		return memberArr;
	}
	
	public void addMember(Member member) {
		memberArr.add(member);
		String fileString = "";
		ArrayList<Boat> boats = member.getBoats();
		String JSONObject = "{\n";
		JSONObject += "\t\"name\"" + ":" + " \"" + member.getName() + "\"" + ",\n";
		JSONObject += "\t\"persNR\"" + ":" + " \"" + member.getPersonalNR()+ "\"" + ",\n";
		JSONObject += "\t\"id\"" + ": " + member.getId() + ",\n";
		JSONObject += "\t\"boats\"" +": "+ "[" + "\n";
		for(int i = 0; i < member.getBoats().size(); i++) {
			JSONObject += "\t\t{ \n";
			JSONObject += "\t\t\t\"type\"" +": " + "\"" + boats.get(i).getType() + "\""+ ",\n";
			if(i == member.getBoats().size()-1)
				JSONObject += "\t\t\t\"length\"" +": " + boats.get(i).getLength() + "\n\t\t}\n";
			else
				JSONObject += "\t\t\t\"length\"" +": " + boats.get(i).getLength() + "\n\t\t},\n";
		}
		JSONObject += "\t]\n";
		JSONObject += "}";
		
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				fileString += scan.nextLine() + System.lineSeparator();
			}
			FileWriter writer = new FileWriter(file);
			System.out.println(memberArr.size());
			if(memberArr.size() > 1){
				System.out.println("NOT FIRST!");
				writer.write(fileString.substring(0, fileString.length()-4) + ",\n" +JSONObject + System.lineSeparator() + fileString.substring(fileString.length()-3));	
			}
			else{
				System.out.println("FIRST MOTHER FUCKER");
				writer.write(fileString.substring(0, fileString.length()-4) + JSONObject + System.lineSeparator() + fileString.substring(fileString.length()-3));
			}
				
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteMember(Member member) {
		
	}
}
