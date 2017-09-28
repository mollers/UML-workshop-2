package view;

import java.util.Scanner;

public class view {
	
	public view() { 
		
	}
	
	public void displayMenu(){
		System.out.println(
			"==Boatclub Menu== \n"+
			"0: Create new member \n"+
			"1: Compact memmber list\n"+
			"2: Verbose memmber list\n"+
			"3: Delete memmber\n"+
			"4: Change memmber info\n"+
			"5: View member\n"+
			"6: Register boat\n"+
			"7: Delete boat\n"+
			"8: Change boat info\n"+
			"type the number in consloe and endter with enter"
				);
	}
	
	public void getInputChar(){
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		
		if (input < 0){
			System.err.println("Please enter an integer equals or higher than 0.");
		}
	}
}
