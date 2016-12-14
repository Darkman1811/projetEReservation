/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import admin.*;
import crud.Admin.CrudRV;
import dataNew.RV;
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
public class RVMB {
    @EJB
    CrudRV crudRV;
    
   private RV rv=new RV();
   private List<RV> listeRV;

    public String ajouterRV(){
        crudRV.ajouterRV(rv);
        return "rv.xhtml";
    }
   
     
    public String editerRV(){
     //  int idRV=(int)FacesContext.getCurrentInstance().getAttributes().get("idRV");
        String idRV=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idRV");
       rv.setId(Integer.valueOf(idRV));
       rv=crudRV.fromId(rv.getId());
        return "rvModif.xhtml";
    }
    
   public String modifierRV(){
        crudRV.modifier(rv);
        return("rv.xhtml");
    }
    
    public String supprimerRV(){
         String idRV=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idRV");
         rv.setId(Integer.valueOf(idRV)); 
        crudRV.delete(rv);
        return("rv.xhtml");
    }
    
    public RV getRV() {
        return rv;
    }

    public void setRV(RV rv) {
        this.rv = rv;
    }

  
    public List<RV> getListeRV() {
        //return listeRV;
        return crudRV.getAll();
    }

    public void setListeRV(List<RV> listeRV) {
        this.listeRV = listeRV;
    }
    
    
}
