/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author James
 */
public class RequestAccountControllerTest {
    
    public RequestAccountControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of initController method, of class RequestAccountController.
     */
    @Test
    public void testInitController() {
        System.out.println("initController");
        RequestAccountController instance = new RequestAccountController();
        instance.initController();
        fail("The test case is a prototype.");
    }
    
}
