package view;

public class Controller {
	
	public void useBoatClubSystem(boatClub.BoatClub b, view v){
		
		v.displayMenu();
		
		while (v.usingSystem()){
			v.getInputChar();
		}
	}
	
}
