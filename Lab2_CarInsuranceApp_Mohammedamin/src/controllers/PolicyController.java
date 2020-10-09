package controllers;


import model.Policy;
import model.Driver;
import carinsurancestarterapp.InputHelper;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author mohammedaminA
 */
public class PolicyController {
    
    private Policy policy;
    
    public PolicyController() {      
        InputHelper inputHelper = new InputHelper();
        
        char c = inputHelper.readCharacter("Load an already existing Policy?");
        if (c == 'Y') {
            char c1 = inputHelper.readCharacter("Load from a Text File  or Object File ?");
            String fileName = inputHelper.readString("Enter File name"); 
            if (c1 == 'T') {
                loadPolicyFromTextFile(fileName);
            }
            else if (c1== 'O') {
                loadPolicyFromObjectFile(fileName);
            }
        }
        else {
            String policyType = inputHelper.readString("Enter Policy Type");  
            String policyOwner = inputHelper.readString("Enter Policy Owner");
            String carReg = inputHelper.readString("Enter Car Reg");
            String carDescription = inputHelper.readString("Enter Car Description");
            Calendar policyStartDate = inputHelper.readDate("Enter Car Description", "yyyy-MM-dd"); 
            policy = new Policy(policyType, policyOwner, carReg, carDescription, policyStartDate);             
        }          
    }
    
    private void loadPolicyFromTextFile(String fileName) {
        char DELIMITER=',';
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) { 
            int policyID, noDrivers;
            String policyType, policyOwner, carReg, carDescription;
            Calendar policyStart=null, dateOfBirth=null;

            String[] temp;
            String line = br.readLine(); 
            temp=line.split(Character.toString(DELIMITER));
            policyID = Integer.parseInt(temp[0]);            
            policyType = stripQuotes(temp[1]);
            policyOwner = stripQuotes(temp[2]); 
            carReg = stripQuotes(temp[3]);   
            carDescription = stripQuotes(temp[4]); 
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String policyStartDateStr = stripQuotes(temp[5]);
            Date policyStartDate;
            try {
                policyStartDate = dateFormat.parse(policyStartDateStr);
                policyStart = Calendar.getInstance();
                policyStart.setTime(policyStartDate);                
            } catch (ParseException ex) {
                Logger.getLogger(PolicyController.class.getName()).log(Level.SEVERE, null, ex);
            }  
              
            
            
            noDrivers = Integer.parseInt(temp[6]);
ArrayList<Driver> namedDrivers = new ArrayList<>();
Driver newDriver;
for (int i=0; i<noDrivers; i++) {
    line = br.readLine();
    temp=line.split(Character.toString(DELIMITER));
    String firstName = stripQuotes(temp[0]);
    String surname = stripQuotes(temp[1]); 
    dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String dateOfBirthStr = stripQuotes(temp[2]);
    Date dateOfBirthDate;
    try {
        dateOfBirthDate = dateFormat.parse(dateOfBirthStr);
        dateOfBirth = Calendar.getInstance();
        dateOfBirth.setTime(dateOfBirthDate); 
    } catch (ParseException ex) {
        Logger.getLogger(
        PolicyController.class.getName()).log(Level.SEVERE,
        null, ex);
    }

    newDriver = new Driver(firstName, surname, dateOfBirth);
    namedDrivers.add(newDriver);
}
            
      
            
            policy = new Policy(policyID, policyType, policyOwner, carReg, carDescription, policyStart,namedDrivers); 
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(PolicyController.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        
        
    }
    
    private String stripQuotes(String str) {
        return str.substring(1, str.length()-1);
    }    

     public void loadPolicyFromObjectFile(String filename) {    
        try{
            FileInputStream fin = new FileInputStream(filename);
            try (ObjectInputStream ois = new ObjectInputStream(fin)) {
                policy = (Policy) ois.readObject();
            }
        }catch(IOException | ClassNotFoundException ex){
            System.out.println(ex);
            System.exit(0);
        }        
    } 
    
    
    public void storePolicyToObjectFile(String filename) {
        ObjectOutputStream output = null;
        try {
            output = new ObjectOutputStream(new FileOutputStream(filename));       
            output.writeObject(policy);
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(PolicyController.class.getName())
                  .log(Level.SEVERE, null, ex);
        } finally {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(PolicyController.class.getName())
                      .log(Level.SEVERE, null, ex);
            }
        }      
    } 
    
    public void run() {
        boolean finished = false;
        do {
            System.out.println(policy);
            char choice = displayPolicyMenu();
            switch (choice) {
                case 'A': 
                    addDriver();
                    break;
                case 'B': 
                   deleteDriver();
                    break;                      
                case 'F':
                    InputHelper inputHelper = new InputHelper();
                    char c = inputHelper.readCharacter("Store to a Text File (T) or Object File (O)?");
                    String fileName = inputHelper.readString("Enter File name"); 
                    if (c == 'T') {
                        storePolicyToTextFile(fileName);
                    }
                    else if (c == 'O') {
                        storePolicyToObjectFile(fileName);
                    }                    
                    finished = true;
            }
        } while (!finished);
    }

    private char displayPolicyMenu() {
        InputHelper inputHelper = new InputHelper();
        System.out.print("A. Add a new driver");
        System.out.print("B. Delete a driver");
        System.out.print("F. Finish");         
        return inputHelper.readCharacter("Enter choice", "ABF");
    }    
    
    private void addDriver() {
        InputHelper inputHelper = new InputHelper();
        String firstName = inputHelper.readString("Enter First Name");
        String surname = inputHelper.readString("Enter Surname");
        Calendar dateOfBirth = inputHelper.readDate("Enter Date of Birth", "yyyy-MM-dd");     
        Driver newDriver = new Driver(firstName, surname, dateOfBirth);               
        policy.addDriver(newDriver);          
    } 
    
    private void deleteDriver() {
        InputHelper inputHelper = new InputHelper();
        Calendar dateOfBirth = inputHelper.readDate("Enter Date of Birth", "yyyy-MM-dd");  
        policy.removeDriver(dateOfBirth);
    }
    
    
    private void storePolicyToTextFile(String fileName) {
    char DELIMITER=','; 
    try (PrintWriter output = new PrintWriter(fileName)) {
        output.println(policy.toString(DELIMITER));
        output.close();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(
        PolicyController.class.getName()).log(Level.SEVERE, 
        null, ex);
    } 
}

}