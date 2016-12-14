/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataNew;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
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

/**
 *
 * @author darkman
 */
@Entity
@NamedQueries({
  @NamedQuery(name="Planning.findAll",
              query="SELECT P FROM Planning P")
})
public class Planning implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String jours_de_semaine;
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date heure_ouverture;
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date heure_fermeture;
    @ManyToOne (cascade = CascadeType.REFRESH)
    private Structure structure;
    @OneToMany(mappedBy = "planning")
    private List <JoursBloques>  joursBloques;
    @OneToMany(mappedBy = "planning")
    private List <RV> rv;
    @OneToMany(mappedBy = "planning")
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
    public String toString() {
        return "Planning-" + getId();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.jours_de_semaine);
        hash = 53 * hash + Objects.hashCode(this.heure_fermeture);
        hash = 53 * hash + Objects.hashCode(this.structure);
        hash = 53 * hash + Objects.hashCode(this.pratiquant);
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
        if (!Objects.equals(this.jours_de_semaine, other.jours_de_semaine)) {
            return false;
        }
        if (!Objects.equals(this.heure_ouverture, other.heure_ouverture)) {
            return false;
        }
        if (!Objects.equals(this.heure_fermeture, other.heure_fermeture)) {
            return false;
        }
        if (!Objects.equals(this.structure, other.structure)) {
            return false;
        }
        if (!Objects.equals(this.pratiquant, other.pratiquant)) {
            return false;
        }
        return true;
    }

   
    
}
