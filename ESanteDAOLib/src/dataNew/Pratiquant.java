/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataNew;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author darkman
 */
@Entity
@NamedQueries({
  @NamedQuery(name="Pratiquant.findAll",
              query="SELECT P FROM Pratiquant P")
})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Pratiquant implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private String nom;
    private String titre;
    private String specialite;
    private String civilite;
    private String age;
    @Column(unique = true,nullable = false)
    public String cni;
     @ManyToOne
     @XmlTransient
    private Planning planning;
      @OneToMany(mappedBy = "pratiquant")
      @XmlTransient
    private List <RV> rv;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

      
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }

    public List<RV> getRv() {
        return rv;
    }

    public void setRv(List<RV> rv) {
        this.rv = rv;
    }

    @Override
    public String toString() {
        return  id+"-"+prenom+ " " + nom ;
    }

    @Override
    public int hashCode() {
        return this.cni.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pratiquant other = (Pratiquant) obj;
        if (!Objects.equals(this.cni, other.cni)) {
            return false;
        }
        return true;
    }
    
    
    
}
