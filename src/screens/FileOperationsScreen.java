package screens;

import functions.DirectoryFunctions;
import functions.FileDirectory;
import functions.ScreenFunctions;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileOperationsScreen implements LockedMeScreen{

	FileDirectory fileDirectory = new FileDirectory();
	
	private ArrayList<String> operations = new ArrayList<>();

    public FileOperationsScreen() {    	
    	operations.add("1. Add a File");
    	operations.add("2. Delete a File");
    	operations.add("3. Search a File");
    	operations.add("4. Navigate to Main Menu");       
    }
	
	@Override
	public void showMenu() {
		System.out.println();
		System.out.println("****File Operations Menu*****");
        for (var s : operations)  {
            System.out.println(s);
        }
	}

	@Override
	public void navigateOption(int option) {
		switch (option) {
		
		case 1: {
			this.addFile();
			this.showMenu();
			break;
		}	
		case 2: {
			this.deleteFile();            
            this.showMenu();	
			break;
		}
		case 3: {
			this.searchFile();
			this.showMenu();
			break;
		}
		case 4: {
			System.out.println("Navigating to Main Menu");
			System.out.println("\n");
			ScreenFunctions.setCurrentScreen(ScreenFunctions.WelcomeScreen);
			ScreenFunctions.getCurrentScreen().showMenu();			
			ScreenFunctions.getCurrentScreen().getInputFromUser();
			break;
		}
		default:
			 System.out.println("Please enter correct option");
             break;		
		}		
	}

	@Override
	public void getInputFromUser() {
		int userInput = 0;
		// !=5 exit condition
		// check invalid input getNavigateOption 
		while((userInput = this.getNavigateOption()) != 5){
			this.navigateOption(userInput);
		}		
	}
	
	private int getNavigateOption() {
		Scanner input = new Scanner(System.in);
		int option = 0;
		
		try {
			System.out.println();
			System.out.println("Enter File Operation");
			option = input.nextInt();
		
		} catch (InputMismatchException | IllegalArgumentException ex) {
			System.out.println("Please enter valid input");		
		}		
		return option;		
	}
	
	public void deleteFile() {
		
		System.out.println("Enter Filename with extension you want to Delete");
		String fileName = this.getFileNameFromUser();
		System.out.println("You are deleting file : " + fileName);
		System.out.println();
		
	    Path filepath = FileSystems.getDefault().getPath(FileDirectory.filepath + fileName).toAbsolutePath();
	    File file = filepath.toFile();
	    
	    if (file.delete()) {
			System.out.println("Deleted File : " + file.getName());
			fileDirectory.getFiles().remove(file);
			DirectoryFunctions.displayFiles();
	    }
	    else {
	        System.out.println("Failed to delete file:" + fileName + ", file was not found.");
	    }		
	}
	
	public void addFile() {
		
		System.out.println("Please Enter the Filename with extension you want to Add:");
		String fileName = this.getFileNameFromUser();
        System.out.println("You are adding a file named : " + fileName);
        System.out.println();
        
        try {
        	File file = new File(FileDirectory.getName() + fileName);
    	    if (file.createNewFile()) {
    	    	System.out.println("File Added Successfully : " + file.getName());
    	    	fileDirectory.getFiles().add(file);
    	    	DirectoryFunctions.displayFiles();
    	    }
    	    else
    		    System.out.println("This File Already Exits, no need to add another");	   	    		
        } catch (IOException e) {
			System.out.println(e);
		}		
	}
	
	public void searchFile() {
		
		Boolean found = false;
		System.out.println("Enter Filename with extension you want to Search");
		String fileName = this.getFileNameFromUser();
		System.out.println("You are searching for a file : " + fileName);
		System.out.println();
		ArrayList<File> files = fileDirectory.getFiles();
		
		for(int i = 0; i < files.size(); i++) {
			if(files.get(i).getName().equals(fileName)) {
				//System.out.println("Found " + fileName);
				found = true;								
			}								
		}		
		if (found == false) {
			System.out.println("File not found");
		}
		else {
			System.out.println("File found");
		}
	}
	
	public String getFileNameFromUser() {
		Scanner sc = new Scanner(System.in);
		String filename = sc.nextLine();
		return filename;
	}
}
