package view;

import java.util.Scanner;

public class view {
	Scanner scan = new Scanner(System.in);
	private int input;
	private boatClub.BoatClub theJollyPirate;
	
	public view(boatClub.BoatClub b) { 
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
	}
	
	public boolean usingSystem(){
		return getInputChar() != 'q';
	}
	
	public int getInputChar(){
		try {
			
			
			do {
				System.err.println("Please enter a number displayed in the meny.");
				input = scan.nextInt();
			}while(input > 0);
			
			switch (input){
				case 0: addMember();
					break;
				case 1: 
					break;
				case 2:	System.out.println("hello");
					break;
				case 3:
					break;
				case 4:
					break;
				case 5: viewMember();
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
				default: input = 'q';
					break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		int input = scan.nextInt();
		
		if (input < 0){
			System.err.println("Please enter an integer equals or higher than 0.");
			
			while (input < 0){
				input = scan.nextInt();
				
				if (input >= 0) break;
			}
		}
		
		switch (input){
			case 0: addMember();
				break;
				
			case 1: 
		}*/
		return input;
	}
	
	private void addMember(){
		System.out.println("Please enter name of new member.");
		String name = getInput();
		
		System.out.println("Please enter personal number of new member in the following format yymmdd-xxxx");
		String pn = getInput();
		
		theJollyPirate.addMemmber(name, pn);
	}
	
	private String getInput(){
		return scan.nextLine();
	}
	
	private void getCompactList(){
		theJollyPirate.MemberList();
	}
	
	private void viewMember(){
		System.out.println(theJollyPirate.viewMember(0).toString());
	}
}
