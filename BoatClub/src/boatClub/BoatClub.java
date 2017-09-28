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
	
	public void addMemmber(String name, String personalNR) {
		int id = getNewId();
		Member member = new Member(name, personalNR, id);
		members.add(member);
		reg.addMember(member);
	}
	
	public ArrayList<Member> MemberList(){
		return members;
	}
	
	
	public void deleteMember(int id){
		int i = findMemberPos(id);
		members.remove(i);
		uppdateRegistry();
	}
	
	public Member viewMember(int id){
		int i = findMemberPos(id);
		return members.get(i);
	}
	
	public void registerBoat(int id, int lenght, Boat.boatType boatType){
		int i = findMemberPos(id);
		Member member = members.get(i);
		member.addBoat(lenght, boatType);
		uppdateRegistry();
	}
	
	public void deleteBoat(int id, int index){
		int i = findMemberPos(id);
		members.get(i).deleteBoats(index);
		uppdateRegistry();
		
	}
	public void changeBoaT(int id, int index, int size, Boat.boatType boatType){
		int i = findMemberPos(id);
		members.get(i).changeBoat(index, size, boatType);
		uppdateRegistry();
	}
	
	private int findMemberPos(int id) {
		for(int i = 0; i < members.size(); i++ ) {
			Member member = members.get(i);
			if(member.getId() == id) {
				return i;
			}
		}
		
		
		return 0;
		
	}
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
