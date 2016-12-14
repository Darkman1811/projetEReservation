/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataNew;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import utils.LocalDateAdapter;
import utils.LocalTimeAdapter;

/**
 *
 * @author darkman
 */
@Entity
@NamedQueries({
  @NamedQuery(name="RV.findAll",
              query="SELECT R FROM RV R")
})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RV implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate dateRV;
    @XmlJavaTypeAdapter(value = LocalTimeAdapter.class)
    private LocalTime heureDebutRV;
    @XmlJavaTypeAdapter(value = LocalTimeAdapter.class)
    private LocalTime heureFinRV;
    private String etat;
    private String codeRV;
    @ManyToOne
    @XmlTransient
    private Planning planning;
    @ManyToOne
    @XmlTransient
    private Client client;
    @ManyToOne
    @XmlTransient
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

    @Override
    public String toString() {
        return id + " " + codeRV;
    }
    
    
}
