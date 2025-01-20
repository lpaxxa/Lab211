/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Validator;

/**
 *
 * @author vile
 */
public class Product {

    private String id;
    private String name;
    private String brandId;
    private String categoryId;
    private int modelYear;
    private double listPrice;

    public Product() {
    }

    public Product(String id, String name, String brandId, String categoryId, int modelYear, double listPrice) {
        this.id = id;
        this.name = name;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.modelYear = modelYear;
        this.listPrice = listPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        boolean isDuplicated = false;
        //id
        do {
            System.out.println("Enter the product ID (Axxx)");
            id = sc.nextLine();
            if (!id.isEmpty() && id.matches("A\\d{3}") || id.matches("a\\d{3}")) {
                if (isDuplicated == true) {
                    setId(Validator.formattedString(id));
                }
                break;
            } else {
                System.out.println("Please enter the product's ID");
                isDuplicated = false;

            }
        } while (true);

        //name
        do {
            System.out.println("Enter the product's name");
            name = sc.nextLine();
            if (!name.isEmpty()) {
                setName(name);
                break;
            } else {
                System.out.println("Please enter the name !!!!");
            }

        } while (true);
        // brand
        do {
            try {
                System.out.println("Enter brand id:");
                brandId = sc.nextLine();
                if (Validator.isValidBrandId(brandId)) {
                    System.out.println("Valid");
                    break;
                }
            } catch (IOException ex) {
                System.out.println("Invalid Brand ID!");
            }
        } while (true);
        //category
        do {
            try {
                System.out.println("Enter Category ID:");
                categoryId = sc.nextLine();
                if (Validator.isValidCategoryId(categoryId)) {
                    System.out.println("Valid category");
                    break;
                }

            } catch (IOException e) {
                System.out.println("Invalid Category ID");
            }

        } while (true);
        //model year
        do {
            try {
                System.out.println("Enter the model year: ");
                modelYear = sc.nextInt();
                if (Validator.isValidYear(modelYear)) {
                    setModelYear(modelYear);
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input.Please enter a valid year !!!");
                sc.nextLine();
            }
        } while (true);

        //listprice
        do {
            try {
                System.out.println("Enter the product's price:");
                listPrice = sc.nextDouble();
                if (Validator.isPositive(listPrice)) {
                    setListPrice(listPrice);
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again !!!");
                sc.nextLine();
            }
        } while (true);

    }

    @Override
    public String toString() {

        return String.format("%s,%s,%s,%s,%d,%.2f ",
                 id, Validator.formattedString(name), Validator.formattedString(brandId), Validator.formattedString(categoryId), modelYear, listPrice);
    }

}
