package view;

import java.io.IOException;
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
		return getInputChar() != "q";
	}
	public boolean checkInput(String input) {
		if(input.length() <= 0)
		{
			return false;
		}
		if(input.toCharArray()[0] == 'q')
		{
				return true;
		}
		try {
		    Integer.parseInt(input);
		    if(Integer.valueOf(input) < 0 || Integer.valueOf(input) > 8) {
		    	return false;
		    }
		    
		} catch (NumberFormatException e) {
			return false;
		    
		}
		return true;
	}

	public String getInputChar(){
		try {
			input = scan.nextLine();
			
			while(!checkInput(input)) {
				System.err.println("Please enter a number displayed in the meny or q");
				Thread.sleep(1);
				System.out.print("Command: ");
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
			case "q": return "q";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return input;
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
	}

	private void verboseList(){
		for (model.Member m: theJollyPirate.MemberList()){
			System.out.println(m.toString());
		}
	}

	private void deleteMember(){
		System.out.println("Please enter ID of the member you want to delete.");
		System.out.print("Id: ");
		int i = scan.nextInt();
		theJollyPirate.deleteMember(i);
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
	}

	private void deleteBoat(){
		scan.nextLine();
		System.out.println("Please enter id of member.");
		int id = scan.nextInt();

		scan.nextLine();
		System.out.println("Please enter index of boat");
		int i = scan.nextInt();

		theJollyPirate.deleteBoat(id, i);
	}

	private void changeBoatInfo() throws IOException{
		System.out.println("Please enter id of member.");
		int id = Integer.parseInt(scan.nextLine());

		System.out.println("Please enter index of members boat.");
		int index = Integer.parseInt(scan.nextLine());

		System.out.println("Please enter new length of members boat.");
		int length = Integer.parseInt(scan.nextLine());

		System.out.println("Please enter boat type of boat.");
		model.Boat.boatType t = Boat.boatType.valueOf(scan.nextLine());

		theJollyPirate.changeBoaT(id, index, length, t);
	}
}
