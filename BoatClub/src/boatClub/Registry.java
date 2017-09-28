package boatClub;

import java.io.File;
import java.util.ArrayList;

public class Registry {
	private ArrayList<Member> memberArr;
	private File file;
	
	public Registry() {
		this.memberArr = new ArrayList<Member>();
		this.file = new File("/members.json");
	}
	
	public ArrayList<Member> loadRegistry(){
		return memberArr;
	}
	
	public void addMember(Member member) {
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
		System.out.println(JSONObject);
	}
	
	public void deleteMember(Member member) {
		
	}
}
