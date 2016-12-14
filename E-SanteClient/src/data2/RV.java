/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data2;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author darkman
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RV implements Serializable{
  
    private int id;
    private java.time.LocalDate dateRV;
    private java.time.LocalTime heureDebutRV;
    private java.time.LocalTime heureFinRV;
    private String etat;
    private String codeRV;
    private Planning planning;
    private Client client;   
    private Pratiquant pratiquant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateRV() {
        return dateRV;
    }

    public void setDateRV(LocalDate dateRV) {
        this.dateRV = dateRV;
    }

    public LocalTime getHeureDebutRV() {
        return heureDebutRV;
    }

    public void setHeureDebutRV(LocalTime heureDebutRV) {
        this.heureDebutRV = heureDebutRV;
    }

    public LocalTime getHeureFinRV() {
        return heureFinRV;
    }

    public void setHeureFinRV(LocalTime heureFinRV) {
        this.heureFinRV = heureFinRV;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getCodeRV() {
        return codeRV;
    }

    public void setCodeRV(String codeRV) {
        this.codeRV = codeRV;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Pratiquant getPratiquant() {
        return pratiquant;
    }

    public void setPratiquant(Pratiquant pratiquant) {
        this.pratiquant = pratiquant;
    }
    
    
}
