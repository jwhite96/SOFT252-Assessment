/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requests;

import accounts.*;
import java.io.Serializable;

/**
 *
 * @author James
 */
public class AppointmentRequest extends Request implements Serializable {
    
    private Doctor doctor;
    private String dateTime;
        
    public AppointmentRequest(Account account, Doctor doctor, String dateTime) {
        this.Account = account;
        this.doctor = doctor;
        this.dateTime = dateTime;
        this.requestType = "APPOINTMENT";
    }
        
    public AppointmentRequest() {
    }
    
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    } 
    
    @Override
    public String toString(){
        return Account.getID() + " " + Account.getFirstName() + " " + Account.getSurname() + ": " + requestType + " [" + doctor + ": " + dateTime + "]" ;
    }

}
