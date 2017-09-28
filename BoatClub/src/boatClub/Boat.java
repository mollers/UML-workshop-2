package boatClub;

public class Boat {
	private int length;
	private String type;
	
	public Boat(int i, String t){
		setSize(i);
		setType(t);
	}
	
	public void setSize(int i){
		length = i;
	}
	
	public int getSize(){
		return length;
	}
	
	public void setType(String t){
		type = t;
	}
	
	public String getType(){
		return type;
	}
	
	
}
