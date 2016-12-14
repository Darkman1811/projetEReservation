/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.Admin;


import dataNew.JoursBloques;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author darkman
 */

@Stateless
public class CrudJoursBloques {
    @PersistenceContext
    EntityManager em;
    
    public void ajouterJoursBloques( JoursBloques joursBloques){
        
        em.persist(joursBloques);
    } 
    
    
public boolean modifier(JoursBloques joursBloques){
    JoursBloques tmp=em.find(JoursBloques.class, joursBloques.getId());
    
    if(tmp!=null){
    //Garder le meme id l'origine modifier tout le reste avec les nouvelles  valeurs
        tmp.setId(joursBloques.getId());        
        tmp.setDate_bloque(joursBloques.getDate_bloque());
        tmp.setDate_fin_bloque(joursBloques.getDate_fin_bloque());
        tmp.setDebut_debut_bloque(joursBloques.getDebut_debut_bloque());
        tmp.setRaison(joursBloques.getRaison());
        tmp.setPlanning(joursBloques.getPlanning());
             
        em.merge(tmp);
    return true;
    }
    return false;
}

public boolean delete(JoursBloques joursBloques)
{
   JoursBloques tmp= em.find(JoursBloques.class, joursBloques.getId());
   if(tmp!=null) {
   em.remove(tmp);
   return true;
   }
   return false;
}       

public JoursBloques fromId(int id){
    return em.find(JoursBloques.class, id);
}
public List<JoursBloques> getAll(){
    return em.createNamedQuery("JoursBloques.findAll",JoursBloques.class).getResultList();
} 
}
