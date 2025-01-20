/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vile
 */
public class MenuImpl extends ArrayList<String> implements Menu{
     public MenuImpl(){
        super();
    }
    
    @Override
    public void addItem(String s){
        this.add(s);
        return;
    }
    
    @Override
    public int getChoice(){
        int result=0;
        for (int i=0; i<this.size(); i++)
            System.out.println((i+1) + ". " + this.get(i));
//        System.out.println(this.get(this.size()-1));
        System.out.println("____________________________");
        System.out.println();
        System.out.print("Select 1 ... 6: ");
        while(true){
        try{
        Scanner sc = new Scanner(System.in);
        result = Integer.parseInt(sc.nextLine()); // get user choice
        break;
        }catch(Exception e){
            System.out.println("Invalid input. Please enter a numbers");
        }
        }
        return result;
    }

  
}
