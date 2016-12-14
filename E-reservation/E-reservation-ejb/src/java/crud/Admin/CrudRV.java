/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.Admin;

import dataNew.Region;
import dataNew.RV;
import java.util.List;
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
public class CrudRV {
    @PersistenceContext
    EntityManager em;
    
    public void ajouterRV( RV rv){
        
        em.persist(rv);
    } 
    
    
public boolean modifier(RV rv){
    RV tmp=em.find(RV.class, rv.getId());
    
    if(tmp!=null){
    //Garder le meme id l'origine modifier tout le reste avec les nouvelles  valeurs
         
        tmp.setCodeRV(rv.getCodeRV());
        tmp.setDateRV(rv.getDateRV());
        tmp.setEtat(rv.getEtat());
        tmp.setHeureDebutRV(rv.getHeureDebutRV());
        tmp.setHeureFinRV(rv.getHeureFinRV());
      //  tmp.setPlanning(rv.getPlanning());
       
        em.merge(tmp);
    return true;
    }
    return false;
}

public boolean delete(RV rv)
{
   RV tmp= em.find(RV.class, rv.getId());
   if(tmp!=null) {
   em.remove(tmp);
   return true;
   }
   return false;
}       

public RV fromId(int id){
    return em.find(RV.class, id);
}

public List<RV> getAll(){
    return em.createNamedQuery("RV.findAll",RV.class).getResultList();
} 
}
