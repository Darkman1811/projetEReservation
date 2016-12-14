/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import crud.Admin.CrudJoursFeries;
import dataNew.JoursFeries;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author darkman
 */
@ManagedBean
@SessionScoped
public class JoursFeriesMB {
    @EJB
    CrudJoursFeries crudJoursFeries;
    
   private JoursFeries joursFeries=new JoursFeries();
   private List<JoursFeries> listeJoursFeries;

    public String ajouterJoursFeries(){
        crudJoursFeries.ajouterJoursFeries(joursFeries);
        return "joursFeries.xhtml";
    }
   
     
    public String editerJoursFeries(){
       String idJoursFeries=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idJoursFeries");
       joursFeries.setId(Integer.valueOf(idJoursFeries));
       joursFeries=crudJoursFeries.fromId(joursFeries.getId());
       return "joursFeriesModif.xhtml";
    }
    
   public String modifierJoursFeries(){
        crudJoursFeries.modifier(joursFeries);
        return("joursFeries.xhtml");
    }
    
    public String supprimerJoursFeries(){
        String idJoursFeries=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idJoursFeries");
        joursFeries.setId(Integer.valueOf(idJoursFeries)); 
        crudJoursFeries.delete(joursFeries);
        return("joursFeries.xhtml");
    }
    
    public JoursFeries getJoursFeries() {
        return joursFeries;
    }

    public void setJoursFeries(JoursFeries joursFeries) {
        this.joursFeries = joursFeries;
    }

  
    public List<JoursFeries> getListeJoursFeries() {
        //return listeJoursFeries;
        return crudJoursFeries.getAll();
    }

    public void setListeJoursFeries(List<JoursFeries> listeJoursFeries) {
        this.listeJoursFeries = listeJoursFeries;
    }
    
    
}
