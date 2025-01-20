/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bikestoremanagement;

import DAO.ProductDAO;
import DAO.ProductDAOImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import pojo.Product;
import utils.Menu;
import utils.MenuImpl;

/**
 *
 * @author vile
 */
public class ManageBike {

    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        ProductDAO productDAO = new ProductDAOImpl();
        productDAO.loadFromFile();
        Menu menu = new MenuImpl();
        String id, name;
        String ans;

        menu.addItem("Create a product");
        menu.addItem("Search a product");
        menu.addItem("Update a product");
        menu.addItem("Delete a product");
        menu.addItem("Save to File");
        menu.addItem("Print list product from the file");
        menu.addItem("Print products with price greater than x");
        menu.addItem("Enter any number to exit");
        //  menu.addItem("Print Name");
        int choice;

        boolean quit = false;
        do {

            System.out.println("\nBike Store Management");
            System.out.println();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    do {
                        Product p = new Product();
                        productDAO.create(p);
                        System.out.println("Do you want to go back to the main menu (yes/no) ?");
                        ans = sc.nextLine();
                        if (ans.equalsIgnoreCase("yes")) {
                            break;
                        }
                    } while (ans.equals("no"));
                    break;

                case 2:
                    do {
                        System.out.println("Enter the product's name: ");
                        name = sc.nextLine();
                        productDAO.search(name);
                        System.out.println("Do you want to go back to the main menu (yes/no) ?");
                        ans = sc.nextLine();
                        if (ans.equalsIgnoreCase("yes")) {
                            break;
                        }
                    } while (ans.equals("no"));
                    break;

                case 3:
                    do {
                        System.out.println("Enter the product's id (Axxx): ");
                        id = sc.nextLine();
                        productDAO.update(id);
                        System.out.println("Do you want to go back to the main menu (yes/no) ?");
                        ans = sc.nextLine();
                        if (ans.equalsIgnoreCase("yes")) {
                            break;
                        }
                    } while (ans.equals("no"));
                    break;
                case 4:
                    do {
                        System.out.println("Enter the product's id:");
                        id = sc.nextLine();
                        productDAO.delete(id);

                        System.out.println("Do you want to go back to the main menu (yes/no) ?");
                        ans = sc.nextLine();
                        if (ans.equalsIgnoreCase("yes")) {
                            break;
                        }
                    } while (ans.equals("no"));
                    break;
                case 5:
                    do {
                        productDAO.saveToFile();
                        System.out.println("Do you want to go back to the main menu (yes/no) ?");
                        ans = sc.nextLine();
                        if (ans.equalsIgnoreCase("yes")) {
                            break;
                        }
                    } while (ans.equals("no"));
                    break;
                case 6:
                    do {
                        productDAO.print();
                        System.out.println("Do you want to go back to the main menu (yes/no) ?");
                        ans = sc.nextLine();

                        if (ans.equalsIgnoreCase("yes")) {
                            break;
                        }

                    } while (ans.equals("no"));
                    break;

                case 7:

                    do {
                        System.out.println("Enter x: ");
                        int x = sc.nextInt();
                        productDAO.findProduct(x);

                        System.out.println("Do you want to go back to the main menu (yes/no) ?");
                        ans = sc.nextLine();
                        if (ans.equalsIgnoreCase("yes")) {
                            break;
                        }

                    } while (ans.equals("no"));
                    break;

                default:
                    System.out.println("Exiting...");

            }

        } while (choice >= 1 && choice <= 7);
    }

}
