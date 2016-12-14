/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.Admin;


import dataNew.JoursFeries;
import dataNew.Ville;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author darkman
 */

@Stateless
public class CrudJoursFeries {
    @PersistenceContext
    EntityManager em;
    
    public Boolean ajouterJoursFeries( JoursFeries jours_feries){
        
        em.persist(jours_feries);
        return true;
    } 
    
    
public boolean modifier(JoursFeries jours_feries){
    JoursFeries tmp=em.find(JoursFeries.class, jours_feries.getId());
    
    if(tmp!=null){
    //Garder le meme id l'origine modifier tout le reste avec les nouvelles  valeurs
        tmp.setId(jours_feries.getId());
        tmp.setFete(jours_feries.getFete());
        tmp.setDate_bloque(jours_feries.getDate_bloque());
        tmp.setPlanning(jours_feries.getPlanning());
             
        em.merge(tmp);
    return true;
    }
    return false;
}

public boolean delete(JoursFeries jours_feries)
{
   JoursFeries tmp= em.find(JoursFeries.class, jours_feries.getId());
   if(tmp!=null) {
   em.remove(tmp);
   return true;
   }
   return false;
}       

public JoursFeries fromId(int id){
    return em.find(JoursFeries.class, id);
}

public List<JoursFeries> getAll(){
    return em.createNamedQuery("JoursFeries.findAll",JoursFeries.class).getResultList();
} 
}
