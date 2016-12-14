/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data2;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 *
 * @author darkman
 */

public class Planning implements Serializable {
    private int id;
    private String jours_de_semaine;
    private java.util.Date heure_ouverture;
    private java.util.Date heure_fermeture;
    private Structure structure;
    private List <JoursBloques>  joursBloques;
    private List <RV> rv;
    private List <Pratiquant>  pratiquant;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJours_de_semaine() {
        return jours_de_semaine;
    }

    public void setJours_de_semaine(String jours_de_semaine) {
        this.jours_de_semaine = jours_de_semaine;
    }

    public Date getHeure_ouverture() {
        return heure_ouverture;
    }

    public void setHeure_ouverture(Date heure_ouverture) {
        this.heure_ouverture = heure_ouverture;
    }

    public Date getHeure_fermeture() {
        return heure_fermeture;
    }

    public void setHeure_fermeture(Date heure_fermeture) {
        this.heure_fermeture = heure_fermeture;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public List<JoursBloques> getJoursBloques() {
        return joursBloques;
    }

    public void setJoursBloques(List<JoursBloques> joursBloques) {
        this.joursBloques = joursBloques;
    }

    public List<RV> getRv() {
        return rv;
    }

    public void setRv(List<RV> rv) {
        this.rv = rv;
    }

    public List<Pratiquant> getPratiquant() {
        return pratiquant;
    }

    public void setPratiquant(List<Pratiquant> pratiquant) {
        this.pratiquant = pratiquant;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.id;
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
        final Planning other = (Planning) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

   
    
}
