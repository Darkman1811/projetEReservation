/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
/**
 *
 * @author darkman
 */

public class JoursBloques {
   
    private int id;
    private java.time.LocalDate date_bloque;
    private java.time.LocalTime debut_debut_bloque;
    private java.time.LocalTime date_fin_bloque;
    private String raison;
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
