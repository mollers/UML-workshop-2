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
		Member memb = new Member(name, personalNR, id);
		members.add(memb);
	}
	
	public void cMemberList(){
		//get list from registry print name, member id and amount of boats
		for(int i = 0; i < members.size(); i++ ){
			Member member = members.get(i);
			System.out.println("name: "+ member.getName()+
					" id: "+member.getId()+
					" amount of boats: "+member.getNumberOfBoats());
		}
	}
	
	public void vMemberList(){
		//get list from 
		for(int i = 0; i < members.size(); i++ ){
			System.out.println("Name: "+members.get(i).getName()+
					" Id: "+members.get(i).getId()+
					" PersonalNR: "+members.get(i).getPersonalNR()+
					" Amount of boats: "+members.get(i).getNumberOfBoats());
		}
	}
	
	public void deleteMember(int id){
		
	}
	
	public void viewMember(int id){
		
	}
	
	public void registerBoat(int id, int lenght, Boat.boatType boatType){
		
	}
	
	public void deleteBoat(int id, int index){
		
	}
	public void changeBoaT(int id, int index, int size, Boat.boatType boatType){
		
	}
}
