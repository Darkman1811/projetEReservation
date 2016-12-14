/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data2;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author darkman
 */
public class JoursFeries {
   
    private int id;
    private java.time.LocalDate date_bloque;
    private String fete;
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

    public String getFete() {
        return fete;
    }

    public void setFete(String fete) {
        this.fete = fete;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }
    
    
    
}
