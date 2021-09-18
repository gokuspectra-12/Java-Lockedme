package com.simplilearn.lockedme;

import java.io.File;

import com.simplilearn.lockedme.DirPlace;

public class serv {

    private static DirPlace fDir= new DirPlace();
    
    public static void PrintFiles() {
    	
    	fDir.fillFiles();

        for (File file : serv.getFileDirectory().getFiles())
        {
            System.out.println(file.getName());
        }
    }
    public static DirPlace getFileDirectory() {
        return fDir;
    }

    public static void setFileDirectory(DirPlace fDir) {
        serv.fDir = fDir;
    }


}

