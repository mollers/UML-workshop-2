package model;

import java.util.ArrayList;

public class BoatClub {

	private ArrayList<Member> members;
	private Registry reg = new Registry();

	public void init(){
		members = reg.loadRegistry();
	}
	// Adding member to the existing registry
	public void addMember(String name, String personalNR) {
		int id = getNewId();
		Member member = new Member(name, personalNR, id);
		members.add(member);
		reg.addMember(member);
	}

	public ArrayList<Member> MemberList(){
		return members;
	}

	public boolean changeMemberInfo(int id, String name, String personalNR){
		int i = findMemberPos(id);
		if(i == -1) {
			return false;
		}else {
			members.get(i).setName(name);
			members.get(i).setPersonalNR(personalNR);
			reg.changeMember(members);
			return true;
		}

	}

	//delete member with the given id
	public boolean deleteMember(int id){
		int i = findMemberPos(id);
		if(i == -1) {
			return false;
		}
		else {
			members.remove(i);
			reg.changeMember(members);
			return true;
		}

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
		reg.changeMember(members);
		//uppdateRegistry();
	}
	//remove boat from the member
	public void deleteBoat(int id, int index){
		int i = findMemberPos(id);
		members.get(i).deleteBoats(index);
		reg.changeMember(members);
		//uppdateRegistry();

	}
	//change info of the existing boat to new info given
	public void changeBoat(int id, int index, int size, Boat.boatType boatType){
		int i = findMemberPos(id);
		members.get(i).changeBoat(index, size, boatType);
		reg.changeMember(members);
		//uppdateRegistry();
	}
	//gives the position in the arraylist for the member with the given id
	private int findMemberPos(int id) {
		for(int i = 0; i < members.size(); i++ ) {
			Member member = members.get(i);
			if(member.getId() == id) {
				return i;
			}
		}
		return -1;
	}
	public boolean memberExists(int id) {
		boolean exists = (findMemberPos(id) == -1);
		if(exists){
			return false;
		}
		else {
			return true;
		}
	}
	public boolean boatExists(int memberID, int boatIndex) {
		try {
			this.members.get(findMemberPos(memberID)).getBoats().get(boatIndex);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}

	// checks the previous highest id of members and gives a new id that is not held
	private int getNewId() {
		int i = members.size();
		if(0 < i) {
			return members.get(i-1).getId() + 1;
		}
		return 1;
	}
	/*
	private void uppdateRegistry() {
		// delete exissting registry
		for(int i = 0; i < members.size(); i++) {
			reg.addMember(members.get(i));
		}
	}*/
}
