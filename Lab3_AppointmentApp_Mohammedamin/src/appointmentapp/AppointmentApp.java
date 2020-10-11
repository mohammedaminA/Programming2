/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentapp;

import controllers.AppointmentController;

/**
 *
 * @author mga
 */
public class AppointmentApp {

    public static void run() {        
        System.out.println("Appointment App\n===============\n\n");
        
        AppointmentController appointmentController = new AppointmentController();  
        
        appointmentController.run();
        
        System.out.println("Thank you for using Appointment App. Good bye.\n");        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AppointmentApp appointmentApp = new AppointmentApp();
        appointmentApp.run();
    }
    
}
