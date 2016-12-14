/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data2;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author darkman
 */
//@Entity
public class Pays implements Serializable{
  
  private int id;
  private String nom_pays;
  private String indicatif_telephonique;
  private String monaie;
  private float taux;
  private List <Region> regions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_pays() {
        return nom_pays;
    }

    public void setNom_pays(String nom_pays) {
        this.nom_pays = nom_pays;
    }

    public String getIndicatif_telephonique() {
        return indicatif_telephonique;
    }

    public void setIndicatif_telephonique(String indicatif_telephonique) {
        this.indicatif_telephonique = indicatif_telephonique;
    }

    public String getMonaie() {
        return monaie;
    }

    public void setMonaie(String monaie) {
        this.monaie = monaie;
    }

    public float getTaux() {
        return taux;
    }

    public void setTaux(float taux) {
        this.taux = taux;
    }

   
    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        //
        hash = this.id;
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
        final Pays other = (Pays) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
  
  
  
}
