package com.simplilearn.lockedme;

import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;


public class DirPlace {

   public static final String name = "../files";

   
    private ArrayList<File> files = new ArrayList<File>();
    
    Path path = FileSystems.getDefault().getPath(name).toAbsolutePath();
    
    File myFiles = path.toFile();
       
    public String getName() {
        return name;
    }
    
    public void display() {
    	System.out.println("Existing Files: ");
    	files.forEach(f -> System.out.println(f));
    }

    public ArrayList<File> fillFiles() {
    	
        File[] dirF = myFiles.listFiles();
        
        
        
    	files.clear();
    	for (int i = 0; i < dirF.length; i++) {
    		if (dirF[i].isFile()) {
    			files.add(dirF[i]);
    		}
    	}
    	
    	Collections.sort(files);
    	
    	return files;
    }

    public ArrayList<File> getFiles() {
    	
    	fillFiles();
    	return files;
    }
    
    
   
    
}
