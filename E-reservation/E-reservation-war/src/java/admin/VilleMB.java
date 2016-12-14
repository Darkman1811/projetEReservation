/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import crud.Admin.CrudVille;
import dataNew.Ville;
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
public class VilleMB {
    @EJB
    CrudVille crudVille;
    
   private Ville ville=new Ville();
   private List<Ville> listeVille;

    public String ajouterVille(){
        crudVille.ajouterVille(ville);
        return "ville.xhtml";
    }
   
     
    public String editerVille(){
     //  int idVille=(int)FacesContext.getCurrentInstance().getAttributes().get("idVille");
        String idVille=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idVille");
       ville.setId(Integer.valueOf(idVille));
       ville=crudVille.fromId(ville.getId());
        return "villeModif.xhtml";
    }
    
   public String modifierVille(){
        crudVille.modifier(ville);
        return("ville.xhtml");
    }
    
    public String supprimerVille(){
         String idVille=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idVille");
         ville.setId(Integer.valueOf(idVille)); 
        crudVille.delete(ville);
        return("ville.xhtml");
    }
    
    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

  
    public List<Ville> getListeVille() {
        //return listeVille;
        return crudVille.getAll();
    }

    public void setListeVille(List<Ville> listeVille) {
        this.listeVille = listeVille;
    }
    
    
}
