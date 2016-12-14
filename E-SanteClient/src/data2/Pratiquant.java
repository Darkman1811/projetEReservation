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

public class Pratiquant implements Serializable{
   
    private int id;
    private String prenom;
    private String nom;
    private String titre;
    private String specialite;
    private String civilite;
    private String age;
    private Planning planning;
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
    
    
    
}
