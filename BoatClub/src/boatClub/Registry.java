package boatClub;

import java.io.File;
import java.io.FileNotFoundException;
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
		Scanner scan;
		String nextName = "";
		String nextPersNR = "";
		int nextId = 0;

		ArrayList<Boat> nextBoats; 
		String nextBoatType = "";
		int nextBoatLength = 0;
		try {
			scan = new Scanner(file);
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				if(line.contains("name")){
					nextName = line.split(":")[1].split("\"")[1];
				}
				if(line.contains("persNR")) {
					nextPersNR = line.split(":")[1].split("\"")[1];
				}
				if(line.contains("id")){
					nextId = Integer.valueOf(line.split(":")[1].split(",")[0].trim());
				}
				if(line.contains("boats")){
					nextBoats = new ArrayList<Boat>();
					do{
						line = scan.nextLine();
						if(line.contains("type")){
							nextBoatType = line.split(":")[1].split("\"")[1];
						}
						if(line.contains("length")){
							nextBoatLength = Integer.valueOf(line.split(":")[1].split(",")[0].trim());
							nextBoats.add(new Boat(nextBoatLength,Boat.boatType.valueOf(nextBoatType)));
						}
					}while(!line.contains("]"));
					memberArr.add(new Member(nextName,nextPersNR,nextId,nextBoats));
				}
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  


		return memberArr;
	}

	public void addMember(Member member) {
		long start = System.currentTimeMillis();
		memberArr.add(member);
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
			String fileString = "";
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				fileString += scan.nextLine() + System.lineSeparator();
			}
			scan.close();
			FileWriter writer = new FileWriter(file);
			if(memberArr.size() > 1){
				writer.write(fileString.substring(0, fileString.length()-4) + ",\n" +JSONObject + System.lineSeparator() + fileString.substring(fileString.length()-3));	
			}
			else{
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
		
		System.out.println("Adding member took: " + (System.currentTimeMillis()-start) + " ms");

	}

	public void deleteMember(Member member) {

	}
}
