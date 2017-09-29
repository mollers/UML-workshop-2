package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Boat;

public class view {
	
	final Scanner scan = new Scanner(System.in);
	private String input;
	private model.BoatClub theJollyPirate;
	
	public view(model.BoatClub b) { 
		theJollyPirate = b;
	}
	
	public void displayMenu(){
		System.out.println(
			"==Boatclub Menu== \n"+
			"0: Create new member \n"+
			"1: Compact member list\n"+
			"2: Verbose member list\n"+
			"3: Delete member\n"+
			"4: Change member info\n"+
			"5: View member\n"+
			"6: Register boat\n"+
			"7: Delete boat\n"+
			"8: Change boat info\n"+
			"type the number in console and enter with enter"
				);
		System.out.print("Command: ");
	}
	
	public boolean usingSystem(){
		return getInputChar() != 'q';
	}
	
	public int getInputChar(){
		try {
			input = scan.nextLine();
			
			while (Integer.valueOf(input) < 0 || Integer.valueOf(input) > 8){
				System.err.println("Please enter a number displayed in the meny.");
				input = scan.nextLine();
			}
			
			switch (input){
				case "0": addMember();
					break;
				case "1": compactList();
					break;
				case "2":	verboseList();
					break;
				case "3":	deleteMember();
					break;
				case "4":	changeMemberInfo();
					break;
				case "5": viewMember();
					break;
				case "6":	registerBoat();
					break;
				case "7":	deleteBoat();
					break;
				case "8":	changeBoatInfo();
					break;
				default: input = "q";
					break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Integer.valueOf(input);
	}
	
	private void addMember(){
		System.out.println("Enter name of new member and press enter");
		System.out.print("Name: ");
		String name = getInput();
		
		System.out.println("Please enter personal number of new member in the following format yymmdd-xxxx");
		System.out.print("PersonalNR: ");
		String pn = getInput();
		
		theJollyPirate.addMemmber(name, pn);
		System.out.println("Member added!");
		displayMenu();
	}
	
	private void compactList(){
		for (model.Member m: theJollyPirate.MemberList()){
			System.out.println(m.getCompactInfo());
		}
		displayMenu();
	}
	
	private void verboseList(){
		for (model.Member m: theJollyPirate.MemberList()){
			System.out.println(m.toString());
		}
		displayMenu();
	}
	
	private void deleteMember(){
		System.out.println("Please enter ID of the member you want to delete.");
		int i = scan.nextInt();
		theJollyPirate.deleteMember(i);
		displayMenu();
	}
	
	private void changeMemberInfo(){
		displayMenu();
	}
	
	private String getInput(){
		
		String s = "";
		try {
			
			while (scan.hasNextLine()){
				s = scan.nextLine();
				if (s != "") break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	private void getCompactList(){
		theJollyPirate.MemberList();
		displayMenu();
	}
	
	private void viewMember(){
		System.out.println("Please enter ID of member.");
		System.out.print("Id: ");
		int id = scan.nextInt();
		
		System.out.println(theJollyPirate.MemberList().get(id-1).toString());
	}
	
	private void printMemberInfo(model.Member m){
		System.out.println("Name: " + m.getName() + " personalNr: " + m.getPersonalNR() + " ID: " + m.getId());
		
		for (int i = 0; i < m.getNumberOfBoats(); i++){
			System.out.println("Boat " + (i + 1) + ": " + m.getBoats().get(i).toString());
		}
	}
	
	private void registerBoat(){
		scan.nextLine();
		System.out.println("Please enter member ID.");
		int i = scan.nextInt();
		
		System.out.println("Please enter length of boat.");
		int l = scan.nextInt();
		
		scan.nextLine();
		System.out.println("Please enter boat type.");
		model.Boat.boatType type = Boat.boatType.valueOf(scan.nextLine());
		
		theJollyPirate.registerBoat(i, l, type);
		displayMenu();
	}
	
	private void deleteBoat(){
		scan.nextLine();
		System.out.println("Please enter id of member.");
		System.out.print("Member Id: ");
		int id = scan.nextInt();
		
		System.out.println(theJollyPirate.MemberList().get(id-1).toString());
		
		scan.nextLine();
		System.out.println("Please enter index of boat");
		System.out.print("Boat index: ");
		int i = scan.nextInt();
		
		theJollyPirate.deleteBoat(id, i);
		displayMenu();
	}
	
	private void changeBoatInfo(){
		displayMenu();
	}
}
