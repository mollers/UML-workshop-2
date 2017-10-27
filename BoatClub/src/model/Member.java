package model;

import java.util.ArrayList;
import java.util.Iterator;
public class Member implements Iterable<Boat>{
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
<<<<<<< HEAD
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

	@Override
	public Iterator<Boat> iterator() {
		return new BoatIterator(this.boats);
	}
	public class BoatIterator implements Iterator<Boat> {
		
		private final ArrayList<Boat> boats;
		private final int size;
		private int index = 0;
		
		public BoatIterator(ArrayList<Boat> boats) {
			this.boats = boats;
			this.size = boats.size();
		}

		@Override
		public boolean hasNext() {
			return index < size;
		}

		@Override
		public Boat next() {
			return boats.get(index++);
		}
		public Boat get(int index) {
			return boats.get(index);
		}
		
	}

=======
	
	
>>>>>>> 14c46aa32f8e7dff24521fe2638cfdda0d3601b5
}
