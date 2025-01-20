/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import pojo.Product;

/**
 *
 * @author vile
 */
public interface ProductDAO {
    void create(Product product);
    void search(String name);
    void update(String id);
    void delete(String id);
    void loadFromFile();
    void saveToFile();
    void print();
    void findProduct(int x);
   // void printName(String name);
}
