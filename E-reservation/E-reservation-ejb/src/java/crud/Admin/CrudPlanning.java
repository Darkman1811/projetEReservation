/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.Admin;

import dataNew.Client;
import dataNew.Planning;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author darkman
 */
@Stateless
public class CrudPlanning {
    @PersistenceContext
    EntityManager em;
   
    public void ajouterPlanning( Planning planning){
        
        em.persist(planning); 
    } 
    
    
public boolean modifier(Planning planning){
    Planning tmp=em.find(Planning.class, planning.getId());
    
    if(tmp!=null){
    //Garder le meme id l'origine modifier tout le reste avec les nouvelles  valeurs
 
        tmp.setHeure_fermeture(planning.getHeure_fermeture());
        tmp.setHeure_ouverture(planning.getHeure_ouverture());
        tmp.setJoursBloques(planning.getJoursBloques());
        tmp.setJours_de_semaine(planning.getJours_de_semaine());
        tmp.setStructure(planning.getStructure());
        
       
        em.merge(tmp);
    return true;
    }
    return false;
}

public boolean delete(Planning planning)
{
   Planning tmp= em.find(Planning.class, planning.getId());
   if(tmp!=null) {
      em.remove(tmp);
   return true;
   }
   return false;
}       

public void fusionner(Set<Planning> list){
    Iterator<Planning> it=list.iterator();
   while(it.hasNext()){
       Planning planning=it.next();
       Planning tmp=em.find(Planning.class, planning.getId());
       if(tmp==null){
           this.ajouterPlanning(planning);
       }
       else{
           this.modifier(planning);           
       }
   }
}
public Planning fromId(int id){
    return em.find(Planning.class, id);
}
public List<Planning> getAll(){
    return em.createNamedQuery("Planning.findAll",Planning.class).getResultList();
} 
}
