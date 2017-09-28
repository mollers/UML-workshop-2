package boatClub;

import java.util.ArrayList;
import boatClub.Boat.boatType;
public class BoatClub {
	private Regestry tmp1;
	private Controller controll;
	
	private Arraylist<Member> members;
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
			System.out.println("name: "+mebmbers[i].getName()+
					" id: "+members[i].getId()+
					" amount of boats: "+members[i].getgetNumberOfBoats());
		}
	}
	
	public void vMemberList(){
		//get list from 
		for(int i = 0; i < members.size(); i++ ){
			System.out.println("Name: "+mebmbers[i].getName()+
					" Id: "+members[i].getId()+
					" PersonalNR: "+members[i].getPersonalNR()+
					" Amount of boats: "+members[i].getgetNumberOfBoats());
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
