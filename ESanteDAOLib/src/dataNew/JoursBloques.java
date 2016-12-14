/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataNew;

import utils.LocalDateAdapter;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import utils.LocalTimeAdapter;

/**
 *
 * @author darkman
 */
@Entity
@NamedQueries({
  @NamedQuery(name="JoursBloques.findAll",
              query="SELECT JB FROM JoursBloques JB")
})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class JoursBloques {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private java.time.LocalDate date_bloque;
    @XmlJavaTypeAdapter(value = LocalTimeAdapter.class)
    private java.time.LocalTime debut_debut_bloque;
    @XmlJavaTypeAdapter(value = LocalTimeAdapter.class)
    private java.time.LocalTime date_fin_bloque;
    private String raison;
    @ManyToOne
    private Planning planning;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate_bloque() {
        return date_bloque;
    }

    public void setDate_bloque(LocalDate date_bloque) {
        this.date_bloque = date_bloque;
    }

    public LocalTime getDebut_debut_bloque() {
        return debut_debut_bloque;
    }

    public void setDebut_debut_bloque(LocalTime debut_debut_bloque) {
        this.debut_debut_bloque = debut_debut_bloque;
    }

    public LocalTime getDate_fin_bloque() {
        return date_fin_bloque;
    }

    public void setDate_fin_bloque(LocalTime date_fin_bloque) {
        this.date_fin_bloque = date_fin_bloque;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }
    
        
    
}
