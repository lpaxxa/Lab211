/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pojo.Product;

/**
 *
 * @author vile
 */
public class ProductDAOImplTest {
    
    public ProductDAOImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of create method, of class ProductDAOImpl.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Product product = null;
        ProductDAOImpl instance = new ProductDAOImpl();
        instance.create(product);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class ProductDAOImpl.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String name = "";
        ProductDAOImpl instance = new ProductDAOImpl();
        instance.search(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ProductDAOImpl.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        String id = "";
        ProductDAOImpl instance = new ProductDAOImpl();
        instance.update(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ProductDAOImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String id = "";
        ProductDAOImpl instance = new ProductDAOImpl();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveToFile method, of class ProductDAOImpl.
     */
    @Test
    public void testSaveToFile() {
        System.out.println("saveToFile");
        ProductDAOImpl instance = new ProductDAOImpl();
        instance.saveToFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class ProductDAOImpl.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        ProductDAOImpl instance = new ProductDAOImpl();
        instance.print();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadFromFile method, of class ProductDAOImpl.
     */
    @Test
    public void testLoadFromFile() {
        System.out.println("loadFromFile");
        ProductDAOImpl instance = new ProductDAOImpl();
        instance.loadFromFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findProduct method, of class ProductDAOImpl.
     */
    @Test
    public void testFindProduct() {
        System.out.println("findProduct");
        int x = 0;
        ProductDAOImpl instance = new ProductDAOImpl();
        instance.findProduct(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
