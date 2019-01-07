import Controller.GUIController;
import View.GUI;

public class Demo {

	public static void main(String[] args) {
		GUI gui = new GUI();
		@SuppressWarnings("unused")
		GUIController controller = new GUIController(gui);
	}

}
