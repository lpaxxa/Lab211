/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import DAO.ProductDAO;
import DAO.ProductDAOImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vile
 */
public class Validator {
    public static boolean isValidYear(int year){
        try{
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
         return year>=1817 && year <=currentYear;
        }catch(NumberFormatException e){
            System.out.println("Must be a number !!!");
            return false;
        }
       
    }
    
    public static boolean isPositive(double number){
        return number >0;
    }
    
    public static boolean returnToMainMenu(){
        String ans;
        do{
    Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to go back to the main menu: ");
        ans = sc.nextLine();
        if(ans.equalsIgnoreCase("yes")){
            return true;
        }else if (ans.equalsIgnoreCase("no")){
            return false;
        }else{
            System.out.println("Invalid option. Please type 'yes' or 'no' " );
        } 
        
    }while (!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no"));
         return true;
        }
    
    public static boolean isValidBrandId(String id) throws IOException{
        ProductDAO product = new ProductDAOImpl();
        product.loadFromFile();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Brand.txt"));
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                if( parts[0].equalsIgnoreCase(id) ){
                    return true;
                   
                }
            }
          
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
        
        return false;
    }
    public static boolean isValidCategoryId(String id)throws IOException{
        ProductDAO product = new ProductDAOImpl();
        product.loadFromFile();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("Category.txt"));
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                if(parts[0].equalsIgnoreCase(id)){
                    return true;
                }
            }
            
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        return false;
    }
    public static String formattedString(String input){
        String[] words = input.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(Character.toTitleCase(word.charAt(0)))
                  .append(word.substring(1))
                  .append(" ");
            
        }
        return result.toString().trim();
    }
}

    
    

