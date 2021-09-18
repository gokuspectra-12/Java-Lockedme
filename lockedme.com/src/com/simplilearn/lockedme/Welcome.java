package com.simplilearn.lockedme;



import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Welcome implements Screen {

    private String greet = "Welcome to VirtualKey!";
    private String myText = "Developer: Gokulraj Pandiyaraj";

    private ArrayList<String> options = new ArrayList<>();


    public Welcome() {
        options.add("1. Show Files");
        options.add("2. Show File Options Menu");
        options.add("3. Quit");

    }
    
    public void introWS() {
    	System.out.println(greet);
        System.out.println(myText);
        System.out.println("\n");
        show();
    }
    
    
    
    @Override
    public void show() {
    	System.out.println("Main Menu");
        for (String s : options)  {
            System.out.println(s);
        }

    }

    public void inp() {
        int clickOp  = 0;
        while ((clickOp = this.options()) != 3) {
            this.navinv(clickOp);
        }
    }

    @Override
    public void navinv(int option) {
        switch(option) {

            case 1: 
                this.ShowFiles();
                
                this.show();
                
                break;
                
            case 2:
            	LookScreen.setCurrentScreen(LookScreen.fileoperations);
                LookScreen.getCurrentScreen().show();
                LookScreen.getCurrentScreen().inp();
                
                this.show();
                
                break;
                
            default:
                System.out.println("Invalid Option");
                break;
        }
        
    }

    public void ShowFiles() {

      

        System.out.println("List of Files: ");
    	serv.PrintFiles();

    }
    
    private int options() {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {

        }
        return returnOption;

    }
}
