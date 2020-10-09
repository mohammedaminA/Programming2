/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author mga
 */
public class Driver implements Serializable {
    private String firstName;
    private String surname;
    private Calendar dateOfBirth;
    
    public Driver() {
        this.firstName = null;
        this.surname = null;
        this.dateOfBirth = null;        
    }
    
    public Driver(String firstName, String surname, Calendar dateOfBirth) {
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;       
    }  
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getSurname() {
        return this.surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public Calendar getDateOfBirth() {
        return this.dateOfBirth;
    }
    
    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }   
  
    private String getFormattedDateOfBirth()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
        String dateString = formatter.format(this.dateOfBirth.getTime());
        return dateString;
    }
    
    @Override
    public String toString() {
        return "\nName: " + this.firstName +
                " " + this.surname +                
                " Start: " + getFormattedDateOfBirth()+ "\n";
    }
    
    public String toString(char delimiter) {
        final char EOLN='\n';       
        final String QUOTE="\"";        
        String str = QUOTE + this.firstName + QUOTE + delimiter +
                QUOTE + this.surname + QUOTE + delimiter +  
                QUOTE + getFormattedDateOfBirth() + QUOTE + EOLN;
        return str;
    }    
}
