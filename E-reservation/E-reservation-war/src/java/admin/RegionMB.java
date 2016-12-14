/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import crud.Admin.CrudRegion;
import dataNew.Region;
import java.io.Serializable;
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
public class RegionMB implements Serializable{
    @EJB
    CrudRegion crudRegion;
    
   private Region region=new Region();
   private List<Region> listeRegion;   
   

    public String ajouterRegion(){
        crudRegion.ajouterRegion(region);
       // System.out.println("Pays: "+region.getPays().getId());
        return "region.xhtml";
    }
   
     
    public String editerRegion(){
     //  int idRegion=(int)FacesContext.getCurrentInstance().getAttributes().get("idRegion");
        String idRegion=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idRegion");
       region.setId(Integer.valueOf(idRegion));
       region=crudRegion.fromId(region.getId());
        return "regionModif.xhtml";
    }
    
   public String modifierRegion(){
        crudRegion.modifier(region);
        return("region.xhtml");
    }
    
    public String supprimerRegion(){
         String idRegion=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idRegion");
         region.setId(Integer.valueOf(idRegion)); 
        crudRegion.delete(region);
        return("region.xhtml");
    }
    
    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

  
    public List<Region> getListeRegion() {
        //return listeRegion;
        return crudRegion.getAll();
    }

    public void setListeRegion(List<Region> listeRegion) {
        this.listeRegion = listeRegion;
    }
    
    
}
