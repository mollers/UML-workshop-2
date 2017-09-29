package execute;
import model.BoatClub;
import view.view;

public class Program {

	public static void main(String[] args) {
		
		BoatClub b = new BoatClub();
		b.init();
		view v = new view(b);
		v.displayMenu();
		
		while (v.usingSystem()){
			
			v.getInputChar();
		}
		
	}
}
