package boatClub;

import java.util.ArrayList;
import boatClub.Boat.boatType;

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
		// get id from rgeistry and uppdate registry and change new highest id
		int id = 0;
		Member memb = new Member(name, personalNR, id);
		members.add(memb);
	}
	
	public ArrayList<Member> MemberList(){
		return members;
	}
	
	
	public void deleteMember(int id){
		int i = findMemberPos(id);
		members.remove(i);
	}
	
	public Member viewMember(int id){
		int i = findMemberPos(id);
		return members.get(i);
	}
	
	public void registerBoat(int id, int lenght, Boat.boatType boatType){
		int i = findMemberPos(id);
		Member member = members.get(i);
	}
	
	public void deleteBoat(int id, int index){
		
	}
	public void changeBoaT(int id, int index, int size, Boat.boatType boatType){
		
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
}
