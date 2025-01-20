/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import pojo.Product;
import utils.Validator;

/**
 *
 * @author vile
 */
public class ProductDAOImpl extends ArrayList<Product> implements ProductDAO {

    @Override
    public void create(Product product) {

        Scanner sc = new Scanner(System.in);

        //id
        while (true) {
            boolean isDuplicated = false;
            System.out.println("Enter the product ID (Axxx): ");
            String id = sc.nextLine();
            if (!id.isEmpty() && id.matches("A\\d{3}")
                    || id.matches("a\\d{3}")) {
                for (Product products : this) {
                    if (id.equalsIgnoreCase(products.getId())) {
                        System.err.println("Duplicated ID !!!");
                        isDuplicated = true;
                        break;
                    }

                }
                if (isDuplicated == false) {
                    product.setId(Validator.formattedString(id));
                    break;
                }

            } else {
                System.err.println("Invalid ID!!!");
            }

        }

        //name
        do {
            System.out.println("Enter the product's name");
            String name = sc.nextLine();
            if (!name.isEmpty()) {
                product.setName(Validator.formattedString(name));
                break;
            } else {
                System.err.println("Please enter the name !!!!");
            }

        } while (true);
        // brand
        do {
            try {
                System.out.println("Enter brand: ");
                String brandId = sc.nextLine();
                if (Validator.isValidBrandId(brandId) && !brandId.isEmpty()) {
                    product.setBrandId(Validator.formattedString(brandId));
                    break;
                } else {
                    System.err.println("Invalid Brand");
                }
            } catch (IOException ex) {
                System.out.println("Invalid Brand ");
            }
        } while (true);
        //category
        do {
            try {
                System.out.println("Enter Category:");
                String categoryId = sc.nextLine();
                if (Validator.isValidCategoryId(categoryId)) {
                    product.setCategoryId(Validator
                            .formattedString(categoryId));
                    break;
                } else {
                    System.err.println("Invalid Category!");
                }

            } catch (IOException e) {
                System.err.println("Invalid Category");
            }

        } while (true);
        //model year
        do {
            try {
                System.out.println("Enter the model year(1817-current): ");
                int modelYear = sc.nextInt();
                if (Validator.isValidYear(modelYear)) {
                    product.setModelYear(modelYear);
                    break;
                } else {
                    System.err.println("Invalid input"
                            + ".Please enter the model year(1817-current) !!!");
                }
            } catch (Exception e) {
                System.err.println("Invalid input"
                        + ".Please enter a valid year (1817-current) !!!");
                sc.nextLine();
            }
        } while (true);

        //listprice
        do {
            try {
                System.out.println("Enter the product's price:");
                double listPrice = sc.nextDouble();
                if (listPrice > 0) {
                    product.setListPrice(listPrice);
                    break;
                } else {
                    System.err.println("Invalid input!!!");
                    
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please try again !!!");
                sc.nextLine();
            }
        } while (true);

        this.add(product);
        saveToFile();
        System.out.println("Product Added successfully");

    }

    @Override
    public void search(String name) {
        

        if (this.isEmpty() || name.isEmpty() ) {
            System.err.println("Have no any product");
        } else {
          List<Product> matchingProducts =  this.stream()
                    .filter(product -> product.getName().toLowerCase()
                    .contains(name.toLowerCase()))
                    .sorted(Comparator.comparing(Product::getModelYear))
                    .toList();
          
          if(matchingProducts.isEmpty()){
              System.out.println("No products found with the name: " + name );
          }else{
              matchingProducts.forEach(product 
                      -> System.out.println(product.toString()));
          }

        }

    }

    @Override
    public void update(String id) {
        Scanner sc = new Scanner(System.in);
        Product pro = this.stream()
                .filter(product -> product.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
        if (pro == null) {
            System.out.println("Product does not exist!!!");
            return;
        }
        System.out.println("UPADTE THE PRODUCT: ");
        //ID
        String newCode;
        do {
            System.out.println("Enter the product's code (Axxx)");
            newCode = sc.nextLine().toLowerCase();
            boolean isDuplicated = false;

            if (!newCode.isEmpty() && newCode.matches("a\\d{3}")
                    || newCode.matches("A\\d{3}")) {
                for (Product product : this) {
                    if (newCode.equals(product.getId().toLowerCase())) {
                        System.out.println("Duplicated code !!!");
                        isDuplicated = true;
                        break;
                    }
                }
                if (isDuplicated == false) {
                    pro.setId(Validator.formattedString(newCode));
                    break;

                }

            }
        } while (!newCode.isEmpty());

        //name
        System.out.println("Enter the product's name");
        String newName = sc.nextLine();
        if (!newName.isEmpty()) {
            pro.setName(Validator.formattedString(newName));

        } else {
            System.out.println("No input. Keeping the old name");

        }

        //brand
        String brandID;
        try {
            do {
                System.out.println("Enter the brand ID name: ");
                brandID = sc.nextLine();

                if (!brandID.isEmpty() && Validator.isValidBrandId(brandID)) {
                    pro.setName(brandID);
                    break;

                } else {
                    System.out.println("Invalid input"
                            + ". Keeping the old brand Id !");
                }
            } while (!Validator.isValidBrandId(brandID));

        } catch (IOException e) {
            System.err.println("Invalid input.");
        }
        //category
        String categoryID;

        try {

            do {
                System.out.println("Enter the category ID name: ");
                categoryID = sc.nextLine();
                if (!categoryID.isEmpty()
                        && Validator.isValidCategoryId(categoryID)) {
                    pro.setName(categoryID);
                    break;
                } else {
                    System.out.println("Invalid input. Keeping the old category");
                }
            } while (!Validator.isValidCategoryId(categoryID));
        } catch (IOException ex) {
           System.err.println("Invalid input.");
                  
        }

        //model year
        String modYear = "";
        boolean isValidYear = false;
        do {
            try {

                System.out.println("Enter ther product's model year(1871- current): ");
                modYear = sc.nextLine();
                if (!modYear.isEmpty()) {
                    if (Validator.isValidYear(Integer.parseInt(modYear))
                            && modYear.matches("^-?\\d+$")) {
                        pro.setModelYear(Integer.parseInt(modYear));
                        isValidYear = true;
                        break;
                    }
                }
                if (isValidYear == false) {
                    System.out.println("Invalid input. Keeping the old year");
                }

            } catch (NumberFormatException e) {
                System.err.println("Must be a number !!!");
            }

        } while (!modYear.isEmpty());

        //listprice
        boolean isPositive = false;
        String listPrice = "";
        do {
            try {
                System.out.println("Enter the product's list price: ");
                listPrice = sc.nextLine();
                if (!listPrice.isEmpty()) {
                    if (Validator.isPositive(Double.parseDouble(listPrice))
                            && listPrice.matches("^-?\\d+(\\.\\d+)?$")) {
                        pro.setListPrice(Double.parseDouble(listPrice));
                        isPositive = true;
                        break;
                    }
                }  if (isPositive == false) {
                    System.out.println("Invalid input.");
                }

            } catch (NumberFormatException e) {
                System.err.println("Must be a number");

            }

        } while (!listPrice.isEmpty());

        saveToFile();
        System.out.println("Updated Successfully");

    }

    @Override
    public void delete(String id) {
       Scanner sc = new Scanner(System.in);
        Product pro = this.stream()
               .filter(product -> product.getId().equalsIgnoreCase(id))
               .findFirst()
                .orElse(null);
       if( pro == null){
           System.out.println("Product does not exist.");
       }else{
           System.out.println("Are you sure about"
                   + " deleting this product (yes/no) ?");
           String ans = sc.nextLine();
           if(ans.equalsIgnoreCase("yes")){
               this.remove(pro);
               System.out.println("Product has been removed.");
           }
           else if (ans.equalsIgnoreCase("no")){
               System.err.println("Delete Failed!");
           }
       }
       
   
       
        
       

    }

    @Override
    public void saveToFile() {

        try (BufferedWriter writer
                = new BufferedWriter(new FileWriter("Product.txt"))) {
            for (Product p : this) {
                writer.write(p.toString());
                writer.newLine();

            }
            System.out.println("Products saved to file successfully");
        } catch (IOException e) {
            System.err.println("Error at saving to file " + e.getMessage());
        }
    }

    @Override
    public void print() {
       Collections.sort(this, Comparator.comparing(Product::getListPrice)
                .reversed()
                .thenComparing(Product::getName));
        for (Product product1 : this) {
            System.out.println(product1.toString());
        }
       
       

    }

  
    @Override
    public void loadFromFile() {
        try {
            BufferedReader reader
                    = new BufferedReader(new FileReader("Product.txt"));
            String line;
            while ((line = reader.readLine()) != null) {

                if (line.isEmpty()) {
                    continue;
                }

                String[] tmp = line.split(",");
                if (tmp.length != 6) {
                    System.out.println("Invalid data format" + line);
                    continue;
                }
                Product result = new Product();
                result.setId(tmp[0].trim());
                result.setName(tmp[1].trim());
                result.setBrandId(tmp[2].trim());
                result.setCategoryId(tmp[3].trim());
                result.setModelYear(Integer.parseInt(tmp[4].trim()));
                result.setListPrice(Double.parseDouble(tmp[5].trim()));

                this.add(result);

            }
            reader.close();

        } catch (IOException | NumberFormatException e) {
            System.out.println("Failed to read data");

        }
    }
        //them chhức năng tìm product có modYear >=x( x nhập từ bàn phím) và cho biết có tất cả bao nhiêu product dc tim thấy

    @Override
    public void findProduct(int x) {
        List<Product> product = this.stream()
                .filter(bike -> bike.getModelYear()>= x)
                .toList();
        if(product.isEmpty()){
            System.out.println("No products have been found");
        }else{
            System.out.println("The list of products with price greater than x is:");
            product.forEach(pro ->System.out.println( pro.toString()));
            System.out.println("The number of those products is: ");
            System.out.println(product.size());
        }
                
    }

}
