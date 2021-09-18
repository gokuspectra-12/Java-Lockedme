package com.simplilearn.lockedme;

import com.simplilearn.lockedme.FileOperations;
import com.simplilearn.lockedme.Screen;
import com.simplilearn.lockedme.Welcome;
import com.simplilearn.lockedme.DirPlace;



public class LookScreen {
	
	
	
	
	
	public static Welcome welcome = new Welcome();
    public static FileOperations fileoperations = new FileOperations();
    
    

    public static Screen screenNow = welcome;

    
    public static Screen getCurrentScreen() {
        return screenNow;
    }

    
    public static void setCurrentScreen(Screen currentScreen) {
        screenNow = currentScreen;
    }
    
    
    
}

