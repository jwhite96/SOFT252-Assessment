/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialization;

import singleton.AccountSingleton;
import accounts.Account;
import appointments.Appointment;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author James
 */
public class AppointmentSerialiser implements Serializable {
    
    public AppointmentSerialiser() {
    }
    
    /**
     * 
     * @param appointments
     * @param XML - name of the XML file
     */
    public static void xmlEncoder(ArrayList<Appointment> appointments, String XML) {
        
        try {
            XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(XML)));
            e.writeObject(appointments);
            e.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccountSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @param appointments
     * @param XML
     * @return ArrayList of saved accounts in the XML file
     */
    public static ArrayList xmlDecoder(ArrayList<Appointment> appointments, String XML) {
    
        try {
            XMLDecoder d = new XMLDecoder(new BufferedInputStream(new FileInputStream(XML)));            
            ArrayList<Appointment> savedAppointments = (ArrayList<Appointment>) d.readObject();
            d.close();  
            
            return savedAppointments;
            
        } catch (FileNotFoundException ex) {
            
            Logger.getLogger(AccountSingleton.class.getName()).log(Level.SEVERE, null, ex);
            
            return null;
        }
    }
}
