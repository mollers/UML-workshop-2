package boatClub;

import java.util.ArrayList;
public class Member {
	private String name;
	private String personalNR;
	private final int id;
	private ArrayList<Boat> boats = new ArrayList<Boat>();
	
	public Member(String n, String p, int i){
		this.name = n;
		this.personalNR = p;
		this.id = i++;
	}
	
	public Member(String n, String p, int i, ArrayList<Boat> b){
		this.name = n;
		this.personalNR = p;
		this.id = i++;
		this.boats = b;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPersonalNR() {
		return personalNR;
	}
	
	public void setPersonalNR(String personalNR) {
		this.personalNR = personalNR;
	}
	
	public int getId() {
		return id;
	}
	
	public int getNumberOfBoats() {
		return this.boats.size();
	}
	
	public ArrayList<Boat> getBoats() {
		return boats;
	}
	
	public void addBoat(Boat boat) {
		this.boats.add(boat);
	}
	
	public void deleteBoats(int index){
		this.boats.remove(index-1);
	}
	
}
