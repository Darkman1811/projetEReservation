/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data2;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author darkman
 */

public class Ville implements Serializable{
 
  private int id;
  private String nom_ville;
  private Region region;
  private List <Structure> structures;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_ville() {
        return nom_ville;
    }

    public void setNom_ville(String nom_ville) {
        this.nom_ville = nom_ville;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Structure> getStructures() {
        return structures;
    }

    public void setStructures(List<Structure> structures) {
        this.structures = structures;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ville other = (Ville) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
  
}
