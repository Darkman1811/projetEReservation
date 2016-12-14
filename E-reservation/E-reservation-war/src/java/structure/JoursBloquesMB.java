/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import admin.*;
import crud.Admin.CrudJoursBloques;
import dataNew.JoursBloques;
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
public class JoursBloquesMB {
    @EJB
    CrudJoursBloques crudJoursBloques;
    
   private JoursBloques joursBloques=new JoursBloques();
   private List<JoursBloques> listeJoursBloques;

    public String ajouterJoursBloques(){
        crudJoursBloques.ajouterJoursBloques(joursBloques);
        return "joursBloques.xhtml";
    }
   
     
    public String editerJoursBloques(){
     //  int idJoursBloques=(int)FacesContext.getCurrentInstance().getAttributes().get("idJoursBloques");
        String idJoursBloques=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idJoursBloques");
       joursBloques.setId(Integer.valueOf(idJoursBloques));
       joursBloques=crudJoursBloques.fromId(joursBloques.getId());
        return "joursBloquesModif.xhtml";
    }
    
   public String modifierJoursBloques(){
        crudJoursBloques.modifier(joursBloques);
        return("joursBloques.xhtml");
    }
    
    public String supprimerJoursBloques(){
         String idJoursBloques=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idJoursBloques");
         joursBloques.setId(Integer.valueOf(idJoursBloques)); 
        crudJoursBloques.delete(joursBloques);
        return("joursBloques.xhtml");
    }
    
    public JoursBloques getJoursBloques() {
        return joursBloques;
    }

    public void setJoursBloques(JoursBloques joursBloques) {
        this.joursBloques = joursBloques;
    }

  
    public List<JoursBloques> getListeJoursBloques() {
        //return listeJoursBloques;
        return crudJoursBloques.getAll();
    }

    public void setListeJoursBloques(List<JoursBloques> listeJoursBloques) {
        this.listeJoursBloques = listeJoursBloques;
    }
    
    
}
