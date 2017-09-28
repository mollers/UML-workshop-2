package boatClub;

import java.util.ArrayList;

public class RegistryMainTest {

	public static void main(String[] args) {
		Registry reg = new Registry();
		
		ArrayList<Boat> boats = new ArrayList<Boat>();
		boats.add(new Boat(4,Boat.boatType.valueOf("Other")));
		boats.add(new Boat(1000,Boat.boatType.valueOf("Motorsailer")));
		
		long start = System.currentTimeMillis();
		
		for(int i = 0; i < 3; i++) {
			
			reg.addMember(new Member("Emil Mattsson", "920718-1190", i, boats));
		}
		
		
		ArrayList<Member> reqMembers = reg.loadRegistry();
		long end = System.currentTimeMillis();
		
		System.out.println("TIME:" + (end-start));
		/*for(int i = 0; i < reqMembers.size(); i++){
			System.out.println(reqMembers.get(i).getName());
			System.out.println(reqMembers.get(i).getPersonalNR());
			System.out.println(reqMembers.get(i).getId());
			ArrayList<Boat> boats = reqMembers.get(i).getBoats();
			for(int j = 0; j < boats.size();j++) {
				System.out.println(boats.get(j).getType());
				System.out.println(boats.get(j).getLength());
			}
		}*/
	}

}
