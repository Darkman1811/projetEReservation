/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import crud.Admin.CrudPays;
import dataNew.Pays;
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
public class PaysMB {
    @EJB
    CrudPays crudPays;
    
   private Pays pays=new Pays();
   private List<Pays> listePays;

    public String ajouterPays(){
        crudPays.ajouterPays(pays);
        return "pays.xhtml";
    }
   
     
    public String editerPays(){
     //  int idPays=(int)FacesContext.getCurrentInstance().getAttributes().get("idPays");
        String idPays=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idPays");
       pays.setId(Integer.valueOf(idPays));
       pays=crudPays.fromId(pays.getId());
        return "paysModif.xhtml";
    }
    
   public String modifierPays(){
        crudPays.modifier(pays);
        return("pays.xhtml");
    }
    
    public String supprimerPays(){
         String idPays=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idPays");
         pays.setId(Integer.valueOf(idPays)); 
        crudPays.delete(pays);
        return("pays.xhtml");
    }
    
    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

  
    public List<Pays> getListePays() {
        //return listePays;
        return crudPays.getAll();
    }

    public void setListePays(List<Pays> listePays) {
        this.listePays = listePays;
    }
    
    
}
