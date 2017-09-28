package boatClub;

import java.util.ArrayList;

public class BoatClub {
	private Registry tmp1;
	//private Controller controll;
	
	private ArrayList<Member> members;
	private String[] memberInfo;
	
	
	public void init(){
		Registry reg = new Registry();
		members = reg.loadRegistry();
	}
	
	public void addMemmber(String name, String personalNR) {
		// uppdate registry
		int id = getNewId();
		Member memb = new Member(name, personalNR, id);
		members.add(memb);
	}
	
	public ArrayList<Member> MemberList(){
		return members;
	}
	
	
	public void deleteMember(int id){
		//uppdate registry
		int i = findMemberPos(id);
		members.remove(i);
	}
	
	public Member viewMember(int id){
		int i = findMemberPos(id);
		return members.get(i);
	}
	
	public void registerBoat(int id, int lenght, Boat.boatType boatType){
		// uppdate registry
		int i = findMemberPos(id);
		Member member = members.get(i);
		member.addBoat(lenght, boatType);
	}
	
	public void deleteBoat(int id, int index){
		//uppdate registery
		int i = findMemberPos(id);
		members.get(i).deleteBoats(index);
		
	}
	public void changeBoaT(int id, int index, int size, Boat.boatType boatType){
		//uppdate registery
		int i = findMemberPos(id);
		members.get(i).changeBoat(index, size, boatType);
	}
	
	private int findMemberPos(int id) {
		//need fix for not a existing id
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
}
