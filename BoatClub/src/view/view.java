package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Boat;
import model.Member;

public class view {

	final Scanner scan = new Scanner(System.in);
	private String input = "";
	private model.BoatClub theJollyPirate;

	public view(model.BoatClub b) { 
		theJollyPirate = b;
	}

	public void displayMenu(){
		System.out.println(
				"......................\n" +
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
						"9: Display menu\n"+
						"type the number in console and enter with enter\n" + 
						"......................"
				);
		System.out.print("Command: ");
	}
	/**
	 * A function to determine if the program should continue to run.
	 * @return boolean, true if input is not q, false otherwise
	 */
	public boolean usingSystem(){
		return input.compareTo("q") != 0;
	}
	/**
	 *  This function checks the input when command is to be chosen.
	 * @param input, the input that should be checked.
	 * @return boolean, true if input is menu option or q (quit)
	 */
	private boolean checkInput(String input) {
		if(input.length() <= 0)
		{
			return false;
		}
		if(input.toCharArray()[0] == 'q')
		{
			return true;
		}
		try {	
			if(Integer.valueOf(input) < 0 || Integer.valueOf(input) > 9 || input.length() > 1) {
				return false;
			}

		} catch (NumberFormatException e) {
			return false;

		}
		return true;
	}
/**
 * This function waits for the next command input, and determine which command that should be executed. I
 */
	public void getInputChar(){
		try {
			input = scan.nextLine();

			while(!checkInput(input)) {
				System.err.println("Please enter a number displayed in the menu or q");
				Thread.sleep(1);
				nextCommand();
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
			case "9": displayMenu();
			break;
			case "q": System.out.println("Program has been shut down");;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void nextCommand() {
		System.out.println("......................");
		System.out.print("Next command: ");
	}
	/**
	* Takes two inputs, checks if they are in the scope of what's accepted, and if they are, the member are added.
	*/
	private void addMember(){
		System.out.println("ADD MEMBER - or insert b to go back to menu");
		System.out.println("Enter name of new member and press enter or b to go back to menu");
		System.out.print("Name: ");
		String name = scan.nextLine();
		if(name.compareTo("b") == 0)
		{
			nextCommand();
		}
		else {
			System.out.println("Please enter personal number of new member in the following format yymmdd-xxxx or b to go back to menu");
			System.out.print("PersonalNR: ");
			String pn = scan.nextLine();

			if(pn.compareTo("b") == 0){
				nextCommand();
			}else {
				theJollyPirate.addMember(name, pn);
				System.out.println("Member added!");
				nextCommand();
			}		
		}		
	}
/**
 * Gets all members from boatClub and print a compact representation of them.
 */
	private void compactList(){
		int i = 0;
		System.out.println("COMPACTLIST");
		for (model.Member m: theJollyPirate.MemberList()){
			System.out.println("Member " + (++i) + ": " + "Name: " + m.getName() + " ID: " + m.getId() + " Boats: " + m.getNumberOfBoats());
		}
		nextCommand();
	}
/**
 *  Gets all members from boatClub and print a verbose representation of them.
 */
	private void verboseList(){
		System.out.println("VERBOSELIST");
		for (model.Member m: theJollyPirate.MemberList()){
			StringBuffer sb = new StringBuffer();
			sb.append("Name: " + m.getName() + " Personal number: " + m.getPersonalNR() + " ID: " + m.getId() + "\n");
			ArrayList<Boat> boats = m.getBoats();
			for (int i = 0; i < boats.size(); i++) {
				sb.append("Boat: " + boats.get(i).getType() + " Length: " + boats.get(i).getLength() + " ID: " + i + "\n");
			}
			System.out.println("Member: " + sb.toString());
		}
		nextCommand();
	}
/**
 *  Deletes the member that corresponds to the input value, if invalid id is entered, you get to the command choosing phase again.
 * @throws InterruptedException, if any thread has interrupted the current thread. The interrupted status of the current thread is cleared when this exception is thrown.
 */
	private void deleteMember() throws InterruptedException{
		System.out.println("DELETE MEMBER - or insert b to go back to menu");
		System.out.println("Please enter ID of the member you want to delete");
		System.out.print("Id: ");
		String id = scan.nextLine();
		if(id.compareTo("b") == 0) {
			nextCommand();
		}else if (!isInteger(id)) {
			System.err.println("Input expected to be integer or \"b\"");
			Thread.sleep(1);
			nextCommand();
		}else {
			if(theJollyPirate.memberExists(Integer.valueOf(id))){
				theJollyPirate.deleteMember(Integer.valueOf(id));
				System.out.println("Member deleted!");
				nextCommand();
			}
			else {
				System.err.println("Unvalid id, try again");
				nextCommand();
			}
		}

	}
/**
 * Takes inputs, check if the inputs are valid, and change the member information corresponding to the inputs.
 * @throws InterruptedException, if any thread has interrupted the current thread. The interrupted status of the current thread is cleared when this exception is thrown.
 */
	private void changeMemberInfo() throws InterruptedException{
		System.out.println("CHANGE MEMBER INFO - or insert b to go back to menu");
		System.out.println("Please enter id of member.");
		System.out.print("ID: ");
		String id = scan.nextLine();
		if(id.compareTo("b ") == 0) {
			nextCommand();
		}else if (!isInteger(id)) {
			System.err.println("Input expected to be integer or \"b\"");
			Thread.sleep(1);
			nextCommand();
		}else if(!theJollyPirate.memberExists(Integer.valueOf(id))){
			System.err.println("Invalid id, try again");
			nextCommand();
		}else {
			System.out.println("Please enter new name of member.");
			System.out.print("New name: ");
			String name = scan.nextLine();
			if(name.compareTo("b") == 0)
			{
				nextCommand();
			}else {
				System.out.println("Please enter new personal number of member.");
				System.out.print("persNR: ");
				String pn = scan.nextLine();
				if(pn.compareTo("b") == 0)
				{
					nextCommand();
				}else {
					theJollyPirate.changeMemberInfo(Integer.valueOf(id), name, pn);
					nextCommand();
				}
			}
		}
	}
	/**
	* Checks for id input, if input is a valid member ID, the member is printed to the console.
	*/
	private void viewMember() throws InterruptedException{
		System.out.println("VIEW MEMBER - or insert b to go back to menu.");
		System.out.println("Please enter ID of member.");
		System.out.print("Id: ");
		String id = scan.nextLine();
		if(id.compareTo("b") == 0) {
			nextCommand();
		}else if (!isInteger(id)) {
			System.err.println("Input expected to be integer or \"b\"");
			Thread.sleep(1);
			nextCommand();
		}else {
			try {
				Member m = theJollyPirate.viewMember(Integer.valueOf(id));
				StringBuffer sb = new StringBuffer();
				sb.append("Name: " + m.getName() + " Personal number: " + m.getPersonalNR() + " ID: " + m.getId() + "\n");
				ArrayList<Boat> boats = m.getBoats();
				for (int i = 0; i < boats.size(); i++) {
					sb.append("Boat: " + boats.get(i).getType() + " Length: " + boats.get(i).getLength() + " ID: " + i + "\n");
				}
				System.out.println("Member: " + sb.toString());
				nextCommand();
			}
			catch(Exception e) {
				System.err.println("Invalid id number, try again!");
				nextCommand();
			}
		}


	}
/**
 *  Takes inputs, and register a new boat with type and length corresponding to inputs, to member corresponding to input. The inputs values are checked.
 * @throws InterruptedException
 */
	private void registerBoat() throws InterruptedException{
		System.out.println("REGISTER BOAT - or insert b to go back to menu.");
		System.out.println("Please enter member ID.");
		System.out.print("ID: ");
		String memberID = scan.nextLine();
		if(memberID.compareTo("b") == 0) {
			nextCommand();
		}else if (!isInteger(memberID)) {
			System.err.println("Input expected to be integer or \"b\"");
			Thread.sleep(1);
			nextCommand();
		}else if(!theJollyPirate.memberExists(Integer.valueOf(memberID))){
			System.out.println("Member doesn't exists");
			nextCommand();
		}
		else {
			System.out.println("Please enter length of boat.");
			System.out.print("Length: ");
			String boatLength = scan.nextLine();

			if(boatLength.compareTo("b") == 0) {
				nextCommand();
			}else if (!isInteger(boatLength)) {
				System.err.println("Input expected to be integer or \"b\"");
				Thread.sleep(1);
				nextCommand();
			}else if(Integer.valueOf(boatLength) <= 0) {
				System.err.println("The length have to be longer then 0");
				Thread.sleep(1);
				nextCommand();
			}else {
				System.out.println("Please enter boat type. 0 - > Sailboat, 1 -> Motorsailer, 2 -> Kayak_Canoe, 3 -> Other");
				System.out.print("Type: ");
				model.Boat.boatType boatType = null;
				boolean validInput = false;
				String type = scan.nextLine();
				switch(type) {
				case "0": boatType = Boat.boatType.Sailboat;
				validInput = true;
				break;
				case "1": boatType = Boat.boatType.Motorsailer;
				validInput = true;
				break;
				case "2": boatType = Boat.boatType.Kayak_Canoe;
				validInput = true;
				break;
				case "3": boatType = Boat.boatType.Other;
				validInput = true;
				break;
				case "b": nextCommand();
				break;
				default : System.err.println("Input didn't match any boat type, try again"); 
				Thread.sleep(1);
				nextCommand();
				}
				if(validInput) {
					theJollyPirate.registerBoat(Integer.valueOf(memberID), Integer.valueOf(boatLength), boatType);
					nextCommand();
				}
			}
		}
	}
/**
 * Deletes boat the corresponds to member id and boat id that's entered by user. The inputs are checked.
 * @throws InterruptedException
 */
	private void deleteBoat() throws InterruptedException{
		System.out.println("DELETE BOAT - or insert b to go back to menu.");
		System.out.println("Please enter id of member.");
		System.out.print("Member ID: ");
		String memberID = scan.nextLine();
		if(memberID.compareTo("b") == 0) {
			nextCommand();
		}else if (!isInteger(memberID)) {
			System.err.println("Input expected to be integer or \"b\"");
			Thread.sleep(1);
			nextCommand();
		}else if(!theJollyPirate.memberExists(Integer.valueOf(memberID))) {
			System.err.println("Invalid member ID");
			Thread.sleep(1);
			nextCommand();
		}else {
			System.out.println("Please enter index of boat");
			System.out.print("Boat index: ");
			String boatID = scan.nextLine();
			if(boatID.compareTo("b") == 0) {
				nextCommand();
			}else if (!isInteger(boatID)) {
				System.err.println("Input expected to be integer or \"b\"");
				Thread.sleep(1);
				nextCommand();
			}else {
				if(theJollyPirate.boatExists(Integer.valueOf(memberID),Integer.valueOf(boatID)))
				{
					theJollyPirate.deleteBoat(Integer.valueOf(memberID), Integer.valueOf(boatID));
					nextCommand();
				} else {
					System.err.println("Invalid boat index");
					Thread.sleep(1);
					nextCommand();
				}			
			}
		}
	}
 /**
  * Change boat information to the boat the corresponds to the inputs, the inputs are checked and verified. 
  * @throws InterruptedException
  */
	private void changeBoatInfo() throws InterruptedException{
		System.out.println("CHANGE BOAT INFO - or insert b to go back to menu.");
		System.out.println("Please enter id of member.");
		System.out.print("Member ID: ");
		String memberID = scan.nextLine();
		if(memberID.compareTo("b") == 0) {
			nextCommand();
		}else if (!isInteger(memberID)) {
			System.err.println("Input expected to be integer or \"b\"");
			Thread.sleep(1);
			nextCommand();
		}else if(!theJollyPirate.memberExists(Integer.valueOf(memberID))) {
			System.err.println("Invalid member ID");
			nextCommand();
		}else {
			System.out.println("Please enter index of members boat.");
			System.out.print("Boat index: ");
			String boatIndex = scan.nextLine();
			if(boatIndex.compareTo("b") == 0) {
				nextCommand();
			}else if (!isInteger(boatIndex)) {
				System.err.println("Input expected to be integer or \"b\"");
				Thread.sleep(1);
				nextCommand();
			}else if(!theJollyPirate.boatExists(Integer.valueOf(memberID), Integer.valueOf(boatIndex))) {
				System.err.println("Invalid boat index");
				Thread.sleep(1);
				nextCommand();
			}else {
				System.out.println("Please enter new length of members boat.");
				System.out.print("Boat length: ");
				String boatLength = scan.nextLine();
				if(boatLength.compareTo("b") == 0) {
					nextCommand();
				}else if (!isInteger(boatLength)) {
					System.err.println("Input expected to be integer or \"b\"");
					Thread.sleep(1);
					nextCommand();
				}else if(Integer.valueOf(boatLength) <= 0) {
					System.err.println("The length have to be longer then 0");
					Thread.sleep(1);
					nextCommand();
				} else {
					System.out.println("Please enter boat type. 0 - > Sailboat, 1 -> Motorsailer, 2 -> Kayak_Canoe, 3 -> Other");
					System.out.print("Type: ");
					model.Boat.boatType boatType = null;
					boolean validInput = false;
					String type = scan.nextLine();
					switch(type) {
					case "0": boatType = Boat.boatType.Sailboat;
					validInput = true;
					break;
					case "1": boatType = Boat.boatType.Motorsailer;
					validInput = true;
					break;
					case "2": boatType = Boat.boatType.Kayak_Canoe;
					validInput = true;
					break;
					case "3": boatType = Boat.boatType.Other;
					validInput = true;
					break;
					case "b": nextCommand();
					break;
					default : System.err.println("Input didn't match any boat type, try again"); 
					Thread.sleep(1);
					nextCommand();
					}
					if(validInput) {
						theJollyPirate.changeBoat(Integer.valueOf(memberID), Integer.valueOf(boatIndex), Integer.valueOf(boatLength), boatType);
						nextCommand();
					}
				}
			}
		}
	} 
	/**
	 * Checks if string can be parsed to a integer.
	 * @param str, input string that will be changed if it's a integer.
	 * @return boolean, true if @param str, can be parsed to a integer, otherwise false.
	 */
	private boolean isInteger(String str) {
		try {
			Integer.valueOf(str);
			return true;
		}catch (Exception e){
			return false;
		}
	}
}
