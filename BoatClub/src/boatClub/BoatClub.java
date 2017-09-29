package boatClub;

import java.util.ArrayList;

public class BoatClub {
	private Registry tmp1;
	//private Controller controll;
	
	private ArrayList<Member> members;
	private String[] memberInfo;
	private Registry reg = new Registry();
	
	public void init(){
		members = reg.loadRegistry();
	}
	// Adding member to the existing registry
	public void addMemmber(String name, String personalNR) {
		int id = getNewId();
		Member member = new Member(name, personalNR, id);
		members.add(member);
		reg.addMember(member);
	}
	
	public ArrayList<Member> MemberList(){
		return members;
	}
	
	//delete member with the given id
	public void deleteMember(int id){
		int i = findMemberPos(id);
		members.remove(i);
		uppdateRegistry();
	}
	//returns the member with the given id
	public Member viewMember(int id){
		int i = findMemberPos(id);
		return members.get(i);
	}
	//adds boat to the member
	public void registerBoat(int id, int lenght, Boat.boatType boatType){
		int i = findMemberPos(id);
		Member member = members.get(i);
		member.addBoat(lenght, boatType);
		uppdateRegistry();
	}
	//remove boat from the member
	public void deleteBoat(int id, int index){
		int i = findMemberPos(id);
		members.get(i).deleteBoats(index);
		uppdateRegistry();
		
	}
	//change info of the exizting boat to new info given
	public void changeBoaT(int id, int index, int size, Boat.boatType boatType){
		int i = findMemberPos(id);
		members.get(i).changeBoat(index, size, boatType);
		uppdateRegistry();
	}
	//gives the position in the arraylist for the member with the given id
	private int findMemberPos(int id) {
		for(int i = 0; i < members.size(); i++ ) {
			Member member = members.get(i);
			if(member.getId() == id) {
				return i;
			}
		}
		
		
		return 0;
		
	}
	
	// checks the previous highest id of members and gives a new id that is not held
	private int getNewId() {
		int i = members.size();
		if(0 < i) {
			return members.get(i-1).getId() + 1;
		}
		return 1;
	}
	private void uppdateRegistry() {
		// delete exissting registry
		for(int i = 0; i < members.size(); i++) {
			reg.addMember(members.get(i));
		}
	}
}
