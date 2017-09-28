package boatClub;

public class RegistryMainTest {

	public static void main(String[] args) {
		Member member = new Member("Emil Bengtsson", "941008-6897", 1);
		Boat boat = new Boat(6, Boat.boatType.Sailboat);
		Boat boat2 = new Boat(150, Boat.boatType.Other);
		
		member.addBoat(boat);
		member.addBoat(boat2);
		Registry register = new Registry();
		register.addMember(member);
		register.addMember(member);
		register.addMember(member);
	}

}
