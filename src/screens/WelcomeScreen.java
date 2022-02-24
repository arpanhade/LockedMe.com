package screens;

import functions.DirectoryFunctions;
import functions.ScreenFunctions;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WelcomeScreen implements LockedMeScreen{

	private String welcomeText = "Welcome to LockedMe.com";
    private String developerText = "Developed by Arpan Hade";

    private ArrayList<String> options = new ArrayList<>();
	
    // constructor
	public WelcomeScreen() {
		options.add("1. Display Available Files");
        options.add("2. Go to File Operations Menu");
        options.add("3. Exit");
	}

	public void showWelcomeMessge() {
		System.out.println(welcomeText);
        System.out.println(developerText);
        System.out.println("\n");
        showMenu();
	}
	
	@Override
	public void showMenu() {
		System.out.println("**********Main Menu**********");
        for (var s : options)  {
            System.out.println(s);
        }		
	}

	@Override
	public void navigateOption(int option) {
		switch (option) {
		
		case 1: {
			this.showFiles();
			break;
		}	
		case 2: {			
			ScreenFunctions.setCurrentScreen(ScreenFunctions.FileOperationsScreen);
			ScreenFunctions.getCurrentScreen().showMenu();			
			ScreenFunctions.getCurrentScreen().getInputFromUser();
			this.showMenu();
			break;
		}
		/*
		case 3 : {
			System.out.println("Thank You!");
			System.out.println("Visit Again");
		}
		*/
		default:			
			System.out.println("Please enter correct option");
            break;		
		}		
	}

	@Override
	public void getInputFromUser() {
		
		int userInput = 0;
		// !=3 exit condition
		// check invalid input at getNavigateOption 
		while((userInput = this.getNavigateOption()) != 3){
			// this.navigateMenu(userInput);
			this.navigateOption(userInput);
		}	
	}
	
	private int getNavigateOption() {
		Scanner input = new Scanner(System.in);
		int option = 0;
		
		try {
			System.out.println();
			System.out.println("Enter Your Choice");
			option = input.nextInt();
		
		} catch (InputMismatchException | IllegalArgumentException ex) {
			System.out.println("Please enter valid input");		
		}		
		return option;		
	}
	
	public void showFiles() {
      		
		DirectoryFunctions.displayFiles();
	}    	
}
