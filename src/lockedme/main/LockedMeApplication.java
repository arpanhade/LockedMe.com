package lockedme.main;
import screens.WelcomeScreen;

public class LockedMeApplication {

	public static void main(String[] args) {
		
		WelcomeScreen welcomescreen = new WelcomeScreen();
		welcomescreen.showWelcomeMessge();
		welcomescreen.getInputFromUser();
	}
}
