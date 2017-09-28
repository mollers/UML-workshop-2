package boatClub;

public class Boat {
	private int length;
	private type t;
	
	public Boat(int i, type t){
		if (i < 1){
			System.err.println("A boat can't be shorter than 1");
			this.t = t;
			
		} else {
			this.length = i;
			this.t = t;
		}
	}
	
	public enum type{
		Sailboat, Motorsailer, Kayak_Canoe, Other
	}
	
	public void setLength(int i){
		length = i;
	}
	
	public int getLength(){
		return length;
	}
	
	public void setType(type t){
		this.t = t;
	}
	
	public type getType(){
		return this.t;
	}
	
	
}
