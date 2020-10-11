/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalTime;

/**
 *
 * @author mohammedaminA
 */
public class PAppointment  extends Appointment{
    private String promoCode;
    private int discountPercentage;
      public PromoAppointment(String customerName, LocalTime appointmentTime, int appointmentLength,String promoCode,int discountPercent){
          super(customerName,appointmentTime,appointmentLength);
          this.discountPercentage=discountPercent;
          this.promoCode=promoCode;
      }
    public void setPromoCode(String code){
        this.promoCode=code;
        
    }
    
    public String getPromoCode(){
        return this.promoCode;
    }
     public void setDiscountPercentage(int discountPercent){
         this.discountPercentage=discountPercent;
     }
     public int getDiscountPercentage(){
         return this.discountPercentage;
     }
    
}