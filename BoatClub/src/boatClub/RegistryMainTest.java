package boatClub;

import java.util.ArrayList;

public class RegistryMainTest {

	public static void main(String[] args) {
		Registry reg = new Registry();
		
		ArrayList<Boat> boats = new ArrayList<Boat>();
		boats.add(new Boat(4,Boat.boatType.valueOf("Other")));
		boats.add(new Boat(1000,Boat.boatType.valueOf("Motorsailer")));
		ArrayList<Member> members = new ArrayList<Member>();
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < 10; i++) {
			
			members.add(new Member("Emil Mattsson", "920718-1190", (i), boats));
		}
		for(int i = 0; i < members.size(); i++) {
			reg.addMember(members.get(i));
		}
		
		members.get(3).setName("Andreas Möller");
		
		reg.changeMember(members);
		
		long end = System.currentTimeMillis();
		
		System.out.println("TIME:" + (end-start));
		/*for(int i = 0; i < reqMembers.size(); i++){
			System.out.println();
			System.out.println(reqMembers.get(i).getName());
			System.out.println(reqMembers.get(i).getPersonalNR());
			System.out.println(reqMembers.get(i).getId());
			ArrayList<Boat> boats2 = reqMembers.get(i).getBoats();
			for(int j = 0; j < boats2.size();j++) {
				System.out.println(boats2.get(j).getType());
				System.out.println(boats2.get(j).getLength());
			}
		}*/
		
		
	}

}
