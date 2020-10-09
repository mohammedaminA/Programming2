/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carinsurancestarterapp;

import controllers.PolicyController;

/**
 *
 * @author mga
 */
public class CarInsuranceApp {
    public static void run() {        
        System.out.println("Car Insurance App\n========\n\n");
        
        PolicyController policyController = new PolicyController();  
        
        policyController.run();
        
        System.out.println("Thank you for using Car Insurance App. Good bye.\n");        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CarInsuranceApp carInsuranceApp = new CarInsuranceApp();
        carInsuranceApp.run();
    }    
}
