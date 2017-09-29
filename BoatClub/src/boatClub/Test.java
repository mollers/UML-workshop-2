package boatClub;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Registry reg = new Registry();
		ArrayList<Boat> boats = new ArrayList<Boat>();
		boats.add(new Boat(4,Boat.boatType.valueOf("Other")));
		boats.add(new Boat(1000,Boat.boatType.valueOf("Motorsailer")));
		reg.addMember(new Member("Emil Mattsson", "920718-1190", 1, boats));
		

	}

}
