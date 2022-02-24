package functions;

import screens.FileOperationsScreen;
import screens.LockedMeScreen;
import screens.WelcomeScreen;

public class ScreenFunctions {

	// object of welcome screen class
	public static WelcomeScreen WelcomeScreen = new WelcomeScreen();
	// object of file operations screen class
	public static FileOperationsScreen FileOperationsScreen = new FileOperationsScreen();
	// assigning welcome screen to current screen
	public static LockedMeScreen CurrentScreen = WelcomeScreen;	
		
	// getter
	public static LockedMeScreen getCurrentScreen() {
			return CurrentScreen;		
	}
	// setter
	public static void setCurrentScreen(LockedMeScreen currentScreen) {
			CurrentScreen = currentScreen;
	}
}
