package model;

public class Boat {
	private int length;
	private boatType type;

	public Boat(int i, boatType t){
		this.length = i;
		this.type = t;
	}

	public enum boatType{
		Sailboat, Motorsailer, Kayak_Canoe, Other
	}

	public void setLength(int i){
		this.length = i;
	}

	public int getLength(){
		return this.length;
	}

	public void setType(boatType t){
		this.type = t;
	}

	public boatType getType(){
		return this.type;
	}

	public String toString(){
		return "Boat: " + this.type + " Length: " + this.length;
	}
}
