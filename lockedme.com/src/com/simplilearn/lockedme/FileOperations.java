package com.simplilearn.lockedme;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



import com.simplilearn.lockedme.*;




public class FileOperations implements Screen {
	
	private DirPlace theDirectory = new DirPlace();
	
	private ArrayList<String> choices = new ArrayList<>();

    public FileOperations() {
    	
    	choices.add("1. Put a file");
        choices.add("2. Now delete a file");
        choices.add("3. We want to look for file");
        choices.add("4. Go back");
        
    }
    
    @Override
    public void show() {
    	System.out.println("File Options Menu");
        for (String s : choices) {
            System.out.println(s);
        }

    }

    public void inp() {
        int selectedOption;
        while ((selectedOption = this.options()) != 4) {
            this.navinv(selectedOption);
        }
    }

    @Override
    public void navinv(int option) {
        
    	switch(option) {

            case 1: 
                this.fAdd();
                
                this.show();
                break;
            case 2: 
                this.delFile();
                
                this.show();
                break;
            case 3: 
                this.fileLook(null);
                this.show();
                break;
           
            default:
                System.out.println("Invalid Option");
                break;
                
                
        }

    }
    
   

    public void fAdd() {
    	System.out.println("File name please:");

        String fileName = this.stringInp();

        System.out.println("File name: " + fileName);
        
		try {
			Path path = FileSystems.getDefault().getPath(DirPlace.name + fileName).toAbsolutePath();
			File file = new File(theDirectory.getName() + fileName);
			
		      if (file.createNewFile()) {
		    	  System.out.println("File that is made: " + file.getName());
		    	  theDirectory.getFiles().add(file);
		    	  
		      } else {
		        System.out.println("It is there.");
		      }
		}catch (IOException e){
			System.out.println(e);
		}
	}
        
    
    
    public void delFile() {
    	
    	System.out.println("File name please:");

        String fileName = this.stringInp();

        System.out.println("Delete the file: " + fileName);
        
        
	  
        
		Path path = FileSystems.getDefault().getPath(DirPlace.name + fileName).toAbsolutePath();
		File file = path.toFile();
	      if (file.delete()) {
	    	  System.out.println("File that is removed: " + file.getName());
	    	  theDirectory.getFiles().remove(file);
	      } else {
	        System.out.println("It failed to remove:" + fileName + ", file was not found.");
	      }
    }
    
    public void fileLook(String filename) {
    	
		Boolean found = false;
    	
    	System.out.println("File name please:");

        String fileName = this.stringInp();

        System.out.println("Searching for file: " + fileName);
        
       
        
        ArrayList<File> files = theDirectory.getFiles();
        
        
        for(int i = 0; i < files.size(); i++) {
			if(files.get(i).getName().equals(fileName)) {
				System.out.println("Found " + fileName);
				found = true;
			}
        }
        if (found == false) {
        	System.out.println("File not found");
        }
    }
    
    private String stringInp() {

        Scanner in = new Scanner(System.in);
        return(in.nextLine());

    }
    
    private int options() {
        Scanner in = new Scanner(System.in);

        int giveOp = 0;
        try {
            giveOp = in.nextInt();
        }
        catch (InputMismatchException ex) {
        	System.out.println("Invalid input");
        }
        return giveOp;

    }

}

