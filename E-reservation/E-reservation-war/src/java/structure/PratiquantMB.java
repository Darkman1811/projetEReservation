/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import admin.*;
import crud.Admin.CrudPratiquant;
import dataNew.Pratiquant;
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
public class PratiquantMB {
    @EJB
    CrudPratiquant crudPratiquant;
    
   private Pratiquant pratiquant=new Pratiquant();
   private List<Pratiquant> listePratiquant;

    public String ajouterPratiquant(){
        crudPratiquant.ajouterPratiquant(pratiquant);
        return "pratiquant.xhtml";
    }
   
     
    public String editerPratiquant(){
     //  int idPratiquant=(int)FacesContext.getCurrentInstance().getAttributes().get("idPratiquant");
        String idPratiquant=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idPratiquant");
       pratiquant.setId(Integer.valueOf(idPratiquant));
       pratiquant=crudPratiquant.fromId(pratiquant.getId());
        return "pratiquantModif.xhtml";
    }
    
   public String modifierPratiquant(){
        crudPratiquant.modifier(pratiquant);
        return("pratiquant.xhtml");
    }
    
    public String supprimerPratiquant(){
         String idPratiquant=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idPratiquant");
         pratiquant.setId(Integer.valueOf(idPratiquant)); 
        crudPratiquant.delete(pratiquant);
        return("pratiquant.xhtml");
    }
    
    public Pratiquant getPratiquant() {
        return pratiquant;
    }

    public void setPratiquant(Pratiquant pratiquant) {
        this.pratiquant = pratiquant;
    }

  
    public List<Pratiquant> getListePratiquant() {
        //return listePratiquant;
        return crudPratiquant.getAll();
    }

    public void setListePratiquant(List<Pratiquant> listePratiquant) {
        this.listePratiquant = listePratiquant;
    }
    
    
}
