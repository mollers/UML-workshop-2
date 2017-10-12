package model;

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
	
	public void addBoat(int lenght, Boat.boatType boatType) {
		Boat boat = new Boat(lenght, boatType);
		this.boats.add(boat);
	}
	
	public void deleteBoat(int index){
		this.boats.remove(index);
	}
	public void changeBoat(int index, int lenght, Boat.boatType boatType) {
		Boat boat = new Boat(lenght, boatType);
		this.boats.set(index, boat);
	}
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Name: " + this.getName() + " Personal number: " + this.getPersonalNR() + " ID: " + this.getId() + "\n");

		for (int i = 0; i < this.boats.size(); i++) {
			sb.append(this.boats.get(i).toString() + " ID: " + i + "\n");
		}
		return sb.toString();
	}
	public String getCompactInfo(){
		StringBuffer sb = new StringBuffer();
		sb.append("Name: " + this.getName() + " ID: " + this.getId() + " Boats: " + this.getNumberOfBoats());
		return sb.toString();
	}
}
