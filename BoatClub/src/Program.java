import boatClub.BoatClub;
import view.Controller;
import view.view;

public class Program {

	public static void main(String[] args) {
		
		BoatClub b = new BoatClub();
		b.init();
		view v = new view(b);
		Controller c = new Controller();
		
		c.useBoatClubSystem(b, v);
		
	}
}
