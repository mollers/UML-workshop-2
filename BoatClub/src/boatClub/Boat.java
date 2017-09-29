package boatClub;

public class Boat {
	private int length;
	private boatType type;
	
	public Boat(int i, boatType t){
		if (i < 1){
			// Maybe move this error handling to view?
			System.err.println("A boat can't be shorter than 1");
			//this.type = t;
			
		} else {
			this.length = i;
			this.type = t;
		}
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
		return "Type: " + this.type + " Length: " + this.length + "\n";
	}
}
