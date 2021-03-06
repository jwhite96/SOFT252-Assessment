/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import accounts.*;
import view.PatientHome;
import accounts.Patient;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import singleton.AccountSingleton;

/**
 *
 * @author James
 */
public class PatientController {
    
    private final PatientHome view;
    private final Account patient;
    
    public PatientController(Account patient) {
        this.view = new PatientHome();
        this.patient = (Patient) patient;
        initController();
        view.setVisible(true);
        view.getLblDetails().setText("Welcome " + patient.getFirstName() + " " + patient.getSurname());
    }
        
    public void initController() {
        view.getBtnLogout().addActionListener(e -> logout());
        view.getBtnSubmit().addActionListener(e -> requestAppointment());
        view.getBtnDelete().addActionListener(e -> deleteAccount());
        view.getBtnCancel().addActionListener(e -> cancelAppointment());
        view.getCmbDoctor().setModel(new DefaultComboBoxModel(Admin.getAccounts("DOCTOR")));
        view.getLstAppointments().setListData(Patient.getAppointments(patient));
        view.getLstHistory().setListData(Patient.getHistory(patient));
    }
    
    private void logout(){
        new LoginController();
        view.setVisible(false);
    }
      
    private void requestAppointment() {
        Doctor doctor = (Doctor) AccountSingleton.convertToObject(view.getCmbDoctor().toString());
        String time = view.getCmbTime().getSelectedItem().toString();
        String day =  view.getCmbDay().getSelectedItem().toString();
        String month = view.getCmbMonth().getSelectedItem().toString();        
        
        String dateTime = time + " / " + day + " / " + month;

        Patient.requestAppointment(patient, doctor, dateTime);
        
        JOptionPane.showMessageDialog(null, "Your appointment request has been received. Thank You");
    }
    
    private void cancelAppointment() {
        int alert = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this appointment?", "Cancel Appointment", JOptionPane.YES_NO_OPTION);
        
        if (alert == JOptionPane.YES_OPTION) {
            Patient.cancelAppointment(view.getLstAppointments().getSelectedValue());
            JOptionPane.showMessageDialog(null, "Appointment Cancelled");            
        }
        view.getLstAppointments().setListData(Patient.getAppointments(patient));
    }
    
    private void deleteAccount() {
        Patient.deleteAccount((Account) patient);
    }
    
}
