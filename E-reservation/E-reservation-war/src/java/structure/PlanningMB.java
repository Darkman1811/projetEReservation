/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import admin.*;
import crud.Admin.CrudPlanning;
import dataNew.Planning;
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
public class PlanningMB {
    @EJB
    CrudPlanning crudPlanning;
    
   private Planning planning=new Planning();
   private List<Planning> listePlanning;

    public String ajouterPlanning(){
        crudPlanning.ajouterPlanning(planning);
        return "planning.xhtml";
    }
   
     
    public String editerPlanning(){
     //  int idPlanning=(int)FacesContext.getCurrentInstance().getAttributes().get("idPlanning");
        String idPlanning=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idPlanning");
       planning.setId(Integer.valueOf(idPlanning));
       planning=crudPlanning.fromId(planning.getId());
        return "planningModif.xhtml";
    }
    
   public String modifierPlanning(){
        crudPlanning.modifier(planning);
        return("planning.xhtml");
    }
    
    public String supprimerPlanning(){
         String idPlanning=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idPlanning");
         planning.setId(Integer.valueOf(idPlanning)); 
        crudPlanning.delete(planning);
        return("planning.xhtml");
    }
    
    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }

  
    public List<Planning> getListePlanning() {
        //return listePlanning;
        return crudPlanning.getAll();
    }

    public void setListePlanning(List<Planning> listePlanning) {
        this.listePlanning = listePlanning;
    }
    
    
}
