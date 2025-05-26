/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 *
 * @author RC_Student_lab
 */
public class ChatApp {
    private static int totalMessage = 0;
    private static int messageCounter = 0;
    private static JSONArray messageStorage = new JSONArray();

    private static boolean exit;

    public static void main(String[] args) {
         if (!login()) return;

    JOptionPane.showMessageDialog(null, "Welcome to we communicate.");

    int maxMessages = 0;
    while (true) {
        String input = JOptionPane.showInputDialog("How many messages would you like to enter?");
        try {
            maxMessages = Integer.parseInt(input);
            if (maxMessages > 0) break;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid positive number.");
        }
    }

    boolean exit = false;
    while (!exit) {
        String[] options = { "Send Message", "Show Recently Sent Messages", "Quit" };
        int choice = JOptionPane.showOptionDialog(null, "Choose an option", "we communicate Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0: // Send Message
                if (messageCounter < maxMessages) {
                sendMessage();
            } else {
                    JOptionPane.showMessageDialog(null, "Message limit reached.");
                }
                break;

            case 1: // Coming Soon
                JOptionPane.showMessageDialog(null, "Coming Soon.");
                break;

            case 2: // Quit
                exit = true;
                break;

            default:
                JOptionPane.showMessageDialog(null, "Invalid option.");
        
    JOptionPane.showMessageDialog(null, "Total messages sent: " + totalMessage);
    saveMessagesToJSON();

        }}
     String[] options ={"send message","show Recently sent Massage","Quit"};
      int choice = JOptionPane.showOptionDialog( null, "Choose an option:", "QuickChat Menu", JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
             
              switch(choice){
                   case 1://coming soon
                       JOptionPane.showMessageDialog(null,"coming soon");
                       break;
                   case 2: //Quit
               exit = true;

                   default:
                       JOptionPane.showMessageDialog(null,"invalid option");     
               }}
        static boolean login() {
    String user = JOptionPane.showInputDialog("Enter username:");
    String pass = JOptionPane.showInputDialog("Enter password:");

    if ("Mtshali".equals(user) && "M@bo123".equals(pass)) {
        return true;
    } else {
        JOptionPane.showMessageDialog(null, "Login failed.");
        return false;
    }}
       static void sendMessage() {
    long messageId = 1000000000L + new Random().nextInt(900000000);
        int messageCounter = 0;
    messageCounter++;

    String recipient = JOptionPane.showInputDialog("Enter recipient number (+CCXXXXXXXXXX):");
    if (recipient == null || !recipient.matches("\\+\\d{9,12}")) {
        JOptionPane.showMessageDialog(null, "Invalid number. Must include international code and be <= 12 digits.");
        return;
    }

    String message = JOptionPane.showInputDialog("Enter your message (max 250 chars):");
    if (message == null || message.length() > 250) {
        JOptionPane.showMessageDialog(null, "Please enter a message of less than 250 characters.");
        return;
    }

    String[] words = message.trim().split("\\s+");
    String hash = String.format("802d:%d:%s",
        Long.parseLong(Long.toString(messageId).substring(0, 2)),
        words.length > 1 ? words[words.length - 1].toUpperCase() : ""
    );

    String[] actions = { "Send", "Disregard", "Store" };
    int action = JOptionPane.showOptionDialog( null,"Choose what to do with this message:", "Message Options", JOptionPane.DEFAULT_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, actions,actions[0]);
    if (action == 1) {
        JOptionPane.showMessageDialog(null, "Message disregarded.");
        return;
    }
JSONObject jsonMessage = new JSONObject();
jsonMessage.put("MessageID", "" + messageId);
// jsonMessage.put("MessageHash", hash);
jsonMessage.put("Recipient", "" + recipient);
jsonMessage.put("Message", "" + message);

if (action == 2) {
    messageStorage.add(jsonMessage);
    JOptionPane.showMessageDialog(null, "Message stored.");
    return;
}

totalMessage ++;

JOptionPane.showMessageDialog(null,
    "Message Sent!\n" +
    "Message ID: " + messageId + "\n" +
    // "Message Hash: " + hash + "\n" +
    "Recipient: " + recipient + "\n" +
    "Message: " + message);
       }
static void saveMessagesToJSON() {
    try (FileWriter file = new FileWriter("storedMessages.json")) {
        file.write(messageStorage.toJSONString());
        file.flush();
        System.out.println("Stored messages saved to storedMessages.json");
    } catch (IOException e) {
        e.printStackTrace();
    }
}


}



            
   
    

