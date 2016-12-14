/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sync;

import dataNew.Client;
import dataNew.JoursBloques;
import dataNew.JoursFeries;
import dataNew.Planning;
import dataNew.Pratiquant;
import dataNew.RV;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author darkman
 */
@XmlRootElement
public class DataSync implements Serializable{
    private List<Client> client;
    private List<Pratiquant> pratiquant;
    private List<Planning> planning;
    private List<JoursBloques> joursBloques;
    private List<JoursFeries> joursFeries;
    private List<RV> rv;
    
    
    public List<JoursBloques> getJoursBloques() {
        return joursBloques;
    }

    public void setJoursBloques(List<JoursBloques> joursBloques) {
        this.joursBloques = joursBloques;
    }

    public List<Client> getClient() {
        return client;
    }

    public void setClient(List<Client> client) {
        this.client = client;
    }

    public List<Planning> getPlanning() {
        return planning;
    }

    public void setPlanning(List<Planning> planning) {
        this.planning = planning;
    }

    public List<Pratiquant> getPratiquant() {
        return pratiquant;
    }

    public void setPratiquant(List<Pratiquant> pratiquant) {
        this.pratiquant = pratiquant;
    }

    public List<JoursFeries> getJoursFeries() {
        return joursFeries;
    }

    public void setJoursFeries(List<JoursFeries> joursFeries) {
        this.joursFeries = joursFeries;
    }

    public List<RV> getRv() {
        return rv;
    }

    public void setRv(List<RV> rv) {
        this.rv = rv;
    }
   
    
    
    
}
