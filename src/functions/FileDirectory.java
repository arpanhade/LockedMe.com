package functions;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class FileDirectory {

	public static final String filepath = "src\\directory\\";	
	private ArrayList<File> files = new ArrayList<File>();
		
	File DirFiles = new File(filepath);
		
	public static String getName() {
	    return filepath;
	}
		
	public void showFiles() {
	    System.out.println("Existing Files: ");
	    for (var f : files)  {
	        System.out.println(f);
	    }
	}
	
	public ArrayList<File> getFiles() {
	    	
	    File[] directoryFiles = DirFiles.listFiles();
	    	
	    for (int i = 0; i < directoryFiles.length; i++) {  		
	    	files.add(directoryFiles[i]);
	    }
		Collections.sort(files);
	    return files;
	   }	
}
