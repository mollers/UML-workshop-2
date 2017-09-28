package boatClub;

import java.util.ArrayList;
public class Member {
	private String name;
	private String personalNR;
	private int id;
	private ArrayList<Boat> boats = new ArrayList<Boat>();
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
	public void setId(int id) {
		this.id = id;
	}
	public int getNumberOfBoats() {
		return this.boats.size();
	}
	public Boat[] getBoats() {
		return boats;
	}
	public void addBoats(Boat boat) {
		this.boats.add(boat);
	}
}
