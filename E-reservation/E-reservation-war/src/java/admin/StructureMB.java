/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import crud.Admin.CrudStructures;
import dataNew.Structure;
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
public class StructureMB {
    @EJB
    CrudStructures crudStructure;
    
   private Structure structure=new Structure();
   private List<Structure> listeStructure;

    public String ajouterStructure(){
        crudStructure.ajouterStructure(structure);
        return "structure.xhtml";
    }
   
     
    public String editerStructure(){
     //  int idStructure=(int)FacesContext.getCurrentInstance().getAttributes().get("idStructure");
        String idStructure=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idStructure");
       structure.setId(Integer.valueOf(idStructure));
       structure=crudStructure.fromId(structure.getId());
        return "structureModif.xhtml";
    }
    
   public String modifierStructure(){
        crudStructure.modifier(structure);
        return("structure.xhtml");
    }
    
    public String supprimerStructure(){
         String idStructure=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idStructure");
         structure.setId(Integer.valueOf(idStructure)); 
        crudStructure.delete(structure);
        return("structure.xhtml");
    }
    
    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

  
    public List<Structure> getListeStructure() {
        //return listeStructure;
        return crudStructure.getAll();
    }

    public void setListeStructure(List<Structure> listeStructure) {
        this.listeStructure = listeStructure;
    }
    
    
}
