/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.function.Predicate;

/**
 *
 * @author mohammedaminA
 */
public class Policy implements Serializable {
    private final int policyId;
    private String policyType;
    private String policyOwner;
    private String carReg;
    private String carDescription;
    private Calendar policyStartDate;
    private ArrayList<Driver> namedDrivers;    
    
    static int lastPolicyIdAllocated = 0;
    
    public Policy() {
        this.policyId = ++lastPolicyIdAllocated;
    }
    
    public Policy(String policyType, String policyOwner, String carReg, String carDescription, Calendar policyStartDate) {
        this.policyId = ++lastPolicyIdAllocated;
        this.policyType = policyType;
        this.policyOwner = policyOwner;
        this.carReg = carReg;
        this.carDescription = carDescription;
        this.policyStartDate = policyStartDate;
    }  
    
    public Policy(int policyId, String policyType, String policyOwner, String carReg, String carDescription, Calendar policyStartDate) {
        this.policyId = policyId;
        this.policyType = policyType;
        this.policyOwner = policyOwner;
        this.carReg = carReg;
        this.carDescription = carDescription;
        this.policyStartDate = policyStartDate;
    }  
    
    public Policy(int policyId, String policyType, String policyOwner, String carReg, String carDescription, Calendar policyStartDate, ArrayList<Driver> namedDrivers) {
        this.policyId = policyId;
        this.policyType = policyType;
        this.policyOwner = policyOwner;
        this.carReg = carReg;
        this.carDescription = carDescription;
        this.policyStartDate = policyStartDate;
        if (policyId > lastPolicyIdAllocated)
            lastPolicyIdAllocated = policyId;        
    } 
    
    public int getPolicyId() {
        return this.policyId;
    }
    
    public String getPolicyType() {
        return this.policyType;
    }
    
    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }
    
    public String getPolicyOwner() {
        return this.policyOwner;
    }
    
    public void setPolicyOwner(String policyOwner) {
        this.policyOwner = policyOwner;
    }
    
    public String getCarReg() {
        return this.carReg;
    }
    
    public void setCarReg(String carReg) {
        this.carReg = carReg;
    }
    
    public String getCarDescription() {
        return this.carDescription;
    }
    
    public void setCarDescription(String carDescription) {
        this.carDescription = carDescription;
    }
    
    public Calendar getPolicyStartDate() {
        return this.policyStartDate;
    }
    
    public void setPolicyStartDate(Calendar policyStartDate) {
        this.policyStartDate = policyStartDate;
    }    



    
    public void removeDriver(Calendar dateOfBirth) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
        String dateString = formatter.format(this.namedDrivers.get(2).getDateOfBirth().getTime());   
        Predicate<Driver> dateOfBirthPredicate = d-> formatter.format(d.getDateOfBirth().getTime()).equals(dateString);       
        this.namedDrivers.removeIf(dateOfBirthPredicate);
    }    
    
    private String getFormattedStartDate()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
        String dateString = formatter.format(this.policyStartDate.getTime());
        return dateString;
    }
    
    @Override
    public String toString() {
        return "\nId: " + Integer.toString(this.policyId) +
                " Type: " + this.policyType +                
                " Owner: " + this.policyOwner +
                " Reg: " + this.carReg +
                " Description: " + this.carDescription +                
                " Start: " + getFormattedStartDate();        
    } 
    
    public String toString(char delimiter) {
        final char EOLN='\n';       
        final String QUOTE="\"";        
        String str = Integer.toString(this.policyId) + delimiter + QUOTE + this.policyType + QUOTE + delimiter +
                QUOTE + this.policyOwner + QUOTE + delimiter +                
                QUOTE + this.carReg + QUOTE + delimiter +  
                QUOTE + this.carDescription + QUOTE + delimiter +
                QUOTE + getFormattedStartDate() + QUOTE + delimiter +                 
                Integer.toString(namedDrivers.size()) + EOLN;
        for (Driver driver : namedDrivers) {
            str =+ driver.toString(delimiter);
        } 
        
    }     
}