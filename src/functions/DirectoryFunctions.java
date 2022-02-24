package functions;

import java.io.File;
import java.util.ArrayList;

public class DirectoryFunctions {

	private FileDirectory FileDir = new FileDirectory();
	
	public static void displayFiles() {
		
		FileDirectory fileDirectory = new FileDirectory();
		ArrayList<File> files = fileDirectory.getFiles();
		System.out.println();
		System.out.println("Available files in System : ");
		System.out.println("---------------------------");
		for(int i = 0; i < files.size(); i++) {			
			System.out.println((1+i) +". "+ files.get(i).getName());								
		}
	}
	// getter
	public FileDirectory getFileDirectory() {
        return FileDir;
    }
}
