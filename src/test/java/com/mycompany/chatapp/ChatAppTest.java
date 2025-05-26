/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.chatapp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RC_Student_lab
 */
public class ChatAppTest {
 

    public ChatAppTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Setting up before all tests.");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Tearing down after all tests.");
    }

    @Before
    public void setUp() {
        System.out.println("Setting up before a test.");
    }

    @After
    public void tearDown() {
        System.out.println("Cleaning up after a test.");
    }

    /** Helper method to indicate success in a test. */
    private void success() {
        System.out.println("Test passed.");
    }

    /** Helper method to fail a test with a custom message. */
    private void failure(String message) {
        fail("Test failed: " + message);
    }

    @Test
    public void testMain() {
        System.out.println("Testing main method...");
        String[] args = {};
        try {
            ChatApp.main(args);
            success();
        } catch (Exception e) {
            failure("Main method threw exception: " + e.getMessage());
        }
    }

    @Test
    public void testLogin() {
        System.out.println("Testing login...");
        try {
            boolean result = ChatApp.login(); // Assume this is stubbed or adjusted for test
            assertTrue("Expected login to succeed", result);
            success();
        } catch (Exception e) {
            failure("Login method threw exception: " + e.getMessage());
        }
    }

    @Test
    public void testSendMessage() {
        System.out.println("Testing sendMessage...");
        try {
            ChatApp.sendMessage();
            success();
        } catch (Exception e) {
            failure("sendMessage threw exception: " + e.getMessage());
        }
    }

    @Test
    public void testSaveMessagesToJSON() {
        System.out.println("Testing saveMessagesToJSON...");
        try {
            ChatApp.saveMessagesToJSON();
            success();
        } catch (Exception e) {
            failure("saveMessagesToJSON threw exception: " + e.getMessage());
        }
    }
}
